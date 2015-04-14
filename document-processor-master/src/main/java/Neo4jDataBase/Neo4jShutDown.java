package Neo4jDataBase;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;

public class Neo4jShutDown {

	
	public static void  NSD(Transaction tx,GraphDatabaseService graphDb){
	 tx.success();
	 tx.finish();
		
	 graphDb.shutdown();
	}
}
