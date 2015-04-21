package resource;

public class FilePath {
	//修改Path即可
	public static String Path="D:/file/";
	public static String CrfPath="Crf/";
	public static String SvmPath="SVMFile/";
	
	public static String DataToExtractFilePath=Path+"DataToExtract/FullData.xls";
	public static String CrfDataToTest=Path+CrfPath+"CrfDataToTest.txt";	
	public static String result=Path+CrfPath+"result";
	public static String resultAfterCTDB=Path+CrfPath+"resultAfterCTDB";
	
	
	public static String TrianDataPath=Path+"TrainData/TrainData.xls";
	public static String ManualLabeledabstract=Path+CrfPath+"ManualLabeledabstract.txt";
	public static String CrfAbstractToTrain=Path+CrfPath+"CrfAbstractToTrain.txt";
	public static String Train=Path+SvmPath+"Train.txt";
	public static String SortedTrain=Path+SvmPath+"SortedTrain.txt";
	public static String SVMModel=Path+SvmPath+"SVMModel";
	public static String DBPATH = Path+"Neo4jDataBase";
	
	

	
}
