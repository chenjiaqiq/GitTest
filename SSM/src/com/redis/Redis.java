package com.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Redis extends JedisPubSub {
   public static void main(String[] args) {
      //连接本地的 Redis 服务
      Jedis jedis = new Jedis("localhost");
      System.out.println("Connection to server sucessfully");
      //查看服务是否运行
      System.out.println("Server is running: "+jedis.ping());
      //获取存储在jedis中的字符
      String name = getRedisTypeOfString(jedis);
      System.out.println("name is : "+name);
      setRedisList(jedis);
 }
   
  public static String getRedisTypeOfString(Jedis jedis){
	  jedis.set("name","heaven");
	  return jedis.get("name");
  }
 
  public static void redisListSet(Jedis jedis){
	  List<String> l = new ArrayList<String>();
	  l.add("a");
	  jedis.lpush("l", "a");
  }
  public static void redisPublis(Jedis jedis){
	  Redis r = new Redis();
	  jedis.psubscribe(r, "redisChat");
	  jedis.publish("redisChat","today is Thursday" );
  }
  
  public static void setRedisList(Jedis jedis){
	 jedis.hdel("user","l");
	 jedis.del("retryList");
	 jedis.lpush("retryList", "a");
	 jedis.lpush("retryList", "b");
	 jedis.lpush("retryList", "c");
	 jedis.lpush("retryList", "d");
	 List<String> l = jedis.lrange("retryList", 0, 1000);
	 for(String retry :l){
		 System.out.println("retry:   "+ retry);
	 }
	 jedis.hset("user","l",l.toString());
	 jedis.del("l");
	 String s = jedis.hget("user", "l");
	 System.out.println("s:   "+ s);

  }
  
  
  @Override
  public void onMessage(String channel, String message) {  
      System.out.println("onMessage " +channel + "=" + message);  
  }  

  // 初始化订阅时候的处理  
  @Override
  public void onSubscribe(String channel, int subscribedChannels) {  
       System.out.println("onSubscribe " + channel + "=" + subscribedChannels);  
  }  

  // 取消订阅时候的处理  
  @Override
  public void onUnsubscribe(String channel, int subscribedChannels) {  
       System.out.println("onUnsubscribe " + channel + "=" + subscribedChannels);  
  }  

  // 初始化按表达式的方式订阅时候的处理  
  @Override
  public void onPSubscribe(String pattern, int subscribedChannels) {  
       System.out.println("onPSubscribe " + pattern + "=" + subscribedChannels);  
  }  

  // 取消按表达式的方式订阅时候的处理  
  @Override
  public void onPUnsubscribe(String pattern, int subscribedChannels) {  
       System.out.println("onPUnsubscribe " + pattern + "=" + subscribedChannels);  
  }  

  // 取得按表达式的方式订阅的消息后的处理  
  @Override
  public void onPMessage(String pattern, String channel, String message) {  
      System.out.println("onPMessage " + pattern + "=" + channel + "=" + message);  
  }  
}