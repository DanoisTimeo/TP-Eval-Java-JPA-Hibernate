package org.tds.epsib3.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name = "couleur", length = 255, nullable = false)
    private String couleur;

    // Relation
    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;

    //<editor-fold desc="Constructeurs">
    public Animal () {}

    public Animal(LocalDate birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Long getId() {
        return id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    //</editor-fold>
}
