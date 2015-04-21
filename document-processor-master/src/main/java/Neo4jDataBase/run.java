package Neo4jDataBase;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import tools.all.ExcelRead;

public class run {

	public static void main(String[] args) {
		String TrianDataPath = "D:/file/DataToExtract/FullData.xls";
		Transaction tx = Neo4jConnection.StartTx();
		// 连接数据库
		GraphDatabaseService graphDb = Neo4jConnection.StartGraphData();
		ArrayList<Patent> Pat = new ArrayList<Patent>();
		// 读取EXCEL的每一行数据
		ExcelRead ER = new ExcelRead();
		Pat = ER.ExcelReadingGetPatentData(TrianDataPath, 1, 1000);
		for (Patent patent : Pat) {
			System.out.println(patent.toString());

			Node PatentTitle;
			PatentTitle = graphDb.createNode();
			PatentTitle.setProperty("Title", patent.getName());

			Node AppNum;
			AppNum = graphDb.createNode();
			AppNum.setProperty("AppNumber", patent.getAppNum());
			PatentTitle.createRelationshipTo(AppNum, new RelType("申请号为"));

			Node PubNum;
			PubNum = graphDb.createNode();
			PubNum.setProperty("PubNumber", patent.getPubNum());
			PatentTitle.createRelationshipTo(PubNum, new RelType("公告号为"));

			//存入申请人数据
			String Ap = patent.getApplicant();
			if (Ap.equals("")) {
				//判断是否为空
			} else {
					int num=search(graphDb,"Applicant",Ap);
					if(num==-1){
						//没找到就新建
						Node Applicant;
						Applicant = graphDb.createNode();
						Applicant.setProperty("Applicant", Ap);
						PatentTitle.createRelationshipTo(Applicant, new RelType("申请人为"));											
					}else{
						//找到了就直接取出节点
						Node Applicant=graphDb.getNodeById(num);
						PatentTitle.createRelationshipTo(Applicant, new RelType("申请人为"));
					}	
			}
						
			Node Inventor;
			Inventor = graphDb.createNode();
			Inventor.setProperty("Inventor", patent.getInventor());
			PatentTitle.createRelationshipTo(Inventor, new RelType("发明人为"));

			Node AppDate;
			AppDate = graphDb.createNode();
			AppDate.setProperty("AppDate", patent.getAppDate());
			PatentTitle.createRelationshipTo(AppDate, new RelType("申请时间为"));

			Node PubDate;
			PubDate = graphDb.createNode();
			PubDate.setProperty("PubDate", patent.getPubDate());
			PatentTitle.createRelationshipTo(PubDate, new RelType("公告时间为"));

			Node PatIllu;
			PatIllu = graphDb.createNode();
			PatIllu.setProperty("PatIllu", patent.getPatIllu());
			PatentTitle.createRelationshipTo(PatIllu, new RelType("专利说明为"));

			Node Abstract;
			Abstract = graphDb.createNode();
			Abstract.setProperty("Abstract", patent.getAbstract());
			PatentTitle.createRelationshipTo(Abstract, new RelType("摘要为"));
			
			Node Effect;
			Effect = graphDb.createNode();
			Effect.setProperty("Effect", patent.getEffect());
			PatentTitle.createRelationshipTo(Effect, new RelType("功效为"));

			
			//存入类型数据
			String Ty = patent.getType();
			if (Ty.equals("")) {
				//判断是否为空
			} else {
				//使用循环取出所有用;隔开的字符串
				while (Ty.indexOf(";") != -1&&Ty.length()>=2) {
					int t = Ty.indexOf(";");
					String Sty=Ty.substring(0, t);
					int num=search(graphDb,"Type",Sty);
					if(num==-1){
						//没找到就新建
						Node Type;
						Type = graphDb.createNode();
						Type.setProperty("Type", Ty.substring(0, t));
						PatentTitle.createRelationshipTo(Type, new RelType("类型为"));												
					}else{
						//找到了就直接取出节点
						Node Type=graphDb.getNodeById(num);
						PatentTitle.createRelationshipTo(Type, new RelType("类型为"));
					}
					Ty = Ty.substring(t + 1);				
				}
			}
		}
	
		// 提交并断开数据库连接
		tx.success();
		System.out.println("SUCCESS");
		Neo4jShutDown.NSD(tx, graphDb);
	}

	public static int search(GraphDatabaseService graphDb,String Type,String Value) {
		Result result = graphDb.execute("match (n {"+Type+": '"+Value+"'}) return n");
		int Num = -1;
		while (result.hasNext()) {
			Map<String, Object> row = result.next();
			for (Entry<String, Object> column : row.entrySet()) {
				System.out.println(column.getKey() + ": " + column.getValue() + "; ");
				String s = column.getValue().toString();
				Num = Integer.parseInt(s.substring(s.indexOf("[") + 1, s.indexOf("]")));
			}
		}
		System.out.println(Num);
		return Num;
	}
}
