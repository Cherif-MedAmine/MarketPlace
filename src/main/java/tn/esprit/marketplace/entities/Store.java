package tn.esprit.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStore;
    @Column(unique = true)
    private String nameStore;
    private boolean status;
    private String link;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private String description;
    private String storeAddress;

    @OneToOne
    @JsonIgnore
    private StoreImage storeImage;

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

}
