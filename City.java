package UndirectedGraphs;

import java.util.ArrayList;

public class City {
	String id;
	String name;
	ArrayList<String> connections=new ArrayList<>();

	public City(String id, String name, String ... a){
		this.id=id;
		this.name=name;
		for(String k : a){
			connections.add(k);
		}
	}	
}
