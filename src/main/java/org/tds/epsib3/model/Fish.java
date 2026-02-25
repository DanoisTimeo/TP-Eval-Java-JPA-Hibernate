package org.tds.epsib3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
public class Fish extends Animal {
    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    //<editor-fold desc="Constructeurs">
    public Fish() {}

    public Fish(LocalDate birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
    //</editor-fold>
}
