package com.kciray.model;

import com.kciray.model.status.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"privileges"})
@EqualsAndHashCode(exclude = {"privileges"})
@Builder
@Entity
public class Role implements BaseEntity<Integer>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "role_privilege",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private List<Privilege> privileges = new ArrayList<>();

//    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
//    private List<RolePrivilege> rolePrivileges = new ArrayList<>();

}
