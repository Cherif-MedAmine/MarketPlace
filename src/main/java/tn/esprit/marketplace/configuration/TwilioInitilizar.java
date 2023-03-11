package tn.esprit.marketplace.Configuration;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitilizar {


    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitilizar.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioInitilizar(TwilioConfiguration twilioConfiguration){
        this.twilioConfiguration=twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        LOGGER.info("twilio initilized ... with account sid {}", twilioConfiguration.getAccountSid());
    }


}
