package DB;

public enum Roles{
    USER ("user"),
    ADMINISTRATOR ("administrator");

    private final String role;

    Roles(String role){
        this.role=role;
    }

    public String getRole() {return role;}
}
