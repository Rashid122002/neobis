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
        name = "staffs",
        uniqueConstraints = {
                @UniqueConstraint(name = "phone_number", columnNames = "phone_number")
        }
)
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long staffId;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "position", nullable = false)
    private String position;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}
