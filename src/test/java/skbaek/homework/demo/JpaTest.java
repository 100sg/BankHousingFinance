package skbaek.homework.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import skbaek.homework.demo.entity.BankCode;
import skbaek.homework.demo.repository.BankRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaTest {

    @Autowired
    BankRepository repository;

    private BankCode generatorBank() {
        return new BankCode(10,"bnk011", "skbank");
    }

    @Test
    void bank_code_save_test(){
        BankCode bank = generatorBank();
        BankCode saveBank = this.repository.save(bank);
        System.out.print("saved = " + repository.count());
        assertThat(saveBank.getNo(), is(notNullValue()));
    }

    @Test
    public void bank_code_null_save_test() {
        BankCode bank= new BankCode();
        bank.setBankName("testBank");
        this.repository.save(bank);
    }


}
