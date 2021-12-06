package tech.pragmat.springsec.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tech.pragmat.springsec.model.MyUser;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private String login;
    private String password;
    private List<? extends GrantedAuthority> grantedAuthorities;


    public static CustomUserDetails fromMyUserToCustomUserDetails(MyUser user){
        CustomUserDetails customUserDetails= new CustomUserDetails();

        customUserDetails.login=user.getName();
        customUserDetails.password=user.getPassword();
        customUserDetails.grantedAuthorities= Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
        return customUserDetails;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(grantedAuthorities);
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
