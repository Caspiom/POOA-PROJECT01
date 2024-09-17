package cms;

import org.hsqldb.rights.User;

public class Content {

    private int id;
    private String title;
    private String content;
    public Users autor;

    public Content(Integer id, String title, String content, Users autor) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.autor = autor;
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
