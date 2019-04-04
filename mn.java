package projfiles;

import java.io.*;
import java.util.*;
import java.lang.Math;

class mn{

    static int T,k,p; //T-number of records     k- anonymization     p- number of clusters
    static List<Integer> cntr; //centroids
    static List<String[]> dataset = new ArrayList<String[]>();
    static int natt=0;
    static List<Double> nni= new ArrayList<Double>();
    static List<String> catAnony = new ArrayList<String>();
    static List<List<Integer>> cluster= new ArrayList<List<Integer>>(); // stores list of elements in array

    //number of attributes
    /*static double[] aver;
    static double[] stddev;*/

    

    //this function calculates the prerequisites of all the attributes
    /*public static void calcPre(){
        double s=0;
        for(int i=0;i<T;i++){
            s+=Double.parseDouble(dataset.get(i)[0]);
        }
        aver[0]=s/T;
        s=0;
        for(int i=0;i<T;i++){
            s+=Double.parseDouble(dataset.get(i)[1]);
        }
        aver[1]=s/T;

    }*/


    //this function will decide the cluster with closest centroid for the point 'a'
    public static void calcPre(){   // int a is the new record 
        
        double avg=0;
        double stdev=0;
        
        
        //For numerical data
        int sum=0;
        for(int i=1;i<dataset.size();i++)
            sum+=Integer.parseInt(dataset.get(i)[0]);
        avg=sum/(dataset.size());

        sum=0;
        for(int i=1;i<dataset.size();i++)
            stdev+=(Integer.parseInt(dataset.get(i)[0])-avg)*(Integer.parseInt(dataset.get(i)[0])-avg);
        stdev=stdev/(dataset.size());
        stdev=Math.sqrt(stdev);

        for(int i=1;i<dataset.size();i++){
            nni.add(Math.abs(Integer.parseInt(dataset.get(i)[0])-avg)/stdev);
            System.out.println(nni.get(i-1));
        }



        //for Categorical data
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the level of anonymization for categorical data:");
        int lvl= sc.nextInt();
        

        if(lvl==0){
            for(int i=1;i<dataset.size();i++){
                String str= dataset.get(i)[2];
                catAnony.add(str);
            }
        }
        else if(lvl==1){
            for(int i=1;i<dataset.size();i++){
                String str= dataset.get(i)[2];
                if(str.equals("Chennai") || str.equals("Vellore"))
                    catAnony.add("Tamil Nadu");
                else
                    catAnony.add("Karnataka");
            }
        }
        else if(lvl==2){
            for(int i=1;i<dataset.size();i++)
                catAnony.add("India");
        }


        

        System.out.println(avg);
        System.out.println(stdev);

        System.out.println(catAnony);

    }

    public static double dista(int a, int b){
        double dis=0;
    
        dis= Math.pow((nni.get(a)-nni.get(b)),2);
        if(catAnony.get(a).equals(catAnony.get(b)))
            dis+=1;
        
        dis= Math.sqrt(dis);
        
        return dis;
        
    }

    public static int clusterDecide(int a){

        int clus=0;
        double dis=dista(a, cntr.get(0));
        for(int i=1;i<cntr.size();i++){
            System.out.print(dis+" "+dista(a, cntr.get(i)));
            if(dista(a, cntr.get(i))<dis){
                dis=dista(a, cntr.get(i));
                clus=i;
            }
        }
        System.out.println();

        return clus;
        
    }

    public static void changeCntr(int x){
        
        List<Integer> curr = new ArrayList<Integer>(cluster.get(x));
        double distances[] = new double[cluster.get(x).size()];
        double disum =0;
        int cntro=0;

        if(cluster.get(x).size()>2){
            for(int i=0;i<curr.size();i++){
                disum=0;
                for(int j=0;j<curr.size();j++){
                    if(i==j)
                        continue;
                    else{
                        disum+=dista(curr.get(i),curr.get(j));
                    }
                }
                distances[i]= disum;
            }

            for(int i=0;i<distances.length;i++)
                if(distances[i]<distances[cntro])
                    cntro=i;
            
            cntr.set(x, curr.get(cntro));
            System.out.println("Cluster changed");

        }

        
    }


    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T,k,p;
        
        Set<Integer> first=new HashSet<Integer>();//stores the first random elements in each cluster

        dataset=new cls().readData();
        //aver = new double[dataset.get(0).length];
        /*System.out.print("Enter the Number of records to be used:");
        T=Integer.parseInt(br.readLine());*/
        T=dataset.size()-1;

        System.out.print("Enter value of k:");
        k=Integer.parseInt(br.readLine());

        System.out.print("Number of clusters are:");
        p=(int)Math.floor(T/k);
        System.out.println(p);
        
        
        calcPre();

        
        Random r=new Random();

        //initialize each cluster
        for(int i = 0; i < p; i++)  {
            cluster.add(new ArrayList<Integer>());
        }

        while(first.size()<p){
            first.add((r.nextInt(T-1)+1));
        }

        System.out.println(first);

        List<Integer> firstl = new ArrayList<Integer>(first);
        // add the first random elements of each cluster in the cluster list
        for(int i=0;i<p;i++){
            cluster.get(i).add(firstl.get(i));
        }
        System.out.println(cluster);
        
        cntr = new ArrayList<Integer>(firstl);//list to store centroid
        int decClus = 0;    //The clustre to which the record will be assigned
        for(int i=0;i<T;i++){
            if(firstl.contains(i))
                continue;
            else{
                firstl.add(i);
                decClus=clusterDecide(i);
                cluster.get(decClus).add(i);
                changeCntr(decClus);
            }

            System.out.println("cntr:" + cntr);
            System.out.println("cluster:"+cluster);

        }

        

        /*dataset=new cls().readData();
        for(int i=0;i<dataset.size();i++){
            String[] a = dataset.get(i);
            System.out.println(a[0]);
        } */

        



    }
}
