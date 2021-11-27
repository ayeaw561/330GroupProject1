import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.lang.String;

public class FileReaderAndZtest {
    private static ArrayList<String> NameArray = new ArrayList<>();
    private static ArrayList<String> GroupName = new ArrayList<>();
    private static ArrayList<String> PopulationData = new ArrayList<>();
    private static ArrayList<String> SampleData = new ArrayList<>();
    private static ArrayList<String> GroupData = new ArrayList<>();
    private static ArrayList<String> GroupNameArray = new ArrayList<>();
    private static NumberFormat form = new DecimalFormat("#0.000");

    public static ArrayList<String> arrayPopulation;
    public static ArrayList<String> arraySample;
    public static double[] arraySGPA;
    public static double[] arrayPGPA;
    public static double sampleMean; //section or group
    public static double popMean; //total popluation of data
    public static double popSD; //total population of data SD
    public static double zScore;
    public static HashMap<String,Integer> PopulationMap = new HashMap<>();
    public static HashMap<String,Integer> SampleMap = new HashMap<>();
    public static void main(String[] args) throws Exception{

        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = "Y";
        
        //reads and stores group files
        readNames("AllGroups.txt");

        readGroupFile("COMSCprogram.GRP", GroupNameArray, PopulationData);

        while(!read.toLowerCase().equals("n")){

        compareClass(scan);
        
        //prompts user compare selected class to a group
        System.out.print("Would you like to compare this class to another group? (Y/N)");
        read = br.readLine();
        if(read.toLowerCase().equals("n")){
            break;
        }

        compareGroup(scan);

        //prompts user to continue comparing
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

        //comparing class to group
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
        //dispalying group data
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
        System.out.println("Compaired Group Z-Score: "+form.format(test2.getZscore()));
        System.out.println("Compaired Group Mean: "+form.format(test2.sampleMean()));

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
        //prompts user to select a class to compare 
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
            
            //displaying class data
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
            System.out.println("Compaired Class Z-Score: "+form.format(test.getZscore()));
            System.out.println("Compaired Class Mean: "+form.format(test.sampleMean()));
            System.out.println();

    }

    //prompts user to try again if the file isnt found.
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
    //reads in the group data
    private static void readFiletoArray(String name, ArrayList<String> array) throws Exception{

        String[] col;
        FileInputStream fstream = new FileInputStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        br.readLine();
    
        while ((strLine = br.readLine()) != null)   {
    
            strLine = strLine.replace((char)9, ',');
            col = strLine.split("\\,", 5); // seperates data by colunm 
            array.add(col[col.length-1]); 
        }
   
        br.close();
        fstream.close();
    
    
    }
    //reads in the class data
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
    public void Ztest(ArrayList<String> arraySam, ArrayList<String> arrayPop){
        PopulationMap.clear();
        SampleMap.clear();
        arrayPopulation = arrayPop;
        arraySample = arraySam;
        double[] array = new double[arrayPopulation.size()];
        double[] array2 = new double[arraySample.size()];
        HashMap<String,Integer> PMap = new HashMap<>();
        HashMap<String,Integer> SMap = new HashMap<>();
        arrayPGPA = array;
        arraySGPA = array2;
        gpa(arrayPopulation, arrayPGPA, PMap);
        PopulationMap = sortByValue(PMap);
        gpa(arraySample, arraySGPA, SMap);
        SampleMap = sortByValue(SMap);
        popmean(arrayPGPA);
        samplemean(arraySGPA);
        calculateSD(arrayPGPA);
        ztest();
        
    }
    //Ztest(){
        
    //}

    public double getZscore(){
        return zScore;
    }

    public Set<String> getPopKeys(){
        return PopulationMap.keySet();
    }

    public Set<String> getSamKeys(){
        return SampleMap.keySet();
    }

    public Collection<Integer> getPopValues(){
        return PopulationMap.values();
    }
    public Collection<Integer> getSamValues(){
        return SampleMap.values();
    }

    public double[] getPop(){
        return arrayPGPA;
    }

    public double[] getSam(){
        return arraySGPA;
    }

    public double sampleMean(){
        return sampleMean;
    }
    
    public double popMean(){
        return popMean;
    }

    public static void setZscore(double z){
        zScore = z;
    }

    public void ztest(){
        zScore = (popMean - sampleMean)/ popSD;
    }

    public static void samplemean(double[] array)
    {
        double sum = 0;
        int length = array.length;
        for(double num : array){
            sum += num;
        }
        sampleMean = sum/length;
    }
    public static void popmean(double[] array)
    {
        double sum = 0;
        int length = array.length;
        for(double num : array){
            sum += num;
        }
        popMean = sum/length;
    }

    public static void calculateSD(double arrayNum[])
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = arrayNum.length;

        for(double num : arrayNum) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: arrayNum) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        popSD = Math.sqrt(standardDeviation/length);
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hashmap)
    {
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hashmap.entrySet());
 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            
            public int compare(Map.Entry<String, Integer> v1,
                               Map.Entry<String, Integer> v2)
            {
                return (v2.getValue()).compareTo(v1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        
        for (Map.Entry<String, Integer> val : list) {
            temp.put(val.getKey(), val.getValue());
        }
        return temp;
    }

    public static void gpa(ArrayList<String> arrayl, double[] arraylVal, HashMap<String, Integer> map){
        int value = 0;
        for(int i = 0; i < arrayl.size(); i++){
            String grade = arrayl.get(i).toString();
            if(!map.containsKey(grade)){
                map.put(grade, 0);
            }
            switch(grade)
            {
                case "A" :
                    arraylVal[i] = 4;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "A-" :
                    arraylVal[i] = 3.66;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "B+" :
                    arraylVal[i] = 3.33;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "B" :
                    arraylVal[i] = 3;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "B-" :
                    arraylVal[i] = 2.66;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "C+" :
                    arraylVal[i] = 2.33;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "C" :
                    arraylVal[i] = 2;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "C-" :
                    arraylVal[i] = 1.66;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "D+" :
                    arraylVal[i] = 1.33;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "D" :
                    arraylVal[i] = 1;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "D-" :
                    arraylVal[i] = .66;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;

                case "F" :
                    arraylVal[i] = 0;
                    value = map.get(grade);
                    value += 1;
                    map.replace(grade, value);
                break;
            }
            //System.out.println(map.values().toString());
        
        }


    }
}
