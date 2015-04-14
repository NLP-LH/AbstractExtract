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
	
	
	
	public static String getDB_PATH() {
		return DBPATH;
	}
	public static void setDB_PATH(String dBPATH) {
		DBPATH = dBPATH;
	}
	public static String getSVMModel() {
		return SVMModel;
	}
	public static void setSVMModel(String sVMModel) {
		SVMModel = sVMModel;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getCrfPath() {
		return CrfPath;
	}
	public void setCrfPath(String crfPath) {
		CrfPath = crfPath;
	}
	public String getSvmPath() {
		return SvmPath;
	}
	public void setSvmPath(String svmPath) {
		SvmPath = svmPath;
	}
	public String getDataToExtractFilePath() {
		return DataToExtractFilePath;
	}
	public void setDataToExtractFilePath(String dataToExtractFilePath) {
		DataToExtractFilePath = dataToExtractFilePath;
	}
	public String getCrfDataToTest() {
		return CrfDataToTest;
	}
	public void setCrfDataToTest(String crfDataToTest) {
		CrfDataToTest = crfDataToTest;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResultAfterCTDB() {
		return resultAfterCTDB;
	}
	public void setResultAfterCTDB(String resultAfterCTDB) {
		this.resultAfterCTDB = resultAfterCTDB;
	}
	public String getTrianDataPath() {
		return TrianDataPath;
	}
	public void setTrianDataPath(String trianDataPath) {
		TrianDataPath = trianDataPath;
	}
	public String getManualLabeledabstract() {
		return ManualLabeledabstract;
	}
	public void setManualLabeledabstract(String manualLabeledabstract) {
		ManualLabeledabstract = manualLabeledabstract;
	}
	public String getCrfAbstractToTrain() {
		return CrfAbstractToTrain;
	}
	public void setCrfAbstractToTrain(String crfAbstractToTrain) {
		CrfAbstractToTrain = crfAbstractToTrain;
	}
	public String getTrain() {
		return Train;
	}
	public void setTrain(String train) {
		Train = train;
	}
	public String getSortedTrain() {
		return SortedTrain;
	}
	public void setSortedTrain(String sortedTrain) {
		SortedTrain = sortedTrain;
	}

	
}
