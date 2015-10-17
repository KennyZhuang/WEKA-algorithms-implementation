package weka.algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import weka.associations.FPGrowth;
import weka.core.Instances;


public class FPgrowthTree {

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
		BufferedReader datafile = readDataFile("students_test.txt");
		Instances data = new Instances(datafile);
		data.setClassIndex(data.numAttributes() - 1);
		
		//Define parameters for Apriori 
		double deltaValue = 0.05;
		double lowerBoundMinSupportValue = 0.1;
		double minMetricValue = 0.5;
		int numRulesValue = 20;
		double upperBoundMinSupportValue = 1.0;
		//Set up parameters for Apriori
		String fpgrowth_result;
		FPGrowth fpgrowth = new FPGrowth();
		fpgrowth.setDelta(deltaValue);
		fpgrowth.setLowerBoundMinSupport(lowerBoundMinSupportValue);
		fpgrowth.setNumRulesToFind(numRulesValue);
		fpgrowth.setUpperBoundMinSupport(upperBoundMinSupportValue);
		fpgrowth.setMinMetric(minMetricValue);
		String[] fpoptions = new String[] {"-N", "7"};
		fpgrowth.setOptions(fpoptions);
		
		try
		{
			fpgrowth.buildAssociations(data);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		fpgrowth_result = fpgrowth.toString();

		System.out.println(fpgrowth_result);
	}
}
