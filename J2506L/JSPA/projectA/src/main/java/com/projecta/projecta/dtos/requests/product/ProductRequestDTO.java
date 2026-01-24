package com.projecta.projecta.dtos.requests.product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    @NotBlank(message = "Name không được để trống")
    private String name;

    @Min(value = 0, message = "Quantity phải >= 0")
    private int quantity;

    @Pattern(
            regexp = "ACTIVE|INACTIVE",
            message = "Status chỉ được là ACTIVE hoặc INACTIVE"
    )
    private String status;

    @NotNull(message = "Price không được null")
    private Double price;
}