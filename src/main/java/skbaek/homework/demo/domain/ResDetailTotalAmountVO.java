package skbaek.homework.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ResDetailTotalAmountVO {

    private String year;

    @JsonProperty("total_amount")
    private Long totalAmount;

    @JsonProperty("detail_amount")
    private BanksFinanceAmountVO resDetailAmount;

    public ResDetailTotalAmountVO(int year,
                                  Long totalAmount, Long housingCityFund,
                                  Long kookminBank, Long wooriBank,
                                  Long shinhanBank, Long koreaCityBank,
                                  Long hanaBank, Long nonghyupSuhyupBank,
                                  Long koreaExchangeBank, Long etcBank) {

        this.year = year + "년";
        this.totalAmount = totalAmount;
        resDetailAmount = BanksFinanceAmountVO.builder()
                .housingCityFund(housingCityFund)
                .kookminBank(kookminBank)
                .wooriBank(wooriBank)
                .shinhanBank(shinhanBank)
                .koreaCityBank(koreaCityBank)
                .hanaBank(hanaBank)
                .nonghyupSuhyupBank(nonghyupSuhyupBank)
                .koreaExchangeBank(koreaExchangeBank)
                .etcBank(etcBank)
                .build();
    }

    @Override
    public String toString() {
        return "ResDetailTotalAmount{" +
                "year='" + year + '\'' +
                ", totalAmount=" + totalAmount +
                ", resDetailAmount=" + resDetailAmount +
                '}';
    }
}
