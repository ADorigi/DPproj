package projfiles;

import java.io.*;
import java.util.*;

class cls{
    public List<String[]> readData() throws FileNotFoundException, IOException{
        String dataset[]=new String[15];

        List<String[]> dtst = new ArrayList<String[]>();
            FileInputStream inf=new FileInputStream("adult.txt");
            InputStreamReader Im=new InputStreamReader(inf);
            BufferedReader br=new BufferedReader(Im);
           
            for(int i=0;i<100;i++){
                int j=0;
                String text=br.readLine();
                StringTokenizer st=new StringTokenizer(text,",");
                 while(st.hasMoreTokens()){
                   dataset[j]=st.nextToken();
                   j++;
                 }
                 dtst.add(dataset);

    }
    return dtst;
}
}