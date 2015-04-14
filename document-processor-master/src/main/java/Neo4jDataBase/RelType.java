package Neo4jDataBase;

import org.neo4j.graphdb.RelationshipType;

public class RelType implements RelationshipType{

	String s;
	
	public RelType(String Rel) {
		super();
		this.s = Rel;
	}

	@Override
	public String name() {
		
		return s;
	}
}
