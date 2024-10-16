package nguyenvana.aprotrain.com.models;

public class Reminder {
    private String noidung;
    private boolean quantrong;

    public Reminder(String noidung, boolean quantrong) {
        this.noidung = noidung;
        this.quantrong = quantrong;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public boolean isQuantrong() {
        return quantrong;
    }

    public void setQuantrong(boolean quantrong) {
        this.quantrong = quantrong;
    }
}
