package com.aptech.nguyenvana;


public class ExamNotFoundException extends Exception {
    public static  final int HIGH_SEVERITY = 1;
    public static  final int LOW_SEVERITY = 2;
    private int severity;
    public ExamNotFoundException(String message, int severity) {
        super(message);
        this.severity = severity;
    }

}
