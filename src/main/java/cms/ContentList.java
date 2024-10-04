package cms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ContentList implements Persistencia<Content> {

    Scanner scan = new Scanner(System.in);
    private List<Content> conteudos = new ArrayList<>();
    private int count = 1 ;

    @Override
    public void save(Content conteudo) {
        if(conteudo.getId() == null) {
            conteudo.setId(count++);
        }
        conteudos.add(conteudo);
    }

    @Override
    public void atualizar(Content entidade) {
        for (Content conteudo : conteudos) {
            if (conteudo.getId() == entidade.getId()) {
                conteudo.setTitle(entidade.getTitle());
                conteudo.setContent(entidade.getContent());
                break;
            }
        }
    }

    @Override
    public List<Content> listar() {
        return Collections.unmodifiableList(conteudos);
    }

    @Override
    public boolean remover(int id) {
        return conteudos.removeIf(conteudo -> conteudo.getId() == id);
    }

    public void createContent(Users CurrentUser) {
        System.out.println("Digite o titulo: ");
        String Titulo = scan.nextLine();

        System.out.println("Digite o conteudo: ");
        String novoConteudo = scan.nextLine();

        Content newContent = new Content(count, Titulo, novoConteudo, CurrentUser);

        save(newContent);
        count++; // Incrementa o contador de IDs
        System.out.println("Conteúdo adicionado com sucesso!");
    }

    public Users editContent(Users CurrentUser) {
        System.out.println("Digite o ID do conteúdo que quer alterar: ");
        int idParaAlterar = scan.nextInt();
        scan.nextLine(); // Consume o restante da linha

        System.out.println("Digite o novo título: ");
        String Newtitle = scan.nextLine();

        System.out.println("Digite o novo conteúdo: ");
        String ConteudoAlterado = scan.nextLine();

        Content content = new Content( idParaAlterar ,  Newtitle, ConteudoAlterado);
        content.setId(idParaAlterar);
        content.setTitle(Newtitle);
        content.setContent(ConteudoAlterado);

        atualizar(content);
        return CurrentUser;
    }

    public Users deleteContent(Users CurrentUser) {
        System.out.println("Digite o id do conteúdo que quer deletar: ");
        int id = scan.nextInt();
        remover(id);
        return CurrentUser;
    }

    public void print() {
        System.out.println("Lista de conteúdos:");
        List<Content> listaConteudos = listar();
        for (Content conteudolist : listaConteudos) {
            System.out.println("ID: " + conteudolist.getId() + ", Título: " + conteudolist.getTitle() + ", Conteúdo: " + conteudolist.getContent());
        }
    }

}