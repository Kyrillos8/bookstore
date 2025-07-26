package com.example.bookstore.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.example.bookstore.entity.permissions.*;

@RequiredArgsConstructor
public enum Role {

    Viewer(Set.of(Viewer_Read)),
    Author(
            Set.of(
                    Author_Read,
                    Author_Create,
                    Author_Write,
                    Author_Delete
            )
    ),
    Admin(
            Set.of(
                    Admin_Read,
                    Admin_Create,
                    Admin_Write,
                    Admin_Delete
            )
    );

    @Getter
    private final Set<permissions> permissions;

    public List<SimpleGrantedAuthority> getGrantedAuthorities() {
        var authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .toList();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
