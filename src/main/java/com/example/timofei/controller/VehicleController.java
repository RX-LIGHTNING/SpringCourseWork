package com.example.timofei.controller;

import com.example.timofei.entity.Driver;
import com.example.timofei.entity.Vehicle;
import com.example.timofei.entity.VehicleFuelConsumption;
import com.example.timofei.service.DriverService;
import com.example.timofei.service.FuelService;
import com.example.timofei.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;
    private final FuelService fuelService;

    @GetMapping("/vehicle/menu")
    public String getVehiclesMenu(Model model){
        return "vehicleCRUD/VehicleMenu";
    }

    @GetMapping("/vehicle")
    public String getVehicles(Model model){
        model.addAttribute("vehicles",vehicleService.findAllVehicles());
        return "vehicleCRUD/vehicle/vehicleList";
    }
    @GetMapping("/vehicle/edit")
    public String editVehicle(Model model,@RequestParam(name="id", required = true)long id){
        model.addAttribute("Vehicle",vehicleService.findVehicleById(id));
        return "vehicleCRUD/vehicle/edit";
    }
    @GetMapping("/vehicle/delete")
    public String deleteVehicle(Model model,@RequestParam(name="id", required = true)long id){
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicle";
    }
    @GetMapping("/vehicle/add")
    public String addVehicle(Model model){
        model.addAttribute("Vehicle",new Vehicle());
        return "vehicleCRUD/vehicle/edit";
    }
    @PostMapping("/vehicle/edit/accept")
    public String editVehicleAccept(Model model, @ModelAttribute("Vehicle") Vehicle vehicle)
    {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicle";
    }
    //-----------------------------------------
    @GetMapping("/vehicle/consumption")
    public String getVehiclesConsumption(Model model){
        model.addAttribute("consumptions",vehicleService.findAllConsumptions());
        return "vehicleCRUD/vehicleConsumption/vehicleConsumption";
    }
    @GetMapping("/vehicle/consumption/edit")
    public String editConsumptionVehicle(Model model,@RequestParam(name="id", required = true)long id){
        model.addAttribute("FuelTypes",fuelService.findAllTypes());
        model.addAttribute("Vehicles",vehicleService.findAllVehicles());
        model.addAttribute("VehicleFuelConsumption",vehicleService.findConsumptionById(id));
        return "vehicleCRUD/vehicleConsumption/edit";
    }
    @GetMapping("/vehicle/consumption/delete")
    public String deleteConsumptionVehicle(Model model,@RequestParam(name="id", required = true)long id){
        vehicleService.deleteConsumption(id);
        return "redirect:/vehicle/consumption";
    }
    @GetMapping("/vehicle/consumption/add")
    public String addConsumptionVehicle(Model model){
        model.addAttribute("FuelTypes",fuelService.findAllTypes());
        model.addAttribute("Vehicles",vehicleService.findAllVehicles());
        model.addAttribute("VehicleFuelConsumption",new VehicleFuelConsumption());
        return "vehicleCRUD/vehicleConsumption/edit";
    }
    @PostMapping("/vehicle/consumption/edit/accept")
    public String editConsumptionVehicleAccept(Model model, @ModelAttribute("VehicleFuelConsumption")VehicleFuelConsumption vehicleFuelConsumption)
    {
        vehicleService.saveConsumption(vehicleFuelConsumption);
        return "redirect:/vehicle/consumption";
    }
}
