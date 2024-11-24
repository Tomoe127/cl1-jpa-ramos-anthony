package pe.edu.i202223055.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202223055.entity.Country;

public class JPARemove {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        String countryCode = "G5P";

        try {
            em.getTransaction().begin();

            Country country = em.find(Country.class, countryCode);

            if (country != null) {
                em.remove(country);
                System.out.println("País eliminado exitosamente: " + country.getName());
            } else {
                System.out.println("El país con el código '" + countryCode + "' no existe.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
