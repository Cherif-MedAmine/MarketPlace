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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStore;
    private String nameStore;
    private  boolean status;
    private String attStore;
    private String link;
    private String description;
    private  String storeAddress;
    private  float rating;
    @OneToMany(mappedBy = "store")
    @JsonIgnore
   private List<Product> products;

    @OneToOne(mappedBy = "store")
    @JsonIgnore
    private User userStore;

    @ManyToMany(mappedBy = "stores")
    @JsonIgnore
    private List<CategoryStore> categorystores;
}
