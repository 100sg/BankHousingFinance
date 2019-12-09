package skbaek.homework.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BanksFinanceAmountVO {

    @JsonProperty("주택도시기금")
    private Long housingCityFund;

    @JsonProperty("국민은행")
    private Long kookminBank;

    @JsonProperty("우리은행")
    private Long wooriBank;

    @JsonProperty("신한은행")
    private Long shinhanBank;

    @JsonProperty("한국시티은행")
    private Long koreaCityBank;

    @JsonProperty("하나은행")
    private Long hanaBank;

    @JsonProperty("농협은행/수협은행")
    private Long nonghyupSuhyupBank;

    @JsonProperty("외환은행")
    private Long koreaExchangeBank;

    @JsonProperty("기타은행")
    private Long etcBank;

    @Override
    public String toString() {
        return "BanksFinanceAmount{" +
                "housingCityFund=" + housingCityFund +
                ", kookminBank=" + kookminBank +
                ", wooriBank=" + wooriBank +
                ", shinhanBank=" + shinhanBank +
                ", koreaCityBank=" + koreaCityBank +
                ", hanaBank=" + hanaBank +
                ", nonghyupSuhyupBank=" + nonghyupSuhyupBank +
                ", koreaExchangeBank=" + koreaExchangeBank +
                ", etcBank=" + etcBank +
                '}';
    }

}