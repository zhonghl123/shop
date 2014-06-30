package util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /*
            * @see java.text.SimpleDateFormat
    */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null || aMask == null || "".equals(aMask)) {
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based on the
     * System Property 'dateFormat' in the format you specify on input
     *
     * @param aDate
     *            A date to convert
     * @return a string representation of the date
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime("yyy-MM-dd", aDate);
    }
}
