package redisConnection;

import java.util.Iterator;
import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisConnection {

	public static void main(String[] args) throws Exception{
		try {
			Jedis jedis = new Jedis("localhost");
			System.out.println("Connection Successful");
			System.out.println("Server ping... Ping? " + jedis.ping());
			
			//Prueba set
			jedis.set("nombre", "Gaston");
			String setNombre = jedis.get("nombre");
			System.out.println(setNombre);
			
			//Prueba Mset
			jedis.mset("1", "Gaston", "2", "Ceccotti", "3", "41048362");
			List<String> mSetYo = jedis.mget("1","2","3");
			for (String yo : mSetYo) {
				System.out.println(yo);
			}
			
			//Eliminacion de las claves creadas (tanto para el set como el Mset)
			jedis.del("nombre","1","2","3");
			System.out.println("claves eliminadas");
			
			//Comprobacion de que pasa si quiero ver datos de una clave que no existe
				//Probamos con el set
			String setNombre2 = jedis.get("nombre");
			System.out.println(setNombre2);
			
			//Cierro la conexion con redis
			jedis.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
