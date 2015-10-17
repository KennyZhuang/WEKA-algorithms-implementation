// Frequent pattern mining using Apriori algorithm

package weka.algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import weka.associations.Apriori;
import weka.core.Instances;

public class AprioriMining {

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
		String apriori_result;
		Apriori apriori = new Apriori();
		apriori.setDelta(deltaValue);
		apriori.setLowerBoundMinSupport(lowerBoundMinSupportValue);
		apriori.setNumRules(numRulesValue);
		apriori.setUpperBoundMinSupport(upperBoundMinSupportValue);
		apriori.setMinMetric(minMetricValue);
		
		try
		{
			apriori.buildAssociations( data );

		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		apriori_result = apriori.toString();

		System.out.println(apriori_result);
	}
}
