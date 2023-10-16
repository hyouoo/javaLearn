import java.util.ArrayList;
import java.util.Scanner;

public class WeekOneHW {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String recipeTitle = sc.nextLine();
        float rate = Float.parseFloat(sc.nextLine());

        ArrayList<String> contents = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String content = sc.nextLine();
            contents.add(i, content);
        }

        int intRate = (int)rate;
        System.out.println("[ " + recipeTitle + " ]");
        System.out.println("별점 : " + intRate + " (" + intRate / 5.0 * 100 + "%)");
        for (String content: contents) {
            String contentsForm = String.format("%d. %s", contents.indexOf(content) + 1, content);
            System.out.println(contentsForm);
        }
    }
}
