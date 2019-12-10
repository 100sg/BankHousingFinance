package skbaek.homework.demo.repository;

import skbaek.homework.demo.domain.RequestVO;

import java.util.List;

public interface IBankHousingFinance<T> {

    List<T> listBanksFinanceTotal() throws Exception;
    List<T> supportFinanceTop(int year) throws Exception;
    List<T> supportFinanceAvgMaxMin(String bankName) throws Exception;
    List<T> supportFinancePredict(RequestVO param) throws Exception;

}
