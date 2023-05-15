package DTO;

public class Utente {

	private String email;
    private String username;
    private String password_user;
    private boolean admin_status;

    public Utente() {}
    

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }


    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }
    
        
    public String getPassword_user() { return password_user; }

    public void setPassword_user(String password_user) { this.password_user = password_user; }

    
    public boolean isAdmin_status() { return admin_status; }

    public void setAdmin_status(boolean admin_status) { this.admin_status = admin_status; }
}