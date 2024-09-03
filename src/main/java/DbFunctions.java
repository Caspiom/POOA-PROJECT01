package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {
    //conectar ao banco de dados postgres
    public Connection connect_to_db(String dbname, String user, String pass){
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if(connection!=null){
                System.out.println("Connected to database");
                System.out.println("-----------------------------");
            } else {
                System.out.println("Failed to connect to database");
                System.out.println("-----------------------------");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }

    //Cria a Tabela de Usuarios
    public void createUsersTable(Connection conn, String table_name){
        Statement statement;
        try {
            String query="CREATE TABLE IF NOT EXISTS " + table_name + " (" +
                    "user_id BIGSERIAL PRIMARY KEY," +
                    "username CHAR(255) UNIQUE," +
                    "password CHAR(255)" + ");";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabela '" + table_name + "' criada com sucesso!");
            System.out.println("-----------------------------");
        } catch(Exception e){
            System.out.println(e);
        }
    }

    //Cria uma tabela de conteudo
    public void createContentTable(Connection conn, String table_name){
        Statement statement;
        try {
            String query="CREATE TABLE IF NOT EXISTS " + table_name + " (" +
                    "content_id BIGSERIAL PRIMARY KEY," +
                    "texto VARCHAR(255)," +
                    "titulo VARCHAR(255)," +
                    "autor CHAR(255) NOT NULL," +
                    "FOREIGN KEY (autor) REFERENCES Table_Users(username)" + ");";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabela '" + table_name + "' criada com sucesso!");
            System.out.println("-----------------------------");
        } catch(Exception e){
            System.out.println(e);
        }
    }

    //Insere conteudo na tabela de usuario
    public void insertIntoUsers(Connection conn,String table_name, String username, String password){
        Statement statement;
        try{
            String query = String.format("INSERT INTO %s (username, password) VALUES ('%s', '%s');",table_name ,username, password);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Dados inseridos com sucesso na tabela " + table_name + "!");
            System.out.println("-----------------------------");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //Insere conteudo na tabela de conteudo
    public void insertIntoContent(Connection conn,String table_name, String texto, String titulo, String autor){
        Statement statement;
        try{
            String query = String.format("INSERT INTO %s (texto, titulo, autor) VALUES ('%s', '%s', '%s');",table_name,texto, titulo, autor);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Dados inseridos com sucesso na tabela " + table_name + "!");
            System.out.println("-----------------------------");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //Lê a tabela de conteudo(se necessario podemos criar uma para ver a de usuario)
    public void read(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = String.format("SELECT * FROM %s",table_name);
            statement = conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.println("Count: " + rs.getString("content_id"));
                System.out.println("Autor: " + rs.getString("autor"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Texto: " + rs.getString("texto"));
                System.out.println("-----------------------------");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //Atualiza um conteudo da tabela baseado no nome
    public void update(Connection conn,String table_name,String Column, String old_name, String new_name){
        Statement statement;
        try{
            String query=String.format("update %s set %s='%s' where %s= '%s' ",table_name, Column, new_name, Column, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabela atualizada com sucesso!");
            System.out.println("-----------------------------");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //Procura um conteudo da tabela pelo nome
    public void search_name(Connection conn, String table_name,String Column, String name){
        Statement statement;
        ResultSet rs = null;

        try {
            String query = String.format("SELECT * FROM %s WHERE %s= '%s'",table_name, Column, name);
            statement= conn.createStatement();
            rs=statement.executeQuery(query);
            System.out.println("Tabela encontrada com sucesso!");
            System.out.println("-----------------------------");
            while(rs.next()){
                System.out.println("Count: " + rs.getString("content_id"));
                System.out.println("Autor: " + rs.getString("autor"));
                System.out.println("Texto: " + rs.getString("texto"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("-----------------------------");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //Deleta uma row dentro de uma tabela x
    public void delete_row(Connection conn,String table_name,String Column, String name){
        Statement statement;
        try{
            String query = String.format("DELETE FROM %s WHERE %s='%s'",table_name, Column, name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabela deletada com sucesso!");
            System.out.println("-----------------------------");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //Deleta uma tabela inteira(cuidado)
    public void delete_table(Connection conn,String table_name){
        Statement statement;
        try{
            String query= String.format("DROP TABLE %s CASCADE",table_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabela deletada com sucesso!");
            System.out.println("-----------------------------");
        }catch(Exception e){
            System.out.println(e);
        }
    }


}
