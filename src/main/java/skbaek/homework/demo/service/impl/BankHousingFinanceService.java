package skbaek.homework.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import skbaek.homework.demo.domain.*;
import skbaek.homework.demo.repository.BankHousingFinanceQuery;
import skbaek.homework.demo.util.LinearRegression;

import java.util.*;

@Slf4j
@Service
public class BankHousingFinanceService {

    private BankHousingFinanceQuery bankHousingFinanceQuery;

    public BankHousingFinanceService(BankHousingFinanceQuery bankHousingFinanceQuery) {
        this.bankHousingFinanceQuery = bankHousingFinanceQuery;
    }

    public List getListBanksFinanceTotal() throws Exception {
        List<ResDetailTotalAmountVO> result = null;
        try {
            result = bankHousingFinanceQuery.listBanksFinanceTotal();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List getBankFinanceTop(RequestVO param) throws Exception {
        int year = param.getYear();
        Optional<Integer> check = Optional.ofNullable(year);
        log.info("check : {}", check.isPresent());
        if(!check.isPresent()) year = 0;

        List<ResTopVO> tmp = bankHousingFinanceQuery.supportFinanceTop(year);
        List<ResTopVO> result = new ArrayList<>();
        log.info("top list size : {}", tmp.size());

        for(int i=0; i < tmp.size(); i = i+9){
            result.add(tmp.get(i));
        }

        return result;
    }

    public List getSupportFinanceAvgMaxMin(RequestVO param) throws Exception {

        List<ResAvgVO> tmp = bankHousingFinanceQuery.supportFinanceAvgMaxMin(param.getBankName());

        log.info("avg : {}", tmp.size());

        List<ResAvgVO> result = new ArrayList<>();
        result.add(tmp.get(0));
        result.add(tmp.get(tmp.size()-1));

        return result;
    }

    public Map<String, Object> getSupportFinancePredict(RequestVO param) throws Exception {

        List<ResPredictVO> tmp = bankHousingFinanceQuery.supportFinancePredict(param);
        double[] x = new double[tmp.size()];
        double[] y = new double[tmp.size()];

        for(int i=0; i < tmp.size()-1; i++) {
            x[i] = i+1;
            y[i] = tmp.get(i).getPredictAmount();
        }
        LinearRegression lr = new LinearRegression(x,y);

        double predictMonth = tmp.size() + param.getMonth();

        Map<String, Object> result = new HashMap<>();
        result.put("bank", tmp.get(0).getBankCode());
        result.put("year", 2018);
        result.put("month", param.getMonth());
        result.put("amount", (int)lr.predict(predictMonth) );

        return result;
    }

}
