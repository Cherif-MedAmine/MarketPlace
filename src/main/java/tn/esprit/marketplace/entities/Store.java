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
    @Column(unique = true)
    private String nameStore;
    private boolean status;
    private String attStore;
    private String link;
    private Long creationDate;
    private String description;
    private String storeAddress;

    @OneToOne(mappedBy = "store")
    private User user;

    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private List<Product> products;

    @ManyToMany(mappedBy = "stores")
    @JsonIgnore
    private List<CategoryStore> categoryStores;

    @OneToMany(mappedBy = "likeStore")
    @JsonIgnore
    private List<StoreLike> storeLikesStore;

    /*public Store(String nameStore, String attStore, String link, String description, String storeAddress) {
        this.nameStore = nameStore;
        this.attStore = attStore;
        this.link = link;
        this.description = description;
        this.storeAddress = storeAddress;
    }*/
}
