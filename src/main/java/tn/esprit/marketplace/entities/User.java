package tn.esprit.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

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
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "idUser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "premium")
    private Boolean premium;

    @Column(name = "score")
    private float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    private Basket basketU;

    @OneToOne(cascade = CascadeType.ALL)
    private Favorite favoriteU;

    @ManyToMany
    @JsonIgnore
    private List<SAV> savs;

    @OneToOne(/*cascade = CascadeType.ALL*/)
    @JsonIgnore
    private Store store;

    @OneToOne(cascade = CascadeType.ALL)
    private MailBox box;


    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<CreditCard> creditCards;

    @OneToMany(mappedBy = "userCoupon")
    @JsonIgnore
    private List<Coupon> coupons;

    @OneToMany(mappedBy = "likeUser")
    @JsonIgnore
    private List<StoreLike> storeLikesUser;

    public User(String userName, String password, List<GrantedAuthority> authorities) {
    }

    public String getUserName() {
        return userName;
    }

    public Role getRole() {
        return role;
    }
}
