package com.kciray.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"profile", "role"})
@EqualsAndHashCode(exclude = {"profile", "role"})
@Builder
@Component
@Entity
@Table(name = "application_user")
public class User implements BaseEntity<Integer>, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> priviliges = role.getPrivileges().stream()
                .map(x -> new SimpleGrantedAuthority(x.getNamePrivilege()))
                .collect(Collectors.toList());
        priviliges.add(new SimpleGrantedAuthority(role.getRole().name()));

        return priviliges;
    }

}
