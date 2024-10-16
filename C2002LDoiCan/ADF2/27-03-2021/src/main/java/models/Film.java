package models;

public class Film {
    private String vietnameseName;
    private String englishName;
    private Double duration;

    public Film(String vietnameseName, String englishName, Double duration) {
        this.vietnameseName = vietnameseName;
        this.englishName = englishName;
        this.duration = duration;
    }
}
