package nguyenvana.aprotrain.myapp.models;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private int id;
    private String name;
    private String description;
    private Date selectedDate;
    private int numberOfRequests;
    private int numberOfPledge;
    private String weight;
    public Product() {}

    public Product(int id, String name, String description,
                   Date selectedDate, int numberOfRequests,
                   int numberOfPledge, String weight) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.selectedDate = selectedDate;
        this.numberOfRequests = numberOfRequests;
        this.numberOfPledge = numberOfPledge;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
    }

    public void setNumberOfRequests(int numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }

    public int getNumberOfPledge() {
        return numberOfPledge;
    }

    public void setNumberOfPledge(int numberOfPledge) {
        this.numberOfPledge = numberOfPledge;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
