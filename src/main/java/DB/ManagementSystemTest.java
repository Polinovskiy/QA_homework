package DB;


import java.sql.SQLException;

public class ManagementSystemTest {
    private static ManagementSystem ms=null;

    public static void main(String[] args) throws Exception{
        ManagementSystem ms = ManagementSystem.getInstance();
        String[][] people;
        for (Roles roles:Roles.values()) {
            System.out.println("----------------------------");
            System.out.println("All "+roles.getRole()+"'s:");
            people=ms.getPeople(roles.getRole());
            ms.printPeople(people);
        }
    }
}
