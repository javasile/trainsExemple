import com.company.model.*;
import com.company.repository.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.sql.Time;
import java.text.Format;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class NewEntityMenu {
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


    public static void CompanyMenu() {

        Scanner stringScan = new Scanner (System.in);

        System.out.print ("Insert train company Name: ");
        String companyName = (stringScan.nextLine ().toUpperCase (Locale.ROOT));

        System.out.print ("Insert VAT company Code Number: ");
        String companyVat = (stringScan.nextLine ().trim ());

        CompanyRepository companyRepository = new CompanyRepository (entityManager);
        Company company = new Company ();
        company.setId (UUID.randomUUID ());
        company.setName (companyName);
        company.setCode (companyVat);
        companyRepository.saveCompany (company);
    }


    public static void DocumentMenu() {
        Scanner numberScan = new Scanner (System.in);
        Scanner stringScan = new Scanner (System.in);

        System.out.print ("Insert train or passenger car series document: ");
        String serie = (numberScan.nextLine ().trim ());

        System.out.print ("Insert train or passenger car number document: ");
        String number = (numberScan.nextLine ().trim ());


        DocumentRepository documentRepository = new DocumentRepository(entityManager);
        Document document = new Document ();
        document.setId (UUID.randomUUID ());
        document.setSeries (serie);
        document.setNumber (number);
        documentRepository.saveDocument ((javax.swing.text.Document) document);

    }

    public static void PassangerMenu(){

        Scanner stringScan = new Scanner (System.in);

        System.out.print ("Insert passenger name: ");
        String name = (stringScan.nextLine ().trim ());

        System.out.print ("Insert passenger surname: ");
        String surname = (stringScan.nextLine ().trim ());

        PassangerRepository passangerRepository = new PassangerRepository (entityManager);
//        passangerRepository.findAll ().forEach (System.out::println);
        Passanger passanger = new Passanger ();
        passanger.setId (UUID.randomUUID());
        passanger.setName (name);
        passanger.setSurname (surname);
        passangerRepository.savePassanger (passanger);
//        passangerRepository.findAll ().forEach (System.out::println);
    }

    public static void TrainMenu(){

        Scanner stringScan = new Scanner (System.in);

        System.out.print ("Insert train Name");

        TrainRepository trainRepository = new TrainRepository (entityManager);
        Train train = new Train ();
        train.setId (UUID.randomUUID ());
        train.setName (stringScan.nextLine ().toUpperCase(Locale.ROOT));
        trainRepository.saveTrain (train);

    }

    public static void PassangerCarMenu(){

        Scanner numberScan = new Scanner (System.in);

        System.out.print ("Insert Passenger Car Number on this rout: ");
        int passCarNumber = numberScan.nextInt ();

        System.out.print ("Insert maximum number of seats: ");
        int numberOfSeats = numberScan.nextInt ();
        Random probabilSeats = new Random ();
        int seatsNumber = probabilSeats.nextInt (numberOfSeats);

        PassangerCarRepository passangerCarRepository = new PassangerCarRepository (entityManager);
        PassangerCar passangerCar = new PassangerCar ();
        passangerCar.setId (UUID.randomUUID ());
        passangerCar.setPassengerCarNumber (passCarNumber);
        passangerCar.setSeats (seatsNumber);
        passangerCarRepository.savePassangerCar (passangerCar);
    }

    public static void TrainStationMenu(){

        Scanner stringScan = new Scanner (System.in);
        Scanner numberScan = new Scanner (System.in);

        TrainStationRepository trainStationRepository = new TrainStationRepository (entityManager);
        TrainStation trainStation = new TrainStation ();
        trainStation.setId (UUID.randomUUID ());

        System.out.print ("Insert Train Station County:");
        trainStation.setName (stringScan.nextLine ());

        System.out.print ("Insert Train Halt Town:");
        trainStation.setCode (stringScan.nextLine ());

        System.out.print ("Insert Line of arriving train:");
        trainStation.setLine (numberScan.nextInt ());

        System.out.print ("Insert Train Rout:");
        trainStation.setRout (stringScan.nextLine ());

        trainStationRepository.saveTrainStation (trainStation);
    }
  public static void ScheduleMenu(){

      Scanner stringScan = new Scanner (System.in);
      Scanner numberScan = new Scanner (System.in);

      ScheduleRepository scheduleRepository = new ScheduleRepository (entityManager);
      Schedule schedule = new Schedule ();
      schedule.setId (UUID.randomUUID ());

      System.out.print ("Insert Schedule day code: ");
      schedule.setCode (stringScan.nextLine ());

      System.out.print ("Insert next hore of arriving train: ");
      int hours = numberScan.nextInt ();
      System.out.print ("Insert next minute of arriving train: ");
      int minute = numberScan.nextInt ();
      LocalTime localTrain = LocalTime.now ();
      LocalTime arrivalTrain = localTrain.plusHours (hours).plusMinutes (minute);
      schedule.setArrivalTime (arrivalTrain);
      schedule.setDepartureTime (arrivalTrain.plusMinutes (5));

    scheduleRepository.saveSchedule (schedule);
  }

  public static void TicketMenu(){

        TicketRepository ticketRepository = new TicketRepository (entityManager);
        Ticket ticket = new Ticket ();
        ticket.setId (UUID.randomUUID ());
        ticketRepository.saveTicket (ticket);

  }

}
