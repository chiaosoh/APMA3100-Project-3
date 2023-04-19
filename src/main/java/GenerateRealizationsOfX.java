public class GenerateRealizationsOfX {
    static final int STARTING_SEED = 1000;
    static final int MULTIPLIER = 24693;
    static final int INCREMENT = 3967;
    static final int MODULUS = 262144;
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
}
