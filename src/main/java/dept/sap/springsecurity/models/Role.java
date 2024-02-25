package dept.sap.springsecurity.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;
    @Setter
    private String authority;

    public Role(Integer roleId, String authority) {
        this.roleId=roleId;
        this.authority=authority;
    }

    public Role() {
        super();
    }

    public Role(String authority) {
        this.authority=authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
