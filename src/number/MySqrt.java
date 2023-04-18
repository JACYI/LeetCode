package number;

public class MySqrt {
    public static double sqrt(double target, double epsilon){
        double guess = target;
        while(Math.abs(guess * guess - target) >= epsilon){
            guess = guess - (guess*guess - target) / (guess * 2);
        }
        return guess;
    }


    public static void main(String[] args) {
        System.out.println(sqrt(2, 0.001));
    }
}
