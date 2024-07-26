package com.akshai.FYO.Repository;

import com.akshai.FYO.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
