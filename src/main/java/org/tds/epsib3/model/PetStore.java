package org.tds.epsib3.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "managerName", length = 255, nullable = false)
    private String managerName;

    // Relations
    @ManyToMany(mappedBy = "petStores")
    private List<Product> products;

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private List<Animal> animals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    //<editor-fold desc="Constructeurs">
    public PetStore() {}

    // Constructeur sans les relations List
    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
    }

    // Constructeur avec les relations List
    public PetStore(String name, String managerName, Address address, List<Product> products, List<Animal> animals) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
        this.products = products;
        this.animals = animals;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManagerName() {
        return managerName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Address getAddress() {
        return address;
    }

    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setName(String name) {
        this.name = name;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    //</editor-fold>
}
