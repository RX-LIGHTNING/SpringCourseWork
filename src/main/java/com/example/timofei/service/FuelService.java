package com.example.timofei.service;


import com.example.timofei.entity.FuelDelivery;
import com.example.timofei.entity.FuelType;
import com.example.timofei.entity.FuelUsage;
import com.example.timofei.repository.FuelDeliveryRepo;
import com.example.timofei.repository.FuelTypeRepo;
import com.example.timofei.repository.FuelUsageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuelService {

    private final FuelTypeRepo fuelTypeRepo;
    private final FuelDeliveryRepo fuelDeliveryRepo;
    private final FuelUsageRepo fuelUsageRepo;

    public Iterable<FuelType> findAllTypes(){
        return fuelTypeRepo.findAll();
    }
    public FuelType findTypeById(Long id){
        return fuelTypeRepo.findById(id).get();
    }
    public void saveType(FuelType fuelType){
        fuelTypeRepo.save(fuelType);
    }
    public void deleteType(Long id){
        fuelTypeRepo.deleteById(id);
    }

    //

    public Iterable<FuelDelivery> findAllDeliveries(){
        return fuelDeliveryRepo.findAll();
    }

    public FuelDelivery findDeliveryById(Long id){
        return fuelDeliveryRepo.findById(id).get();
    }

    public void saveDelivery(FuelDelivery fuelDelivery){
        fuelDeliveryRepo.save(fuelDelivery);
    }

    public void deleteDelivery(Long id){
        fuelDeliveryRepo.deleteById(id);
    }

    //---------------------

    public Iterable<FuelUsage> findAllUsages(){
        return fuelUsageRepo.findAll();
    }
    public FuelUsage findUsageById(Long id){
        return fuelUsageRepo.findById(id).get();
    }
    public void saveUsage(FuelUsage fuelUsage){
        fuelUsageRepo.save(fuelUsage);
    }
    public void deleteUsage(Long id){
        fuelUsageRepo.deleteById(id);
    }
}
