import java.util.*;

public class WeekTwoHW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("자료구조를 List/Set/Map 중에서 선택해 주세요!");
        String collType = sc.nextLine();
        String[] typeName = {"List", "Set", "Map"};
        ArrayList<String> typeList = new ArrayList<>(Arrays.asList(typeName));
        if (!typeList.contains(collType)) {
            System.out.println("잘못 입력하셨어요.");
            return;
        }

        System.out.println("요리 제목은 무엇인가요?");
        String recipeTitle = sc.nextLine();

        System.out.println("요리 레시피를 한 문장씩 입력해 주시고 입력이 끝나면 '끝'을 적어 주세요~");
        switch (collType) {
            case "List":
                ArrayList<String> listContents = new ArrayList<>();
                while (true) {
                    String content = sc.nextLine();
                    if (content.equals("끝")) {
                        break;
                    } else {
                        listContents.add(content);
                    }
                }
                System.out.println("[ " + collType + " (으)로 저장된 " + recipeTitle + " ]");
                for (String content : listContents) {
                    String contentsForm = String.format("%d. %s", listContents.indexOf(content) + 1, content);
                    System.out.println(contentsForm);
                }
                break;

            case "Set":
                LinkedHashSet<String> setContents = new LinkedHashSet<>();
                while (true) {
                    String content = sc.nextLine();
                    if (content.equals("끝")) {
                        break;
                    } else {
                        setContents.add(content);
                    }
                }
                System.out.println("[ " + collType + " (으)로 저장된 " + recipeTitle + " ]");
                Iterator setIterator = setContents.iterator();
                for (int i = 0; i < setContents.size(); i++) {
                    String contentsForm = String.format("%d. %s", i + 1, setIterator.next());
                    System.out.println(contentsForm);
                }
                break;

            case "Map":
                Map<Integer, String> mapContents = new LinkedHashMap<>();
                Integer num = 1;
                while (true) {
                    String content = sc.nextLine();
                    if (content.equals("끝")) {
                        break;
                    } else {
                        mapContents.put(num, content);
                        num++;
                    }
                }
                System.out.println("[ " + collType + " (으)로 저장된 " + recipeTitle + " ]");
                for (Map.Entry<Integer, String> entrySet : mapContents.entrySet()) {
                    String contentsForm = String.format("%d. %s", entrySet.getKey(), entrySet.getValue());
                    System.out.println(contentsForm);
                }
                break;
        }
    }
}
