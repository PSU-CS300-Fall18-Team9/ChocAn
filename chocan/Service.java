package chocan;

import java.util.*;

public class Service
{
    protected String serviceName;
    protected int currentDate;
    protected int currentTime;
    protected int serviceDate;
    protected int pid;
    protected int mid;
    protected int serviceCode;
    protected int fee;
    protected String comments;
    protected int month;
    protected int day;
    protected int year;

    public Service()
    {
        this.serviceName = null; //added field as requested by Carter
        this.currentDate = 0; //look a tht slack for translation
        this.currentTime = 0;
        this.serviceDate = 0;
        this.pid = 0;
        this.mid = 0;
        this.serviceCode = 0;
        this.fee = 0;
        this.comments = null;
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }

    public Service(String serviceName, int currentDate, int currentTime, int serviceDate, int pid, int mid, int serviceCode, int fee, String comments, int month, int day, int year)
    {
        this.serviceName = serviceName;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.serviceDate = serviceDate;
        this.pid = pid;
        this.mid = mid;
        this.serviceCode = serviceCode;
        this.fee = fee;
        this.comments = comments;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    //constructor with args without month, day, year
    public Service(int currentDate, int currentTime, int serviceDate, int pid, int mid, int serviceCode, int fee, String comments)
    {
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.serviceDate = serviceDate;
        this.pid = pid;
        this.mid = mid;
        this.serviceCode = serviceCode;
        this.fee = fee;
        this.comments = comments;
    }

    public Service(int month, int day, int year, int serviceCode, int fee, String comments)
    {
        this.month = month;
        this.day = day;
        this.year = year;
        this.serviceCode = serviceCode;
        this.fee = fee;
        this.comments = comments;
    }

    public Service(Service toAdd)
    {
        this.currentDate = toAdd.currentDate;
        this.currentTime = toAdd.currentTime;
        this.serviceDate = toAdd.serviceDate;
        this.pid = toAdd.pid;
        this.mid = toAdd.mid;
        this.serviceCode = toAdd.serviceCode;
        this.fee = toAdd.fee;
        this.comments = toAdd.comments;
    }

    public String toString()
    {
        String info;

        info = "\nCurrent Date: " + this.currentDate +
                "\nCurrent Time: " + this.currentTime +
                "\nService Date: " + this.serviceDate +
                "\nService Code: " + this.serviceCode +
                "\nPid: " + this.pid +
                "\nMid: " + this.mid +
                "\nFee: " + this.fee +
                "\nComment: " + this.comments;

        return dateOfService() + "\n" + info; //this to String return the current date as date TO CHECK with menu functionalityj
    }

    public boolean find(int svcCode)
    {
        if(serviceCode == svcCode) return true;

        return false;
    }

    public String dateOfService()
    {
        Calendar calendar = Calendar.getInstance();

        String date;

        date = calendar.get(Calendar.MONTH) + "-"
                + calendar.get(Calendar.DAY_OF_MONTH) + "-"
                + calendar.get(Calendar.YEAR);

        return date ;
    }

    public String dateTime()
    {
        Calendar calendar = Calendar.getInstance();

        String time;

        time = calendar.get(Calendar.MONTH) + "-"
                + calendar.get(Calendar.DAY_OF_MONTH) + "-"
                + calendar.get(Calendar.YEAR) + " "
                + calendar.get(Calendar.HOUR) + ":"
                + calendar.get(Calendar.MINUTE) + ":"
                + calendar.get(Calendar.SECOND);

        return time;
    }
}