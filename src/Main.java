import com.company.model.*;
import com.company.repository.CompanyRepository;
import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;
import org.hibernate.cfg.Configuration;



public class Main {
    private static final SessionFactory sessionFactory;
    private static final EntityManager entityManager;

    static{
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass (Company.class)
                .addAnnotatedClass (Document.class)
                .addAnnotatedClass (Passanger.class)
                .addAnnotatedClass (PassangerCar.class)
                .addAnnotatedClass (Schedule.class)
                .addAnnotatedClass (Ticket.class)
                .addAnnotatedClass (Train.class)
                .addAnnotatedClass (TrainStation.class);

        sessionFactory = configuration.buildSessionFactory();
        entityManager = sessionFactory.createEntityManager ();

    }

    public static void main(String[] args) {

        System.out.println ("**************************");

    CompanyRepository companyRepository = new CompanyRepository (entityManager);
    companyRepository.findAll ().forEach (System.out::println);


    }
}
