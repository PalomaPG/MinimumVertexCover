package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ExternalGraph extends Graph{

	private int [] selected_nodes;
	private String path_to_graph;
	private int n_edges;
	
	public ExternalGraph(String path){
		path_to_graph = path;
		setN_edges(0);
		buildGraph();
	}

	@Override
	public void buildGraph() {
		// TODO Auto-generated method stub
		//ReadFile
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path_to_graph));
			String line;
			while((line=br.readLine()).charAt(0)=='c');
			String [] vals = line.split(" |\t");
			n=Integer.parseInt(vals[2]);
			setN_edges(Integer.parseInt(vals[3]));
			graph = new LinkedList[n];

			for(int i=0;i<n;i++)
				graph[i] = new LinkedList<Integer>();
			
		    while ((line = br.readLine())!=null) {

		    	if(line.charAt(0)!='e') break;
		        vals = line.split("\t| ");
		        graph[Integer.parseInt(vals[1])-1].add(Integer.parseInt(vals[2]));
		    }
			br.close();
		    
		}catch(IOException e){
			System.err.println("Error while reading");
		}
	}
	



	public int getN_edges() {
		return n_edges;
	}

	public void setN_edges(int n_edges) {
		this.n_edges = n_edges;
	}
}
