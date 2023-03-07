package tn.esprit.marketplace.restController;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.marketplace.dto.CreatePayment;
import tn.esprit.marketplace.dto.CreatePaymentResponse;
import tn.esprit.marketplace.entities.Transaction;
import tn.esprit.marketplace.services.interfaces.ITransactionService;


import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@RestController
@RequestMapping("api/transaction")
public class PaymentController {

    @Autowired
    private ITransactionService its;


    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePayment createPayment) throws StripeException {
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount((long) createPayment.getAmount())
                        .setCurrency(createPayment.getCurrency())
                        .build();
        its.addTransaction(Transaction.builder()
                .total_amount(createPayment.getAmount())
                .Transaction_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .username(createPayment.getUser_mail())
                .build());


        // Create a PaymentIntent with the order amount and currency
        PaymentIntent paymentIntent = PaymentIntent.create(params);

        return new CreatePaymentResponse(paymentIntent.getClientSecret());


    }
}
