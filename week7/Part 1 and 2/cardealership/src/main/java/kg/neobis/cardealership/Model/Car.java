package kg.neobis.cardealership.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;
    @Column(name = "car_brand")
    private String carBrand;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "year_of_manufacture")
    private LocalDate yearOfManufacture;
    @Column(name = "engine_capacity")
    private String engineCapacity;
    @Column(name = "car_color")
    private String carColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "price_id",
            referencedColumnName = "price_id",
            foreignKey = @ForeignKey(name = "price_id_fk")
    )
    private Price priceId;

    @Column(name = "notes")
    private String notes;
}
