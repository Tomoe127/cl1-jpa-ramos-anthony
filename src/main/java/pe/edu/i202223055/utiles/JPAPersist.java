package pe.edu.i202223055.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202223055.entity.City;
import pe.edu.i202223055.entity.Country;
import pe.edu.i202223055.entity.CountryLanguage;

import java.util.List;

public class JPAPersist {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Country country = new Country(
                "G5P",
                "patapata",
                "Asia",
                "Hache",
                174256,
                2000,
                10,
                80,
                10000,
                5000,
                "Idk",
                "Democrativo",
                "g5byebye",
                5,
                "G5",
                null,
                null
        );

        City city1 = new City("naka", "nose", 1, country);
        City city2 = new City("ciri", "cuy", 2, country);
        City city3 = new City("naja", "cabo", 3, country);

        country.setCity(List.of(city1, city2, city3));

        CountryLanguage language1 = new CountryLanguage(country, "Español", "T", 60);
        CountryLanguage language2 = new CountryLanguage(country, "Chino", "F", 40);

        country.setCountryLanguages(List.of(language1, language2));

        em.persist(country);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("El país, sus ciudades y lenguajes han sido registrados con éxito.");


    }
}
