package org.example.models;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@Data
public class Category {
    private Long id;
    private String name;
    private String description;
}
/*
Bài tập:
Download code baitap01 và làm thêm các chức năng:
-Tao database trong mysql(tu cac cau lenh SQL hoc tren lop)
-Hiền thị menu chức năng them, sua xoa, san pham
VD: chon 1: them san pham, 2: edit san pham
Du lieu nhap vao dung Scanner
-Ket noi voi DB dung JDBC
-Chuyen giao dien sang dinh dang JavaFX(chua can ngay)
* */
