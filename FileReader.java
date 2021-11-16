import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class FileReader {
    private static ArrayList<String> NameArray = new ArrayList<>();
    private static ArrayList<String> GroupName = new ArrayList<>();
    private static ArrayList<String> PopulationData = new ArrayList<>();
    private static ArrayList<String> SampleData = new ArrayList<>();
    private static ArrayList<String> GroupData = new ArrayList<>();
    private static ArrayList<String> GroupNameArray = new ArrayList<>();
    public static void main(String[] args) throws Exception{

        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = "Y";
        
        readNames("AllGroups.txt");

        readGroupFile("COMSCprogram.GRP", GroupNameArray, PopulationData);

        while(!read.toLowerCase().equals("n")){

        compareClass(scan);
        
        System.out.print("Would you like to compare this class to another group? (Y/N)");
        read = br.readLine();
        if(read.toLowerCase().equals("n")){
            break;
        }

        compareGroup(scan);

        System.out.print("Would you like to compare another? (Y/N)");
        read = br.readLine();

        }

    }

    private static void compareGroup(Scanner scan) throws Exception{
        int name, n;
        String fName;
        File file2;

        for(int i = 0; i < GroupName.size(); i++){
            n = i + 1;
            String strin = GroupName.get(i);
            System.out.println(n + ". " + strin);
        }

        do{
            System.out.println("\nEnter the group you would like to compare: (Enter a ##) ");
            int j = GroupName.size();
            name = check(scan);
            while(!(name <= j && name > 0)){
                System.out.println("try again");
                name = check(scan);
            }
            fName = GroupName.get(name - 1);
            System.out.println("File: " + fName);
            file2 = new File(fName);
            }while(!file2.exists());

        readGroupFile(fName, NameArray, GroupData);
         
        Ztest test2 = new Ztest(SampleData, GroupData);
        //System.out.println("Selected Group Data: ");
       //System.out.println(Arrays.toString(test2.getPop()));
        System.out.println("Group Data : ");
        System.out.println(test2.getPopKeys().toString());
        System.out.println(test2.getPopValues().toString());
        System.out.println("Selected Class Data : ");
        System.out.println(test2.getSamKeys().toString());
        System.out.println(test2.getSamValues().toString());
        System.out.println("Calculations: ");
        System.out.println("Compaired Group Z-Score: "+test2.getZscore());
        System.out.println("Compaired Group Mean: "+test2.sampleMean());

    }

    private static void compareClass(Scanner scan) throws Exception{
        String fileName;
        File file;
        int name, n;

        for(int i = 0; i < GroupNameArray.size(); i++){
            n = i + 1;
            String strin = GroupNameArray.get(i);
            System.out.println(n + ". " + strin);
        }

        do{
            System.out.println("\nEnter the class you would like to compare to all COMSC programs: (Enter a ##) ");
            int j = GroupNameArray.size();
            name = check(scan);
            while(!(name <= j && name > 0)){
                System.out.println("try again");
                name = check(scan);
            }

            fileName = GroupNameArray.get(name - 1);
            System.out.println("File: " + fileName);
            file = new File(fileName);
            }while(!file.exists());
    
    
            readFiletoArray(fileName, SampleData);
    
            Ztest test = new Ztest(SampleData, PopulationData);
            //System.out.println(Arrays.toString(test.getPop()));
            //System.out.println(Arrays.toString(test.getSam()));
            System.out.println("Population Data : ");
            System.out.println(test.getPopKeys().toString());
            System.out.println(test.getPopValues().toString());
            System.out.println("Selected Class Data : ");
            System.out.println(test.getSamKeys().toString());
            System.out.println(test.getSamValues().toString());
            System.out.println("Calculations: ");
            System.out.println("Compaired Class Z-Score: "+test.getZscore());
            System.out.println("Compaired Class Mean: "+test.sampleMean());
            System.out.println();

    }

    
    private static int check(Scanner scan){
    while(!scan.hasNextInt()){
        System.out.println("try again");
                scan.next();
        }
        return scan.nextInt();
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
    }

    private static void readFiletoArray(String name, ArrayList<String> array) throws Exception{

        String[] col;
        FileInputStream fstream = new FileInputStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        br.readLine();
    
        while ((strLine = br.readLine()) != null)   {
    
            strLine = strLine.replace((char)9, ',');
            col = strLine.split("\\,", 5);
            array.add(col[col.length-1]); 
        }
   
        br.close();
        fstream.close();
    
    
    }

    private static void readGroupFile(String name, ArrayList<String> arraySz, ArrayList<String> arrayValues) throws Exception{
    
        String[] col;
        FileInputStream fstream = new FileInputStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        br.readLine();
    
        while ((strLine = br.readLine()) != null)   {
            arraySz.add(strLine);
        }

        br.close();
        fstream.close();

        for(int i = 0; i < arraySz.size(); i++){
            FileInputStream arrstream = new FileInputStream(arraySz.get(i));
            BufferedReader ar = new BufferedReader(new InputStreamReader(arrstream));
            String str;
            ar.readLine();
            

            while((str = ar.readLine()) != null){

                str = str.replace((char)9, ',');
                col = str.split("\\,", 5);
                arrayValues.add(col[col.length-1]); 
            }

        }
    }
}
