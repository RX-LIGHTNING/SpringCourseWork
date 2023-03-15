package com.example.timofei.controller;

import com.example.timofei.entity.Driver;
import com.example.timofei.entity.FuelDelivery;
import com.example.timofei.entity.FuelType;
import com.example.timofei.entity.FuelUsage;
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
public class FuelController {

    private final FuelService fuelService;
    private final VehicleService vehicleService;
    private final DriverService driverService;

    @GetMapping("/fuel")
    public String getFuelMenu(Model model){
        return "fuelCRUD/FuelMenu";
    }
    @GetMapping("/fuel/type")
    public String getFuelType(Model model){
        model.addAttribute("types",fuelService.findAllTypes());
        return "fuelCRUD/fuelType/fuelType";
    }
    @GetMapping("/fuel/type/edit")
    public String editFuelType(Model model,@RequestParam(name="id", required = true)long id){
        model.addAttribute("FuelType",fuelService.findTypeById(id));
        return "fuelCRUD/fuelType/edit";
    }
    @GetMapping("/fuel/type/delete")
    public String deleteFuelType(Model model,@RequestParam(name="id", required = true)long id){
        fuelService.deleteType(id);
        return "redirect:/fuel/type";
    }
    @GetMapping("/fuel/type/add")
    public String addFuelType(Model model){
        model.addAttribute("FuelType",new FuelType());
        return "fuelCRUD/fuelType/edit";
    }
    @PostMapping("/fuel/type/edit/accept")
    public String editDriverAccept(Model model, @ModelAttribute("FuelType") FuelType fuelType)
    {
        fuelService.saveType(fuelType);
        return "redirect:/fuel/type";
    }

    //

    @GetMapping("/fuel/usage")
    public String getFuelUsage(Model model){
        model.addAttribute("usages",fuelService.findAllUsages());
        return "fuelCRUD/fuelUsage/fuelUsage";
    }
    @GetMapping("/fuel/usage/edit")
    public String editFuelUsage(Model model,@RequestParam(name="id", required = true)long id){
        model.addAttribute("FuelUsage",fuelService.findUsageById(id));
        model.addAttribute("FuelTypes", fuelService.findAllTypes());
        model.addAttribute("Vehicles", vehicleService.findAllVehicles());
        model.addAttribute("Drivers", driverService.findAll());
        return "fuelCRUD/fuelUsage/edit";
    }
    @GetMapping("/fuel/usage/delete")
    public String deleteFuelUsage(Model model,@RequestParam(name="id", required = true)long id){
        fuelService.deleteUsage(id);
        return "redirect:/fuel/usage";
    }
    @GetMapping("/fuel/usage/add")
    public String addFuelUsage(Model model){
        model.addAttribute("FuelUsage",new FuelUsage());
        model.addAttribute("FuelTypes", fuelService.findAllTypes());
        model.addAttribute("Vehicles", vehicleService.findAllVehicles());
        model.addAttribute("Drivers", driverService.findAll());
        return "fuelCRUD/fuelUsage/edit";
    }
    @PostMapping("/fuel/usage/edit/accept")
    public String editUsageAccept(Model model, @ModelAttribute("FuelUsage") FuelUsage fuelUsage)
    {
        fuelService.saveUsage(fuelUsage);
        return "redirect:/fuel/usage";
    }
    //----------------------------
    @GetMapping("/fuel/delivery")
    public String getFuelDelivery(Model model){
        model.addAttribute("deliveries",fuelService.findAllDeliveries());
        return "fuelCRUD/fuelDelivery/fueldelivery";
    }
    @GetMapping("/fuel/delivery/edit")
    public String editFuelDelivery(Model model,@RequestParam(name="id", required = true)long id){
        model.addAttribute("FuelDelivery",fuelService.findDeliveryById(id));
        model.addAttribute("FuelTypes", fuelService.findAllTypes());
        return "fuelCRUD/fuelDelivery/edit";
    }
    @GetMapping("/fuel/delivery/delete")
    public String deleteFuelDelivery(Model model,@RequestParam(name="id", required = true)long id){
        fuelService.deleteDelivery(id);
        return "redirect:/fuel/delivery";
    }
    @GetMapping("/fuel/delivery/add")
    public String addFuelDelivery(Model model){
        model.addAttribute("FuelDelivery",new FuelDelivery());
        model.addAttribute("FuelTypes", fuelService.findAllTypes());
        return "fuelCRUD/fuelDelivery/edit";
    }
    @PostMapping("/fuel/delivery/edit/accept")
    public String editDeliveryAccept(Model model, @ModelAttribute("FuelDelivery")FuelDelivery fuelDelivery)
    {
        fuelService.saveDelivery(fuelDelivery);
        return "redirect:/fuel/delivery";
    }
}
