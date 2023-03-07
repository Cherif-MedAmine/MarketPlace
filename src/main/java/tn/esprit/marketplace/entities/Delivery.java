package tn.esprit.marketplace.entities;

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
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDelivery;
    private String nameDelivery;
    private Date startDate;
    private Date endDate;

    @OneToOne(mappedBy = "delivery")
    private Transaction transaction;
}
