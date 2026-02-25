package org.tds.epsib3.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code", length = 255, nullable = false)
    private String code;

    @Column(name = "label", length = 255, nullable = false)
    private String label;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    @Column(name = "price", nullable = false)
    private double price;

    // Relation
    @ManyToMany
    @JoinTable(
            name = "petstore_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "petstore_id")
    )
    private List<PetStore> petStores;

    //<editor-fold desc="Constructeurs">
    public Product() {}

    // Constructeur sans relation
    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    // Constructeur avec relation
    public Product(String code, String label, ProdType type, double price, List<PetStore> petStores) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        this.petStores = petStores;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public ProdType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public List<PetStore> getPetStores() {
        return petStores;
    }

    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setCode(String code) {
        this.code = code;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPetStores(List<PetStore> petStores) {
        this.petStores = petStores;
    }

    //</editor-fold>
}
