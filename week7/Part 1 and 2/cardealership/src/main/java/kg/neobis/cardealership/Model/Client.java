package kg.neobis.cardealership.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(
        name = "clients",
        uniqueConstraints = {
                @UniqueConstraint(name = "phone_number", columnNames = "phone_number")
        }
)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "notes")
    private String notes;
}
