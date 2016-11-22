import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args)
    {
        //System.out.println("Hello World!");
        String resultatJavaScript ="";
        Document doc = null;
        try
        {
            doc = Jsoup.connect("https://fr.wikipedia.org/wiki/Liste_de_langues").get();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //String title = doc.title();
        //System.out.println(title);
        Elements resultLinks = doc.select("li > a");
        for (Element element : resultLinks )
        {
            if(element.text().length() > 1)
            {
                resultatJavaScript += "\"" + element.text() + "\": " + "\"" + element.text().substring(0, 1).toUpperCase()+ element.text().substring(1).toLowerCase() + "\",\n";
            }
            //System.out.println(element.text());

        }
        //System.out.println(resultLinks.getClass());
        //String linkText = resultLinks.text();
        //System.out.println(linkText.getClass());
        System.out.print(resultatJavaScript);


    }
}
