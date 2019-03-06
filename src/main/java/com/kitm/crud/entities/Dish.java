package com.kitm.crud.entities;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @NotBlank(message = "Privaloma įvesti patiekalo grupę.")
//    @Size(max = 30, message = "Leidžiama įvesti iki 30 simbolių")
    private String group;

//    @NotBlank(message = "Privaloma įvesti patiekalo pavadinimą.")
//    @Size(max = 30, message = "Leidžiama įvesti iki 30 simbolių")
    private String name;

//    @NotNull(message = "Privaloma įvesti kalorijų skaičių.")
//    @Range(min = 1, max = 9999, message = "Leidžiama įvesti nuo 1 iki 9999 kalorijų")
    private int calories;

//    @NotNull(message = "Privaloma įvesti patiekalo kainą.")
//    @Range(min = 0, max = 100000, message = "Kaina negali būti neigiama.")
    private double price;

    public Dish() {}

    public Dish(String group, String name, Integer calories, Double price) {
        this.group = group;
        this.name = name;
        this.calories = calories;
        this.price = price;

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Dish{" + "id=" + id + ", group=" + group + ", name=" + name + ", calories=" + calories + ", price=" + price + '}';
    }
}
