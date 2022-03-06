package kg.neobis.cardealership.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "orders",
        uniqueConstraints = {
                @UniqueConstraint(name = "order_number", columnNames = "order_number"),
                @UniqueConstraint(name = "document_number", columnNames = "document_number")
        }
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "client_id",
            foreignKey = @ForeignKey(name = "client_id_fk")
    )
    private Client clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "car_id",
            referencedColumnName = "car_id",
            foreignKey = @ForeignKey(name = "car_id_fk2")
    )
    private Car carId;

    @Column(name = "placement_date", nullable = false)
    private LocalDate placementDate;
    @Column(name = "order_number", nullable = false)
    private String orderNumber;
    @Column(name = "document_type", nullable = false)
    private String documentType;
    @Column(name = "document_number", nullable = false)
    private String documentNumber;
    @Column(name = "address", nullable = false)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "sale_id",
            referencedColumnName = "sale_id",
            foreignKey = @ForeignKey(name = "sale_id_fk")
    )
    private SaleDescription saleId;
}
