package tn.esprit.marketplace.restController;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.marketplace.entities.AttachementProduct;
import tn.esprit.marketplace.services.IAttachementService;


@RestController
public class AttachementController {
    @Autowired
    IAttachementService iAttachementService;

    @PostMapping("/uploadMultipleFiles")
    public AttachementProduct addAttachement(@RequestParam("files") MultipartFile[] files){

        return iAttachementService.addAttachement(files);
    }
}
