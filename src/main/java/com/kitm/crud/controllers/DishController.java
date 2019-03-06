package com.kitm.crud.controllers;

import com.kitm.crud.entities.Dish;
import com.kitm.crud.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DishController {

    private final DishRepository dishRepository;

    @Autowired
    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @GetMapping("/input")
    public String showInputForm(Dish dish) {
        return "add-dish";
    }

    @PostMapping("/adddish")
    public String addDish(@Valid Dish dish, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-dish";
        }

        dishRepository.save(dish);
        model.addAttribute("dishes", dishRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Netinkamas patiekalo id:" + id));
        model.addAttribute("dish", dish);
        return "update-dish";
    }

    @PostMapping("/update/{id}")
    public String updateDish(@PathVariable("id") long id, @Valid Dish dish, BindingResult result, Model model) {
        if (result.hasErrors()) {
            dish.setId(id);
            return "update-dish";
        }

        dishRepository.save(dish);
        model.addAttribute("dishes", dishRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteDish(@PathVariable("id") long id, Model model) {
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Netinkamas patiekalo id:" + id));
        dishRepository.delete(dish);
        model.addAttribute("dishes", dishRepository.findAll());
        return "index";
    }
}
