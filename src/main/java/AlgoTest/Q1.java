package AlgoTest;

//  num     result
//  900     1
//  550     5
//  320     6
//  160     8
public class Q1 {
    public static void main(String[] args) {
        Q1 method = new Q1();
        int[] nums = {900, 550, 320, 160};
        for (int num : nums) {
            System.out.println(method.solution(num));
        }
    }

    private int solution(int num) {
        int answer=0;
        int change = 1000 - num;
        int[] coins = {500, 100, 50, 10};
        for (int coin: coins) {
            answer += change / coin;
            change = change % coin;
        }
        return answer;
    }
}
