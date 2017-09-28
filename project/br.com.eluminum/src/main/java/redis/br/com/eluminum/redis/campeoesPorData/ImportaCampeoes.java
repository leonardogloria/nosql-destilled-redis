package redis.br.com.eluminum.redis.campeoesPorData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import redis.clients.jedis.Jedis;

public class ImportaCampeoes {
	public static final  String[]  artistas = {"Jay-Z","Pink Floyd","Anitta","Pantera","Legião Urbana",
			"Adelle","Beyonce","Lobão","Titães","Jessie J","Katy Perry","Bon Jovi","Sam Smith","Ed Sheehan"};

	public static void main(String ...args){

		Jedis jedis  = new Jedis("192.168.99.100",6379);
		  DateTimeFormatter formatador = 
        		  DateTimeFormatter.ofPattern("dd-MM-yyyy");
		  LocalDate dataInicio = LocalDate.of(2016, 1, 1);
		  for(int i = 1;i<80;i++){
			  StringBuffer chaveBilboard = new StringBuffer("mais_ouvidos:bilboard:");
			  StringBuffer chaveSpotify = new StringBuffer("mais_ouvidos:spotify:");
			  StringBuffer chaveDeezer = new StringBuffer("mais_ouvidos:deezer:");
			  LocalDate nextWeek = dataInicio.plus(i, ChronoUnit.WEEKS);      

			  chaveBilboard.append(formatador.format(nextWeek));
			  chaveSpotify.append(formatador.format(nextWeek));
			  chaveDeezer.append(formatador.format(nextWeek));

			  
			  System.out.println(chaveDeezer);
			  
			  System.out.println(jedis.set(chaveBilboard.toString(), getListaAleatoria()));
			  System.out.println(jedis.set(chaveSpotify.toString(), getListaAleatoria()));
			  System.out.println(jedis.set(chaveDeezer.toString(), getListaAleatoria()));

			  
		  }

		
	}
	private static String getListaAleatoria() {
		List<String> semanal = new ArrayList<String>(Arrays.asList(artistas));
		StringBuffer lista = new StringBuffer();

		Random rand = new Random();
		for(int i=0;i<5;i++){
			
			int index = rand.nextInt(semanal.size());
			String artista = semanal.get(index);
			//System.out.println("O artista é: " + artista);
			lista.append(artista+ ", ");
			semanal.remove(index);
			
			
		}
		return lista.toString();
	}
	

}
