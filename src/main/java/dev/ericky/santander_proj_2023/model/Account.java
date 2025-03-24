package dev.ericky.santander_proj_2023.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;
    private String agency;

    @Column(precision = 10, scale = 2 )
    private BigDecimal balance;
    @Column(name = "additional_limit", precision = 10, scale = 2 )
    private BigDecimal limit;
}
