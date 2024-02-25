package dept.sap.springsecurity.services;

import dept.sap.springsecurity.models.ApplicationUser;
import dept.sap.springsecurity.models.Role;
import dept.sap.springsecurity.repository.RoleRepository;
import dept.sap.springsecurity.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ApplicationUser registerUser(String username, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepository.save(new ApplicationUser(20,username,encodedPassword,authorities));
    }
    public Boolean userIsPresent(String username){
        return userRepository.findByUsername(username).isPresent();
    }
}
