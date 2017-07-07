package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	protected int n;
	protected LinkedList<Integer>[] graph;
	
	public Graph(){}
	protected void buildGraph(){}
	
	public void duplicateGraph(Graph g){
		n = g.n;
		graph = new  LinkedList[n];
		for(int i=0; i<n;i++){
			graph[i] = new LinkedList<Integer>();
			Iterator<Integer> it = g.graph[i].iterator();
			while(it.hasNext()){
				graph[i].add(it.next());
			}
		} 
	}
	
	public void show(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n;i++){
			Iterator<Integer> it = graph[i].iterator();
			sb.append(String.format("Node %d adjacent to: ", i));
			while(it.hasNext()){
				sb.append(String.format(" %d ", it.next()));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public boolean isEmpty(){
		
		boolean b=true;
		for(int i=0; i<n; i++){
			if(!graph[i].isEmpty()) {
				b=false;
				break;
			}
		}
		
		return b;
	}
	public boolean disconnected(int i){
		if(graph[i].isEmpty()) return true;
		else return false;
	}
	
	public int extractLinks(int i){
		
		if(!graph[i].isEmpty()){
			int j =graph[i].removeFirst();
			Iterator <Integer> it = graph[i].iterator();
			while(it.hasNext()){
				int next = it.next();
				//System.err.println(next);
				//System.err.println(i);
				if(graph[next].contains(i))
					graph[next].remove((Integer)i);
			
			}
			graph[i].clear();
			return j;
		}
		else return -1;
	}
	
	public void extractLinks2(int i){
		if(i>-1){
			Iterator <Integer> it = graph[i].iterator();
			while(it.hasNext()){
				int next = it.next();
				//System.err.println(next);
				//System.err.println(i);
				if(graph[next].contains(i))
					graph[next].remove((Integer)i);
			
			}
			graph[i].clear();
		}
	}
	
	public int maxDegreeNode(){
		int degree = -1;
		int index=-1;
		for(int j=0;j<n;j++){
			if(graph[j].size()>degree){
				degree=graph[j].size();
				index=j;
			} 
		}
		return index;
	}
	
	public int maxNeig(int i){
		
		Iterator<Integer> it = graph[i].iterator();
		int degree = -1;
		int index = -1;
		while(it.hasNext()){
			int j = it.next();
			if(graph[j].size()>degree){
				degree = graph[j].size();
				index=j;
			}
		}
		return index;
	}
	
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public LinkedList<Integer>[] getGraph() {
		return graph;
	}
	public void setGraph(LinkedList<Integer>[] graph) {
		this.graph = graph;
	}
}
