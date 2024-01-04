/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Instance třídy {@code Export} představují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Export {
    public void listExporters (CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            
            if (country.contains(country)) {
                country = record.get("Country");
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                System.out.println("Country: " + country + exports + ":" + value);
                
            }
            else {
                System.out.println("NOT FOUND");
            }
        }
    }
    
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public void numberOfExporters (CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            
            if (exports.contains(exportItem)) {
                count += 1;
                
                
                //System.out.println(count);
            }
            
        }
        System.out.println(count);
    }
    
    public void bigExporters (CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String money = record.get("Value (dollars)");
            String country = record.get("Country");
            if (money.length() > amount.length()) {
                System.out.println(country + " " + money);
            }
        }
    }
    
    public void bigExportersTest () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
    
    public void numberOfExportersTest () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        numberOfExporters(parser, "sugar");
    }
    
    public void twoProductTest() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "fish", "nuts");
    }
    
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "Nauru");
    }
}
