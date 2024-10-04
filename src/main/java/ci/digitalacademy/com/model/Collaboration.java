package ci.digitalacademy.com.model;

import ci.digitalacademy.com.model.enume.CollaborationStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Collaboration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slug;
    @Enumerated(value= EnumType.STRING)
    private CollaborationStatus status;
    private LocalDate createAt;
    private LocalDate updateAt;

    @OneToOne
    private Service service;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    private InterimBalance interimBalance;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Feedback> feedback;
}
