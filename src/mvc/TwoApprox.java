package mvc;

import java.util.LinkedList;



import graph.Graph;

public class TwoApprox extends MVC{

	@Override
	public LinkedList<Integer> mvc(Graph graph) {
		// TODO Auto-generated method stub
		LinkedList<Integer> vertices = new LinkedList<Integer>();
		
		Graph aux_graph = new Graph();
		aux_graph.duplicateGraph(graph);
		int n = graph.getN();
		while(true){
			if(aux_graph.isEmpty()) break;
			for(int i=0; i<n; i++){
				if(!aux_graph.disconnected(i)  && !vertices.contains((Integer)i)) vertices.add(i);
				int j=aux_graph.extractLinks(i);
				aux_graph.extractLinks2(j);
				
				if(j>-1 && !vertices.contains((Integer)j)) vertices.add(j);
			}
		}
		//aux_graph.show();
		return vertices;
	}


}
