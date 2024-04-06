package application.model;

public class adminData {
    
    private String username;
    private String role;
    
    public adminData(String username, String role) {
        this.username = username;
        this.role = role;
    }
    
    public String getAdminUsername() {
        return username;
    }

    public String getAdminUserRole() {
        return role;
    }
}

