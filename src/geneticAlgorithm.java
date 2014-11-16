import java.util.Arrays;

/**
 * Created by Lada on 15.11.14.
 */
public class geneticAlgorithm {
    int numberOfGenerations = 20;
    int numberOfChromozoms = 8;
    Generation g = new Generation(numberOfGenerations,numberOfChromozoms, true);
    Generation g2 = new Generation();

    public geneticAlgorithm(){
            g2=g;
        for (int i=0;i<60;i++){
            g2 = g2.Reproduction();
            g2.Crossing(0.6);
            g2.Mutation(0.01);
            double sum = 0;
            double[] array = g2.GetFittnesFunctionForAllChromozoms(false);
            for (int j = 0; j < numberOfGenerations; j++)
            {
                sum = sum + array[j];
            }
            System.out.println(i+"  "+sum);
        }
        System.out.println(Arrays.toString(g.GetFittnesFunctionForAllChromozoms(false)));
        System.out.println(Arrays.toString(g2.GetFittnesFunctionForAllChromozoms(false)));
    }



    public static void main(String[] args) {
        new geneticAlgorithm();
    }
}