class ArticleNode {
    String title;
    String content;
    ArticleNode next; // Reference to the next node

    public ArticleNode(String title, String content) {
        this.title = title;
        this.content = content;
        this.next = null; // Initialize the next reference to null
    }
}
