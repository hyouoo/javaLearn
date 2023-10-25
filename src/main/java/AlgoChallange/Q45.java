package AlgoChallange;

// 카드 뭉치
// 문제 설명
//        코니는 영어 단어가 적힌 카드 뭉치 두 개를 선물로 받았습니다. 코니는 다음과 같은 규칙으로 카드에 적힌 단어들을 사용해 원하는 순서의 단어 배열을 만들 수 있는지 알고 싶습니다.
//        원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
//        한 번 사용한 카드는 다시 사용할 수 없습니다.
//        카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
//        기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.
//        예를 들어 첫 번째 카드 뭉치에 순서대로 ["i", "drink", "water"], 두 번째 카드 뭉치에 순서대로 ["want", "to"]가 적혀있을 때
//        ["i", "want", "to", "drink", "water"] 순서의 단어 배열을 만들려고 한다면 첫 번째 카드 뭉치에서 "i"를 사용한 후 두 번째 카드 뭉치에서 "want"와 "to"를 사용하고
//        첫 번째 카드뭉치에 "drink"와 "water"를 차례대로 사용하면 원하는 순서의 단어 배열을 만들 수 있습니다.
//        문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때,
//        cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return하는 solution 함수를 완성해주세요.
// 제한사항
//        1 ≤ cards1의 길이, cards2의 길이 ≤ 10
//        1 ≤ cards1[i]의 길이, cards2[i]의 길이 ≤ 10
//        cards1과 cards2에는 서로 다른 단어만 존재합니다.
//        2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
//        1 ≤ goal[i]의 길이 ≤ 10
//        goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있습니다.
//        cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있습니다.
// 입출력 예
//        cards1	                cards2	        goal	                                result
//        ["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"Yes"
//        ["i", "water", "drink"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"No"
public class Q45 {
    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(solution(cards1, cards2, goal));
    }

    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        // goal의 단어를 하나씩 가져와서 cards1, cards2에 있는지 확인 후 두군데 다 없으면 "No" return
        // cards1은 p1 인덱스, cards2는 p2 인덱스로 있을 시 각각 증가
        int p1 = 0, p2 = 0;
        for (String target : goal) {
            if (p1 < cards1.length && target.equals(cards1[p1])) {
                p1++;
            } else if (p2 < cards2.length && target.equals(cards2[p2])) {
                p2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}