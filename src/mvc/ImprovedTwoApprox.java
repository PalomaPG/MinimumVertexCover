package mvc;

import java.util.LinkedList;

import graph.Graph;

public class ImprovedTwoApprox extends MVC{

	@Override
	public LinkedList<Integer> mvc(Graph graph) {
		// TODO Auto-generated method stub
		LinkedList<Integer> vertices = new LinkedList<Integer>();
		Graph aux_graph = new Graph();
		aux_graph.duplicateGraph(graph);
		int u, v;
		int n = graph.getN();
		while(true){
			if(aux_graph.isEmpty()) break;
			u= aux_graph.maxDegreeNode();
			vertices.add(u);
			v=aux_graph.maxNeig(u);
			if(v>-1) vertices.add(v);
			aux_graph.extractLinks2(u);
			aux_graph.extractLinks2(v);
		}
		return vertices;
	}

}
