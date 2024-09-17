package cms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContentList implements Persistencia<Content> {

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

}