package videopoker;

public class Statistic {
    private String stat;
    private Integer value;

    public Statistic(String stat) {
        this.stat = stat;
        this.value = 0;
    }

    void add() {
        this.value++;
    }

    String get_stat() {
        return this.stat;
    }

    int get_value() {
        return this.value;
    }
}