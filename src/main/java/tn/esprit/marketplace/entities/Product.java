package tn.esprit.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String nameProduct;
    private String refProduct;
    private  float priceProduct;
    private  float priceAfterSales;
    private  boolean status;
    private  int likes;
    private String description;

//    @ManyToMany
//    @JsonIgnore
//    private List<Basket> baskets;
    @ManyToMany
    @JsonIgnore
    private List<Favorite> pfavorite;

    @OneToMany (mappedBy = "attproduct")
    @JsonIgnore

    private Set<AttachementProduct> attachmentProducts = new HashSet<>();
    @ManyToOne
    @JsonIgnore
    private CategoryProduct categoryProduct;
    @ManyToMany
    @JsonIgnore
    private List<Catalog> catalogs;
    @ManyToOne
    @JsonIgnore
    private Store store;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private  List<ProductBasket>productBaskets;


}
