package edu.ufp.inf.lp2.proj;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author joaoc, tiago
 */
public class Date implements Comparable<Date> {

    private int day;

    private int month;

    private int year;

    private int hora;

    private int minuto;

    /**
     *
     * @param ddmmyyyyhhmm
     */
    public Date(String ddmmyyyyhhmm) {
        if (ddmmyyyyhhmm.length() == 12) {
            this.day = Integer.parseInt(ddmmyyyyhhmm.subSequence(0, 2).toString());
            this.month = Integer.parseInt(ddmmyyyyhhmm.subSequence(2, 4).toString());;
            this.year = Integer.parseInt(ddmmyyyyhhmm.subSequence(4, 8).toString());;
            this.hora = Integer.parseInt(ddmmyyyyhhmm.subSequence(8, 10).toString());
            this.minuto = Integer.parseInt(ddmmyyyyhhmm.subSequence(10, 12).toString());
        }
    }

    /**
     *
     */
    public Date() {
        Calendar gregCalendar = new GregorianCalendar();
        this.day = gregCalendar.get(Calendar.DAY_OF_MONTH);
        this.month = gregCalendar.get(Calendar.MONTH) + 1;
        this.year = gregCalendar.get(Calendar.YEAR);
        this.hora = gregCalendar.get(Calendar.HOUR);
        this.minuto = gregCalendar.get(Calendar.MINUTE);

    }

    /**
     *
     * @param d
     * @return
     */
    public int differenceYears(Date d) {
        return Math.abs(this.getYear() - d.getYear());
    }

    /**
     *
     * @param d
     * @return
     */
    public boolean beforeDate(Date d) {
        if (this.year < d.getYear()) {
            return true;
        } else if (this.year == d.getYear()) {
            if (this.month < d.getMonth()) {
                return true;
            } else if (this.month == d.getMonth()) {
                if (this.day < d.getDay()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param d
     * @return
     */
    public boolean afterDate(Date d) {
        if (this.year == d.getYear() && this.month == d.getMonth() && this.day == d.getDay()) {
            return false;
        }
        return !this.beforeDate(d);
    }

    /**
     *
     * @return
     */
    public boolean isLeapYear() {
        return (this.year % 400 == 0) || ((this.year % 4 == 0) && (this.year % 100 != 0));
    }

    /**
     *
     * @return
     */
    public int dayMonth() {
        switch (this.month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear() ? 29 : 28;
            default:
                return 31;
        }
    }

    /**
     *
     * @param d
     * @return
     */
    public int differenceMonth(Date d) {
        int difference = (this.getMonth() - d.getMonth()) + (this.getYear() - d.getYear()) * 12;
        return Math.abs(difference);
    }

    /**
     *
     * @param d
     * @return
     */
    public int differenceDays(Date d) {
        return 0;
    }

    @Override
    public String toString() {
        return this.day + "/" + this.month + "/" + this.year + " | " + this.hora + ":" + this.minuto;
    }

    /**
     *
     * @param d
     * @return
     */
    public boolean equals(Date d) {
        if (this.getYear() == d.year && this.getMonth() == d.month && this.getDay() == d.day && this.getHora() == d.hora && this.getMinuto() == d.minuto) {
            return true;
        }
        return false;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     *
     * @return
     */
    public int getHora() {
        return hora;
    }

    /**
     *
     * @param hora
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     *
     * @return
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     *
     * @param minuto
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    @Override
    public int compareTo(Date o) {
        if (equals(o)) {
            return 0;
        } else if (beforeDate(o)) {
            return -1;
        }
        return 1;
    }

}
