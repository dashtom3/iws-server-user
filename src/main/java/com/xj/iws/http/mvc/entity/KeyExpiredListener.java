package com.xj.iws.http.mvc.entity;

import redis.clients.jedis.JedisPubSub;

public class KeyExpiredListener extends JedisPubSub {  
  
	@Override  
    public void unsubscribe() {  
        super.unsubscribe();  
    }  
  
    @Override  
    public void unsubscribe(String... channels) {  
        super.unsubscribe(channels);  
    }  
  
    @Override  
    public void subscribe(String... channels) {  
        super.subscribe(channels);  
    }  
  
    @Override  
    public void psubscribe(String... patterns) {  
        super.psubscribe(patterns);  
    }  
  
    @Override  
    public void punsubscribe() {  
        super.punsubscribe();  
    }  
  
    @Override  
    public void punsubscribe(String... patterns) {  
        super.punsubscribe(patterns);  
    }  
  
    @Override  
    public void onMessage(String channel, String message) {  
        System.out.println("channel:" + channel + "receives message :" + message);  
        this.unsubscribe();  
    }  
  
    @Override  
    public void onPMessage(String pattern, String channel, String message) {  
    System.out.println("12312321321312213123");
     //ҵ���߼���д��
    }  
  
    @Override  
    public void onSubscribe(String channel, int subscribedChannels) {  
        System.out.println("channel:" + channel + "is been subscribed:" + subscribedChannels);  
    }  
  
    @Override  
    public void onPUnsubscribe(String pattern, int subscribedChannels) {  
    	 System.out.println(2);
    }  
  
    @Override  
    public void onPSubscribe(String pattern, int subscribedChannels) {  
    	 System.out.println(3);
    }  
  
    @Override  
    public void onUnsubscribe(String channel, int subscribedChannels) {  
        System.out.println("channel:" + channel + "is been unsubscribed:" + subscribedChannels);  
    }  
  
  
  
}  