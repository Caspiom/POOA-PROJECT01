package main.java;

import java.util.LinkedList;
import java.util.Scanner;
import java.sql.Connection;

public class Main  {
    public static void main(String[] args) {

        // Criação do objetos
        // Creation of the objects
        main.java.DbFunctions DB=new main.java.DbFunctions();
        Scanner sc = new Scanner(System.in);
        main.java.Content content =new main.java.Content();
        main.java.Users users=new main.java.Users();
        main.java.MenuMethods menu=new main.java.MenuMethods();

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
                System.out.println("2 - Listar os conteúdos.");
                System.out.println("3 - Sair do sistema.");
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
                        String currentLogin = sc.next(); //next() para ler a entrada

                        System.out.println("Digite sua Senha: ");
                        String senha = sc.next();

                        //Por enquanto Login e senha se mantem admin
                        //For now Login and pass are both admin
                        if (currentLogin.equals("admin") && senha.equals("admin")) {
                            System.out.println("Succeso no Login.");
                            op2=0;

                            //Segundo menu
                            //Second menu
                            while (op2 != 10) {
                                System.out.println("=======================");
                                System.out.println("1 - Cria novo conteúdo.");
                                System.out.println("2 - Listar os conteúdos.");
                                System.out.println("3 - Editar conteúdo.");
                                System.out.println("4 - Deletar conteúdo.");
                                System.out.println("5 - Criar novo usuário.");
                                System.out.println("6 - Listar os usuários.");
                                System.out.println("7 - Alterar usuário.");
                                System.out.println("8 - Excluir usuário.");
                                System.out.println("9 - Alterar Senha.");
                                System.out.println("10 - Sair da conta.");
                                System.out.println("=======================");
                                op2 = sc.nextInt();

                                switch (op2) {
                                    case 1:
                                        menu.createContent(connection, table_content, currentLogin);
                                        continue;
                                    case 2:
                                        content.read(connection, table_content);
                                        continue;
                                    case 3:
                                        menu.changeContent(connection, table_content, currentLogin);
                                        continue;
                                    case 4:
                                        menu.deleteContent(connection, table_content, currentLogin);
                                        continue;
                                    case 5:
                                        menu.createUser(connection, table_user, currentLogin);
                                        continue;
                                    case 6:
                                        users.read(connection, table_user);
                                        continue;
                                    case 7:
                                        menu.updateUser(connection, table_user, currentLogin);
                                        continue;
                                    case 8:
                                        menu.deleteUser(connection, table_user, currentLogin);
                                        continue;
                                    case 9:
                                        menu.updatePass(connection, table_user, currentLogin);
                                    case 10:
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
                        content.read(connection, table_content);
                        continue;
                    case 3:
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