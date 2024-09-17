package cms;

import java.util.List;

public class ContentService {

    private Persistencia<Content> persistencia;

    public void ConteudoService(Persistencia<Content> persistencia) {
        this.persistencia = persistencia;
    }

    public void save(Content conteudo) {
        persistencia.save(conteudo);
    }


    public void atualizarConteudo(int id, String titulo, String texto, Users autor) {
        persistencia.atualizar(new Content(id, titulo, texto, autor));
    }

    public List<Content> listarConteudos() {
        return persistencia.listar();
    }

    public boolean removerConteudo(int id) {
        return persistencia.remover(id);
    }




}
