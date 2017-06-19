package graph;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGraph extends Graph{
	

	private double p;
	
	public RandomGraph(int i, double p){
		n = (int)Math.pow(2, i);
		graph = new LinkedList[n];
		for(int j = 0; j < n; j++)
			graph[j] = new LinkedList<Integer>();
		
		this.p = p;
		buildGraph();
	}

	protected void buildGraph(){
		
		double n_p;
		for(int j=0; j<n; j++)
			for(int k=j+1; k<n;k++){
				n_p = ThreadLocalRandom.current().nextDouble();
				if(n_p<=p) {
					graph[j].add(k);
					if(!graph[k].contains(j)) graph[k].add(j);
				}
			}
	}
	

}
