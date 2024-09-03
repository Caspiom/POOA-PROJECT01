package main.java;

import java.util.LinkedList;
import java.util.Scanner;
import java.sql.Connection;

public class Main  {
    public static void main(String[] args) {

        //CRIAÇÃO DO OBEJETO DB
        main.java.DbFunctions DB=new main.java.DbFunctions();

        //CONECTANDO A O BANCO POSTGRES
        Connection connection = DB.connect_to_db("", "postgres", "postgres" );

        int op = 0;
        int op2 = 0;
        LinkedList<String> articles = new LinkedList<String>();
        Scanner sc = new Scanner(System.in);
        main.java.Content contentList = new main.java.Content();

        String table_content = "table_content";
        //db.createContentTable(conn, "Table_Content");
        String table_user = "Table_Users";
        //db.createUsersTable(conn, table_user);

        DB.delete_table(connection, table_content);

        DB.createUsersTable(connection, table_user);

        DB.createContentTable(connection, table_content);




        try {
            while (op != 3) {
                System.out.println("=======================");
                System.out.println("1 - Login.");
                System.out.println("2 - Cadastrar usuario.");
                System.out.println("3 - Listar os conteúdos.");
                System.out.println("4 - Sair do sistema.");
                System.out.println("=======================");



                try {
                    op = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Opção inválida. Digite novamente.");
                    continue;
                }


                switch (op) {
                    case 1:

                        System.out.println("Digite seu Login: ");
                        String login = sc.next(); //next() para ler a entrada

                        System.out.println("Digite sua Senha: ");
                        String senha = sc.next();


                        if (login.equals("admin") && senha.equals("admin")) {
                            System.out.println("Succeso no Login.");
                            op2=0;

                            while (op2 != 5) {
                                System.out.println("=======================");
                                System.out.println("1 - Cria novo conteúdo.");
                                System.out.println("2 - Listar os conteúdos.");
                                System.out.println("3 - Editar conteúdo.");
                                System.out.println("4 - Deletar conteúdo.");
                                System.out.println("5 - Sair da conta.");
                                System.out.println("=======================");
                                op2 = sc.nextInt();

                                switch (op2) {
                                    case 1:
                                        System.out.println("Digite o título a ser adicionado no banco de dados: ");
                                        if (sc.hasNextLine()) sc.nextLine(); // Limpa qualquer nova linha residual
                                        String titulo = sc.nextLine();

                                        System.out.println("Digite o texto a ser adicionado no banco de dados: ");
                                        String texto = sc.nextLine();
                                        DB.insertIntoContent(connection, table_content, texto, titulo, login);
                                        break;
                                    case 2:
                                        DB.read(connection, table_content);
                                        break;
                                    case 3:
                                            System.out.println("=======================");
                                            System.out.println("1 - Mudar título");
                                            System.out.println("2 - Mudar conteudo");
                                            System.out.println("=======================");
                                            int opTiCon = sc.nextInt();
                                            switch (opTiCon){
                                                case 1:
                                                    System.out.println("Digite o título a ser modificado: ");
                                                    String oldTitle = sc.next();

                                                    System.out.println("Digite o novo título: ");
                                                    String newTitle = sc.next();

                                                    DB.update(connection, table_content, "titulo", oldTitle, newTitle);
                                                    break;
                                                case 2:
                                                    System.out.println("Digite o conteudo a ser modificado: ");
                                                    String oldContent = sc.next();

                                                    System.out.println("Digite o novo conteudo: ");
                                                    String newContent = sc.next();

                                                    DB.update(connection, table_content, "titulo", oldContent, newContent);
                                                    break;
                                            }
                                    case 4:
                                            System.out.println("Digite o título do conteudo a ser deletado: ");
                                            String delContent = sc.next();

                                            DB.delete_row(connection, table_content, "titulo", delContent);
                                        break;
                                    case 5:
                                        System.out.println("Saindo da sua conta. Até logo!");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Login e Senha incorretos! Digite novamente.");
                        }
                        break;
                    case 2:
                        DB.insertIntoUsers(connection, table_user,"admin","admin" );
                        System.out.println("Usario admin criado!");
                    case 3:
                        contentList.listContent(articles);
                        break;
                    case 4:
                        System.out.println("Saindo do sistema. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");

                }

            }
        }catch (Exception e){
            System.out.println("Opção inválida. Tente novamente.");
        }
    }
}