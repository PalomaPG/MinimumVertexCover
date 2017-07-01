package main;

import java.util.concurrent.ThreadLocalRandom;

import graph.ExternalGraph;
import graph.RandomGraph;
import mvc.Heuristic;
import mvc.ImprovedTwoApprox;
import mvc.TwoApprox;

public class Main {
	
	static double prob[];
	static final int n_probs = 5;
	public static void main(String [] args){
		
		prob = new double[11];
		//testGraphRnd(5);
		testExtGraph();
	}
	
	public static void testExtGraph(){
		
		ExternalGraph eg = new ExternalGraph(5);
		eg.buildGraph();
	}
	
	public static double testGraphRnd(int i){
		
		int n = (int) Math.pow(2, i);
		double p=ThreadLocalRandom.current().nextDouble(1.0/n,1.0);
		
		RandomGraph rg = new RandomGraph(i,p);
		//rg.show();
		
		TwoApprox ta = new TwoApprox();
		//ta.show( ta.mvc(rg) );
		
		Heuristic heur = new Heuristic();
		//heur.show( heur.mvc(rg) );
		
		ImprovedTwoApprox i2a = new ImprovedTwoApprox();
		//i2a.show( i2a.mvc(rg) );
		
		return p;
	}
	
	public static void globalTest(){
		
		/*Random graphs*/
		{
			
			for(int i=10; i<=20; i++){
				for(int j=1;j<=n_probs; j++)
					testGraphRnd(i);
					
			}
			
		}
		/*External graphs*/
		{
			
		}
		
	}
}
