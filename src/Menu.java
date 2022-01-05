import com.company.model.*;
import com.company.repository.DocumentRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;


public class Menu {
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

    Scanner numberScan = new Scanner (System.in);
    Scanner stringScan = new Scanner (System.in);

    public static void CompanyMenu() {
//        Company company = new Company ();

        Map<String, String > company = (Map<String, String>) new ArrayList<Company> ();
        Scanner numberScan = new Scanner (System.in);
        Scanner stringScan = new Scanner (System.in);

        System.out.print ("Insert train company Name: ");
        String companyName = (stringScan.nextLine ().toUpperCase (Locale.ROOT));

        System.out.print ("Insert VAT company Code Number: ");
        String companyVat = (stringScan.nextLine ().trim ());
        company.put (companyName, companyVat);

    }


    public static void DocumentMenu() {
        Scanner numberScan = new Scanner (System.in);
        Scanner stringScan = new Scanner (System.in);

        System.out.print ("Insert train or passenger car series document: ");
        String serie = (numberScan.nextLine ().trim ());

        System.out.print ("Insert train or passenger car number document: ");
        String number = (numberScan.nextLine ().trim ());


        DocumentRepository documentRepository = new DocumentRepository(entityManager);
        documentRepository.findAll().forEach(System.out::println);
        Document document = new Document ();
        document.setSeries (serie);
        document.setNumber (number);
        documentRepository.saveDocument ((javax.swing.text.Document) document);
        documentRepository.findAll ().forEach (System.out::println);
    }
}
