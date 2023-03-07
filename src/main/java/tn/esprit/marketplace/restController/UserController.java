package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.services.UserNotFoundException;
import tn.esprit.marketplace.services.interfaces.IUserService;
import tn.esprit.marketplace.services.mapper.UserMapper;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    IUserService iUserService;


    @PostMapping("AddUser")
    User addUser(@RequestBody User user,String roleName) {

        return iUserService.addUser(user,roleName);
    }

    @PutMapping("UpdateUser/{id}")
    public User updateUser(@PathVariable("id") long id, @RequestBody User user) throws UserNotFoundException {
        return iUserService.updateUser(id, user);
    }

    @DeleteMapping("DeleteUser/{id}")
    public User deleteUser(@PathVariable("id") Long idUser) throws UserNotFoundException {
        return iUserService.deleteUser(idUser);

    }

    @GetMapping("getAllUSers")
    public List<User> getAllUsers() {
        return iUserService.getAllUsers();
    }

    @GetMapping("getUserById/{id}")
    public User getUserById(@PathVariable("id") Long idUser) throws UserNotFoundException {
        return iUserService.getUserById(idUser);
    }

    /////////////////////////////////////////////////

    @Autowired
    UserMapper userMapper;

    /*@PostMapping("addUserDTO")
    UserDTO addUserDTO(@RequestBody UserDTO userDTO) {
        UserDTO userDTO1 = userMapper.toDto(iUserService.addUserDTO(userDTO));
        return userDTO1;
    }*/

    /*@PostMapping("/addUserWithStore")
    public void addUserWithStore(@RequestBody User user) {
        iUserService.addUserWithStore(user);
    }*/

    @PostMapping("/addUserWithoutStore")
    User addUserWithoutStore(@RequestBody User user) {
        return iUserService.addUserWithoutStore(user);
    }

    @PutMapping("/affectStoreToUser/{idStore}/{idUser}")
    public void affectStoreToUser(@PathVariable("idStore") Long idStore,@PathVariable("idUser") Long idUser) {
        iUserService.affectStoreToUser(idStore, idUser);
    }

}
