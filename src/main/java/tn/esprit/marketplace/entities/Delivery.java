package tn.esprit.marketplace.entities;

import lombok.*;
import tn.esprit.marketplace.enums.DeliveryType;

import javax.persistence.*;
import java.time.LocalDateTime;


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
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String address;
    @Enumerated(EnumType.STRING)
    DeliveryType status;

    @OneToOne(mappedBy = "delivery")
    Transaction transaction;
}
