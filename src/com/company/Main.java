//Service is created as node of a LLL, where provider/member
//are are the head of a LLL of services

package com.company;
import java.util.StringTokenizer;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    Scanner input = new Scanner(System.in);
    public static void main(System[] args) {

    }

    //service is an obj of a LLL of services of a Provider or member
    public class service{

        protected service next; //TODO next here???

        protected int currentDate;
        protected int currentTime;
        protected int serviceDate;
        protected int pid;
        protected int mid;
        protected int serviceCode;
        protected int fee;
        protected String comments;

        //TODO check on this, used to support main
        protected int month;
        protected int day;
        protected int year;

        //default constructor
        public service(){
            this.currentDate = 0;
            this.currentTime = 0;
            this.serviceDate = 0;
            this.pid = 0;
            this.mid = 0;
            this.serviceCode = 0;
            this.fee = 0;
            this.comments = null;

            //TODO check on this, used to support main
            this.month = 0;
            this.day = 0;
            this.year = 0;
        }

        //constructor with args
        public service(int currentDate, int currentTime, int serviceDate, int pid, int mid, int serviceCode, int fee, String comments){
            this.currentDate = currentDate;
            this.currentTime = currentTime;
            this.serviceDate = serviceDate;
            this.pid = pid;
            this.mid = mid;
            this.serviceCode = serviceCode;
            this.fee = fee;
            this.comments = comments;
        }

        //TODO constructor with limited args to support the menu functionality TODO check on this
        public service(int month, int day, int year, int serviceCode, String comments){
            this.month = month;
            this.day = day;
            this.year = year;
            this.serviceCode = serviceCode;
            this.comments = comments;
        }

        //used as copy constructor
        public service(service toAdd)
            this.currentDate = toAdd.currentDate;
            this.currentTime = toAdd.currentTime;
            this.serviceDate = toAdd.serviceDate;
            this.pid = toAdd.pid;
            this.mid = toAdd.mid;
            this.serviceCode = toAdd.serviceCode;
            this.fee = toAdd.fee;
            this.comments = toAdd.comments;
        }

        //display is implemented using toString with System.out.println(srv);
        //anytime we want to display a service fields
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

            return info;
        }

        //compare svcCode to Service code
        protected boolean find(int svcCode)
        {
            if(serviceCode == svcCode) return true;

            return false;
        }

        //wrapper for constructor to et called in main
        public boolean createServiceRec(int month, int day, int year, int svcCode, String comment)
        {
            new service(month, day, year, svcCode, comment);
            return true;
        }

        //change date TODO do we need this???
        public int changeDate(int serviceDate){

            return 1;
        }

        //add comments TODO doe we need this ???
        public int addComments(String comment){

            return 1;
        }

        /*
        //TODO I don't think we need this also get everything as string and constructor expects int
        //make provider report
        protected int makeProReport(PDirectory PDir){
            try {
                File toRead = new File("ProviderList.txt");
                Scanner IN = new Scanner(toRead);
                String buffer = null;

                String currentData = null;
                String currentTime = null;
                String serviceData = null;
                String pid = null;
                String mid = null;
                String serviceCode = null;
                String fee = null;
                String comments = null;

                while(IN.hasNextLine()){
                    buffer = IN.nextLine();
                    StringTokenizer tokenizer = new StringTokenizer(buffer, "#");
                    currentData = tokenizer.nextToken();
                    currentTime = tokenizer.nextToken();
                    serviceData = tokenizer.nextToken();
                    pid = tokenizer.nextToken();
                    mid = tokenizer.nextToken();
                    serviceCode = tokenizer.nextToken();
                    fee = tokenizer.nextToken();
                    comments = tokenizer.nextToken();

                    //TODO call a function to create an obj of type service
                 //   service temp = new service(currentData, currentTime, serviceData, pid, mid, serviceCode, fee, comments) //TODO takes int String passed
                    //TODO or retrive an obj???

                }
                IN.close();
            }
            catch (IOException noFile) {
                noFile.printStackTrace();
            }
            return -1;
        }
*/
        //TODO to implement this??? need it???
        //make member report
        protected int makeMemReport(){
            return 1;
        }
    }
}