package SuperThis;

public class Main {
    public static void main(String[] args) {
        Parent child = new Child();
        child.setFather("David");
        String res = child.toString();
        System.out.println(res);
    }
}
