package com.example.timofei.controller;

import com.example.timofei.entity.Driver;
import com.example.timofei.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/driver")
    public String getDrivers(Model model){
        model.addAttribute("drivers",driverService.findAll());
        return "driverCRUD/drivers";
    }
    @GetMapping("/driver/edit")
    public String editDriver(Model model,@RequestParam(name="id", required = true)long id){
        model.addAttribute("Driver",driverService.findById(id));
        return "driverCRUD/edit";
    }
    @GetMapping("/driver/delete")
    public String deleteDriver(Model model,@RequestParam(name="id", required = true)long id){
        driverService.delete(id);
        return "redirect:/driver";
    }
    @GetMapping("/driver/add")
    public String addDriver(Model model){
        model.addAttribute("Driver",new Driver());
        return "driverCRUD/edit";
    }
    @PostMapping("/driver/edit/accept")
    public String editDriverAccept(Model model, @ModelAttribute("Driver") Driver driver)
    {
        driverService.save(driver);
        return "redirect:/driver";
    }
}
