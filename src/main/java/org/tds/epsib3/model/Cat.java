package org.tds.epsib3.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Cat extends Animal {

    @Column(name = "couleur", length = 255, nullable = false)
    private String chipId;

    //<editor-fold desc="Constructeurs">
    public Cat() {}

    public Cat(LocalDate birth, String couleur, PetStore petStore, String chipId) {
        super(birth, couleur, petStore);
        this.chipId = chipId;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public String getChipId() {
        return chipId;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
    //</editor-fold>

}
