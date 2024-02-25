package dept.sap.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
public class RegistrationDTO {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    public RegistrationDTO(){
        super();
    }
    public RegistrationDTO(String username,String password){
        super();
        this.username=username;
        this.password=password;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    public String toString(){
        String op = "username"+getUsername()+"password"+getPassword();
        return op;
    }
}
