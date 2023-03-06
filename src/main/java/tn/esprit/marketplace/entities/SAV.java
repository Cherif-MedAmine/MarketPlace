package tn.esprit.marketplace.entities;

import lombok.*;
import tn.esprit.marketplace.enums.ServiceType;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SAV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSAV;
    private String refProduct;
    private String description;
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @ManyToMany(mappedBy = "savs")
    private List<User> users;
}
