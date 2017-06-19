package graph;

import java.util.LinkedList;

public class ExternalGraph extends Graph{

	private int [] selected_nodes;
	
	public ExternalGraph(int i){
		n= (int) Math.pow(2, i);
		selected_nodes = new int[n];
		graph = new LinkedList[n];
	}

	@Override
	protected void buildGraph() {
		// TODO Auto-generated method stub
		//ReadFile
	}
	
	private void selectVertices(int ext_vertices){
		
		int k=0;
		for(int j=0; j<ext_vertices; j++){
			double p = Math.random();
			if(p>=0.5) {
				selected_nodes[k]=j;
				k++;
				if(k>=n) break;
			}
		}
	}
}
