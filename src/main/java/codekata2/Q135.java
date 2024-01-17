package codekata2;

import java.util.Arrays;

// 이모티콘 할인행사
// https://school.programmers.co.kr/learn/courses/30/lessons/150368
// 입출력 예
//      users	                                                                                emoticons	                result
//      [[40, 10000], [25, 10000]]	                                                            [7000, 9000]	            [1, 5400]
//      [[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]]	[1300, 1500, 1600, 4900]	[4, 13860]
public class Q135 {
    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        Solution135 solution = new Solution135();
        System.out.println(Arrays.toString(solution.solution(users, emoticons)));
    }
}

// 할인율들을 이모티콘의 갯수와 조합해서 모든 가격을 구해본다
// threshold 가격과 비교해서 가입자 수를 구한다
// 가입자 수가 최대일 때의 할인율 조합을 구한다
// 가입자를 빼고 비가입자의 지출을 구한다
class Solution135 {

    private final int[] discount = {10, 20, 30, 40};
    private int[][] users;
    private int[] emoticons;
    private int numUser, numEmoti;
    private int numJoin = 0, salePrice = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        numUser = users.length;
        numEmoti = emoticons.length;

        int[][] price = new int[numEmoti][2];
        for (int i = 0; i < numEmoti; i++) {
            price[i][1] = emoticons[i];
        }

        int depth = 0;
        dfs(depth, price);

        return new int[] {numJoin, salePrice};
    }

    private void dfs(int depth, int[][] price) {
        if (depth == numEmoti) {
            getResults(price);
            return;
        }
        for (int rate : discount) {
            price[depth][0] = rate;
            price[depth][1] = emoticons[depth] - (emoticons[depth] * rate / 100);
            dfs(depth + 1, price);
        }
    }

    private void getResults(int[][] price) {
        int caseSale = 0, join = 0;

        int userSale;
        for (int i = 0; i < numUser; i++) {
            userSale = 0;
            for (int j = 0; j < numEmoti; j++) {
                if (price[j][0] >= users[i][0]){
                    userSale += price[j][1];
                }
            }
            if (userSale >= users[i][1]) {
                join++;
                continue;
            }
            caseSale += userSale;
        }
        if (numJoin < join) {
            numJoin = join;
            salePrice = caseSale;
        } else if (numJoin == join && salePrice < caseSale) {
            salePrice = caseSale;
        }
    }
}