import java.util.Random;

/**
 * Created by Lada on 15.11.14.
 */
public class Chromozom {
    int[] ch;
    int lengthCh;

    public Chromozom(int length,boolean state){
         ch = new int[length];
         lengthCh = length;
         if (state) RandomGenerateInitialState();
    }

    public void RandomGenerateInitialState(){
        Random rnd = new Random();
        for (int i=0;i<this.lengthCh;i++){
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
       for (int i=0;i<lengthCh;i++){
           switch (i){
            case 1:case 2:case 3:case 0:
                price += power(2,i)*ch[i];
                break;
            case 5:case 6:case 7:case 4:
                weight += power(2,i-4)*ch[i];
           }
       }
       y = price;
       return y;
    }

}
