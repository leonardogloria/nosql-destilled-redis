package redis.br.com.eluminum.redis.helloredis;

import redis.clients.jedis.Jedis;

public class Starter {
	private static Jedis jedis;
	public static void main(String ... args){
		Starter.exemploDelete();
		Starter.exemploSet();
		Starter.exemploGet();
	}
	public static void exemploSet(){
		jedis = new Jedis("192.168.99.100",6379);
		String resultado = jedis.set("ultimo_usuario_logado","lgloria");
		System.out.println(resultado);
	}
	public static void exemploGet(){
		jedis = new Jedis("192.168.99.100",6379);
		String resultado = jedis.get("ultimo_usuario_logado");
		System.out.println(resultado);
	}
	public static void exemploDelete(){
		jedis = new Jedis("192.168.99.100",6379);
		Long resultado = jedis.del("ultimo_usuario_logado");
		System.out.println(resultado);
	}

}
