package com.example.bookstore.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum permissions {
    // Define permissions for each role
    Admin_Read("admin:read"),
    Admin_Create("admin:create"),
    Admin_Write("admin:update"),
    Admin_Delete("admin:delete"),

    Author_Read("author:read"),
    Author_Create("author:create"),
    Author_Write("author:update"),
    Author_Delete("author:delete"),

    Viewer_Read("admin:read");

    @Getter
    private final String permission;
}
