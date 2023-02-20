package tn.esprit.marketplace.entities;

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
public class CategoryStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoryS;
    private String nameCategoryS;
    @ManyToMany
    private List<Store> stores;
}
