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
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoryP;
    private String nameCategoryP;
    @OneToMany(mappedBy = "categoryProduct")
    private List<Product> products;
}
