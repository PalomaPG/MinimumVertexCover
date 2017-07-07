package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import graph.ExternalGraph;
import graph.Graph;
import graph.RandomGraph;
import mvc.Heuristic;
import mvc.ImprovedTwoApprox;
import mvc.TwoApprox;

public class Main {
	
	static double prob[];
	static final int n_probs = 5;
	static String path_to_ext;
	
	public static void main(String [] args) throws Exception{
		
		if(args.length<1) throw new Exception("Please, enter extern-data and output results paths ");
		System.err.println(args[0]);
		testRndGraph( args[1], "rnd_graph");
		//testExternFiles(args[0], args[1]+"ext_graph.txt");
	}
	
	public static void execTests(String pref, PrintWriter pw, TwoApprox ta, Heuristic heur, 
			ImprovedTwoApprox i2a, Graph graph){
		try{
			
			LinkedList<Integer> vta=ta.mvc(graph);
			LinkedList<Integer> vheur=heur.mvc(graph);
			LinkedList<Integer> vi2a=i2a.mvc(graph);
			int s_heur = vheur.size();
			int s_ta = vta.size();
			int s_i2a =vi2a.size();
			long rt_heur = heur.getRuntime();
			long rt_ta = ta.getRuntime();
			long rt_i2a = i2a.getRuntime();
			double mean = ((double)s_ta+(double)s_heur+(double)s_i2a)/3.0;
			String print_ =String.format("%s %d %d %d %d %d %d %f\n", pref, s_ta, rt_ta, s_heur,rt_heur, s_i2a, rt_i2a, mean);
			System.err.println(print_);
			pw.write(print_);
			
		}catch(Exception e){System.err.println("There was an error while executing");}
		System.err.println("DONE");
	}
	
	public static void testRndGraph(String path_output, String file_pref){
		/*TwoApprox ta =new TwoApprox();
		Heuristic heur = new Heuristic();
		ImprovedTwoApprox i2a=new ImprovedTwoApprox();*/
		
		
		try{
			
			for(int i=14; i<=20; i++){
				StringBuilder sb = new StringBuilder();
				sb.append(path_output).append(file_pref).append("_").append(i).append(".txt");
				PrintWriter writer = new PrintWriter(sb.toString());
				int n = (int) Math.pow(2, i);
				for(int j=1;j<=5;j++){
					double p=ThreadLocalRandom.current().nextDouble(1.0/n,1.0);
					RandomGraph rg = new RandomGraph(i,p);
					String prefix = String.format("%f %d", p, rg.getN());
					execTests(prefix, writer, new TwoApprox(), new Heuristic(), new ImprovedTwoApprox(), rg);
				}
				writer.close();
			}
			
		}catch (IOException e) {
			  System.err.println("An error has ocurred while writing");
		}
	}
	
	public static void testExternFiles(String path_input, String path_output){
		
		File folder = new File(path_input);
		/*TwoApprox ta =new TwoApprox();
		Heuristic heur = new Heuristic();
		ImprovedTwoApprox i2a=new ImprovedTwoApprox();*/
		
		try{
		    PrintWriter writer = new PrintWriter(path_output);
		
		    for (File fileEntry : folder.listFiles()) {
		    	ExternalGraph eg = new ExternalGraph(fileEntry.getAbsolutePath());
		    	String[] vals =fileEntry.getName().split("\\.");
		    	double p = Double.parseDouble(vals[1])/10;
		    	String prefix = String.format("%s %f %d", vals[0], p, eg.getN());
		    	execTests(prefix, writer, new TwoApprox(), new Heuristic(), new ImprovedTwoApprox(), eg);
		    	//eg.show();
		    }
		    writer.close();
		}catch (IOException e) {
			  System.err.println("An error has ocurred while writing");
		}


	}
	
}
