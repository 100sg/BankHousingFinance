package skbaek.homework.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class CreditGuaranteeAmountVO {

    @JsonProperty("연도")
    private String year;

    @JsonProperty("월")
    private String month;

    @JsonProperty("주택도시기금1)(억원)")
    private String housingCityFund;

    @JsonProperty("국민은행(억원)")
    private String kookminBank;

    @JsonProperty("우리은행(억원)")
    private String wooriBank;

    @JsonProperty("신한은행(억원)")
    private String shinhanBank;

    @JsonProperty("한국시티은행(억원)")
    private String koreaCityBank;

    @JsonProperty("하나은행(억원)")
    private String hanaBank;

    @JsonProperty("농협은행/수협은행(억원)")
    private String nonghyupSuhyupBank;

    @JsonProperty("외환은행(억원)")
    private String koreaExchangeBank;

    @JsonProperty("기타은행(억원)")
    private String etcBank;
}