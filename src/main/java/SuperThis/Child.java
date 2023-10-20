package SuperThis;

public class Child extends Parent {
    private String son;
    private String daughter;

    public Child() {
        this("son", "daughter");
    }
    public Child (String son, String daughter) {
        this.son = son;
        this.daughter = daughter;
    }
    public void setSon(String son) {
        this.son = son;
    }

    public void setDaughter(String daughter) {
        this.daughter = daughter;
    }

    public String getSon() {
        return son;
    }

    public String getDaughter() {
        return daughter;
    }

    public String toString () {
        return super.getFather() + " / " + super.getMother() + " / " + this.getFather() + " / " + this.getMother();
    }
}
