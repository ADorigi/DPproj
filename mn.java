package projfiles;

import java.io.*;
import java.util.*;

class mn{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String dataset[][]= new String[100][15];
        dataset=new cls().readData();
        System.out.println(dataset[12][4]);
    }
}
