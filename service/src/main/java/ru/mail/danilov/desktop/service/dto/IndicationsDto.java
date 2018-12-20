package ru.mail.danilov.desktop.service.dto;

import java.time.LocalDate;

public class IndicationsDto {
    private LocalDate date;
    private Integer water;
    private Integer light;
    private Integer gas;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Integer getGas() {
        return gas;
    }

    public void setGas(Integer gas) {
        this.gas = gas;
    }
}
