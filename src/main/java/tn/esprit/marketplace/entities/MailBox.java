package tn.esprit.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
public class MailBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMailBox;
    @OneToOne(mappedBy = "box")
    @JsonIgnore
    private User userBox;

    @ManyToMany
    @JsonIgnore
    private List<Email> emails;
}
