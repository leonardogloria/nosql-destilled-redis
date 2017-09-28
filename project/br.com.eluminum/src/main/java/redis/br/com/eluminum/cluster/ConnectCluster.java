package redis.br.com.eluminum.cluster;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class ConnectCluster {
	public static void main(String ... args){
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		//Jedis Cluster will attempt to discover cluster nodes automatically
		jedisClusterNodes.add(new HostAndPort("192.168.99.100", 6379));
		//jedisClusterNodes.add(new HostAndPort("192.168.99.100", 6380));
		//jedisClusterNodes.add(new HostAndPort("192.168.99.100", 6381));
		JedisCluster jc = new JedisCluster(jedisClusterNodes);
		jc.set("foo", "bar");
		String value = jc.get("foo");
	}

}
