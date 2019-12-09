package skbaek.homework.demo.repository;

import skbaek.homework.demo.domain.RequestVO;

import java.util.List;

public interface IBankHousingFinance<T> {

    List<T> listBanksFinanceTotal();
    List<T> supportFinanceTop(int year);
    List<T> supportFinanceAvgMaxMin(String bankName);
    List<T> supportFinancePredict(RequestVO param);

}
