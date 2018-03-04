package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import ru.service.DriverService;
import ru.model.*;


@Controller
public class HomeController {
    private DriverService driverService;

    @Autowired(required = true)
    @Qualifier(value = "driverService")
    public void setProductService(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("driver", new DriverEntity());
        model.addAttribute("listDrivers", this.driverService.driverList());
        return "drivers";
    }

    @RequestMapping(value = "/drivers/add", method = RequestMethod.POST)
    public String addDriver(@ModelAttribute("driver") DriverEntity driverEntity) {
        if (driverEntity.getIdDriver()==0) {
            this.driverService.addDriver(driverEntity);
        } else {
            this.driverService.updateDriver(driverEntity);
        }
        return "redirect:/drivers";
    }

    @RequestMapping("/remove/{id}")
    public String removeDriver(@PathVariable("id") Integer id) {
        this.driverService.removeDriver(id);
        return "redirect:/drivers";
    }

    @RequestMapping("edit/{id}")
    public String editDriver(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("driver", this.driverService.getDriverById(id));
        model.addAttribute("listDrivers", this.driverService.driverList());
        return "drivers";
    }
/*
    @RequestMapping("driverData/{id}")
    public String driverData(@PathVariable("id") String id, Model model) {
        model.addAttribute("driver", this.driverService.getDriverById(id));
        return "driverData";
    }*/
}