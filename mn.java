package projfiles;

import java.io.*;
import java.util.*;
import java.lang.Math;

class mn{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T,k,p;

        List<String[]> dataset = new ArrayList<String[]>();
        dataset=new cls().readData();

        System.out.print("Enter the Number of records to be used:");
        T=Integer.parseInt(br.readLine());

        System.out.print("Enter value of k:");
        k=Integer.parseInt(br.readLine());

        System.out.print("Number of clusters are:");
        p=(int)Math.floor(T/k);
        System.out.println(p);

        List<List<Integer>> cluster= new ArrayList<List<Integer>>(); // stores list of elements in array
        Set<Integer> first=new HashSet<Integer>();//stores the first random elements in each cluster
        Random r=new Random();

        //initialize each cluster
        for(int i = 0; i < p; i++)  {
            cluster.add(new ArrayList<Integer>());
        }

        while(first.size()<p){
            first.add((r.nextInt(T)+1));
        }

        System.out.println(first);

        List<Integer> firstl = new ArrayList<Integer>(first);

        // add the first random elements of each cluster in the 
        for(int i=0;i<p;i++){
            cluster.get(i).add(firstl.get(i));
        }
        System.out.println(cluster);

        
    }
}
