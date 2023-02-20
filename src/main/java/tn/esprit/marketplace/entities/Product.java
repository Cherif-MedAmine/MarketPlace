package tn.esprit.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

   @ManyToMany
  @JsonIgnore
   private List<Basket> pbaskets;
    @ManyToMany
    @JsonIgnore
   private List<Favoris> pfavoris;

   @OneToMany (mappedBy = "attproduct")
   private List<AttachementProduct> attachmentProducts;
   @ManyToOne
    private CategoryProduct categoryProduct;
    @ManyToMany
    private List<Catalog> catalogs;
    @ManyToOne
    private Store store;
}
