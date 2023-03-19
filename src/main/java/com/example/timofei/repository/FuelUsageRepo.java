package com.example.timofei.repository;

import com.example.timofei.entity.FuelUsage;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface FuelUsageRepo extends CrudRepository<FuelUsage,Long> {
    List<FuelUsage> findFuelUsagesByUsagedateBetween(Date publicationTimeStart,
                                                     Date publicationTimeEnd);
}
