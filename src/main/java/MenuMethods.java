package main.java;

import java.sql.Connection;
import java.util.Scanner;

public class MenuMethods {

    main.java.DbFunctions DB=new main.java.DbFunctions();
    Scanner sc = new Scanner(System.in);
    main.java.Content content =new main.java.Content();

    public String createContent(Object connection, String table_content, String login){
        System.out.println("Digite o título a ser adicionado no banco de dados: ");
        String titulo = sc.nextLine();

        System.out.println("Digite o texto a ser adicionado no banco de dados: ");
        String texto = sc.nextLine();
        content.insertInto((Connection) connection, table_content, texto, titulo, login);
        return titulo;
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
        return newContent;
    }

    public String DeleteContent(Object connection, String table_content, String login){
        String delContent = null;
        System.out.println("Digite o título do conteudo a ser deletado: ");
        delContent = sc.nextLine();

        DB.delete_row((Connection) connection, table_content, "titulo", delContent);
        return delContent;
    }

}
