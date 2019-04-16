package model.dao.impl.jdbc.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseDate {
    private Logger log = Logger.getLogger(this.getClass());

    public Date parseDate(String string) {
        if (string == null) {
            return null;
        } else {
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

            Date parsingDate = null;
            try {
                parsingDate = ft.parse(string);
                log.info("Строка " + string + " распаршена как "+parsingDate);
            }catch (ParseException e) {
                log.info("wrong parsing");
            }
            return parsingDate;
        }

    }
}
