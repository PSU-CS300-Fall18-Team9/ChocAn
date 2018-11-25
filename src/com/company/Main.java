
package com.company;

public class Main {

    public static void main(System[] args) {



    }

    //service is a LLL of services
    public class service{

        protected service next;

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
        protected int displayName(node * head){
                System.out.println(("Name: " + Name));
        }

        //add comments
        public String addComments(String comment){
        }

        //make provider report
        protected int makeProReport("ProviderList.txt"){
            try {
                File toRead = new File("ProviderList.txt");
                Scanner IN = new Scanner(toRead);
                String buffer = null;

                currentData = currentData;
                this.currentTime = currentTime;
                this.serviceData = serviceData;
                this.pid = pid;
                this.mid = mid;
                this.serviceCode = serviceCode;
                this.fee = fee;
                this.comments = comments;

                //TODO work on this
            }
        }

        //make member report
        protected int makeMemReport(){
        }
    }
}