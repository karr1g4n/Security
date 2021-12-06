package tech.pragmat.springsec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tech.pragmat.springsec.model.MyUser;
import tech.pragmat.springsec.repository.UserRepository;
import tech.pragmat.springsec.service.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userService;

    @Autowired
    public CustomUserDetailsService(UserRepository userService) {
        this.userService = userService;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user=userService.findFirstByName(username);
        return CustomUserDetails.fromMyUserToCustomUserDetails(user);
    }
}
