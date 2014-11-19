import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Lada on 15.11.14.
 */
public class geneticAlgorithm {
    int numberOfGenerations = 3;
    int numberOfChromozoms = 3;
    Generation g = new Generation(numberOfGenerations,numberOfChromozoms, true);
    Generation g2 = new Generation();
    double lastSum=0;
    int pocet2=0;
    public geneticAlgorithm(){
            g2=g;
        for (int i=0;i<3;i++){
            System.out.println(i+". generace: ");
            for (int j=0;j<numberOfGenerations;j++){
              //  System.out.print(g2.parents[j].fitnesFunction()+" ");
                System.out.println(Arrays.toString(g2.parents[j].ch));
            }
            g2 = g2.Reproduction();
            g2 = g2.Crossing(0.6);
            g2 = g2.Mutation(0.1);
            double sum = 0;
            double[] array = g2.GetFittnesFunctionForAllParents(false);
            for (int j = 0; j < numberOfGenerations; j++){
                sum = sum + array[j];
                if (i==0) lastSum=sum;
            }
            System.out.println(sum);
       /*     if (lastSum == sum)
                pocet2++;
            else pocet2=0;
            lastSum = sum;
*/
        }
        System.out.println(Arrays.toString(g.GetFittnesFunctionForAllParents(false)));
        System.out.println(Arrays.toString(g2.GetFittnesFunctionForAllParents(false)));
    }



    public static void main(String[] args) {
        new geneticAlgorithm();
    }
}