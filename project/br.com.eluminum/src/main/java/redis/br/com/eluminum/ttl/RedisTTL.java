package redis.br.com.eluminum.ttl;

import redis.clients.jedis.Jedis;

public class RedisTTL {
	public static void main(String[] args){
		
		
		
	}
	public void expire(){
		Jedis jedis = new Jedis("192.168.99.100",6379);
		String chave= "playlist:rock:12-09-2017";
		jedis.set(chave, "Walk,Du Hast,Run To The Hills");
		jedis.expire(chave, 30);
		
		//Adicionando novo valor ao Expire
		jedis.expire(chave,30);
		
		//Removendo TTL
		jedis.persist(chave);
		
		
		
	}
	public void getTTL(){
		Jedis jedis = new Jedis("192.168.99.100",6379);
		String chave= "playlist:rock:12-09-2017";
		System.out.println(jedis.ttl(chave));
		
		
	}
}
