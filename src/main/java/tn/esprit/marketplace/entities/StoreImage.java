package tn.esprit.marketplace.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class StoreImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStoreImage;
    private String name;
    private String type;
    @Lob
    private byte[] imageData;

    @OneToOne(mappedBy = "storeImage")
    private Store store;
}
