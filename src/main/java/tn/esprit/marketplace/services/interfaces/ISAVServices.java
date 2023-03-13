package tn.esprit.marketplace.services.interfaces;



import tn.esprit.marketplace.entities.SAV;

import java.util.List;


public interface ISAVServices {
    void  add(SAV sav);

   void  update(SAV sav);

    void delete(Long idSAV);

    List<SAV> getAllSAVS();

    SAV getSAVById(Long idSAV);
}



