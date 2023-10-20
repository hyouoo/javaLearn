package SuperThis;

public class Parent {
    private String father;
    private String mother;

    public Parent(String father, String mother) {
        this.father = father;
        this.mother = mother;
    }
    public Parent () {
        this("father", "mother");
    }
    public void setFather(String father) {
        this.father = father;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String toString() {
        return this.father + " / " + this.mother;
    }
}
