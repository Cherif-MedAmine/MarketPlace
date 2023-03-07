package tn.esprit.marketplace.services.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.marketplace.entities.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDTO {

    private Long idUser;

    private String userName;

    private String password;

    private String email;

    private Date creationDate;

    private String phoneNumber;

    private Boolean premium;

    private float score;

    private Basket basketU;

    private Favorite favoriteU;

    private Role role;

    private List<SAV> savs;

    private Store store;

    private MailBox box;

    private List<CreditCard> creditCards;

    private List<Coupon> coupons;

    private List<StoreLike> storeLikesUser;
}
