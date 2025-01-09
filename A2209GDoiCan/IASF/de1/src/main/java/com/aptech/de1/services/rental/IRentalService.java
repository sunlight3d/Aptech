package com.aptech.de1.services.rental;

import com.aptech.de1.models.Rental;
import org.springframework.data.domain.Page;

public interface IRentalService {
    Page<Rental> getRentalsWithDetails(int page, int size, String search);
}
