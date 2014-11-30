import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Lada on 15.11.14.
 */
public class geneticAlgorithm {
    int numberOfGenerations = 100;
    int numberOfChromozoms = 5;
    Generation g = new Generation(numberOfGenerations,numberOfChromozoms, true);
    Generation g2 = new Generation();

    public double[] mode(double a[]) {
        double[] returnArray = {0,-1};
        double maxValue=-1;
        int maxCount=0;

        for (int i = 0; i < a.length; ++i) {
            int count = 0;
            for (int j = 0; j < a.length; ++j) {
                if (a[j] == a[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = a[i];
            }
        }
        returnArray[0] = maxCount;
        returnArray[1] = maxValue;

        return returnArray;
    }

    public geneticAlgorithm(){
            g2=g;
        for (int i=0;i<1000;i++){
            System.out.println(i+". generace: ");
            for (int j=0;j<numberOfGenerations;j++){
              //  System.out.print(g2.parents[j].fitnesFunction()+" ");
                System.out.println(Arrays.toString(g2.parents[j].ch)+" f: "+g2.parents[j].fitnesFunction());
            }
            g2 = g2.Reproduction();
            g2 = g2.Crossing(1);
            g2 = g2.Mutation(0.2);
            int sum=0;
            double[] f = new double[numberOfGenerations];
            int change=0;
            for (int h=1;h<numberOfGenerations;h++) {
               f[h] = g2.parents[h].fitnesFunction();
            }
            double[] values = mode(f);
            if (values[0]>(3*numberOfGenerations/4)){
                System.out.println("Fitness "+values[1]);
                break;
            }

          //  double[] array = g2.GetFittnesFunctionForAllParents(false);
            /*     if (lastSum == sum)
                pocet2++;
            else pocet2=0;
            lastSum = sum;
*/
        }
     //   System.out.println(Arrays.toString(g.GetFittnesFunctionForAllParents(false)));
     //   System.out.println(Arrays.toString(g2.GetFittnesFunctionForAllParents(false)));
    }



    public static void main(String[] args) {
        new geneticAlgorithm();
    }
}