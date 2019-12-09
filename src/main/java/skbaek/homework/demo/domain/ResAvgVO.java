package skbaek.homework.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResAvgVO {

    private String year;
    private int amount;

    public ResAvgVO(int year, double average) {
        this.year = year + "년";
        this.amount = (int)average;
    }

    @Override
    public String toString() {
        return "Test{" +
                ", year=" + year +
                ", average=" + amount +
                '}';
    }
}
