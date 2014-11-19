import java.util.Random;

/**
 * Created by Lada on 15.11.14.
 */
public class Parent {
    int[] ch;
    int lengthParents;

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


    public double fitnesFunction(){
       double y=0;
       double price = 0,weight = 0;
       for (int i=0;i<lengthParents;i++){
                price += ch[i];

       }
       y = price;
       return y;
    }

}
