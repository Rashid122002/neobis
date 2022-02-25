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
@Table(name = "delivery_orders")
public class DeliveryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_order_id")
    private Long deliveryOrderId;
    @Column(name = "order_description")
    private String orderDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "provider_id",
            referencedColumnName = "provider_id",
            foreignKey = @ForeignKey(name = "provider_id_fk")
    )
    private Provider providerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "staff_id",
            referencedColumnName = "staff_id",
            foreignKey = @ForeignKey(name = "staff_id_fk")
    )
    private Staff staffId;

    @Column(name = "placement_date")
    private LocalDate placementDate;
    @Column(name = "execution_date")
    private LocalDate executionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "purchase_id",
            referencedColumnName = "purchase_id",
            foreignKey = @ForeignKey(name = "purchase_id_fk")
    )
    private PurchaseDescription purchaseId;
}
