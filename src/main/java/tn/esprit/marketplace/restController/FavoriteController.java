package tn.esprit.marketplace.restController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.marketplace.services.interfaces.IFavoriteService;


@RestController
@AllArgsConstructor
@RequestMapping("/api/favorite")
public class FavoriteController {

    IFavoriteService iFavoriteService;


@GetMapping("recommandation")
    public String  recommandation(@RequestParam Long idUser){
    return iFavoriteService.recommandation(idUser);
}

}
