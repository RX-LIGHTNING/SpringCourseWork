package com.example.timofei.controller;

import com.example.timofei.entity.FuelUsage;
import com.example.timofei.entity.RouteList;
import com.example.timofei.service.DriverService;
import com.example.timofei.service.RouteListService;
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
public class RouteListController {

    private final RouteListService routeListService;
    private final VehicleService vehicleService;
    private final DriverService driverService;

    @GetMapping("/route")
    public String getFuelUsage(Model model){
        model.addAttribute("routes",routeListService.findAll());
        return "RouteCRUD/RouteList";
    }
    @GetMapping("/route/edit")
    public String editFuelUsage(Model model,@RequestParam(name="id", required = true)long id){
        model.addAttribute("RouteList",routeListService.findRouteById(id));
        model.addAttribute("Vehicles", vehicleService.findAllVehicles());
        model.addAttribute("Drivers", driverService.findAll());
        return "RouteCRUD/edit";
    }
    @GetMapping("/route/delete")
    public String deleteFuelUsage(Model model,@RequestParam(name="id", required = true)long id){
        routeListService.deleteType(id);
        return "redirect:/route";
    }
    @GetMapping("/route/add")
    public String addFuelUsage(Model model){
        model.addAttribute("RouteList",new RouteList());
        model.addAttribute("Vehicles", vehicleService.findAllVehicles());
        model.addAttribute("Drivers", driverService.findAll());
        return "RouteCRUD/edit";
    }
    @PostMapping("/route/edit/accept")
    public String editUsageAccept(Model model, @ModelAttribute("RouteList") RouteList routeList)
    {
        routeListService.saveType(routeList);
        return "redirect:/route";
    }
}
