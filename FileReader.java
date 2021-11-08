import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class FileReader {
    public static ArrayList<String> NameArray = new ArrayList<>();
   public static ArrayList<String> PopulationData = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        System.out.println(PopulationData.size());
        readNames("AllGroups.txt");
        for(int i = 0; i < NameArray.size(); i++){
            readFile(NameArray.get(i));
        }
        System.out.println(PopulationData.size());
        /*ArrayList<String> data = new ArrayList<>();
        readFiletoArray("COMSC330_02.SEC", data);
*/
    }

    private static void readNames(String name) throws Exception{
        ArrayList<String> arr = new ArrayList<>();
        FileInputStream fstream = new FileInputStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

        while ((strLine = br.readLine()) != null)   {
            arr.add(strLine);
        }
        br.close();
        fstream.close();
        for(int i = 0; i < arr.size(); i++){
        FileInputStream arrstream = new FileInputStream(arr.get(i));
        BufferedReader ar = new BufferedReader(new InputStreamReader(arrstream));
            String str;
            String groupName = ar.readLine();

            while ((str = ar.readLine()) != null)   {
            NameArray.add(str);
            }
        }
        fstream.close();
    }

    private static void readFile(String name) throws Exception{
        String[] col;
        
        FileInputStream fstream = new FileInputStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

    while ((strLine = br.readLine()) != null)   {

        
          col = strLine.split("\\,", 5);
          PopulationData.add(col[col.length-1]); 
          //System.out.println(col[col.length-1]);
        

}

        //Close the input stream
fstream.close();


        }

        private static void readFiletoArray(String name, ArrayList<String> array) throws Exception{
            String[] col;
            FileInputStream fstream = new FileInputStream(name);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
    
        while ((strLine = br.readLine()) != null)   {
    
            
              col = strLine.split("\\,", 5);
              array.add(col[col.length-1]); 
              //System.out.println(col[col.length-1]);
            
    
    }
    
            //Close the input stream
    fstream.close();
    
    
            }

}
