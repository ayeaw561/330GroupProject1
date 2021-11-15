import java.util.*;
public class Ztest {

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

    public Ztest(ArrayList<String> arraySam, ArrayList<String> arrayPop){
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

    Ztest(){
        
    }

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
