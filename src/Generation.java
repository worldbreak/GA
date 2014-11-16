import java.util.Random;

/**
 * Created by Lada on 15.11.14.
 */
public class Generation {
    Chromozom[] chromozoms;
    int lengthGen;
    int lengthChrom;
    public Generation(){}

    public Generation(int lengthGen, int lengthChrom, boolean InitialState ) {
        chromozoms = new Chromozom[lengthGen];
        this.lengthGen = lengthGen;
        this.lengthChrom = lengthChrom;
        for (int i=0;i<lengthGen;i++){
            chromozoms[i] = new Chromozom(lengthChrom, InitialState);
        }
    }

    public double[] GetFittnesFunctionForAllChromozoms(boolean normalize){
        double results[] = new double[lengthGen];
        for (int i=0;i<lengthGen;i++){
            results[i] = this.chromozoms[i].fitnesFunction();
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
        Random rnd = new Random();
        double[] df = GetFittnesFunctionForAllChromozoms(true);
        for (int i=0;i<lengthGen;i++){
            double rand = rnd.nextDouble();
            for (int j=0;j<lengthGen;j++){
                if (df[j]>rand){
                    g.chromozoms[i] = this.chromozoms[j];
                    break;
                }
            }
        }
        return g;
    }

    public Generation Crossing(double probability){
        Generation g = this;
        Random rnd = new Random();
        outerLoop:
        for (int i=0;i<lengthGen;i++){
            for (int j=0;j<lengthGen;j++){
                double rand = rnd.nextDouble();
                if (probability>rand){
                     int randomNum = rnd.nextInt(this.lengthChrom-2)+1;
                    for (int k=randomNum;k<lengthChrom;k++){
                        g.chromozoms[i].ch[k] = this.chromozoms[j].ch[k];
                        g.chromozoms[j].ch[k] = this.chromozoms[i].ch[k];
                    }
                    break outerLoop;
                }
            }
        }
        return g;
    }

    public Generation Mutation(double probalitity){
        Generation g = this;
        Random rnd = new Random();
        double randomP = rnd.nextDouble();
        if (probalitity>randomP){
            int randomA = rnd.nextInt(this.lengthChrom);
            int randomCH = rnd.nextInt(this.lengthGen);
            if (g.chromozoms[randomCH].ch[randomA]==0){
                g.chromozoms[randomCH].ch[randomA]=1;
            }
            else
            {
                g.chromozoms[randomCH].ch[randomA]=0;
            }
        }
        return g;
    }

}
