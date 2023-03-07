package tn.esprit.marketplace.entities;

import lombok.*;
import tn.esprit.marketplace.enums.CouponType;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoupon;
    @Column(unique = true)
    private String code;
    private float discount;
    private float percentage;
    private Date startDate;
    private Date endDate;
    private Integer usesTotal;
    @Enumerated(EnumType.STRING)
    private CouponType couponType;

    @ManyToOne
    private User userCoupon;
}
