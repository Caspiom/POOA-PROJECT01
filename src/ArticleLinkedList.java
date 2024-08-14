class ArticleLinkedList {
    private ArticleNode head;
    private ArticleNode tail;

    public ArticleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addArticle(String title, String content) {
        ArticleNode newNode = new ArticleNode(title, content);
        if (head == null) {
            // Se a lista estiver vazia coloca o primeiro item como head e tail ao mesmo tempo
            head = newNode;
            tail = newNode;
        } else {
            // Caso contrario, adiciona um novo nó após a tail
            tail.next = newNode;
            tail = newNode;
        }
    }

}
