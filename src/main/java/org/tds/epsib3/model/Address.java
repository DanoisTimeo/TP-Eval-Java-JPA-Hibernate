package org.tds.epsib3.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number", length = 255, nullable = false)
    private String number;

    @Column(name = "street", length = 255, nullable = false)
    private String street;

    @Column(name = "zipCode", length = 255, nullable = false)
    private String zipCode;

    @Column(name = "city", length = 255, nullable = false)
    private String city;

    //<editor-fold desc="Constructeurs">
    public Address() {}

    public Address(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setNumber(String number) {
        this.number = number;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    //</editor-fold>
}
