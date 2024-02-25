package dept.sap.springsecurity;

import dept.sap.springsecurity.models.ApplicationUser;
import dept.sap.springsecurity.models.Role;
import dept.sap.springsecurity.repository.RoleRepository;
import dept.sap.springsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (roleRepository.findByAuthority("ADMIN").isPresent()) return;
            Role adminRole = new Role(1,"ADMIN");
            roleRepository.save(adminRole);
            Role userRole = new Role(2,"USER");
            roleRepository.save(userRole);
            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            ApplicationUser admin = new ApplicationUser(61, "admin", passwordEncoder.encode("pass"), roles);
            userRepository.save(admin);
        };
    }
}
