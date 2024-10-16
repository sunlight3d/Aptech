package models;

public class Product {
    private String productName;
    private Integer productYear;
    private Double price;

    public Product(String productName, Integer productYear, Double price) {
        this.productName = productName;
        this.productYear = productYear;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductYear() {
        return productYear;
    }

    public void setProductYear(Integer productYear) {
        this.productYear = productYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
