package tn.esprit.marketplace.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class StoreLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStoreLike;

    @ManyToOne
    private Store likeStore;

    @ManyToOne
    private User likeUser;
}
