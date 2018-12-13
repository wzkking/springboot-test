package org.wt.book.redis.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wt.book.redis.JedisBuilder;
import org.wt.book.redis.RedisOperator;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;



@Component
public class RedisOperatorImpl implements RedisOperator {
	
	private Logger logger = LoggerFactory.getLogger(RedisOperatorImpl.class);

	@Autowired
	private JedisBuilder builder;
	
	public JedisBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(JedisBuilder builder) {
		this.builder = builder;
	}

	/**
	 ***************************************************
	 *                   key
	 ***************************************************
	 */
	public void set(String key, String value, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			jedis.set(key, value);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call set(key="+key+", value="+value+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call set(key="+key+", value="+value+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
	}
	
	public String get(String key, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.get(key);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call get(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call get(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Long incr(String key, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.incr(key);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call incr(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call incr(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Long incr(String key, long integer, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.incrBy(key, integer);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call incr(key="+key+", index="+integer+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call incr(key="+key+", index="+integer+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public boolean exists(String key, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.exists(key);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call exists(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call exists(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return false;
	}
	
	public Long del(String key, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.del(new String[]{key});
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call del(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call del(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	public String setex(String key, int seconds, String value, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.setex(key, seconds, value);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call setex(key="+key+", time="+seconds+", value="+value+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call setex(key="+key+", time="+seconds+", value="+value+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	/**
	 ***************************************************
	 *                   list
	 ***************************************************
	 */
	public void lpush(String key, String value, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			jedis.lpush(key, value);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call lpush(key="+key+", value="+value+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call lpush(key="+key+", value="+value+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
	}
	
	public String rpop(String key, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.rpop(key);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call rpop(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call rpop(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Long llen(String key, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.llen(key);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call llen(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call llen(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public List<String> rrange(String key, long start, long end, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.lrange(key, 0- end, 0 -start);	
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call rrange(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call rrange(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public void ltrim(String key, long start, long end, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			jedis.ltrim(key, start, end);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call ltrim(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call ltrim(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
	}
	
	public String lindex(String key, long index, int db){
		String ret = null;
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			ret = jedis.lindex(key, index);
		}catch(Exception e){
			flag = false;
			logger.error("redis call ltrim(key="+key+", index="+index+", db="+db, e);
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return ret;
	}
	
	/**add by yuruyi*/
	public Long rpush(String key, int db, String ... strings){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.rpush(key, strings);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call rpush(key="+key+", db="+db+", values="+ strings +") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call rpush(key="+key+", db="+db+", values="+ strings +") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	/**
	 ***************************************************
	 *                   hashset
	 ***************************************************
	 */
	public Long hset(String key ,String field,String value,int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.hset(key, field, value);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call hset(key="+key+", field="+field+", value="+value+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call hset(key="+key+", field="+field+", value="+value+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Long hlen(String key ,int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.hlen(key);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call hlen(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call hlen(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	public Long hdel(String key,String field ,int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.hdel(key, field);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call hdel(key="+key+", field="+field+"db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call hdel(key="+key+", field="+field+"db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	public String hget(String key,String field ,int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.hget(key, field);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call hget(key="+key+", field="+field+"db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call hget(key="+key+", field="+field+"db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Long hincrBy(String key, String field, long value, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.hincrBy(key, field, value);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call hincrBy(key="+key+", field="+field+"db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call hincrBy(key="+key+", field="+field+"db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	/**add by yuruyi*/
	public List<String> hmget(String key, int db, String ... fields){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.hmget(key, fields);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call hmget(key="+key+", field="+fields+"db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call hmget(key="+key+", field="+fields+"db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Map<String,String> hgetAll(String key, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.hgetAll(key);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call hgetAll(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call hgetAll(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	/**add by yuruyi*/
	public Set<String> hkeys(String key, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.hkeys(key);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call hkeys(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call hkeys(key="+key+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	
	
	public boolean sismember(String key, String member, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.sismember(key, member);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call sismember(key="+key+", db="+db+ ", member=" + member + ") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call sismember(key="+key+", db="+db +", member=" + member + ") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return false;
	}

	public Long sadd(int db, String key, final String... members){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.sadd(key, members);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call sadd(key="+key+", db="+db+ ") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call sadd(key="+key+", db="+db + ") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return 0l;
	}
	
	
	/**
	 ***************************************************
	 *                   sort sets
	 ***************************************************
	 */
	public void zadd(String key, double score, String member, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			jedis.zadd(key, score, member);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zadd(key="+key+", score="+score+", member="+member+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zadd(key="+key+", score="+score+", member="+member+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
	}
	
	public Set<String> zrangeByScore(String key, double min, double max, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrangeByScore(key, min, max);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrangeByScore(key="+key+", min="+min+", max="+max+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrangeByScore(key="+key+", min="+min+", max="+max+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	//add by andy
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrangeByScoreWithScores(key, min, max);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrangeByScoreWithScores(key="+key+", min="+min+", max="+max+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrangeByScoreWithScores(key="+key+", min="+min+", max="+max+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Set<String> zrangeByScore(String key, double min, double max,int offset, int count, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrangeByScore(key, min, max, offset, count);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrangeByScore(key="+key+", min="+min+", max="+max+", offset="+offset+", count="+count+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrangeByScore(key="+key+", min="+min+", max="+max+", offset="+offset+", count="+count+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Double zscore(String key, String member, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zscore(key, member);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zscore(key="+key+", member="+member+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zscore(key="+key+", member="+member+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Long zrem(String key, String member, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrem(key, member);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrem(key="+key+", member="+member+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrem(key="+key+", member="+member+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	public Set<String> zrevrange(String key, long start, long end, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrevrange(key, start, end);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrevrange(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrevrange(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	public Set<String> zrevrangeByScore(String key, double min, double max, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrevrangeByScore(key, min, max);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrevrangeByScore(key="+key+", min="+min+", max="+max+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrevrangeByScore(key="+key+", min="+min+", max="+max+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrevrangeByScore(key, max, min, offset, count);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrevrangeByScore(key="+key+", min="+min+", max="+max+", offset="+offset+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrevrangeByScore(key="+key+", min="+min+", max="+max+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Long zcount(String key, double min, double max, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zcount(key, min, max);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zcount(key="+key+", min="+min+", max="+max+",db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zcount(key="+key+", min="+min+", max="+max+",db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Long zremrangeByScore(String key, double start, double end, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zremrangeByScore(key, start, end);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zremrangeByScore(key="+key+", start="+start+", end="+end+",db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zremrangeByScore(key="+key+", start="+start+", end="+end+",db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Double zincrby(String key, double score, String member, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zincrby(key, score, member);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zincrby(key="+key+", score="+score+", member="+member+",db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zincrby(key="+key+", score="+score+", member="+member+",db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	public Long zrank(String key, String member, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrank(key, member);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrank(key="+key+", member="+member+",db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrank(key="+key+", member="+member+",db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	public Long zrevrank(String key, String member, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrevrank(key, member);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrevrank(key="+key+", member="+member+",db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrevrank(key="+key+", member="+member+",db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	
	public Long zremrangeByRank(String key, long start, long end,int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zremrangeByRank(key, start,end);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zremrangeByRank(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zremrangeByRank(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}
	
	public Set<String> zrange(String key, long start, long end, int db){
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrange(key,start,end);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrange(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrange(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	public Set<Tuple> zrangeWithScores(String key, long start, long end, int db) {
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrangeWithScores(key, start, end);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrangeWithScores(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrangeWithScores(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	public Set<Tuple> zrevrangeWithScores(String key, long start, long end, int db) {
		Jedis jedis = builder.buildJedis(db);
		boolean flag = true;
		try{
			return jedis.zrevrangeWithScores(key, start, end);
		}catch(RuntimeException e){
			flag = false;
			logger.error("redis call zrangeWithScores(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}catch(Exception e){
			flag = false;
			logger.error("redis call zrangeWithScores(key="+key+", start="+start+", end="+end+", db="+db+") exception: "+e.toString());
			builder.returnBrokenResource(jedis);
		}finally{
			if(flag)
				builder.returnResource(jedis);
		}
		return null;
	}

	@Override
	public String cleanDB(int db) {
		// TODO Auto-generated method stub
		Jedis jedis = builder.buildJedis(db);
		try{
			String result = jedis.flushDB();
			return result;
		}catch(Exception e){
			builder.returnResource(jedis);
		}finally{
			builder.returnResource(jedis);
		}
		return null;
	}
}
