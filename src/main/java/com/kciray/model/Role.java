package com.kciray.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kciray.model.status.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"users","rolePrivileges"})
@EqualsAndHashCode(exclude = {"users","rolePrivileges"})
@Builder
@Entity
public class Role implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

//    public GrantedAuthority getAuthority() {
//        return new SimpleGrantedAuthority(role.getAuthority());
//    }
//    public static Role getRole(RoleEnum role) {
//        Role roleObj = new Role();
//        roleObj.setRole(role);
//        return roleObj;
//    }


//    @JsonIgnore
//    @Builder.Default
//    @OneToMany (mappedBy = "role", fetch = FetchType.LAZY)
//    private List<User> users = new ArrayList<>();
//    @JsonIgnore
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<RolePrivilege> rolePrivileges = new ArrayList<>();

}
