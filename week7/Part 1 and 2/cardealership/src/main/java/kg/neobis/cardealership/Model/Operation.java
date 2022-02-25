package kg.neobis.cardealership.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    private Long operationId;
    @Column(name = "operation_date")
    private LocalDate operationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "car_id",
            referencedColumnName = "car_id",
            foreignKey = @ForeignKey(name = "car_id_fk1")
    )
    private Car carId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "delivery_order_id",
            referencedColumnName = "delivery_order_id",
            foreignKey = @ForeignKey(name = "delivery_order_id_fk")
    )
    private DeliveryOrder deliveryOrderId;

    @Column(name = "operation_description")
    private String operationDescription;
    @Column(name = "factory_price")
    private double factoryPrice;
    @Column(name = "cost_up_to")
    private double costUpTo;
    @Column(name = "total_amount")
    private double totalAmount;
}
