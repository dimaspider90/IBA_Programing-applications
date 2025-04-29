package net.iba.hibernate.criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DeveloperRunner {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        // Инициализация Configuration и создание SessionFactory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Developer.class);
        sessionFactory = configuration.buildSessionFactory();

        DeveloperRunner developerRunner = new DeveloperRunner();

        System.out.println("Adding developer's records to the DB");
        developerRunner.addDeveloper("Ihor", "Developer", "Java Developer", 2, 3000);
        developerRunner.addDeveloper("Some", "Developer", "C++ Developer", 2, 4000);
        developerRunner.addDeveloper("Peter", "UI", "UI Developer", 4, 5000);

        System.out.println("List of developers with over 3 years of experience:");
        List<Developer> experiencedDevelopers = developerRunner.listDevelopersOverThreeYears();
        for (Developer developer : experiencedDevelopers) {
            System.out.println(developer);
        }

        System.out.println("===================================");
        sessionFactory.close();
    }

    public void addDeveloper(String firstName, String lastName, String specialty, int experience, int salary) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Developer developer = new Developer(firstName, lastName, specialty, experience, salary);
            session.save(developer); // Сохранение объекта в базе данных
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Developer> listDevelopersOverThreeYears() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Developer> developers = null;
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Developer> query = builder.createQuery(Developer.class);
            Root<Developer> root = query.from(Developer.class);
            query.select(root).where(builder.gt(root.get("experience"), 3)); // Условие выбора разработчиков с опытом более 3 лет

            developers = session.createQuery(query).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return developers;
    }
}