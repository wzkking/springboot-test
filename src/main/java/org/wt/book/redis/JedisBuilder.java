package org.wt.book.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:redis.properties")
public class JedisBuilder {
	
	private JedisPool pool = null;

	@Value("${redis.hostName}")
	private String host;

	@Value("${redis.port}")
	private Integer port;

	@Value("${redis.timeout}")
	private Integer timeout;

	@Value("${redis.testOnBorrow}")
	private boolean flag;

	@Value("${redis.password}")
	private String password;

	@Value("${redis.maxIdle}")
	private Integer maxidle;

	@Value("${redis.maxTotal}")
	private Integer maxtotal;

	@Bean
	public JedisPool initPool(){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(maxtotal);
		config.setMaxIdle(maxidle); 
		config.setTestOnBorrow(flag);
		pool = new JedisPool(config, host, port, timeout,password);
		return pool;
	}
	
	public void initialize() {
		pool = new JedisPool(new JedisPoolConfig(), host, port, timeout,password);
	}
	
	public synchronized Jedis buildJedis(int db){
		Jedis jedis = null;
		try{
			jedis = pool.getResource();	
			if (!jedis.isConnected()){
				jedis.connect();
			}
			if(flag){
				jedis.select(db);
			}
		}catch(Exception e){
			System.out.println();
		}
		return jedis;
	}
	
	public synchronized void returnResource(Jedis jedis){
		if(null != jedis){
			pool.returnResource(jedis);
		}
	}
	
	public synchronized void returnBrokenResource(Jedis jedis){
		if(null != jedis){
			pool.returnBrokenResource(jedis);
		}
	}
	
	public void stop() {
		pool.destroy();
	}
	
}
