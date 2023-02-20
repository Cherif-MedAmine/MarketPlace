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
    private String ribSend;
    private String ribRec;
    private  float price;
    private Date TransactionDate;
    private  float tax;
    private  String clientAddress;
    private float finalPrice;
    private Boolean status;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @OneToOne(mappedBy = "transaction")
   private Basket basket;
    @ManyToOne
   private Delivery delivery;

}
