package kea.sem3.jwtdemo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@EqualsAndHashCode
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    public Car() {}

    public Car(CarBrand brand, String model, double pricePrDay) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }

    @Enumerated(EnumType.STRING)
    CarBrand brand;

    @Column(length = 60)
    String model;

    double pricePrDay;

}
