package com.example.multipledb.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PRepository extends JpaRepository<PrimaryEntity, Integer>{

}
