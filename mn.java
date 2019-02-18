package projfiles;

import java.io.*;
import java.util.*;

class mn{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T,k;

        List<String[]> dataset = new ArrayList<String[]>();
        dataset=new cls().readData();

        System.out.print("Enter the Number of records to be used:");
        T=Integer.parseInt(br.readLine());

        System.out.print("Enter value of k:");
        k=Integer.parseInt(br.readLine());



    }
}
