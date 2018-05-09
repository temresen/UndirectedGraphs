package UndirectedGraphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public  class tester {
	public static  void main(String[] args) throws IOException {
		String[] komsular = null;
		ArrayList<City> sehirler = new ArrayList<City>();
		BufferedReader b = new BufferedReader(new FileReader("C:/Users/user/Desktop/cities.txt"));
		for(String list = b.readLine(); list != null; list = b.readLine())
		{
			String[] parcala = list.split(" ");
			int uzunluk = parcala.length;
			komsular = new String[uzunluk-2];
			for(int i = 2; i < parcala.length; i++)
			{
				komsular[i-2] = parcala[i];
			}
			sehirler.add(new City(parcala[0],parcala[1],komsular));
		}
		
		for(int m=0; m < sehirler.size(); m++)
		{
			System.out.println(sehirler.get(m).name);
			System.out.println("Komsular: "+sehirler.get(m).connections);
			System.out.println("");
		}
		Graph theGraph = new Graph(sehirler.size());
		for(int i=0; i<sehirler.size(); i++){
			theGraph.addConnection(i, sehirler.get(i).name); 
		}
	}
}
