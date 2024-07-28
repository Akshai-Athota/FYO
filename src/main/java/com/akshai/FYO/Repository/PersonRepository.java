package com.akshai.FYO.Repository;

import com.akshai.FYO.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query("SELECT u FROM Person u WHERE u.currentLocation = :currentLocation")
    List<Person> findByCurrentLocation(@Param("currentLocation") String currentLocation);

}
