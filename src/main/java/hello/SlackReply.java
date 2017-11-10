package hello;

public class SlackReply {

    private final long id;
    private final String content;

    public SlackReply(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
