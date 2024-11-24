package pe.edu.i202223055.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202223055.entity.Country;

public class JPAFind {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            String countryCode = "PER";
            Country country = em.find(Country.class, countryCode);

            if (country != null) {
                System.out.println("País encontrado: " + country.getName());

                country.getCity().stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println("Ciudad: " + city.getName() + ", Población: " + city.getPopulation()));
            } else {
                System.out.println("No se encontró el país con el código '" + countryCode + "'.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
