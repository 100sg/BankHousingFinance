package skbaek.homework.demo.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Repository;
import skbaek.homework.demo.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class BankHousingFinanceQuery implements IBankHousingFinance {

    private final EntityManager em;
    public BankHousingFinanceQuery(EntityManager em) throws ApplicationContextException {
        this.em = em;
    }

    @Override
    public List listBanksFinanceTotal() throws JDBCException {
        String query = "SELECT new skbaek.homework.demo.domain.ResDetailTotalAmountVO(" +
                "m.year, SUM(m.amount), " +
                "SUM(CASE WHEN m.bankName = '주택도시기금' THEN m.amount ELSE 0 END)," +
                "SUM(CASE WHEN m.bankName = '국민은행' THEN m.amount ELSE 0 END)," +
                "SUM(CASE WHEN m.bankName = '우리은행' THEN m.amount ELSE 0 END)," +
                "SUM(CASE WHEN m.bankName = '신한은행' THEN m.amount ELSE 0 END)," +
                "SUM(CASE WHEN m.bankName = '한국시티은행' THEN m.amount ELSE 0 END)," +
                "SUM(CASE WHEN m.bankName = '하나은행' THEN m.amount ELSE 0 END)," +
                "SUM(CASE WHEN m.bankName = '농협은행/수협은행' THEN m.amount ELSE 0 END)," +
                "SUM(CASE WHEN m.bankName = '외환은행' THEN m.amount ELSE 0 END)," +
                "SUM(CASE WHEN m.bankName = '기타은행' THEN m.amount ELSE 0 END)) " +
                "FROM BankHousingFinance m group by m.year";

        TypedQuery<ResDetailTotalAmountVO> result = em.createQuery(query, ResDetailTotalAmountVO.class);
        List<ResDetailTotalAmountVO> list = result.getResultList();

        return list;
    }

    @Override
    public List supportFinanceTop(int year) throws JDBCException {

        Query result;
        if( Optional.of(year).get() == 0  ) { //값이 없을때 전체 조회
            String query = "SELECT new skbaek.homework.demo.domain.ResTopVO(m.bankName, m.year, SUM(m.amount)) " +
                    "FROM BankHousingFinance m " +
                    "GROUP BY m.bankName, m.year " +
                    "ORDER BY m.year, SUM(m.amount) DESC";
            result = em.createQuery(query);
        } else { // 값이 있을때 조건 조회
            String query = "SELECT new skbaek.homework.demo.domain.ResTopVO(m.bankName, m.year, SUM(m.amount)) " +
                    "FROM BankHousingFinance m " +
                    "WHERE m.year= :year " +
                    "GROUP BY m.bankName, m.year " +
                    "ORDER BY m.year, SUM(m.amount) DESC";
            result = em.createQuery(query).setParameter("year", year);
        }

        List<ResTopVO> list = result.getResultList();

        return list;
    }

    @Override
    public List supportFinanceAvgMaxMin(String bankName) throws JDBCException {
        String query = "SELECT new skbaek.homework.demo.domain.ResAvgVO(m.year, ROUND(AVG(amount),0) AS average) " +
                "FROM BankHousingFinance  m " +
                "GROUP BY m.bankName, m.year " +
                "HAVING m.bankName = :bankName AND 2005 <= year AND year <= 2016 " +
                "ORDER BY average";

        Query result = em.createQuery(query).setParameter("bankName", bankName);
        List<ResAvgVO> list = result.getResultList();
        return list;
    }

    @Override
    public List supportFinancePredict(RequestVO param) throws JDBCException {
        String query = "SELECT new skbaek.homework.demo.domain.ResPredictVO(m.amount, b.bankCode) " +
                "FROM BankHousingFinance m, BankCode b " +
                "WHERE m.bankName = :bankName " +
                "AND m.bankName = b.bankName";

        Query result = em.createQuery(query, ResPredictVO.class).setParameter("bankName", param.getBankName());
        List<ResPredictVO> list = result.getResultList();

        return list;
    }

}
