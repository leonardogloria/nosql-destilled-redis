package redis.br.com.eluminum.redis.helloredis;

import redis.clients.jedis.Jedis;

public class HelloRedis {
	public static void main(String ... args){
		Jedis jedis = new Jedis("192.168.99.100",6379);
		String resultado = jedis.echo("Hello Redis");
		System.out.println(resultado);
	}

}
