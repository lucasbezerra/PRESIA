/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 *
 * @author usuario
 */
public class CalendarOperations {

    public static String SumMonths(Date actual, int quantity) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String actualString = sd.format(actual);
        StringTokenizer token = new StringTokenizer(actualString, "/");
        String dates[] = new String[3];
        int i = 0;
        while (token.hasMoreTokens()) {
            dates[i] = token.nextToken();
            i++;
        }
        int year = Integer.valueOf(dates[2]);
        int month = Integer.valueOf(dates[1]) - 1;
        int day = Integer.valueOf(dates[0]);
        Calendar c = new GregorianCalendar(year, month, day);
        c.add(Calendar.MONTH, quantity);
        return sd.format(c.getTime());
    }

    public static int countDays(Date d1, Date d2) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String s1 = sd.format(d1);
        String s2 = sd.format(d2);
        StringTokenizer token1 = new StringTokenizer(s1, "/");
        String date1[] = new String[3];
        int i = 0;
        while (token1.hasMoreTokens()) {
            date1[i] = token1.nextToken();
            i++;
        }
        int year1 = Integer.valueOf(date1[2]);
        int month1 = Integer.valueOf(date1[1]) - 1;
        int day1 = Integer.valueOf(date1[0]);
        Calendar c1 = new GregorianCalendar(year1, month1, day1);
        StringTokenizer token2 = new StringTokenizer(s2, "/");
        String date2[] = new String[3];
        int i2 = 0;
        while (token2.hasMoreTokens()) {
            date2[i2] = token2.nextToken();
            i2++;
        }
        int year2 = Integer.valueOf(date2[2]);
        int month2 = Integer.valueOf(date2[1]) - 1;
        int day2 = Integer.valueOf(date2[0]);
        Calendar c2 = new GregorianCalendar(year2, month2, day2);
        long m1 = c1.getTimeInMillis();
        long m2 = c2.getTimeInMillis();
        return (int) ((m2 - m1) / (24*60*60*1000));
    }

    public static int VerifyTwoDates(Date d1, Date d2) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String s1 = sd.format(d1);
        String s2 = sd.format(d2);
        StringTokenizer token1 = new StringTokenizer(s1, "/");
        String date1[] = new String[3];
        int i = 0;
        while (token1.hasMoreTokens()) {
            date1[i] = token1.nextToken();
            i++;
        }
        int year1 = Integer.valueOf(date1[2]);
        int month1 = Integer.valueOf(date1[1]) - 1;
        int day1 = Integer.valueOf(date1[0]);
        Calendar c1 = new GregorianCalendar(year1, month1, day1);
        StringTokenizer token2 = new StringTokenizer(s2, "/");
        String date2[] = new String[3];
        int i2 = 0;
        while (token2.hasMoreTokens()) {
            date2[i2] = token2.nextToken();
            i2++;
        }
        int year2 = Integer.valueOf(date2[2]);
        int month2 = Integer.valueOf(date2[1]) - 1;
        int day2 = Integer.valueOf(date2[0]);
        Calendar c2 = new GregorianCalendar(year2, month2, day2);
        int result = c1.compareTo(c2);
        if (result == 0)
            return 0;
        else if (result < 0)
            return 1;
        else if (result > 0)
            return -1;
        return 0;
    }
}
