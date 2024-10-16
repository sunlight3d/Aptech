package org.bookmanager.forms;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Navigation {
    private ArrayList<Frame> frames = new ArrayList<>();
    public void push(JFrame frame) {
        frames.add(frame);
    }
    public void pop() {
        
    }
    public void popToFrame(JFrame frame) {

    }
}
