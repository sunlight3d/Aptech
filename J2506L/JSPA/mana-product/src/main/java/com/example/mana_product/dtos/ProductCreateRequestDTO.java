package com.example.mana_product.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateRequestDTO {
    //params for "insert": DONOT need id !
    //request must have "VAlidation"
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String name;

    @Min(value = 0, message = "Giá không được âm")
    private Double price;

    @NotNull(message = "Phải có category_id")
    private Long categoryId;
}
