package main.java;

import java.util.LinkedList;
import java.util.Scanner;
import java.sql.Connection;

public class Main  {
    public static void main(String[] args) {

        // Criação do objeto DB e sc
        // Creation of the DB and sc object
        main.java.DbFunctions DB=new main.java.DbFunctions();
        Scanner sc = new Scanner(System.in);
        main.java.Content content =new main.java.Content();
        main.java.Users users=new main.java.Users();

        // Conectando ao banco Postgres
        // Connecting to the Postgres database
        Connection connection = DB.connect_to_db("", "postgres", "postgres" );

        // Criação de variáveis de controle
        // Creation of control variables
        int op = 0;
        int op2 = 0;

        // Dá nome às variáveis responsáveis por gerenciar as tabelas do banco de dados
        // Names the variables responsible for managing the database tables
        String table_content = "table_content";
        String table_user = "Table_Users";

        //Cria(se ja não existir) os bancos as tabelas
        users.createTable(connection, table_user);
        content.createTable(connection, table_content);

        try {
            while (op != 4) {
                // Menu inicial
                // First menu
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
                        // Login e Senha
                        // Login and Pass
                        System.out.println("Digite seu Login: ");
                        String login = sc.next(); //next() para ler a entrada

                        System.out.println("Digite sua Senha: ");
                        String senha = sc.next();

                        //Por enquanto Login e senha se mantem admin
                        //For now Login and pass are both admin
                        if (login.equals("admin") && senha.equals("admin")) {
                            System.out.println("Succeso no Login.");
                            op2=0;

                            //Segundo menu
                            //Second menu
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
                                        content.insertInto(connection, table_content, texto, titulo, login);
                                        continue;
                                    case 2:
                                        DB.read(connection, table_content);
                                        continue;
                                    case 3:
                                            System.out.println("=======================");
                                            System.out.println("1 - Mudar título");
                                            System.out.println("2 - Mudar conteudo");
                                            System.out.println("=======================");
                                            int opTiCon = sc.nextInt();
                                            switch (opTiCon){
                                                case 1:
                                                    System.out.println("Digite o título a ser modificado: ");
                                                    if (sc.hasNextLine()) sc.nextLine(); // Limpa qualquer nova linha residual
                                                    String oldTitle = sc.nextLine();

                                                    System.out.println("Digite o novo título: ");
                                                    String newTitle = sc.nextLine();

                                                    DB.update(connection, table_content, "titulo", oldTitle, newTitle);
                                                    continue;
                                                case 2:
                                                    System.out.println("Digite o conteudo a ser modificado: ");
                                                    if (sc.hasNextLine()) sc.nextLine(); // Limpa qualquer nova linha residual
                                                    String oldContent = sc.nextLine();

                                                    System.out.println("Digite o novo conteudo: ");
                                                    String newContent = sc.nextLine();

                                                    DB.update(connection, table_content, "titulo", oldContent, newContent);
                                                    continue;
                                                default:
                                                    System.out.println("Opção inválida. Tente novamente.");
                                                    break;
                                            }
                                    case 4:
                                            System.out.println("Digite o título do conteudo a ser deletado: ");
                                            if (sc.hasNextLine()) sc.nextLine(); // Limpa qualquer nova linha residual
                                            String delContent = sc.nextLine();

                                            DB.delete_row(connection, table_content, "titulo", delContent);
                                        continue;
                                    case 5:
                                        System.out.println("Saindo da sua conta. Até logo!");
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                }
                            }
                        } else {
                            System.out.println("Login e Senha incorretos! Digite novamente.");
                        }
                        break;
                    case 2:
                        users.insertInto(connection, table_user,"admin","admin" );
                        System.out.println("Usario admin criado!");
                        continue;
                    case 3:
                        DB.read(connection, table_content);
                        continue;
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