/**
 * 
 */
package tutorial;

import javax.persistence.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/points.odb");
        EntityManager em = emf.createEntityManager();

        // Store 1000 Point objects in the database:
        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();

        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());

        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());

        // Retrieve all the Point objects from the database:
        TypedQuery<Point> query =
            em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }

        // Person anlegen
        EntityManager emPers = emf.createEntityManager();
        emPers.getTransaction().begin();
        Person pers1 = new Person("Hans", "Dampf", "2001-12-12") ;
        emPers.persist(pers1);
        Person pers2 = new Person("Hannelore", "Dampfer", "1961-10-17");
        emPers.persist(pers2);
        Person pers3 = new Person("Max", "Garten", "1956-07-19");
        emPers.persist(pers3);
        emPers.getTransaction().commit();
        
        // alle Personen ausgeben
        TypedQuery<Person> query1 =
                emPers.createQuery("SELECT pers FROM Person pers", Person.class);
            List<Person> results2 = query1.getResultList();
            for (Person pers : results2) {
                System.out.println(pers);
            }
        
        // Close the database connection:
        em.close();
        emf.close();
    }
}
