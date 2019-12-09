package skbaek.homework.demo.util;

import org.springframework.stereotype.Component;
import skbaek.homework.demo.entity.BankHousingFinance;
import skbaek.homework.demo.domain.CreditGuaranteeAmountVO;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreditGuaranteeAmountMapper {

    private static final String COMMA = ",";
    private static final String EMPTY = "";

    public List<BankHousingFinance> toGuaranteeAmounts(CreditGuaranteeAmountVO guaranteeAmountVO) {
        List<BankHousingFinance> bankHousingFinances = new ArrayList<>();
        String year = guaranteeAmountVO.getYear();
        String month = guaranteeAmountVO.getMonth();

        bankHousingFinances.add(
                toGuaranteeAmount(year, month, FileHeader.HOUSECITY_FUND.getValue(), guaranteeAmountVO.getHousingCityFund()));

        bankHousingFinances.add(
                toGuaranteeAmount(year, month, FileHeader.KOOKMIN.getValue(), guaranteeAmountVO.getKookminBank()));

        bankHousingFinances.add(
                toGuaranteeAmount(year, month, FileHeader.WOORI.getValue(), guaranteeAmountVO.getWooriBank()));

        bankHousingFinances.add(
                toGuaranteeAmount(year, month, FileHeader.SHINHAN.getValue(), guaranteeAmountVO.getShinhanBank()));

        bankHousingFinances.add(
                toGuaranteeAmount(year, month, FileHeader.KOREACITY.getValue(), guaranteeAmountVO.getKoreaCityBank()));

        bankHousingFinances.add(
                toGuaranteeAmount(year, month, FileHeader.HANA.getValue(), guaranteeAmountVO.getHanaBank()));

        bankHousingFinances.add(
                toGuaranteeAmount(year, month, FileHeader.NONGHYUP_SUHYUP.getValue(), guaranteeAmountVO.getNonghyupSuhyupBank()));

        bankHousingFinances.add(
                toGuaranteeAmount(year, month, FileHeader.KOREAEXCHANGE.getValue(), guaranteeAmountVO.getKoreaExchangeBank()));

        bankHousingFinances.add(
                toGuaranteeAmount(year, month, FileHeader.ETC.getValue(), guaranteeAmountVO.getEtcBank()));

        return bankHousingFinances;
    }

    private BankHousingFinance toGuaranteeAmount(String year, String month, String bank, String amount) {
        return new BankHousingFinance(convertingToInt(year), convertingToInt(month), bank, convertingToLong(amount));
    }

    private int convertingToInt(String txt) {
        int result;

        result = Integer.parseInt(txt);

        return result;
    }

    private Long convertingToLong(String txt) {
        Long result = null;
        try {
            result = Long.parseLong(txt.replaceAll(COMMA, EMPTY));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }
}