
public class Ztest {

    public static String[] arrayPopulation;
    public static String[] arraySample;
    public static double[] arraySGPA;
    public static double[] arrayPGPA;
    public static double sampleMean; //section or group
    public static double popMean; //total popluation of data
    public static double popSD; //total population of data SD
    public static double zScore;

    public Ztest(String[] arraySam, double[] arraySamGPA, String[] arrayPop, double[] arrayPopGPA){

        arrayPopulation = arrayPop;
        arraySample = arraySam;
        arrayPopGPA = arrayPGPA;
        arraySamGPA = arraySGPA;
    }

    Ztest(){
        
    }

    public static void main(String[] args){

    //String[] arraylist = {"A","B", "A-", "C","F","B+", "D-"};
        //GPAconvert con = new GPAconvert();
        //double[] arraylistVal = new double[arraylist.length];

       // gpa(arraylist, arraylistVal);

  // popSD = calculateSD(arraylistVal);
   //sampleMean = mean();
   //popMean = mean();
  // System.out.println(popSD);

   // zScore = (sampleMean - popMean)/popSD;
    }

    public double getZscore(){
        return zScore;
    }

    public static void setZscore(double z){
        zScore = z;
    }

    public double mean(double[] array)
    {
        double sum = 0;
        int length = array.length;
        for(double num : array){
            sum += num;
        }
        double mean = sum/length;

        return mean;
    }

    public double calculateSD(double arrayNum[])
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

        return Math.sqrt(standardDeviation/length);
    }

    public double[] gpa(String[] arrayl, double[] arraylVal){

        for(int i = 0; i < arrayl.length; i++){
            if(arrayl[i] == null){break;}
            switch(arrayl[i])
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

        return arraylVal;
    }
}
