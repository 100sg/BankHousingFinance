package skbaek.homework.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_bank_finance")
public class BankHousingFinance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private int year;
    private int month;
    private String bankName;
    private Long amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "b_name")
    private BankCode bankCode;

    public BankHousingFinance(int year, int month, String bankName, Long amount) {
        this.year = year;
        this.month = month;
        this.bankName = bankName;
        this.amount = amount;
    }

}