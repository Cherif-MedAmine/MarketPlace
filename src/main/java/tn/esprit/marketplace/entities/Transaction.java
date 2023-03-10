package tn.esprit.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
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
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;
    private Double total_amount;
    private Date Transaction_date;
    private String username;

    @OneToOne
    private Basket basket;

    @OneToOne
    Delivery delivery;

    @OneToMany(mappedBy = "transaction")
    @JsonIgnore
    private List<Workflow> workflows;

}
