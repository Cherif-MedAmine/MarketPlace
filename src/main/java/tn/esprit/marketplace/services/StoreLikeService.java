package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.Store;
import tn.esprit.marketplace.entities.StoreLike;
import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.exception.GenericException;
import tn.esprit.marketplace.repositories.StoreLikeRepository;
import tn.esprit.marketplace.repositories.StoreRepository;
import tn.esprit.marketplace.repositories.UserRepository;
import tn.esprit.marketplace.services.interfaces.IStoreLikeService;
import tn.esprit.marketplace.utils.ConstUtils;

@Service
@AllArgsConstructor
public class StoreLikeService implements IStoreLikeService {

    StoreLikeRepository storeLikeRepository;
    StoreRepository storeRepository;
    UserRepository userRepository;

    @Override
    public void likeStore(Long idUser, Long idStore) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException(String.format(ConstUtils.USER_NOT_EXIST)));
        Store store = storeRepository.findById(idStore)
                .orElseThrow(() -> new RuntimeException(String.format(ConstUtils.STORE_NOT_EXIST)));

        StoreLike storeLike = new StoreLike();
        storeLike.setLikeUser(user);
        storeLike.setLikeStore(store);

        storeLikeRepository.save(storeLike);
    }

    @Override
    public void dislikeStore(Long idUser, Long idStore) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException(String.format(ConstUtils.USER_NOT_EXIST)));
        Store store = storeRepository.findById(idStore)
                .orElseThrow(() -> new RuntimeException(String.format(ConstUtils.STORE_NOT_EXIST)));

        StoreLike storeLike = storeLikeRepository.findByLikeUserAndLikeStore(user, store);
        if (storeLike == null) throw new GenericException(ConstUtils.STORE_LIKE_NOT_EXIST);

        storeLikeRepository.delete(storeLike);
    }

    @Override
    public int countLikesByStore(Long idStore) {
        Store store = storeRepository.findById(idStore)
                .orElseThrow(() -> new RuntimeException(String.format(ConstUtils.STORE_NOT_EXIST)));
        return storeLikeRepository.countLikesByStore(store);
    }

}
