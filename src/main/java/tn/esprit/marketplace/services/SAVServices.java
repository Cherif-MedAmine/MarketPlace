package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.SAV;
import tn.esprit.marketplace.repositories.SAVRepository;
import tn.esprit.marketplace.services.interfaces.ISAVServices;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class SAVServices implements ISAVServices {





    SAVRepository savRepository;
    @Override
    public List<SAV> getAllSAVS() {
        return savRepository.findAll();
    }
    @Override
    public SAV getSAVById(Long idSAV) {
        Optional<SAV> sav = savRepository.findById(idSAV);
        if (sav.isPresent()) {
            return sav.get();
        } else {
            throw new RuntimeException("SAV not found for id: " + idSAV);
        }
    }

    @Override
    public void add(SAV sav) {
        savRepository.save(sav);
    }

    @Override
    public void update(SAV sav) {
        savRepository.save(sav);
    }

    @Override
    public void delete(Long idSAV) {
        savRepository.deleteById(idSAV);
    }


}
