package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.marketplace.services.IAttachementService;
import tn.esprit.marketplace.services.IFavorisService;

@RestController
public class FavorisController {
    @Autowired
    IFavorisService iFavorisService;

}
