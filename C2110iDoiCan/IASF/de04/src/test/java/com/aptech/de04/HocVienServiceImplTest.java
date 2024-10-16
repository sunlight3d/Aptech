package com.aptech.de04;

import com.aptech.de04.models.HocVien;
import com.aptech.de04.respositories.HocVienRepository;
import com.aptech.de04.services.HocVienService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HocVienServiceImplTest {

    private HocVienService hocVienService;

    @BeforeEach
    public void setup() {

    }

    @Test
    public void testFindAll() {
        // Call the findAll() method
        List<HocVien> hocViens = hocVienService.findAll();
        assertNotNull(hocViens);
    }

    @Test
    public void testFindHocVienByName() {
        // Define a test HocVien name
        String searchName = "John Doe";

        // Call the findHocVienByName() method
        HocVien foundHocVien = hocVienService.findHocVienByName(searchName);

        // Assert that the returned HocVien is not null
        assertNotNull(foundHocVien);
    }

    @Test
    public void testInputHocViens() {
        // Call the inputHocViens() method
        hocVienService.inputHocViens();

        // Call the findAll() method to retrieve all HocViens
        List<HocVien> hocViens = hocVienService.findAll();

        // Assert that the returned list is not null
        assertNotNull(hocViens);

        // Assert that the size of the list is as expected
        assertEquals(3, hocViens.size());
    }


}
