package com.aptech.de01.viewmodels.user;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BookViewModel {
    @NotEmpty(message = "Title is required")
    @Size(min = 3, message = "Title must be at least 3 characters")
    private String title;

    @NotEmpty(message = "Category is required")
    private String category;

    @Min(value = 0, message = "Price must be greater than 0")
    private double price;
}