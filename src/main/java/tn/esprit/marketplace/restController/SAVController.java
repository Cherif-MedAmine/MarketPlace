package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.SAV;
import tn.esprit.marketplace.services.interfaces.ISAVServices;


import java.util.List;

@RestController
public class SAVController {
    @Autowired
    ISAVServices isavServices;

    @PostMapping("AddSAV")
    public void add(@RequestBody SAV sav) {

         isavServices.add(sav);
    }

    @GetMapping("/get_all_SAV")
    public List<SAV> getAllSAVS() {
        return isavServices.getAllSAVS();
    }

    @PutMapping("/updateSAV")
    public  void  update(@RequestBody SAV sav) {
         isavServices.update(sav);
    }

    @DeleteMapping("/deleteSAV/{idSAV}")
    public void delete(@PathVariable("idSAV") Long idSAV) {

        isavServices.delete(idSAV);
    }

    @GetMapping("/get_SAV/{idSAV}")
    public SAV getSAVById(@PathVariable Long idSAV) {
        return isavServices.getSAVById(idSAV);
    }
}