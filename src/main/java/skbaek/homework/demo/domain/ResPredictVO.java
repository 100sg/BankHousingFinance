package skbaek.homework.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResPredictVO {

    private long predictAmount;
    private String bankCode;
//    private long month;

    public ResPredictVO(double predictAmount, String bankCode) {
        this.predictAmount = (long)predictAmount;
        this.bankCode = bankCode;
    }

}
