package com.ilham.crudapi.repositories;

import com.ilham.crudapi.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository <CarEntity, Integer>{

}
