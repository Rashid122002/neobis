package kg.neobis.cardealership.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;
    @Column(name = "car_brand", nullable = false)
    private String carBrand;
    @Column(name = "serial_number", nullable = false)
    private String serialNumber;
    @Column(name = "year_of_manufacture", nullable = false)
    private LocalDate yearOfManufacture;
    @Column(name = "engine_capacity", nullable = false)
    private String engineCapacity;
    @Column(name = "car_color", nullable = false)
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
