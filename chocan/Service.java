package chocan;
import java.util.*;

/*
public class Service 
{


    boolean debug = true;

    public Service()
    {
        if(debug == true)
        {
            System.out.println("Service default constructor");
        }
    }

    public String toString()
    {
        if(debug == true)
        {
            System.out.println("Service toString");
        }

        String data = null;

        return data;
    }
}

*/

//Service is created as node of a LLL, where provider/member
//are are the head of a LLL of services

//package com.company;
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

        protected int currentData;
        protected int currentTime;
        protected int serviceData;
        protected int pid;
        protected int mid;
        protected int serviceCode;
        protected int fee;
        protected String comments;

        //default constructor
        public service(){
            this.currentData = 0;
            this.currentTime = 0;
            this.serviceData = 0;
            this.pid = 0;
            this.mid = 0;
            this.serviceCode = 0;
            this.fee = 0;
            this.comments = null;
        }

        //constructor with args
        public service(int currentData, int currentTime, int serviceData, int pid, int mid, int serviceCode, int fee, String comments){
            this.currentData = currentData;
            this.currentTime = currentTime;
            this.serviceData = serviceData;
            this.pid = pid;
            this.mid = mid;
            this.serviceCode = serviceCode;
            this.fee = fee;
            this.comments = comments;
        }

        //used as copy constructor
        public service(service toAdd){
            this.currentData = toAdd.currentData;
            this.currentTime = toAdd.currentTime;
            this.serviceData = toAdd.serviceData;
            this.pid = toAdd.pid;
            this.mid = toAdd.mid;
            this.serviceCode = toAdd.serviceCode;
            this.fee = toAdd.fee;
            this.comments = toAdd.comments;
        }

        //change date
        public int changeDate(int serviceDate){

        }

        //wrapper for display TODO we need a display function??
        public int displayName(){
            if(this.head == null) return 0;

            return displayName(this.head.goNext())+1;
        }

        //display name TODO what do we need to do with this...
        protected int displayName(node head){
                System.out.println(("Name: " + Name));
        }

        //add comments
        public String addComments(String comment){
        }

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
                    service temp = new service(currentData, currentTime, serviceData, pid, mid, serviceCode, fee, comments) //TODO takes int String passed
                    //TODO or retrive an obj???

                }
                IN.close();
            }
            catch (IOException noFile) {
                noFile.printStackTrace();
            }
            return -1;
        }

        //make member report
        protected int makeMemReport(){
        }
    }
}
