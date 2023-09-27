import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) {
        String url = "https://www.scrapethissite.com/pages/simple/";
        try {
            Document doc = Jsoup.connect(url).get();
//            System.out.println(doc);

            Elements countries = doc.select(".country");

            for (Element country : countries) {
                String countryName = country.select(".country-name").text();
                String capitalCity = country.select(".country-capital").text();
                String population = country.select(".country-population").text();
                System.out.println(countryName + " - " + capitalCity + " - Population - " + population);
            }

        } catch (IOException e) {
            System.out.println("An IOException occurred. Please try again.");
        }
    }
}
