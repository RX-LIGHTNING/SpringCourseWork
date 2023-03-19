package com.example.timofei.controller;

import com.example.timofei.entity.*;
import com.example.timofei.service.DriverService;
import com.example.timofei.service.FuelService;
import com.example.timofei.service.RouteListService;
import com.example.timofei.service.VehicleService;
import com.example.timofei.utils.WordHelper;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class FuelController {

    private final FuelService fuelService;
    private final VehicleService vehicleService;
    private final DriverService driverService;

    private final RouteListService routeListService;

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
        model.addAttribute("Routes", routeListService.findAll());
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
        model.addAttribute("Routes", routeListService.findAll());
        return "fuelCRUD/fuelUsage/edit";
    }
    @PostMapping("/fuel/usage/edit/accept")
    public String editUsageAccept(Model model, @ModelAttribute("FuelUsage") FuelUsage fuelUsage)
    {
        fuelService.saveUsage(fuelUsage);
        return "redirect:/fuel/usage";
    }
    @GetMapping(value = "/fuel/usage/word", produces = "application/vnd.openxmlformats-"
            + "officedocument.wordprocessingml.document")
    public ResponseEntity<InputStreamResource> fuelUsage(Model model, @RequestParam(name="id", required = true)long id ) throws IOException, InvalidFormatException {
        ByteArrayInputStream bis = WordHelper.generateUsage(fuelService.findUsageById(id));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "inline; filename=mydoc.docx");
        return ResponseEntity.ok().headers(headers).
                body(new InputStreamResource(bis));
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
    @GetMapping(value = "/fuel/delivery/word", produces = "application/vnd.openxmlformats-"
            + "officedocument.wordprocessingml.document")
    public ResponseEntity<InputStreamResource> fuelDelivery(Model model, @RequestParam(name="id", required = true)long id ) throws IOException, InvalidFormatException {
        ByteArrayInputStream bis = WordHelper.generateDelivery(fuelService.findDeliveryById(id));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "inline; filename=mydoc.docx");
        return ResponseEntity.ok().headers(headers).
                body(new InputStreamResource(bis));
    }
}
