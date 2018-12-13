package org.wt.book.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Tuple;

/**
 * redis 通用方法
 */
public interface RedisOperator {

	public JedisBuilder getBuilder();

	/**
	 ***************************************************
	 * key
	 ***************************************************
	 */
	public void set(String key, String value, int db);

	public String get(String key, int db);

	public Long incr(String key, int db);

	public Long incr(String key, long integer, int db);

	public boolean exists(String key, int db);

	public Long del(String key, int db);

	public String setex(String key, int seconds, String value, int db);

	/**
	 ***************************************************
	 * list
	 ***************************************************
	 */
	public void lpush(String key, String value, int db);

	public String rpop(String key, int db);

	public Long llen(String key, int db);

	public List<String> rrange(String key, long start, long end, int db);

	public void ltrim(String key, long start, long end, int db);

	public String lindex(String key, long index, int db);

	public Long rpush(String key, int db, String... strings);

	/**
	 ***************************************************
	 * hashset
	 ***************************************************
	 */
	public Long hset(String key, String field, String value, int db);

	public Long hlen(String key, int db);

	public Long hdel(String key, String field, int db);

	public String hget(String key, String field, int db);

	public Long hincrBy(String key, String field, long value, int db);

	/** add by yuruyi */
	public List<String> hmget(String key, int db, String... fields);

	public Map<String, String> hgetAll(String key, int db);

	public Set<String> hkeys(String key, int db);

	/**
	 ***************************************************
	 * sets
	 ***************************************************
	 */
	public boolean sismember(String key, String member, int db);

	public Long sadd(int db, String key, final String... members);

	/**
	 ***************************************************
	 * sort sets
	 ***************************************************
	 */
	public void zadd(String key, double score, String member, int db);

	public Set<String> zrangeByScore(String key, double min, double max, int db);

	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int db);

	public Set<String> zrangeByScore(String key, double min, double max, int offset, int count, int db);

	public Double zscore(String key, String member, int db);

	public Long zrem(String key, String member, int db);

	public Set<String> zrevrange(String key, long start, long end, int db);

	public Set<String> zrevrangeByScore(String key, double max, double min, int db);

	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count, int db);

	public Long zcount(String key, double min, double max, int db);

	public Long zremrangeByScore(String key, double start, double end, int db);

	public Double zincrby(String key, double score, String member, int db);

	public Long zrank(String key, String member, int db);

	public Long zrevrank(String key, String member, int db);

	public Long zremrangeByRank(String key, long start, long end, int db);

	public Set<String> zrange(String key, long start, long end, int db);

	/**
	 * ZRANGE key start stop [WITHSCORES]
	 * <p>
	 * 返回有序集 key 中，指定区间内的成员。(其中成员的位置按 score 值递增(从小到大)来排序。)
	 * <p>
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @param db
	 * @return
	 */
	public Set<Tuple> zrangeWithScores(String key, long start, long end, int db);

	/**
	 * ZREVRANGE key start stop [WITHSCORES]
	 * <p>
	 * 返回有序集 key 中，指定区间内的成员。(其中成员的位置按 score 值递减(从大到小)来排)
	 * </p>
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @param db
	 * @return
	 */
	public Set<Tuple> zrevrangeWithScores(String key, long start, long end, int db);
	
	/**
	 * 清空db
	 * @param key
	 * @param start
	 * @param end
	 * @param db
	 * @return
	 */
	public String cleanDB(int db);

}
