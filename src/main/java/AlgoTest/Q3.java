package AlgoTest;

//      s                       result
//      “2 3 4 5”	            “4 5”
//      "15 3 10 9 7 8"	        “8 7”
//      “97 75 88 99 95 92 73”	“75 97”
public class Q3 {
    public static void main(String[] args) {
        Q3 method = new Q3();
        String[] ss = {"2 3 4 5", "15 3 10 9 7 8", "97 75 88 99 95 92 73"};
        for (String s: ss) {
            System.out.println(method.solution(s));
        }
    }
    public String solution(String s) {
        int maxPrime = 0;
        int minOther = Integer.MAX_VALUE;
        String[] splitS = s.split(" ");
        int[] nums = new int[splitS.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(splitS[i]);
        }
        for (int num : nums) {
            if (isPrime(num)) maxPrime = Math.max(maxPrime, num);
            else minOther = Math.min(minOther, num);
        }
        return String.format("%d %d", minOther, maxPrime);
    }

    public boolean isPrime(int num) {
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
