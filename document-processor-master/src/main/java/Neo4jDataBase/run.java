package Neo4jDataBase;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import tools.all.ExcelRead;

public class run {

	public static void main(String[] args) {
		String TrianDataPath="D:/file/DataToExtract/FullData.xls";	
		Transaction tx=Neo4jConnection.StartTx();
		//连接数据库
		GraphDatabaseService graphDb=Neo4jConnection.StartGraphData();
		ArrayList<Patent> Pat = new ArrayList<Patent>();
		//读取EXCEL的每一行数据
		ExcelRead ER=new ExcelRead();
		Pat=ER.ExcelReadingGetPatentData(TrianDataPath, 1, 1000);
		for(Patent patent:Pat){
						
			System.out.println(patent.toString());
					
			Node PatentTitle;
			PatentTitle = graphDb.createNode();
			PatentTitle.setProperty("Title", patent.getName());
			
			Node AppNum;
			AppNum = graphDb.createNode();
			AppNum.setProperty("AppNumber",patent.getAppNum());	
			PatentTitle.createRelationshipTo(AppNum,new RelType("申请号为"));				
			
			Node PubNum;
			PubNum = graphDb.createNode();
			PubNum.setProperty("PubNumber",patent.getPubNum());
			PatentTitle.createRelationshipTo(PubNum,new RelType("公告号为"));	
			
			Node Applicant;
			Applicant = graphDb.createNode();
			Applicant.setProperty("Applicant",patent.getApplicant());
			PatentTitle.createRelationshipTo(Applicant,new RelType("申请人为"));	
			
			Node Inventor;
			Inventor = graphDb.createNode();
			Inventor.setProperty("Inventor",patent.getInventor());
			PatentTitle.createRelationshipTo(Inventor,new RelType("发明人为"));	
			
			Node AppDate;
			AppDate = graphDb.createNode();
			AppDate.setProperty("AppDate",patent.getAppDate());
			PatentTitle.createRelationshipTo(AppDate,new RelType("申请时间为"));	
			
			Node PubDate;
			PubDate = graphDb.createNode();
			PubDate.setProperty("PubDate",patent.getPubDate());
			PatentTitle.createRelationshipTo(PubDate,new RelType("公告时间为"));
			
			Node PatIllu;
			PatIllu = graphDb.createNode();
			PatIllu.setProperty("PatIllu",patent.getPatIllu());
			PatentTitle.createRelationshipTo(PatIllu,new RelType("专利说明为"));
			
			Node Abstract;
			Abstract = graphDb.createNode();
			Abstract.setProperty("Abstract",patent.getAbstract());
			PatentTitle.createRelationshipTo(Abstract,new RelType("摘要为"));
			
		
		
		
			
		}
		//查询，返回的结果如n: Node[4];
	      Result result = graphDb.execute( "match (n {Inventor: '冀晓宇,刘云浩,何源,王继良.'}) return n" ); 
			
		    while ( result.hasNext() )
		    {
		        Map<String,Object> row = result.next();
		        for ( Entry<String,Object> column : row.entrySet() )
		        {
		            //rows += column.getKey() + ": " + column.getValue() + "; ";
		        	System.out.println(column.getKey() + ": " + column.getValue() + "; ");	
		        }
		     //   rows += "\n";
		    }
		  
		    
		//提交并断开数据库连接
		tx.success();
		System.out.println("SUCCESS");	
		Neo4jShutDown.NSD(tx, graphDb);
	}
	
	public static void ss() {
		Node firstNode;
		Node secondNode;
		Relationship relationship;

		Transaction tx=Neo4jConnection.StartTx();
		GraphDatabaseService graphDb=Neo4jConnection.StartGraphData();
		
	
			firstNode = graphDb.createNode();
			firstNode.setProperty("message", 123);
			secondNode = graphDb.createNode();
			secondNode.setProperty("message", "World!");
			relationship = firstNode.createRelationshipTo(secondNode,new RelType("包括"));	
			relationship.setProperty("message", "brave neo4j");			
			
		tx.success();
		System.out.println("SUCCESS");	
		Neo4jShutDown.NSD(tx, graphDb);
	}
}
