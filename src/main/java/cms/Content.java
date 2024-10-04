package cms;

import org.hsqldb.rights.User;

public class Content {
	  private int idParaAlterar;
    private int id;
    private String title;
    private String Newtitle;
    private String ConteudoAlterado;
    private String content;
    public Users autor;
  

    public Content(Integer id, String title, String content, Users autor) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.autor = autor;
    }

    public Content(int idParaAlterar, String Newtitle, String ConteudoAlterado) {
    	   this.idParaAlterar = idParaAlterar;
    	   this.title = Newtitle;
    	   this.ConteudoAlterado = ConteudoAlterado;
	}
   
	public int getIdParaAlterar() {
		return idParaAlterar;
	}

	public void setIdParaAlterar(int idParaAlterar) {
		this.idParaAlterar = idParaAlterar;
	}

	public void setConteudoAlterado(String conteudoAlterado) {
		ConteudoAlterado = conteudoAlterado;
	}

	public String getNewtitle() {
		return Newtitle;
	}

	public void setNewtitle(String newtitle) {
		Newtitle = newtitle;
	}

	public String getConteudoAlterado() {
		return ConteudoAlterado;
	}

	public void setNewContent(String newContent) {
		this.ConteudoAlterado = newContent;
	}

	public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public Users getAutor() {
        return autor;
    }

    public void setAutor(Users autor) {
        this.autor = autor;
    }


}
