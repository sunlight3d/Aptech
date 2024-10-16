package models;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

@Entity("films")
public class Film {
    @Id
    private String _id;
    private String vietnameseName;
    private String englishName;
    private Double duration;

    public Film(String vietnameseName, String englishName, Double duration) {
        this.vietnameseName = vietnameseName;
        this.englishName = englishName;
        this.duration = duration;
    }
}
