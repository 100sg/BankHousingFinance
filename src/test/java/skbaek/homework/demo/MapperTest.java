package skbaek.homework.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContextException;
import skbaek.homework.demo.domain.CreditGuaranteeAmountVO;
import skbaek.homework.demo.entity.BankHousingFinance;
import skbaek.homework.demo.util.CreditGuaranteeAmountMapper;

import java.lang.annotation.Annotation;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MapperTest {

    @Test
    public void csv_finance_mapping_test() {
        CreditGuaranteeAmountMapper creditGuaranteeAmountMapper = new CreditGuaranteeAmountMapper();
        CreditGuaranteeAmountVO creditGuaranteeAmountVO = new CreditGuaranteeAmountVO();
        creditGuaranteeAmountVO.setYear("2017");
        creditGuaranteeAmountVO.setMonth("11");
        creditGuaranteeAmountVO.setHousingCityFund("100");
        creditGuaranteeAmountVO.setKookminBank("150");
        creditGuaranteeAmountVO.setWooriBank("200");
        creditGuaranteeAmountVO.setShinhanBank("250");
        creditGuaranteeAmountVO.setKoreaCityBank("300");
        creditGuaranteeAmountVO.setHanaBank("350");
        creditGuaranteeAmountVO.setNonghyupSuhyupBank("400");
        creditGuaranteeAmountVO.setKoreaExchangeBank("450");
        creditGuaranteeAmountVO.setEtcBank("500");

        List<BankHousingFinance> supportFinance = creditGuaranteeAmountMapper.toGuaranteeAmounts(creditGuaranteeAmountVO);

        assertThat(supportFinance.get(0).getYear()).isEqualTo(2017);
        assertThat(supportFinance.get(0).getBankName()).isEqualTo("주택도시기금");
        assertThat(supportFinance.get(0).getAmount()).isEqualTo(100L);

    }

    @Test
    public void csv_finance_mapping_fail_test() {
        CreditGuaranteeAmountMapper creditGuaranteeAmountMapper = new CreditGuaranteeAmountMapper();
        CreditGuaranteeAmountVO creditGuaranteeAmountVO = new CreditGuaranteeAmountVO();
        creditGuaranteeAmountVO.setYear("0");
        creditGuaranteeAmountVO.setMonth("0");
        creditGuaranteeAmountVO.setHousingCityFund("Fail");
        creditGuaranteeAmountVO.setKookminBank("Fail");
        creditGuaranteeAmountVO.setWooriBank("Fail");
        creditGuaranteeAmountVO.setShinhanBank("Fail");
        creditGuaranteeAmountVO.setKoreaCityBank("Fail");
        creditGuaranteeAmountVO.setHanaBank("Fail");
        creditGuaranteeAmountVO.setNonghyupSuhyupBank("Fail");
        creditGuaranteeAmountVO.setKoreaExchangeBank("Fail");
        creditGuaranteeAmountVO.setEtcBank("Fail");

        assertThat(creditGuaranteeAmountMapper.toGuaranteeAmounts(creditGuaranteeAmountVO));
    }
}
