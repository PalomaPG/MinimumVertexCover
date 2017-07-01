package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ExternalGraph extends Graph{

	private int [] selected_nodes;
	
	public ExternalGraph(int i){
		n= (int) Math.pow(2, i);
		selected_nodes = new int[n];
		graph = new LinkedList[n];
	}

	@Override
	public void buildGraph() {
		// TODO Auto-generated method stub
		//ReadFile
		
		try {
			System.out.println("Holaa");
			BufferedReader br = new BufferedReader(new FileReader("/home/paloma/workspace/Tarea3/extern-data/graph.pg"));
			int n_nodes = Integer.parseInt(br.readLine());
			br.readLine();
			String line;
		    while (true) {

		        line = br.readLine();
		        if(line==null) break;
		        String [] vals = line.split("\t| ");
		        System.err.println(vals[0]);
		        
		        
		    }
		    
		}catch(IOException e){
			System.err.println("Error while reading");
		}
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
