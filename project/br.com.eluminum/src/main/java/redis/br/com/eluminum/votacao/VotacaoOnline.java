package redis.br.com.eluminum.votacao;

import java.util.Random;

import redis.clients.jedis.Jedis;

public class VotacaoOnline {
	public static void main(String ...args){
		Jedis jedis = new Jedis("192.168.99.100",6379);
		jedis.set("votacao:iron", "0");
		jedis.set("votacao:metallica", "0");
		jedis.set("votacao:slayer", "0");
		int votacaoIron = 0, votacaoMetallica = 0,votacaoSlayer = 0;
		Random rand = new Random();
		
		for(int i=0;i<1000;i++){
			int voto = rand.nextInt(3) + 1; 
			switch(voto){
			case 1:
				jedis.incr("votacao:iron");
				votacaoIron++;
				break;
			case 2: 
				jedis.incr("votacao:metallica");
				votacaoMetallica++;
				break;
			case 3: 
				jedis.incr("votacao:slayer");
				votacaoSlayer++;
				break;
				
			}
			
		}
		System.out.println(votacaoIron);
		System.out.println(votacaoMetallica);
		System.out.println(votacaoSlayer);
		//Decrementando
	    //jedis.decr("votacao:iron"); //Decrementando em 1
		
		//Incrementando em passo
		//jedis.incrBy("votacao:iron", 5); //Incrementa em 5
		//jedis.decrBy("votacao:iron",5); //Decrementando em 5
		
		//Incrementando em Float
		//jedis.incrByFloat("temperatura:rio", 5.3D); //Incrementando em 5.3
		

	}
}
