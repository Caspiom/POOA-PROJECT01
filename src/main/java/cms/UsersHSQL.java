package cms;

import java.sql.*;
import java.util.Scanner;

public class UsersHSQL {

    DbFunctions DB=new DbFunctions();
    Scanner sc = new Scanner(System.in);


    //Cria a Tabela de Usuarios
    public void createTable(Connection conn, String table_name) {
        String query = "CREATE TABLE IF NOT EXISTS " + table_name + " (" +
                "user_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, " +
                "username CHAR(255) UNIQUE, " +
                "password CHAR(255));";
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Tabela '" + table_name + "' criada com sucesso!");
            System.out.println("-----------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Insere conteudo na tabela de usuario
    public void insertInto(Connection conn, String table_name, String username, String password) {
        String query = "INSERT INTO " + table_name + " (username, password) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso na tabela " + table_name + "!");
            System.out.println("-----------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Lê a tabela de usuario
    public void read(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = String.format("SELECT * FROM %s",table_name);
            statement = conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.println("Count: " + rs.getString("user_id"));
                System.out.println("Autor: " + rs.getString("username"));
                System.out.println("Senha: " + rs.getString("password"));
                System.out.println("-----------------------------");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public Users createUser(Object connection, String table_users, Users login){
        System.out.println("Digite o nome do novo usuário: ");
        String newUser = sc.nextLine();

        System.out.println("Digite a senha: ");
        String pass = sc.nextLine();
        System.out.println("Digite a senha novamente: ");
        String pass2 = sc.nextLine();
        if(pass.equals(pass2)){
            insertInto((Connection) connection, table_users, newUser, pass);
        }else{
            System.out.println("Senhas não compatíveis, tente novamente");
        }
        return login;
    }

    public String updateUser(Object connection, String table_users, Users login) {
        String updateUser = null;
        System.out.println("Seu usuário atual é: " + login.getName());
        String currentUser = login.getName();

        System.out.println("Digite o seu novo nome de usuário: ");
        updateUser = sc.nextLine();
        System.out.println("Digite novamente: ");
        String updateUser2 = sc.nextLine();

        if (updateUser.equals(updateUser2)) {
            DB.update((Connection) connection, table_users, "username", currentUser, updateUser);
            login.setName(updateUser);
            System.out.println("Seu nome de usuário foi atualizado com sucesso!");
        } else {
            System.out.println("Nomes de usuário não compatíveis, tente novamente");
        }
        return updateUser;
    }

    public Users deleteUser(Object connection, String table_users, Users login){
        String deleteUser = null;
        System.out.println("Digite o usuário a ser deletado:");
        deleteUser = sc.nextLine();

        try {
            DB.delete_row((Connection) connection, table_users, "username", deleteUser);
        }catch (Exception e){
            System.out.println(e);
        }
        return login;
    }

    private String getCurrentPassword(Connection connection, String table_users, String login) {
        String query = "SELECT password FROM " + table_users + " WHERE username = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String updatePass(Object connection, String table_users, Users login){
        String updatePass = null;
        System.out.println("Seu usuário atual é: " + login.getName());

        // Recuperar a senha atual do usuário
        String currentPassword = getCurrentPassword((Connection)connection, table_users, login.getName());
        if (currentPassword == null) {
            System.out.println("Usuário não encontrado.");
            return null;
        }

        System.out.println("Digite a sua nova senha: " );
        updatePass = sc.nextLine();
        System.out.println("Digite novamente: " );
        String updatePass2 = sc.nextLine();

        if(updatePass.equals(updatePass2)){
            DB.update((Connection) connection, table_users, "password", currentPassword, updatePass);
            System.out.println("Sua senha foi atualizado com sucesso!");
        }else{
            System.out.println("Senhas não compatíveis, tente novamente");
        }
        return updatePass;
    }

}
