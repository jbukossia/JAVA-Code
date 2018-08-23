import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import org.apache.commons.lang.ArrayUtils;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.rules.DecisionTable;
import weka.classifiers.functions.SMO;
import weka.core.FastVector;
import weka.core.Instances;
import weka.filters.Filter;
import weka.core.OptionHandler;
import weka.filters.unsupervised.attribute.Remove;
import weka.classifiers.meta.FilteredClassifier;
import java.io.PrintWriter;
import java.io.File;
 
public class mlWeka {
	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;
 
		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
 
		return inputReader;
	}

	public static void main(String[] args) throws Exception {
		File path1 = new File("~/data/Train_output");
		File path2 = new File("~/data/Appl_output");
		String[] trainFiles = path1.list();
		Arrays.sort(trainFiles);
		String[] testFiles = path2.list();
		Arrays.sort(testFiles);

		for(int i=0; i<trainFiles.length; ++i) 
			System.out.println( i + "	:	" + trainFiles[i] );

		System.out.println("");
		System.out.println("");

		for(int i=0; i<testFiles.length; ++i) 
			System.out.println( i + "	:	" + testFiles[i] );

		for(int k = 0; k < trainFiles.length; ++k){
			BufferedReader trainfile = readDataFile(path1 + "/Train_" + k + ".arff");
			BufferedReader testfile = readDataFile(path2 + "/Appl_" + k + ".arff");

			Instances train = new Instances(trainfile);		
			Instances test = new Instances(testfile);
		
			Remove rm = new Remove();
			rm.setAttributeIndices("1");

			train.setClassIndex(train.numAttributes() - 1);
			test.setClassIndex(test.numAttributes() - 1); 

			SMO svm = new SMO();
		        String[] options1 = weka.core.Utils.splitOptions("-C 1.0 -L 0.001 -P 1.0E-12 -N 0 -M -V -1 -W 1 -K \"weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0\"");
		        svm.setOptions(options1);

			FilteredClassifier fc = new FilteredClassifier();
	 		fc.setFilter(rm);
	 		fc.setClassifier(svm);

			// Cross Validation
		        FastVector predictions = new FastVector();
	    		Evaluation eval = new Evaluation(train);
	   	 	eval.crossValidateModel(fc, train, 2, new Random(1));
			System.out.println(eval.toSummaryString("\nResults\n======\n", false));

			//Use test set
			fc.buildClassifier(train);
			PrintWriter writer = new PrintWriter("data/RECOMM_output/SMO_" + k + ".txt", "UTF-8");
			for (int i = 0; i < test.numInstances(); i++) {
				   double pred = fc.classifyInstance(test.instance(i));
				   if(!test.classAttribute().value((int) pred).startsWith("neg_"))
				   writer.println("MOVE " + (int) test.instance(i).value(0) + " TO hash:" + test.classAttribute().value((int) pred));
			 }
			writer.close();
//////////////////////	csv for mlPostprocess
			PrintWriter writeCSV = new PrintWriter("data/RECOMM_CSV/SMO_" + k + ".csv", "UTF-8");
			for (int i = 0; i < test.numInstances(); i++) {
				   double pred = fc.classifyInstance(test.instance(i));
				   if(!test.classAttribute().value((int) pred).startsWith("neg_"))
				   writeCSV.print((int) test.instance(i).value(0) + "," + test.classAttribute().value((int) pred) + ",");
			 }
			writeCSV.close();
/////////////////////////////////////////////
		}
	}
}
