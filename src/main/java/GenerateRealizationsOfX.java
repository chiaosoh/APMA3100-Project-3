import java.util.Scanner;

public class GenerateRealizationsOfX {
    static final int STARTING_SEED = 1000;
    static final int MULTIPLIER = 24693;
    static final int INCREMENT = 3967;
    static final int MODULUS = 262144;
    static int sampleSize = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a sample size: ");
        sampleSize = scanner.nextInt();
        print110InstancesOfTrials();
//        System.out.println(generateRandomProbability(1));
//        System.out.println(generateRandomProbability(2));
//        System.out.println(generateRandomProbability(3));
//        System.out.println(generateRandomProbability(51));
//        System.out.println(generateRandomProbability(52));
//        System.out.println(generateRandomProbability(53));
    }
    public static double generateRandomProbability(int index) {
        long randomNumber = STARTING_SEED;
        for(int i = 0; i < index; i++) {
            randomNumber = getRandomNumber(randomNumber);
        }
        return getRandomProbability(randomNumber);
    }
    public static int getRandomNumber(long previousNumber) {
        return (int)((previousNumber * MULTIPLIER + INCREMENT) % MODULUS);
    }
    public static double getRandomProbability(long randomNumber) {
        return (double) (randomNumber)/MODULUS;
    }
    public static double getDistanceBetweenDropAndTarget(double probability) {
        return Math.sqrt(-2 * 57 * 57 * Math.log(1-probability));
    }
    public static void printAverageOfNInstancesOfDrops(int index) {
        double sum = 0;
        for(int i = 0; i < sampleSize; i++) {
            sum += getDistanceBetweenDropAndTarget(generateRandomProbability(index));
            index++;
        }
        System.out.println(sum/sampleSize);
    }

    public static void print110InstancesOfTrials() {
        int index = 1;
        for(int i = 0; i < 110; i++) {
            //System.out.println("Instannce number " + (i+1));
            printAverageOfNInstancesOfDrops(index);
            index += sampleSize;
        }
    }
    //for generating samples, each estimate of m has sample size n, corresponding to n random #s
    //need to generate 110 examples of m, so n*110 random #s will be used
}
