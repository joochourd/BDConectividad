package mongoConnection;
import java.net.UnknownHostException;

import java.util.Arrays;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import mongoConnection.*;
public class MongoConnection {

	public static void main(String[] args) throws UnknownHostException {

	}
	public static String getNames(String nombre) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient();
		DB database = mongoClient.getDB("test");
		DBCollection collection = database.getCollection("usuarios");
		System.out.println(collection.getCount()); 
		
		DBObject query = new BasicDBObject("nombre", nombre);
		DBCursor cursor = collection.find(query);
		if(cursor.one() != null) {
			int returned = cursor.one().toString().indexOf("mail\" : \"");
			String value = cursor.one().toString().substring(returned+9, cursor.one().toString().length()-2);
			return value;
		}
		return "Usuario no encontrado";
	}
	public static void setNames(String mail, String nombre) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient();
		DB database = mongoClient.getDB("test");
		DBCollection collection = database.getCollection("usuarios");
		System.out.println(collection.getCount()); 
		
		DBObject person = new BasicDBObject("nombre", nombre).append("mail", mail);
		
		collection.insert(person);

	}

}
