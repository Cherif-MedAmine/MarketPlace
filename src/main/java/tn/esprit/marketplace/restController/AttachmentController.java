package tn.esprit.marketplace.restController;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import tn.esprit.marketplace.entities.AttachementProduct;
import tn.esprit.marketplace.services.interfaces.IAttachementService;


@RestController
public class AttachmentController {
    @Autowired
    IAttachementService iAttachementService;
@PostMapping("/addAttachment")
    public AttachementProduct addAttachment(@RequestBody AttachementProduct attachementProduct){

    return iAttachementService.addAttachment(attachementProduct);
}
}
