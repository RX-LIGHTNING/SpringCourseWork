package com.example.timofei.repository;


import com.example.timofei.entity.FuelType;
import com.example.timofei.entity.RouteList;
import org.springframework.data.repository.CrudRepository;

public interface RouteListRepo extends CrudRepository<RouteList,Long> {
}
