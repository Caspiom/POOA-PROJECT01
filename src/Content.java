
import java.io.PrintStream;
import java.util.LinkedList;

public class Content {

    LinkedList<String> articles = new LinkedList<String>();

    public void addContent(String content, LinkedList<String> articles) {
        articles.add(content);
    }

    public void listContent(LinkedList<String> articles) {
        System.out.println(articles);
    }

    public void updateContent(String content, String newContent, LinkedList<String> articles) {
        if(articles.contains(content)) {
            int index = articles.indexOf(content);
            if (index != -1) {
                articles.set(index, newContent);
                System.out.println("Conteudo atualizado com sucesso.");
            }
        }else{
            System.out.println("O artigo não existe");
        }
    }

    public void removeContent(String content, LinkedList<String> articles) {
        if(articles.contains(content)) {
            articles.remove(content);
            System.out.println("Conteudo deletado com sucesso.");
        }else{
            System.out.println("O artigo não existe");
        }
    }


}
