import java.util.LinkedList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Bem vindo ao sistema de gestão de artigos.!");

        int op = 0;
        int op2 = 0;
        LinkedList<String> articles = new LinkedList<String>();
        Scanner sc = new Scanner(System.in);
        Content contentList = new Content();

        try {
            while (op != 3) {
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
                        System.out.println("Digite seu Login: ");
                        String login = sc.next(); // Use next() para ler a entrada

                        System.out.println("Digite sua Senha: ");
                        String senha = sc.next();


                        if (login.equals(senha)) {
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
                                        System.out.println("Digite a ser adicionado no banco de dados: ");
                                        String content = sc.next();
                                        contentList.addContent(content, articles);
                                        break;
                                    case 2:
                                        contentList.listContent(articles);
                                        break;
                                    case 3:
                                            System.out.println("Digite o conteudo a ser modificado: ");
                                            String oldContent = sc.next();

                                            System.out.println("Digite o novo conteudo: ");
                                            String newContent = sc.next();

                                            contentList.updateContent(oldContent, newContent, articles);
                                        break;
                                    case 4:
                                            System.out.println("Digite o conteudo a ser deletado: ");
                                            String delContent = sc.next();

                                            contentList.removeContent(delContent, articles);
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
                        contentList.listContent(articles);
                        break;
                    case 3:
                        System.out.println("Saindo do sistema. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");

                }

            }
        }catch (Exception e){
            System.out.println("Opção inválida. Tente novamente.");
            return;
        }
    }
}