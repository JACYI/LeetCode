package others;

public class code1823 {
    public static int findTheWinner(int n, int k) {
        int winner = 0;
        for(int i=2; i<=n; i++){
            winner = (winner + k) % i;
        }
        return winner;
    }
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }
}
