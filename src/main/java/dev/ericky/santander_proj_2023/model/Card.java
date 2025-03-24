package dev.ericky.santander_proj_2023.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity(name = "tb_card")
public class Card  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @Column(name = "available_limit", precision = 10, scale = 2 )
    private BigDecimal limit;
}
