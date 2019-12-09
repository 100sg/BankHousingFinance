package skbaek.homework.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import skbaek.homework.demo.entity.BankCode;
import skbaek.homework.demo.repository.BankRepository;

@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BankRepository repository) {
        log.info("table data check : {}", repository.count());
        if(repository.count() == 0) {
            return (args) -> {
                repository.save(new BankCode("주택도시기금", "bnk093"));
                repository.save(new BankCode("국민은행", "bnk004"));
                repository.save(new BankCode("우리은행", "bnk020"));
                repository.save(new BankCode("신한은행", "bnk088"));
                repository.save(new BankCode("한국시티은행", "bnk027"));
                repository.save(new BankCode("하나은행", "bnk081"));
                repository.save(new BankCode("농협은행/수협은행", "bnk011"));
                repository.save(new BankCode("외환은행", "bnk005"));
                repository.save(new BankCode("기타은행", "bnk400"));
            };
        } else {
            return null;
        }
    }
}