package Neo4jDataBase;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import resource.FilePath;

public class Neo4jConnection {
	private static final String DB_PATH = FilePath.DBPATH; // "neo4j-db";//
	private static GraphDatabaseService graphDb = new GraphDatabaseFactory()
			.newEmbeddedDatabase(DB_PATH);

	public static Transaction StartTx() {

		registerShutdownHook(graphDb);
		Transaction tx = graphDb.beginTx();
		return tx;
	}

	public static GraphDatabaseService StartGraphData() {
		return graphDb;

	}

	private static void registerShutdownHook(final GraphDatabaseService graphDb) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				graphDb.shutdown();
			}
		});
	}
}
