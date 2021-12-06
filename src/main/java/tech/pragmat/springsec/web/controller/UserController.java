package tech.pragmat.springsec.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class UserController {

//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @PostMapping("/save/user")
//    public MyUser saveUser(@RequestParam MyUser user) {
//        return userService.saveUser(user);
//    }
//
//    @PostMapping("/save/role")
//    public MyRole saveRole(@RequestParam MyRole role) {
//        return userService.saveRole(role);
//    }
//
//    @GetMapping("/")
//    public List<MyUser> getUsers() {
//        return userService.getUsers();
//    }


    @GetMapping("/admin/get")
    public String getAdmin() {
        return "Hi admin";
    }

    @GetMapping("/user/get")
    public String getUser() {
        return "Hi user";
    }


}
