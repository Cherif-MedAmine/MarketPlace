package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.services.interfaces.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @PostMapping("AddUser")
    User addUser(@RequestBody User user) {

       return iUserService.addUser(user);
    }

}
