package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.services.interfaces.IStoreLikeService;

@RestController
@RequestMapping("/storeLike")
public class StoreLikeController {

    @Autowired
    IStoreLikeService iStoreLikeService;

    @PostMapping("/likeStore/{idUser}/{idStore}")
    public void likeStore(@PathVariable("idUser") Long idUser, @PathVariable("idStore") Long idStore) {
        iStoreLikeService.likeStore(idUser, idStore);
    }

    @DeleteMapping("/dislikeStore/{idUser}/{idStore}")
    public void dislikeStore(@PathVariable("idUser") Long idUser, @PathVariable("idStore") Long idStore) {
        iStoreLikeService.dislikeStore(idUser, idStore);
    }

    @GetMapping("/countLikesByStore/{idStore}")
    public int countLikesByStore(@PathVariable("idStore") Long idStore) {
        return iStoreLikeService.countLikesByStore(idStore);
    }

}
