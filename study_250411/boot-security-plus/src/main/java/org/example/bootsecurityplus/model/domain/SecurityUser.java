package org.example.bootsecurityplus.model.domain;

public record SecurityUser(
        Long userId, // null
        String username,
        String password,
        String role,
        String createdAt // null
) {
    public static SecurityUser toDB(String username, String password, String role) {
        return new SecurityUser(null, username, password, role, null);
    }
}
