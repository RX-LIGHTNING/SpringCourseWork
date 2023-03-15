package com.example.timofei.service;


import com.example.timofei.entity.Vehicle;
import com.example.timofei.entity.VehicleFuelConsumption;
import com.example.timofei.repository.VehicleFuelConsumptionRepo;
import com.example.timofei.repository.VehicleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepo vehicleRepo;
    private final VehicleFuelConsumptionRepo vehicleFuelConsumptionRepo;

    public Iterable<Vehicle> findAllVehicles(){
        return vehicleRepo.findAll();
    }
    public Vehicle findVehicleById(Long id){
        return vehicleRepo.findById(id).get();
    }
    public void saveVehicle(Vehicle vehicle){
        vehicleRepo.save(vehicle);
    }
    public void deleteVehicle(Long id){
        vehicleRepo.deleteById(id);
    }
    //v
    public Iterable<VehicleFuelConsumption> findAllConsumptions(){
        return vehicleFuelConsumptionRepo.findAll();
    }
    public VehicleFuelConsumption findConsumptionById(Long id){
        return vehicleFuelConsumptionRepo.findById(id).get();
    }
    public void saveConsumption(VehicleFuelConsumption vehicleFuelConsumption){
        vehicleFuelConsumptionRepo.save(vehicleFuelConsumption);
    }
    public void deleteConsumption(Long id){
        vehicleFuelConsumptionRepo.deleteById(id);
    }
}
