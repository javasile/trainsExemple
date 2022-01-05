import com.company.model.*;
import com.company.repository.CompanyRepository;
import com.company.repository.DocumentRepository;
import com.company.repository.PassangerRepository;
import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;

import org.hibernate.cfg.Configuration;
import org.hibernate.id.UUIDGenerator;

import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import static org.jvnet.fastinfoset.EncodingAlgorithmIndexes.UUID;


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

//        Menu.DocumentMenu ();

//        System.out.println ("**************************");
//
//    CompanyRepository companyRepository = new CompanyRepository (entityManager);
//    companyRepository.findAll ().forEach (System.out::println);

/**
        DocumentRepository documentRepository = new DocumentRepository(entityManager);
        documentRepository.findAll().forEach(System.out::println);
        Document document = new Document ();
        document.setSeries ("S53245");
        document.setNumber ("3248");
        documentRepository.saveDocument (document);
        documentRepository.findAll ().forEach (System.out::println);
*/

        PassangerRepository passangerRepository = new PassangerRepository (entityManager);
        passangerRepository.findAll ().forEach (System.out::println);
        Passanger passanger = new Passanger ();
//        passanger.setId (RandomGenerator.getDefault ().longs (UUID));
        passanger.setName ("Nico");
        passanger.setSurname ("Andra");
        passangerRepository.savePassanger (passanger);
        passangerRepository.findAll ().forEach (System.out::println);
    }
}
