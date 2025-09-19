package common.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private int id;
    private String username;
    private String password; // ở bản thật có thể hash, bản demo để plain
    private String name;
    private String email;
    private String phone;
    private String role; // USER, ADMIN

    public UserDTO() {}

    public UserDTO(int id, String username, String password, String name,
                   String email, String phone, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
