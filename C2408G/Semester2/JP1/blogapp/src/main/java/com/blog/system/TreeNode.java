package com.blog.system;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private int data;
    private List<TreeNode> children = new ArrayList<>();

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
