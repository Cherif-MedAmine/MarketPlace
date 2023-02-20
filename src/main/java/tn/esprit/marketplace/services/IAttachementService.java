package tn.esprit.marketplace.services;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.marketplace.entities.AttachementProduct;

import javax.swing.*;
import java.io.IOException;

public interface IAttachementService {




    AttachementProduct addAttachement(MultipartFile[] files);
}
