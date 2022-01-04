import com.company.model.Company;
import com.company.model.Document;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Menu {

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


    public void DocumentMenu(Document document) {
        Scanner numberScan = new Scanner (System.in);
        Scanner stringScan = new Scanner (System.in);

        System.out.print ("Insert train or passenger car series document: ");
        document.setSeries (numberScan.nextLine ().trim ());

        System.out.print ("Insert train or passenger car number document: ");
        document.setNumber (numberScan.nextLine ().trim ());
    }
}
