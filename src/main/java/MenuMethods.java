package main.java;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MenuMethods {

    main.java.DbFunctions DB=new main.java.DbFunctions();
    Scanner sc = new Scanner(System.in);
    main.java.Content content =new main.java.Content();
    main.java.Users user=new main.java.Users();

    public String createContent(Object connection, String table_content, String login){
        System.out.println("Digite o título a ser adicionado no banco de dados: ");
        String titulo = sc.nextLine();

        System.out.println("Digite o texto a ser adicionado no banco de dados: ");
        String texto = sc.nextLine();
        content.insertInto((Connection) connection, table_content, texto, titulo, login);
        return login;
    }

    public String changeContent(Object connection, String table_content, String login){
        String newContent = null;
        System.out.println("=======================");
        System.out.println("1 - Mudar título");
        System.out.println("2 - Mudar conteudo");
        System.out.println("=======================");
        int op = sc.nextInt();
        switch (op){
            case 1:
                System.out.println("Digite o título a ser modificado: ");
                if (sc.hasNextLine()) sc.nextLine(); // Limpa qualquer nova linha residual
                String oldTitle = sc.nextLine();

                System.out.println("Digite o novo título: ");
                newContent = sc.nextLine();

                DB.update((Connection) connection, table_content, "titulo", oldTitle, newContent);
                break;
            case 2:
                System.out.println("Digite o conteudo a ser modificado: ");
                if (sc.hasNextLine()) sc.nextLine(); // Limpa qualquer nova linha residual
                String oldContent = sc.nextLine();

                System.out.println("Digite o novo conteudo: ");
                newContent = sc.nextLine();

                DB.update((Connection) connection, table_content, "titulo", oldContent, newContent);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
        return login;
    }

    public String deleteContent(Object connection, String table_content, String login){
        String delContent = null;
        System.out.println("Digite o título do conteudo a ser deletado: ");
        delContent = sc.nextLine();

        try {
            DB.delete_row((Connection) connection, table_content, "titulo", delContent);
        } catch (Exception e) {
            System.out.println(e);
        }
        return login;
    }

    public String createUser(Object connection, String table_users, String login){
        System.out.println("Digite o nome do novo usuário: ");
        String newUser = sc.nextLine();

        System.out.println("Digite a senha: ");
        String pass = sc.nextLine();
        System.out.println("Digite a senha novamente: ");
        String pass2 = sc.nextLine();
        if(pass.equals(pass2)){
            user.insertInto((Connection) connection, table_users, newUser, pass);
        }else{
            System.out.println("Senhas não compatíveis, tente novamente");
        }
        return login;
    }

    public String updateUser(Object connection, String table_users, String login){
        String updateUser = null;
        System.out.println("Seu usuário atual é: " + login);

        System.out.println("Digite o seu novo nome de usuário: " );
        updateUser = sc.nextLine();
        System.out.println("Digite novamente: " );
        String updateUser2 = sc.nextLine();

        if(updateUser.equals(updateUser2)){
            DB.update((Connection) connection, table_users, "username", updateUser, updateUser2);
            System.out.println("Seu nome de usuário foi atualizado com sucesso!");
        }else{
            System.out.println("Nomes de usuário não compatíveis, tente novamente");
        }
        return updateUser;
    }

    public String deleteUser(Object connection, String table_users, String login){
        String deleteUser = null;
        System.out.println("Digite o usuário a ser deletado:");
        deleteUser = sc.nextLine();

        try {
            DB.delete_row((Connection) connection, table_users, "titulo", deleteUser);
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

    public String updatePass(Object connection, String table_users, String login){
        String updatePass = null;
        System.out.println("Seu usuário atual é: " + login);

        // Recuperar a senha atual do usuário
        String currentPassword = getCurrentPassword((Connection)connection, table_users, login);
        if (currentPassword == null) {
            System.out.println("Usuário não encontrado.");
            return null;
        }

        System.out.println("Digite a sua nova senha: " );
        updatePass = sc.nextLine();
        System.out.println("Digite novamente: " );
        String updatePass2 = sc.nextLine();

        if(updatePass.equals(updatePass2)){
            DB.update((Connection) connection, table_users, "username", updatePass, updatePass2);
            System.out.println("Seu nome de usuário foi atualizado com sucesso!");
        }else{
            System.out.println("Nomes de usuário não compatíveis, tente novamente");
        }
        return updatePass;
    }


}
