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

    public Ztest(ArrayList<String> arraySam, ArrayList<String> arrayPop){

        arrayPopulation = arrayPop;
        arraySample = arraySam;
        double[] array = new double[arrayPopulation.size()];
        double[] array2 = new double[arraySample.size()];
        arrayPGPA = array;
        arraySGPA = array2;
        gpa(arrayPopulation, arrayPGPA);
        gpa(arraySample, arraySGPA);
        popmean(arrayPGPA);
        samplemean(arraySGPA);
        calculateSD(arrayPGPA);
        ztest();
        
    }

    Ztest(){
        
    }

    public static void main(String[] args){
        gpa(arrayPopulation, arrayPGPA);

    }

    public double getZscore(){
        return zScore;
    }

    public double[] getPop(){
        return arrayPGPA;
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

    public static void gpa(ArrayList<String> arrayl, double[] arraylVal){
        
        for(int i = 0; i < arrayl.size(); i++){
            //System.out.println(arrayl.get(i).toString());
            //if(arrayl.get(i).toString() == null){break;}
            switch(arrayl.get(i).toString())
            {
                case "A" :
                    arraylVal[i] = 4;
                break;

                case "A-" :
                    arraylVal[i] = 3.66;
                break;

                case "B+" :
                    arraylVal[i] = 3.33;
                break;

                case "B" :
                    arraylVal[i] = 3;
                break;

                case "B-" :
                    arraylVal[i] = 2.66;
                break;

                case "C+" :
                    arraylVal[i] = 2.33;
                break;

                case "C" :
                    arraylVal[i] = 2;
                break;

                case "C-" :
                    arraylVal[i] = 1.66;
                break;

                case "D+" :
                    arraylVal[i] = 1.33;
                break;

                case "D" :
                    arraylVal[i] = 1;
                break;

                case "D-" :
                    arraylVal[i] = .66;
                break;

                case "F" :
                    arraylVal[i] = 0;
                break;
            }
            //System.out.println("arraylVal[" + i + "]: " + arraylVal[i]);
        
        }


    }
}
