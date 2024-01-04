/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Instance třídy {@code ColdAndHumide} představují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class ColdAndHumide {
    public CSVRecord coldestHourInFile (CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if (lowestSoFar == null) {
                lowestSoFar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if (currentTemp > lowestTemp) {
                    lowestSoFar = currentRow;
                }
            }
        }
        return lowestSoFar;
    }
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature: " + lowest.get("TemperatureF"));
    }
    
    public CSVRecord fileWithColdestTemperature () {
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            lowestSoFar = getLowestOfTwo(currentRow, lowetSoFar); 
        }
    }
    
    public CSVRecord getLowestOfTwo (CSVRecord currentRow, CSVRecord lowestSoFar) {
        if (lowestSoFar == null) {
                lowestSoFar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if (currentTemp > lowestTemp) {
                    lowestSoFar = currentRow;
                }
            }
        return lowestSoFar;
    }
}
