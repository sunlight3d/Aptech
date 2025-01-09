package com.aptech.de1.services.rental;

import com.aptech.de1.models.Rental;
import com.aptech.de1.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RentalService implements IRentalService{
    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Page<Rental> getRentalsWithDetails(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (search != null && !search.isBlank()) {
            return rentalRepository.findAllRentalsWithSearch(search, pageable);
        }
        return rentalRepository.findAllRentalsWithDetails(pageable);
    }
}
