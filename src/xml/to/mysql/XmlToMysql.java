/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.to.mysql;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author stefan
 */
public class XmlToMysql {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {

        ReadValues r1 = new ReadValues();
        WriteValues w2 = new WriteValues();
        w2.setupConnection();
        String[] strArr = r1.ausgabeliste();
        String[] strArr1 = r1.currencyListe();
        String date = r1.dateMethod();

        for (int i = 0; i < strArr.length; i++) {
            if (strArr1[i] != null) {
                w2.insert(strArr[i], strArr1[i], date);
            }
        }

        System.out.println("Datum2: " + w2.dateMethod());
        //  System.out.println(ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS));

        for (int i = 2; i < strArr.length; i++) {
            System.out.println(strArr[i] + "  " + strArr1[i]);

        }
    }

    
}
