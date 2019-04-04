package projfiles;

import java.io.*;
import java.util.*;
/////Added Commit
class cls{
    public List<String[]> readData() throws FileNotFoundException, IOException{
        String dataset[][]=new String[200][15];

        List<String[]> dtst = new ArrayList<String[]>();
            FileInputStream inf=new FileInputStream("projfiles/testdat.txt");
            InputStreamReader Im=new InputStreamReader(inf);
            BufferedReader br=new BufferedReader(Im);
            String text;
            int i=0;
            while((text=br.readLine())!=null){
                int j=0;
                StringTokenizer st=new StringTokenizer(text,",");
                while(st.hasMoreTokens()){
                dataset[i][j]=st.nextToken();
                j++;
                }
                dtst.add(dataset[i]);
                i++;
            }
        br.close();

        return dtst;
    }
}
