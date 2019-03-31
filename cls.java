package projfiles;

import java.io.*;
import java.util.*;
/////Added Commit
class cls{
    public List<String[]> readData() throws FileNotFoundException, IOException{
        String dataset[][]=new String[200][15];

        List<String[]> dtst = new ArrayList<String[]>();
            FileInputStream inf=new FileInputStream("testdat.txt");
            InputStreamReader Im=new InputStreamReader(inf);
            BufferedReader br=new BufferedReader(Im);
           
            for(int i=0;i<7;i++){
                int j=0;
                String text=br.readLine();
                StringTokenizer st=new StringTokenizer(text,",");
                while(st.hasMoreTokens()){
                dataset[i][j]=st.nextToken();
                j++;
                }
                dtst.add(dataset[i]);
                
                 

    }
    br.close();

    return dtst;
}
}
