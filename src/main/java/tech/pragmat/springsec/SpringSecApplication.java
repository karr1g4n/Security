package tech.pragmat.springsec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech.pragmat.springsec.model.MyRole;
import tech.pragmat.springsec.model.MyUser;
import tech.pragmat.springsec.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecApplication.class, args);
    }


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {

			MyRole role= new MyRole(0, "USER");
			userService.saveRole(role);
			userService.saveRole(new MyRole(0, "ADMIN"));

			MyUser user=new MyUser(0, "Artem", "1234",new ArrayList<>());

//
			userService.saveUser(user);
//
//			System.out.println("____________________________________________");
			userService.addRoleToUser(user.getName(), role.getName());

			MyUser myUser = userService.getUser(user.getName());

			System.out.println(myUser.toString());


		};
	}
}

