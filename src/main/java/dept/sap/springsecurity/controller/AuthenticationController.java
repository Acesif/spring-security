package dept.sap.springsecurity.controller;

import dept.sap.springsecurity.dto.RegistrationDTO;
import dept.sap.springsecurity.models.ApplicationUser;
import dept.sap.springsecurity.models.LoginResponseDTO;
import dept.sap.springsecurity.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        boolean present = authenticationService.userIsPresent(body.getUsername());
        if(present){
            return null;
        }
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(),body.getPassword());
    }
}
