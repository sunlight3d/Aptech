package com.aptech.de01.viewmodels;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookViewModel {
    //can validate
    private String title;
    private String category;
    private double price;
}