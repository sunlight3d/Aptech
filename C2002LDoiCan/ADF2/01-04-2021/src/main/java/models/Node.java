package models;

import java.util.ArrayList;

public class Node {
    private String content;//Eg: *, / 2
    Node parent;

    public Node(String content) {
        this.content = content;
    }

    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }

}
