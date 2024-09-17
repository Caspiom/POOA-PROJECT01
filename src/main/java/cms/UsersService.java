package cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersService {

    public boolean validarLogin(Connection conn, String username, String password) {
        if (username != null && !username.isEmpty() && username.equals(password)) {
            if (!userExists(conn, username)) {
                Users user = new Users(username, password);
                user.setPassword(password);
                user.setName(username);
                UsersHSQL db = new UsersHSQL();
                db.insertInto(conn, "Table_Users", username, password);
                System.out.println(password);
                return true;
            } else {
                System.out.println(password);
                return true;
            }
        }
        return false;
    }

    private boolean userExists(Connection conn, String username) {
        String query = "SELECT COUNT(*) FROM Table_Users WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
