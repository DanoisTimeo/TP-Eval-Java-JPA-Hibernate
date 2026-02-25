package org.tds.epsib3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.tds.epsib3.model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); EntityManager em = emf.createEntityManager();) {
            em.getTransaction().begin();

            //<editor-fold desc="Insérer au moins trois enregistrements dans chacune des tables via EntityManager">

            //<editor-fold desc="Création de 3 PetStores avec 3 adresses">
            PetStore ps1 = new PetStore(
                    "Animalia",
                    "Timeo Danois",
                    new Address("10", "Rue A", "44000", "Nantes")
            );
            PetStore ps2 = new PetStore(
                    "PetParadise",
                    "Bob Parssie",
                    new Address("20", "Rue B", "69000", "Lyon")
            );
            PetStore ps3 = new PetStore(
                    "HappyPets",
                    "Claire Ravons",
                    new Address("30", "Rue C", "33000", "Bordeaux")
            );

            em.persist(ps1);
            em.persist(ps2);
            em.persist(ps3);
            //</editor-fold>

            //<editor-fold desc="Création de 3 produits">
            Product p1 = new Product(
                    "F001",
                    "Cat Food",
                    ProdType.FOOD,
                    10.0, Arrays.asList(ps1, ps2) // on réutilise les magasins créés avant
            );
            Product p2 = new Product(
                    "F002",
                    "Fish Food",
                    ProdType.FOOD,
                    12.5,
                    Arrays.asList(ps1, ps3)
            );
            Product p3 = new Product(
                    "A001",
                    "Cat Toy",
                    ProdType.ACCESSORY,
                    5.0,
                    Arrays.asList(ps2, ps3)
            );

            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            //</editor-fold>

            //<editor-fold desc="Création de 3 chats et 3 poissons">
            Cat cat1 = new Cat(
                    LocalDate.of(2022, 1, 15),
                    "Black",
                    ps1,
                    "CHIP123"
            );
            Cat cat2 = new Cat(
                    LocalDate.of(2021, 5, 10),
                    "White",
                    ps2,
                    "CHIP456"
            );
            Cat cat3 = new Cat(
                    LocalDate.of(2020, 9, 5),
                    "Gray",
                    ps3,
                    "CHIP789"
            );

            Fish fish1 = new Fish(
                    LocalDate.of(2023, 3, 2),
                    "Gold",
                    ps1,
                    FishLivEnv.FRESH_WATER
            );
            Fish fish2 = new Fish(
                    LocalDate.of(2023, 6, 12),
                    "Blue",
                    ps2,
                    FishLivEnv.SEA_WATER
            );
            Fish fish3 = new Fish(
                    LocalDate.of(2022, 11, 20),
                    "Red",
                    ps3,
                    FishLivEnv.FRESH_WATER
            );

            em.persist(cat1);
            em.persist(cat2);
            em.persist(cat3);
            em.persist(fish1);
            em.persist(fish2);
            em.persist(fish3);
            //</editor-fold>

            //</editor-fold>

            //<editor-fold desc="Réaliser une requête qui permet d’extraire tous les animaux d’une animalerie donnée">

            // On liste les animaux de l'animalerie "ps1"
            List<Animal> animalsInStore = em.createQuery(
                    "SELECT a FROM Animal a WHERE a.petStore = :store", Animal.class)
                    .setParameter("store", ps1)
                    .getResultList();

            // Affichage
            System.out.println("Liste des animaux de l'animalerie" + ps1.getName() + " :");
            for (Animal a : animalsInStore) {
                String type = a.getClass().getSimpleName(); // Cat ou Fish
                String couleur = a.getCouleur();

                if (a instanceof Cat c) {
                    System.out.printf("%s - Couleur: %s, ChipId: %s%n", type, couleur, c.getChipId());
                } else if (a instanceof Fish f) {
                    System.out.printf("%s - Couleur: %s, Environnement: %s%n", type, couleur, f.getLivingEnv());
                } else {
                    System.out.printf("%s - Couleur: %s%n", type, couleur);
                }
            }
            //</editor-fold>

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("oups");
            throw new RuntimeException(e);
        }
    }
}