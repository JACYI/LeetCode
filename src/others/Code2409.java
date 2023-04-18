package others;

/**
 * @Author yiyonghao
 * @Date 2023/4/17 21:08
 */
public class Code2409 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daySums = new int[13];
        for(int i=1; i<=12; i++) {
            daySums[i] += daySums[i - 1] + days[i-1];
        }
        int[][] alice = new int[2][2];
        int[][] bob = new int[2][2];
        alice[0][0] = Integer.parseInt(arriveAlice.substring(0, 2));
        alice[0][1] = Integer.parseInt(arriveAlice.substring(3));
        alice[1][0] = Integer.parseInt(leaveAlice.substring(0, 2));
        alice[1][1] = Integer.parseInt(leaveAlice.substring(3));

        bob[0][0] = Integer.parseInt(arriveBob.substring(0, 2));
        bob[0][1] = Integer.parseInt(arriveBob.substring(3));
        bob[1][0] = Integer.parseInt(leaveBob.substring(0, 2));
        bob[1][1] = Integer.parseInt(leaveBob.substring(3));

        int[][] firstArrive, secondArrive;
        if(dateCompare(bob[0], alice[0]) < 0) {
            firstArrive = bob;
            secondArrive = alice;
        } else {
            firstArrive = alice;
            secondArrive = bob;
        }

        // 1. 空集
        if(dateCompare(firstArrive[1], secondArrive[0]) < 0) {
            return 0;
        }

        int[] left = dateCompare(firstArrive[0], secondArrive[0]) <= 0 ? secondArrive[0] : firstArrive[0];
        int[] right = dateCompare(firstArrive[1], secondArrive[1]) >= 0 ? secondArrive[1] : firstArrive[1];

        return daySums[right[0]-1] + right[1] - (daySums[left[0]-1] + left[1]) + 1;
    }

    public int dateCompare(int[] date1, int[] date2) {
        if(date1[0] == date2[0]) {
            return Integer.compare(date1[1], date2[1]);
        }
        return Integer.compare(date1[0], date2[0]);
    }

    public static void main(String[] args) {
        Code2409 c = new Code2409();
        c.countDaysTogether("02-15", "03-18", "02-18", "03-01");
    }
}
