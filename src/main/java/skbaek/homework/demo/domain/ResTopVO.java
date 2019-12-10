package skbaek.homework.demo.domain;

import lombok.Getter;

@Getter
public class ResTopVO {

    private String bankName;
    private String year;
    private Long total;

    public ResTopVO(String bankName, int year, Long total) {
        this.bankName = bankName;
        this.year = year + "년";
        this.total = total;
    }

}
