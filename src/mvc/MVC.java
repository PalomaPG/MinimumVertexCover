package mvc;

import java.util.Iterator;
import java.util.LinkedList;

import graph.Graph;

public abstract class MVC {
	
	protected long runtime;
	public long getRuntime() {
		return runtime;
	}

	public void setRuntime(long runtime) {
		this.runtime = runtime;
	}

	public abstract LinkedList<Integer> mvc(Graph graph);
	
	public void show(LinkedList<Integer> ll){
		
		Iterator<Integer> it = ll.iterator();
		StringBuilder sb = new StringBuilder();
		sb.append("Vertices: \n");
		while(it.hasNext()){
			sb.append(String.format(" %d \n", it.next()));
		}
		
		System.err.println(sb.toString());
		System.err.println(String.format("total length: %d",  ll.size()));
	}
	

	
}
