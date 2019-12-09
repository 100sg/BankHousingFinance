package skbaek.homework.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_bank")
public class BankCode {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    @Column(name = "b_name")
    private String bankName;
    @Column(unique=true,nullable = false)
    private String bankCode;

    public BankCode(String name, String code){
        this.bankName = name;
        this.bankCode = code;
    }

}
