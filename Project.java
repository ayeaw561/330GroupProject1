import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Project{
  public static void main(String[] args) throws Exception{
        ArrayList<String> GroupList = new ArrayList<>();

    // pass the file as a parameter
    File file = new File("AllGroups.txt");
    Scanner sc = new Scanner(file);
    //reads all lines in the text file then adds it to the ArrauList
    while (sc.hasNextLine()){  
       String Groups = sc.nextLine();
        GroupList.add(Groups);
    }
    sc.close();
      //goes through the ArrayList holding the list of the three groups 
      for(int i=0; i < GroupList.size(); i++){
        //Reading in the COMSC330 Group
        //looking the the first item in the array list
        if(i == 1){
          ArrayList<String> Group1 = new ArrayList<>();
          Scanner sc1 = new Scanner(new File(GroupList.get(0)));//scanning the first item in the ArrayList
            //Adds the contents of the first item in the GroupList ArrayList to the Group1 ArrayList
            while(sc1.hasNextLine()){
            String CSGroup1 = sc1.nextLine();
              Group1.add(CSGroup1);
            }
System.out.print(Group1+ "\n");     

//Reads 
for(int a = 1; a <= Group1.size(); a++){
  if (a == 1){
    ArrayList<String> Group1Data = new ArrayList<>();
    String line = null;
    //Scanner sc2 = new Scanner(new File(Group1.get(1)));
    FileInputStream is1 = new FileInputStream(Group1.get(1));
    FileInputStream is2 = new FileInputStream(Group1.get(2));
    SequenceInputStream is = new SequenceInputStream(is1, is2);
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    while((line = br.readLine()) != null){
      String CSGroup1Data = br.readLine();
System.out.print(CSGroup1Data + " | ");
    }
    }


  }   

          }

    //Reading the Senior Design Group
    else if(i == 2){
      ArrayList<String> Group2 = new ArrayList<>();
      Scanner sc2 = new Scanner(new File(GroupList.get(1)));//scanning the first item in the ArrayList
//for(int a = 1; a <= Group1.size(); a++){
        //Adds the contents of the first item in the GroupList ArrayList to the Group1 ArrayList
        while(sc2.hasNextLine()){
        String CSGroup2 = sc2.nextLine();
          Group2.add(CSGroup2);
    }
    System.out.print(Group2+ "\n");

    for(int a = 1; a <= Group2.size(); a++){
      if (a == 1){
        ArrayList<String> Group2Data = new ArrayList<>();
        String line = null;
        //Scanner sc2 = new Scanner(new File(Group1.get(1)));
        FileInputStream is1 = new FileInputStream(Group2.get(1));
        FileInputStream is2 = new FileInputStream(Group2.get(2));
        SequenceInputStream is = new SequenceInputStream(is1, is2);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while((line = br.readLine()) != null){
          String CSGroup2Data = br.readLine();
    System.out.print(CSGroup2Data + " | ");
        }
        }
    
    
      }

    }
    //Reading the Computer Science Program Group
    else {
      ArrayList<String> Group3 = new ArrayList<>();
      Scanner sc3 = new Scanner(new File(GroupList.get(2)));//scanning the first item in the ArrayList
//for(int a = 1; a <= Group1.size(); a++){
        //Adds the contents of the first item in the GroupList ArrayList to the Group1 ArrayList
        while(sc3.hasNextLine()){
        String CSGroup3 = sc3.nextLine();
          Group3.add(CSGroup3);
    }
    System.out.print(Group3+ "\n");

    for(int a = 1; a <= Group3.size(); a++){
      if (a == 1){
        ArrayList<String> Group2Data = new ArrayList<>();
        String line = null;
        //Scanner sc2 = new Scanner(new File(Group1.get(1)));
        FileInputStream is1 = new FileInputStream(Group3.get(1));
        FileInputStream is2 = new FileInputStream(Group3.get(2));
        FileInputStream is3 = new FileInputStream(Group3.get(3));
        FileInputStream is4 = new FileInputStream(Group3.get(4));
        FileInputStream is5 = new FileInputStream(Group3.get(5));
        SequenceInputStream is = new SequenceInputStream(is1, is2);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while((line = br.readLine()) != null){
          String CSGroup3Data = br.readLine();
    System.out.print(CSGroup3Data + " | ");
        }
        }
    
    
      }

    }
           
            
          
        }


      }



  }




/**************
  for(int a = 1; a <= Group1.size(); a++){
    if (a == 1){
     // BufferedReader br = null;
      ArrayList<String> Group1Data = new ArrayList<>();
      String line = null;
      //Scanner sc2 = new Scanner(new File(Group1.get(1)));
      BufferedReader br = new BufferedReader(new FileReader(Group1.get(1)));
      while((line = br.readLine()) != null){
        String CSGroup1Data = br.readLine();
          //for(String line1 : Group1Data){
            String[] cols = line.split(",");
            System.out.println(cols[1]+" "+ cols[cols.length-1]);
          //}
       
        //System.out.println("Coulmn 4 =" + cols[3]);
        System.out.print(CSGroup1Data);
      }
      //while (sc2.hasNextLine()){
        //String CSGroup1Data = sc2.nextLine();
        //String data = CSGroup1Data.split(",");
      }

    }


  *************/