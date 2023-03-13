package tn.esprit.marketplace.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailSenderService {


        @Autowired
        private JavaMailSender javaMailSender;

        @Autowired
        private TemplateEngine templateEngine;

        public void sendEmail(String to, String subject,String username,String productname,float price) throws javax.mail.MessagingException {


            Context context = new Context();
            context.setVariable("name", username);
            context.setVariable("productname",productname);
            context.setVariable("price",price);
            String htmlContent = templateEngine.process("email-template.html", context);

            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);

            javaMailSender.send(message);
        }
    }


