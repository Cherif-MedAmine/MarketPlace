package tn.esprit.marketplace.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistory;

    private Long productId;
    private String productName;
    private int productQuantity;
    private float productPrice;
    private String productCategory;
    private String buyer;
    private String seller;
    private Double totalAmount;
    private Date transactionDate;

    @ManyToOne
    private Transaction transaction;

}
