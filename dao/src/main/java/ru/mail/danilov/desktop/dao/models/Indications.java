package ru.mail.danilov.desktop.dao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "counters_indications")
public class Indications {
    @Id
    @Column(name = "feed_date", updatable = false, nullable = false, unique = true)
    private LocalDate date;
    @Column(name = "water")
    private Integer water;
    @Column(name = "light")
    private Integer light;
    @Column(name = "gas")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indications that = (Indications) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(water, that.water) &&
                Objects.equals(light, that.light) &&
                Objects.equals(gas, that.gas);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, water, light, gas);
    }
}
