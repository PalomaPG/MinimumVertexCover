package main;

import java.util.concurrent.ThreadLocalRandom;

import graph.RandomGraph;
import mvc.Heuristic;
import mvc.ImprovedTwoApprox;
import mvc.TwoApprox;

public class Main {
	
	static double p[];
	
	public static void main(String [] args){
		
		testGraph(5);
	}
	
	public static void testGraph(int i){
		
		int n = (int) Math.pow(2, i);
		double p=ThreadLocalRandom.current().nextDouble(1.0/n,1.0);
		
		RandomGraph rg = new RandomGraph(i,p);
		//rg.show();
		
		TwoApprox ta = new TwoApprox();
		ta.show( ta.mvc(rg) );
		
		Heuristic heur = new Heuristic();
		heur.show( heur.mvc(rg) );
		
		ImprovedTwoApprox i2a = new ImprovedTwoApprox();
		i2a.show( i2a.mvc(rg) );
		
	}
}
