package mvc;

import java.util.LinkedList;

import graph.Graph;

public class Heuristic extends MVC{

	@Override
	public LinkedList<Integer> mvc(Graph graph) {
		// TODO Auto-generated method stub
		LinkedList<Integer> vertices = new LinkedList<Integer>();
		Graph aux_graph = new Graph();
		aux_graph.duplicateGraph(graph);
		int index;
		int n = graph.getN();
		while(true){
			if(aux_graph.isEmpty()) break;
			index= aux_graph.maxDegreeNode();
			vertices.add(index);
			aux_graph.extractLinks2(index);
		}
		return vertices;
	}

}
