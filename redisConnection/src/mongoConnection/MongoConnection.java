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
		
		/*List<Integer> books = Arrays.asList(27464, 747854);
		DBObject person = new BasicDBObject("_id", "jo")
                .append("name", "Jo Bloggs")
                .append("address", new BasicDBObject("street", "123 Fake St")
                                             .append("city", "Faketon")
                                             .append("state", "MA")
                                             .append("zip", 12345))
                .append("books", books);
		collection.insert(person);*/
		DBObject query = new BasicDBObject("nombre", "Juan Perez");
		DBCursor cursor = collection.find(query);
		System.out.println(cursor.one());
	}

}
