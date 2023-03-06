package tn.esprit.marketplace.services.interfaces;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.marketplace.entities.AttachementProduct;
import tn.esprit.marketplace.entities.Product;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public interface IAttachementService {


    AttachementProduct addAttachment(AttachementProduct attachementProduct);
}
