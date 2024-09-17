package cms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {

    private static final String DB_URL = "jdbc:hsqldb:mem:conteudoDB";

    //conectar ao banco de dados hsql
    protected Connection connect_to_hsql(String dbname, String user, String pass){
        Connection connection = null;
        try{
            // Carregar o driver
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            // Estabelecer a conexão
            String connectionUrl = DB_URL + dbname;
            connection = DriverManager.getConnection(connectionUrl, user, pass);
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
            System.out.println("Coluna deletada com sucesso!");
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
