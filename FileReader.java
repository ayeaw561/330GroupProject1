import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class FileReader {
    public static ArrayList<String> NameArray = new ArrayList<>();
    public static ArrayList<String> GroupName = new ArrayList<>();
    public static ArrayList<String> PopulationData = new ArrayList<>();
    public static ArrayList<String> SampleData = new ArrayList<>();
    public static ArrayList<String> GroupData = new ArrayList<>();
    public static void main(String[] args) throws Exception{

        File file, file2;
        String fileName, fName;
        
        readNames("AllGroups.txt");

        for(int i = 0; i < NameArray.size(); i++){
            String strin = NameArray.get(i);
            System.out.println(strin);
            readFile(strin);
        }
        
        Scanner scan = new Scanner(System.in);
        do{
        System.out.println("\nEnter the class you would like to compare: ");
        fileName = scan.nextLine();
        file = new File(fileName);
        }while(!file.exists());

        readFiletoArray(fileName, SampleData);

        Ztest test = new Ztest(SampleData, PopulationData);
        System.out.println(Arrays.toString(test.getPop()));
        System.out.println("Sample Z-Score: "+test.getZscore());
        System.out.println("Sample Mean: "+test.sampleMean());
        System.out.println();

        do{
            System.out.println("\nEnter the group you would like to compare: ");
            fName = scan.nextLine();
            file2 = new File(fName);
            }while(!file2.exists());

        readGroupFile(fileName);

        Ztest test2 = new Ztest(SampleData, GroupData);
        System.out.println(Arrays.toString(test2.getPop()));
        System.out.println("Group Z-Score: "+test2.getZscore());
        System.out.println("Group Mean: "+test2.sampleMean());

    }


    private static void readNames(String name) throws Exception{
        
        FileInputStream fstream = new FileInputStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        while ((strLine = br.readLine()) != null)   {
            GroupName.add(strLine);
        }

        br.close();
        fstream.close();

        for(int i = 0; i < GroupName.size(); i++){
            FileInputStream arrstream = new FileInputStream(GroupName.get(i));
            BufferedReader ar = new BufferedReader(new InputStreamReader(arrstream));
            String str;
            String groupName = ar.readLine();
            System.out.println(groupName);

            while ((str = ar.readLine()) != null)   {
                NameArray.add(str);
                //System.out.println(str);
            }
        }
        fstream.close();
    }

    private static void readFile(String name) throws Exception{
        String[] col;
        
        FileInputStream fstream = new FileInputStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        String groupName = br.readLine();
        //System.out.println(groupName);

        while ((strLine = br.readLine()) != null)   {

          strLine = strLine.replace((char)9, ',');
          //System.out.println(strLine);
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
    
            strLine = strLine.replace((char)9, ',');
            //System.out.println(strLine);
            col = strLine.split("\\,", 5);
            array.add(col[col.length-1]); 
            //System.out.println(col[col.length-1]);
            
    
        }
    
        //Close the input stream
        fstream.close();
    
    
    }

    private static void readGroupFile(String name) throws Exception{
        ArrayList<String> nameArr = new ArrayList<>();
        String[] col;
        FileInputStream fstream = new FileInputStream("COMSC330.GRP");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        String groupName = br.readLine();
        //System.out.println(groupName);
    
        while ((strLine = br.readLine()) != null)   {
            nameArr.add(strLine);
    
        }

        br.close();
        fstream.close();

        for(int i = 0; i < nameArr.size(); i++){
            FileInputStream arrstream = new FileInputStream(nameArr.get(i));
            BufferedReader ar = new BufferedReader(new InputStreamReader(arrstream));
            String str;
            ar.readLine();
            //System.out.println(groupName);

            while((str = ar.readLine()) != null){
                str = str.replace((char)9, ',');
                //System.out.println(str);
                col = str.split("\\,", 5);
                GroupData.add(col[col.length-1]); 
                //System.out.println(col[col.length-1]);
            }
    
        //Close the input stream
        fstream.close();
    
    
    }
    }
}