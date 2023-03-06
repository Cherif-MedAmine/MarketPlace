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
public class Basket implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBasket;
    private float totalPrice;



    @OneToOne (mappedBy = "basketU")
            @JsonIgnore
   private User userB;
//    @ManyToMany(mappedBy = "baskets")
//            @JsonIgnore
//    private List<Product> products;

    @OneToOne
    @JsonIgnore
   private Transaction transaction;
    @OneToMany(mappedBy = "basket")
    @JsonIgnore
    private  List<ProductBasket>productBaskets;


}
