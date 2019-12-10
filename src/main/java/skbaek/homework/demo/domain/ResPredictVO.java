package skbaek.homework.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ResPredictVO {

    private long predictAmount;
    private String bankCode;

    public ResPredictVO(double predictAmount, String bankCode) {
        this.predictAmount = (long)predictAmount;
        this.bankCode = bankCode;
    }

}
