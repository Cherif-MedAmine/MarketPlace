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
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatalog;
    private String nameCatalog;

    @ManyToMany (mappedBy = "catalogs")
    private List<Product> products;
}
