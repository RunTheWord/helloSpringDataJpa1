package kr.ac.hansung.cse.hellospringdatajpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "상품명은 비워둘 수 없습니다.")
    private String name;

    @NotBlank(message = "브랜드명을 입력하세요.")
    private String brand;

    @NotBlank(message = "제조국을 입력하세요.")
    private String madeIn;

    @NotNull(message = "가격은 반드시 입력되어야 합니다.")
    @DecimalMin(value = "0.00", inclusive = true, message = "가격은 0 이상이어야 합니다.")
    private Double price;

    public Product(String name, String brand, String madeIn, double price) {
        this.name = name;
        this.brand = brand;
        this.madeIn = madeIn;
        this.price = price;
    }
}