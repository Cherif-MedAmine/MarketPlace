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
public class User  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String firstName;
    private  String lastName;
    private  String password;
    private  String email;
    private Date creationDate;
    private  String phoneNumber;
    private  Boolean premium;
    private  float score;

    @OneToOne(cascade = CascadeType.ALL)
    private Basket basketU;

    @OneToOne(cascade = CascadeType.ALL)
    private Favorite favoriteU;

    @ManyToOne
    @JsonIgnore
    private Role role;

    @ManyToMany
    @JsonIgnore
    private List<SAV>savs;

    @OneToOne(cascade = CascadeType.ALL)
    private Store store;

    @OneToOne(cascade = CascadeType.ALL)
   private MailBox box;

    @OneToMany(mappedBy = "user")
    @JsonIgnore

    private List<CreditCard> creditCards;

    @ManyToMany
    @JsonIgnore
    private List<Coupon> coupons;
}
