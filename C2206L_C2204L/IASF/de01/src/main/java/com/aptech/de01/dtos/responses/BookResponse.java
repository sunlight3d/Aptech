package com.aptech.de01.dtos.responses;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private Long id;
    private String title;
    private String category;
    private BigDecimal price;
    public Boolean isExpensive() {
        return price.compareTo(BigDecimal.valueOf(10.0)) > 0;
    }
}
