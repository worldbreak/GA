import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Lada on 15.11.14.
 */
public class geneticAlgorithm {
    int numberOfGenerations = 4;
    int numberOfChromozoms = 8;
    Generation g = new Generation(numberOfGenerations,numberOfChromozoms, true);
    Generation g2 = new Generation();
    double lastSum=0;
    int pocet2=0;

    public geneticAlgorithm(){
            g2=g;
        for (int i=0;i<100;i++){
            System.out.println(i+". generace: ");
            for (int j=0;j<numberOfGenerations;j++){
              //  System.out.print(g2.parents[j].fitnesFunction()+" ");
                System.out.println(Arrays.toString(g2.parents[j].ch));
            }
            g2 = g2.Reproduction();
            g2 = g2.Crossing(1);
            g2 = g2.Mutation(0.2);
            int sum=0;
            for (int h=0;h<numberOfGenerations;h++)
            for (int k=0;k<numberOfChromozoms;k++) {
                if (g2.parents[h].ch[k] == 1) sum++;
            }
            if (sum == numberOfGenerations*numberOfChromozoms) break;
            double[] array = g2.GetFittnesFunctionForAllParents(false);
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