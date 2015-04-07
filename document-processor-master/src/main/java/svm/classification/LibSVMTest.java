package svm.classification;
import java.io.IOException;

public class LibSVMTest {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Test for svm_train and svm_predict
		//svm_train: 
		//	  param: String[], parse result of command line parameter of svm-train
		//    return: String, the directory of modelFile
		//svm_predect:
		//	  param: String[], parse result of command line parameter of svm-predict, including the modelfile
		//    return: Double, the accuracy of SVM classification
		//String[] trainArgs = {"D:/file/SVMFile/train"};//directory of training file
		//String modelFile = svm_train.main(trainArgs);
		//System.out.println(modelFile);
		
		String[] testArgs = {"D:/file/SVMFile/SortedTest.txt", "D:/file/SVMFile/SVMModel", "result"};//directory of test file, model file, result file
		
		Double accuracy = svm_predict.main(testArgs);
		//System.out.println("SVM Classification is done! The accuracy is " + accuracy);
		
		//Test for cross validation
		//String[] crossValidationTrainArgs = {"-v", "10", "UCI-breast-cancer-tra"};// 10 fold cross validation
		//modelFile = svm_train.main(crossValidationTrainArgs);
		//System.out.print("Cross validation is done! The modelFile is " + modelFile);
	}

}
