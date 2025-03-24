package dev.ericky.santander_proj_2023.model;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "tb_news")
public class News extends Item{

}
