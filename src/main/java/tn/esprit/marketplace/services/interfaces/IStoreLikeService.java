package tn.esprit.marketplace.services.interfaces;

public interface IStoreLikeService {

    void likeStore(Long idUser, Long idStore);

    void dislikeStore(Long idUser, Long idStore);

    int countLikesByStore(Long idStore);

}
