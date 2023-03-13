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

    @PostMapping("Add")
    public void add(@RequestBody SAV sav) {

         isavServices.add(sav);
    }

    @GetMapping("/get_all")
    public List<SAV> getAllSAVS() {
        return isavServices.getAllSAVS();
    }

    @PutMapping("/update")
    public  void  update(@RequestBody SAV sav) {
         isavServices.update(sav);
    }

    @DeleteMapping("/delete/{idSAV}")
    public void delete(@PathVariable("idSAV") Long idSAV) {

        isavServices.delete(idSAV);
    }

    @GetMapping("/get/{idSAV}")
    public SAV getSAVById(@PathVariable Long idSAV) {
        return isavServices.getSAVById(idSAV);
    }
}