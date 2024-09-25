package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.SneakyThrows;
import org.example.entities.Car;
import org.example.entities.DriversLicense;
import org.example.entities.Owner;
import org.example.enums.CarType;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CarOwnersDB")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            DriversLicense myLicense = new DriversLicense("QWE123RTY");
            Owner me = new Owner("me", myLicense);
            Car toyotaRav4 = new Car("ToyotaRav4", CarType.UTILITY, 250.5D, 10000, me, 2015);
            me.getCars().add(toyotaRav4);
            entityManager.persist(me);

            DriversLicense dadsLicense = new DriversLicense("ASD987FGH");
            Owner dad = new Owner("dad", dadsLicense);
            Car nissanMicro = new Car("NissanMicro", CarType.UTILITY, 99D, 5000, dad, 2009);
            dad.getCars().add(nissanMicro);
            entityManager.persist(dad);

            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}