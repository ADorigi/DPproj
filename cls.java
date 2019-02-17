package projfiles;

import java.io.*;
import java.util.*;

class cls{
    public String[][] readData() throws FileNotFoundException, IOException{
        String dataset[][]=new String[100][15];
            FileInputStream inf=new FileInputStream("adult.txt");
            InputStreamReader Im=new InputStreamReader(inf);
            BufferedReader br=new BufferedReader(Im);
            System.out.println("Text from File is as Follows..");
           
            for(int i=0;i<100;i++){
                int j=0;
                String text=br.readLine();
                StringTokenizer st=new StringTokenizer(text,",");
                 while(st.hasMoreTokens()){
                   dataset[i][j]=st.nextToken();
                   j++;
                 }
    }
    return dataset;
}
}