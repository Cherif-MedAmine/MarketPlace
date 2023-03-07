package tn.esprit.marketplace.services.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.services.dto.UserDTO;

@Component
public class UserMapper {
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setCreationDate(user.getCreationDate());
        userDTO.setBox(user.getBox());
        userDTO.setEmail(user.getEmail());
        userDTO.setCoupons(user.getCoupons());

        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        return user;
    }

}
