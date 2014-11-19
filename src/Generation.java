import java.util.Arrays;
import java.util.Random;

/**
 * Created by Lada on 15.11.14.
 */
public class Generation {
    Parent[] parents;
    int lengthGen;
    int lengthChrom;
    public Generation(){}

    public Generation(int lengthGen, int lengthChrom, boolean InitialState ) {
        parents = new Parent[lengthGen];
        this.lengthGen = lengthGen;
        this.lengthChrom = lengthChrom;
        for (int i=0;i<lengthGen;i++){
            parents[i] = new Parent(lengthChrom, InitialState);
        }
    }

    public double[] GetFittnesFunctionForAllParents(boolean normalize){
        double results[] = new double[lengthGen];
        for (int i=0;i<lengthGen;i++){
            results[i] = this.parents[i].fitnesFunction();
        }
        if (normalize)
        results = Normalize(results);
        return results;
    }

    private double[] Normalize(double[] uArray){
        double sum = 0;
        double help = 0;
        double results[] = new double[uArray.length];
        for (int i=0;i<uArray.length;i++){
            sum += uArray[i];
        }

        for (int j=0;j<uArray.length;j++){
            results[j] = (uArray[j]+ help)/sum;
            help += uArray[j];
        }

        return results;
    }

    public Generation Reproduction(){
        Generation g = new Generation(lengthGen,lengthChrom, true);
        double[] df = GetFittnesFunctionForAllParents(true);
        Random rnd = new Random();
        for (int i=0;i<lengthGen;i++){
            double rand = rnd.nextDouble();
            for (int j=0;j<lengthGen;j++){
                if (df[j]>rand){
                    g.parents[i] = this.parents[j];
                    System.out.println("i: "+i+" "+ Arrays.toString(g.parents[i].ch));
                    break;
                }
            }
        }
        return g;
    }

    public Generation Crossing(double probability){
        Random rnd = new Random();
        boolean end = false;
        int j;
        System.out.println("Krizeni pred:");
        for (int n=0;n<lengthGen;n++){

            //  System.out.print(g2.parents[j].fitnesFunction()+" ");
            System.out.println(Arrays.toString(this.parents[n].ch));
        }
        do{
           int i= rnd.nextInt(lengthGen);
           do {
             j=rnd.nextInt(lengthGen);
           } while (i==j);
            System.out.println("i: "+i+" j:"+j);
            double rand = rnd.nextDouble();
            //       System.out.println("Prohazuji "+i+" s "+j+". Od pozice "+randomNum);
            if (probability>rand){
                int randomNum = rnd.nextInt(this.lengthChrom-2)+1;
            //    System.out.println("randomnum: "+randomNum);
                int[] ch1 = this.parents[i].ch;
                int[] ch2 = this.parents[j].ch;
                for (int k=randomNum;k<lengthChrom;k++){

                    int a = ch1[k];
                    ch1[k] = ch2[k];
                    ch2[k] = a;
                    System.out.println(Arrays.toString(this.parents[3].ch));
                  //  System.out.println("k="+k);

                }
                this.parents[i].ch=ch1;
                this.parents[j].ch=ch2;
                System.out.println("Krizeni po:");
                for (int n=0;n<lengthGen;n++) {
                    System.out.println(Arrays.toString(this.parents[n].ch));
                }
                System.out.println();
                end = true;
            }
        }while(end==false);


     /*   for (int i=0;i<lengthGen;i++){
            for (int j=0;j<lengthGen;j++){
                double rand = rnd.nextDouble();
                if (i!=j)
                if (probability>rand){
                    int randomNum = rnd.nextInt(this.lengthChrom-2)+1;
             //       System.out.println("Prohazuji "+i+" s "+j+". Od pozice "+randomNum);
                    for (int k=randomNum;k<lengthChrom;k++){
                        int a = this.parents[j].ch[k];
                        g.parents[j].ch[k] = this.parents[i].ch[k];
                        g.parents[i].ch[k] = a;

                    }
              //      System.out.println("i-tá i="+i+" "+Arrays.toString(g.parents[i].ch));
              //      System.out.println("j-tá j="+j+" "+Arrays.toString(g.parents[j].ch));
                }
            }
        }*/
        return this;
    }

    public Generation Mutation(double probalitity){
        Generation g = this;
        Random rnd = new Random();
        double randomP = rnd.nextDouble();
        if (probalitity>randomP){
            int randomA = rnd.nextInt(this.lengthChrom);
            int randomCH = rnd.nextInt(this.lengthGen);
            if (g.parents[randomCH].ch[randomA]==0){
                g.parents[randomCH].ch[randomA]=1;
            }
            else
            {
                g.parents[randomCH].ch[randomA]=0;
            }
        }
        for (int j=0;j<lengthGen;j++){
            //  System.out.print(g2.parents[j].fitnesFunction()+" ");
            System.out.println(Arrays.toString(g.parents[j].ch));
        }
        return g;
    }

}
