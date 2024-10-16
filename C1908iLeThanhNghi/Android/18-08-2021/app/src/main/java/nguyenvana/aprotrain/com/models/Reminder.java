package nguyenvana.aprotrain.com.models;

public class Reminder {
    private int id;
    private String noidung;
    private boolean quantrong;

    public Reminder(int id, String noidung, boolean quantrong) {
        this.id = id;
        this.noidung = noidung;
        this.quantrong = quantrong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
