package tn.esprit.marketplace.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmail;
    private String emailSender;
    private String emailReceiver;
    private String subject;
    private String message;

    @ManyToMany(mappedBy = "emails")
    private List<MailBox> mailBoxes;

}
