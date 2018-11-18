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

import mongoConnection.*;
public class MongoConnection {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient();
		DB database = mongoClient.getDB("test");
		DBCollection collection = database.getCollection("usuarios");
		System.out.println(collection.getCount()); 
		
		DBObject query = new BasicDBObject("nombre", "Juan Perez");
		DBCursor cursor = collection.find(query);
		System.out.println(cursor.one());
	}

}
