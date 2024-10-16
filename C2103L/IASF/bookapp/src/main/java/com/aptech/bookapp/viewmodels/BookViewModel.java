package com.aptech.bookapp.viewmodels;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookViewModel {
    private String title;
    private String category;
    private Float price;
}
