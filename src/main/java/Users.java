package main.java;

import java.sql.Connection;
import java.sql.Statement;

public class Users {

    //Cria a Tabela de Usuarios
    public void createTable(Connection conn, String table_name){
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

    //Insere conteudo na tabela de usuario
    public void insertInto(Connection conn,String table_name, String username, String password){
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

}
