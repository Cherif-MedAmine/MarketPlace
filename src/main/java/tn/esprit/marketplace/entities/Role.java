package tn.esprit.marketplace.entities;

import lombok.*;
import tn.esprit.marketplace.enums.RoleType;

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
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
