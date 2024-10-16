package com.aprotrain.calculatorapp.models;

public class Item {
    private String content;
    private boolean isShow;

    public Item(String content, boolean isShow) {
        this.content = content;
        this.isShow = isShow;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
