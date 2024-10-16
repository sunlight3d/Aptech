package models;

public class CompactDisk {
    private Integer id;
    private String title;
    private String singer;
    private Integer numberOfSongs;
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Integer getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(Integer numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    //default constructor
    CompactDisk(){
        title = "";
        singer = "";
        numberOfSongs = 0;
        price = 0.0f;
    }

    public CompactDisk(
            Integer id,
            String title, String singer,
                       Integer numberOfSongs, Float price) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.numberOfSongs = numberOfSongs;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("id = %d, title= %s, singer= %s,numberOfSongs=%d, price= %.1f",
                this.id, this.title, this.singer, this.numberOfSongs, this.price);
    }
}
