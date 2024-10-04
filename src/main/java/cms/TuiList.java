package cms;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TuiList extends UI {
	
	public void start () {
        Scanner scan = new Scanner(System.in);

        ContentList conteudo = new ContentList();
        UsersList users = new UsersList();

        int opcaoMenuPrincipal = 0;
        int count = 0;
        //o usuario é criado quando logado no sistema pela primeira vez
        Users admin = new Users(count, "admin", "admin");
        users.save(admin);
        count++;

        while (opcaoMenuPrincipal != 3) {
            int opcaoMenuConteudo = 1;
            System.out.println("=======================");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Listar os Conteúdos");
            System.out.println("3 - Sair do sistema");
            System.out.println("=======================");

            try {
                opcaoMenuPrincipal = scan.nextInt();
                scan.nextLine(); 
            } catch (Exception e) {
                System.out.println("Opção inválida. Digite um número entre 1 e 3.");
                scan.nextLine(); 
                continue;
            }



            switch (opcaoMenuPrincipal) {
                case 1:
                    System.out.println("Digite seu usuário: ");
                    String usuario = scan.nextLine();

                    System.out.println("Digite sua senha: ");
                    String senha = scan.nextLine();

                    Users CurrentUser = new Users(count, usuario, senha);

                    if(users.verificarCredenciais(usuario, senha)) {
                        while (opcaoMenuConteudo <= 10 && opcaoMenuConteudo >=1) {
                            System.out.println("=======================");
                            System.out.println("1 - Criar conteúdo");
                            System.out.println("2 - Listar conteúdo");
                            System.out.println("3 - Editar conteúdo");
                            System.out.println("4 - Deletar conteúdo");
                            System.out.println("5 - Criar usuário");
                            System.out.println("6 - Listar usuários");
                            System.out.println("7 - Editar usuário");
                            System.out.println("8 - Deletar usuário");
                            System.out.println("9 - Alterar senha do usuário");
                            System.out.println("10 - Sair");
                            System.out.println("=======================");

                            try {
                                opcaoMenuConteudo = scan.nextInt();
                                scan.nextLine(); // Consumir o caractere de nova linha
                            } catch (Exception e) {
                                System.out.println("Opção inválida. Digite um número entre 1 e 10.");
                                scan.nextLine(); // Limpar o buffer de entrada
                                continue;
                            }

                            switch (opcaoMenuConteudo) {
                                case 1:
                                    conteudo.createContent(CurrentUser);
                                    break;
                                case 2:
                                    conteudo.print();
                                    break;
                                case 3:
                                    conteudo.editContent(CurrentUser);
                                    break;
                                case 4:
                                    conteudo.deleteContent(CurrentUser);
                                    break;
                                case 5:
                                    users.createUser(count);
                                    count++;
                                    break;
                                case 6:
                                    users.print();
                                    break;
                                case 7:
                                    users.editUser();
                                    break;
                                case 8:
                                    users.deleteUser();
                                    break;
                                case 9:
                                    users.editPass();
                                    break;
                                case 10:
                                    opcaoMenuConteudo = 0;
                                    break;
                                default:
                                    System.out.println("Opção inválida. Digite um número entre 1 e 10.");
                                    opcaoMenuConteudo = 1;
                            }
                        }
                    }
                    opcaoMenuConteudo = 0; // Reiniciar a opção do menu de conteúdo
                    if(!users.verificarCredenciais(usuario, senha)){
                        users.remover(CurrentUser.getId());
                    }
                    break;
                case 2:
                    conteudo.print();
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar nosso sistema, volte sempre !");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scan.close();
    }
}




