package com.akshai.FYO.Repository;

import com.akshai.FYO.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
