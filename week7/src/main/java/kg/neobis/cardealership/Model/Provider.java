package kg.neobis.cardealership.Model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "providers",
        uniqueConstraints = {
                @UniqueConstraint(name = "phone_number", columnNames = "phone_number")
        }
)
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Long providerId;
    @Column(name = "company_name", nullable = false)
    private String companyName;
    @Column(name = "company_official_name", nullable = false)
    private String companyOfficialName;
    @Column(name = "position", nullable = false)
    private String position;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "fax", nullable = false)
    private String fax;
    @Column(name = "payment_term", nullable = false)
    private String paymentTerm;
}
