package com.aptech.de02.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignProductCategoryDTO {
    private String categoryId;
    private String productName;
}
