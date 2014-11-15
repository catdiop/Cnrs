package enseirb.t3.ressource;

import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import enseirb.t3.entity.Atelier;

public class ConnectToDatabase {
		private static String databaseName="myDb";
		
	public static Datastore connect() {
		try {
			
			List<MongoCredential> mongoCredential=new LinkedList<MongoCredential>();
			
			ServerAddress serverAddress=new ServerAddress("localhost", 27017);
			
			Mongo mongoClient = new MongoClient(serverAddress, mongoCredential);
			
			Morphia morphia=new Morphia();
			morphia.map(Atelier.class);
			Datastore ds=morphia.createDatastore(mongoClient, databaseName);
			return ds;
		}
		catch(UnknownHostException u) {
			System.out.println("Error: "+u.getMessage());
		}
		return null;
	}
	
}
