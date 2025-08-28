import java.sql.*;

public class Vuln {
    public static void main(String[] args) throws Exception {
        // CodeQL should flag this as SQL injection
        String userInput = args[0];
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        Statement stmt = conn.createStatement();
        stmt.execute("SELECT * FROM users WHERE name = '" + userInput + "'");
    }
}
