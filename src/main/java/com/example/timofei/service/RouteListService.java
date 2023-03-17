package com.example.timofei.service;

import com.example.timofei.entity.FuelType;
import com.example.timofei.entity.RouteList;
import com.example.timofei.repository.RouteListRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteListService {
    private final RouteListRepo routeListRepo;

    public Iterable<RouteList> findAll(){
        return routeListRepo.findAll();
    }
    public RouteList findRouteById(Long id){
        return routeListRepo.findById(id).get();
    }
    public void saveType(RouteList routeList){
        routeListRepo.save(routeList);
    }
    public void deleteType(Long id){
        routeListRepo.deleteById(id);
    }
}
