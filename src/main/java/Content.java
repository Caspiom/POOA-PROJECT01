package main.java;

import java.sql.Connection;
import java.sql.Statement;

public class Content {

    //Cria uma tabela de conteudo
    public void createTable(Connection conn, String table_name){
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

    //Insere conteudo na tabela de conteudo
    public void insertInto(Connection conn,String table_name, String texto, String titulo, String autor){
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

}
