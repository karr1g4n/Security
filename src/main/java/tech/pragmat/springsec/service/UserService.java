package tech.pragmat.springsec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pragmat.springsec.model.MyRole;
import tech.pragmat.springsec.model.MyUser;
import tech.pragmat.springsec.repository.RoleRepository;
import tech.pragmat.springsec.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    //
    //    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        //        this.passwordEncoder=passwordEncoder;
    }

    public MyUser saveUser(MyUser user) {
        //        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public MyRole saveRole(MyRole role) {
        return roleRepository.save(role);
    }

    //    public void addRoleToUser(String userName, String roleName) {
    //        MyUser user = userRepository.findFirstByName(userName);
    //        MyRole role = roleRepository.findFirstByName(roleName);
    //
    //        if (user != null || role != null) {
    //            user.getMyRoleList().add(role);
    //            userRepository.save(user);
    //        }
    //    }

    public MyUser getUser(String userName) {
        return userRepository.findFirstByName(userName);
    }

    public List<MyUser> getUsers() {
        return (List<MyUser>) userRepository.findAll();
    }
}
