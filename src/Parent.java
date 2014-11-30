import java.util.Arrays;
import java.util.Random;

/**
 * Created by Lada on 15.11.14.
 */
public class Parent {
    int[] ch;
    int lengthParents;
    double[] priceInBag = {170,200,181.3,160,250};
    double[] weightInBag = {20,10,15,15,25};
    double maximumBagCapacity = 30;

    public Parent(int length,boolean state){
         ch = new int[length];
         lengthParents = length;
         if (state) RandomGenerateInitialState();
    }

    public void RandomGenerateInitialState(){
        Random rnd = new Random();
        for (int i=0;i<this.lengthParents;i++){
            if (rnd.nextDouble()<0.5)
                this.ch[i]=0;
            else
                this.ch[i]=1;
        }

    }

    public double power(double x, int n) {
        double y = 1;
        for (int i = 0; i < n; i++)
            y *= x;
        return y;
    }

    public static double maxValue(double[] arrayMax) {
        double max=0;
        for (int i=1;i<arrayMax.length;i++)
        {
            if (arrayMax[i] > max)
            {
                max = arrayMax[i];
            }
        }
        return max;
    }
    public double fitnesFunction(){
       double y=0;
       double price = 0,weight = 0;
       double rho = maxValue(priceInBag)/maxValue(weightInBag);

        for (int i=0;i<lengthParents;i++){
           if (ch[i]==1) {
               price += priceInBag[i];
               weight += weightInBag[i];
           }

       }


     //  double penalize = rho*(weight-maximumBagCapacity);
        if ((weight - maximumBagCapacity)>0) price = 0;
       return (price);
    }
}
