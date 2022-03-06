package kg.neobis.cardealership.Model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sale_descriptions")
public class SaleDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private int saleId;
    @Column(name = "description", nullable = false)
    private String description;
}
