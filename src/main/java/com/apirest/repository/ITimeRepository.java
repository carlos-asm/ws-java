package com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.model.Time;

@Repository
public interface ITimeRepository extends JpaRepository<Time, Integer>{

}
