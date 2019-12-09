package skbaek.homework.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skbaek.homework.demo.entity.BankCode;
import skbaek.homework.demo.entity.BankHousingFinance;
import skbaek.homework.demo.repository.BankHousingFinanceQuery;
import skbaek.homework.demo.repository.BankHousingFinanceRepository;
import skbaek.homework.demo.repository.BankRepository;
import skbaek.homework.demo.service.impl.BankHousingFinanceService;
import skbaek.homework.demo.service.impl.BankService;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceTest {

    private BankHousingFinance entity;
    private BankHousingFinanceService service;
    private BankHousingFinanceQuery query;
    private BankHousingFinanceRepository repository;

    @BeforeEach
    public void init() {
        entity = mock(BankHousingFinance.class);
        repository = mock(BankHousingFinanceRepository.class);
        service = mock(BankHousingFinanceService.class);
        query = mock(BankHousingFinanceQuery.class);
    }

    @Test
    public void repository_test() throws Exception {
        when(repository.findAll()).thenReturn(Collections.singletonList(new BankHousingFinance()));

        List<BankHousingFinance> findList = repository.findAll();

        assertThat(findList).isNotEmpty();
    }

    @Test
    public void query_param_test() throws Exception {

    }
}
