package models;

public class CodeLine {
    private String content;
    private boolean isComment;
    public CodeLine(String content, boolean isComment){
        this.content = content;
        this.isComment = isComment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isComment() {
        return isComment;
    }

    public void setComment(boolean comment) {
        isComment = comment;
    }
}
