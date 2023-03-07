package tn.esprit.marketplace.entities;

import lombok.*;

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
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;
    private Double total_amount;
    private Date Transaction_date;
    private String username;


    @OneToOne(mappedBy = "transaction")
    private Basket basket;
    @OneToOne
    Delivery delivery;

}
