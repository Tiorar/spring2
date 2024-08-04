import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            User tempPerson = new User();
            tempPerson.setName("Егор");
            tempPerson.setLastname("Ракитин");
            tempPerson.setAge(38);
            session.beginTransaction();
            session.save(tempPerson);
            session.getTransaction().commit();
            System.out.println("Запись добавлена в базу данных");
        } finally {
            factory.close();
        }
    }
}