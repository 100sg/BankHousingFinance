package skbaek.homework.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResultTypeVO {

    private String year;
    private int amount;
    private long predictAmount;
    private String bankCode;

    public ResultTypeVO(int year, double average) {
        this.year = year + "년";
        this.amount = (int)average;
    }
    public ResultTypeVO(double predictAmount, String bankCode) {
        this.predictAmount = (long)predictAmount;
        this.bankCode = bankCode;
    }
}
