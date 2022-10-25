package RentACar;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Program {

	public static void main(String[] args)throws IOException {
		
		String input = "input.txt";
		String input2 = "input2.txt";
		String input3 = "input3.txt";
		
		Company company = new Company(" ");
		Office office = new Office(" "," "," ",0);
		Customer customer = new Customer(" "," ",0);
		CarRequest carRequest = new CarRequest("","","","","",null,null,false);
		CarRequest carRequest2 = new CarRequest("","","","","",null,null,false);
		int office_counter=0;
		int [] empcounterforoffice = new int[100];
		int [] empcounterforofficecont = new int[100];
		int employeeid =0;
		int employeecounter =0;
		int officeid = 1;
		int customerid=1;
		int customercounter=1;
		int carrequestcounter =0;
		int nextdaycounter =1;
		int contractcounter = 0;
		Contract contract=new Contract(0,0,0,null,null,false);
		boolean isDateAvailable = false;
		boolean isemployeeAvailable = false;
		boolean one_fourday = false;
		Random r = new Random();
		
		Date date = new Date(1,1,2021);
		
		 try {
	            File f = new File(input);
	            Scanner sc = new Scanner(f);
	            
	            while(sc.hasNextLine()){
	                String line = sc.nextLine();
	                String[] details = line.split(";");
	                String command = details[0]; 
	               	                
	                switch(command) {
	                
	                case "addOffice":	                 	
	                	office = new Office(details[1],details[2],details[3],officeid);
	                	officeid++;
	                	office_counter++;
	                	empcounterforoffice[office_counter]=0;
	                    company.addOffice(office);
	                	break;
	                	
	                case "listOffice":
	                	company.listOffice();
	                	break;
	                	
	                case "addCustomer":	
	                    customer = new Customer(details[1],details[2],customerid);
	                    customerid++;
	                    customercounter++;
	                	company.addCustomer(customer);
	                	break;
	                	
	                case "listCustomer":
	                	company.listCustomer();
	                	break;
	                	
	                case "addCar":
	                	Car car = new Car(details[1],details[2],details[3],details[4],details[5], true);
	                	company.addCar(car);
	                	break;
	                	
	                case "listCar": 
	                	company.listCar(details[1]);
	                	break;
	                	
	                case "addEmployee": 
	                	employeecounter++;
	                	int officenumber = Integer.valueOf(details[5]);
	                	if(empcounterforoffice[officenumber]<3){	                	
	                		Employee employee = new Employee(details[1],details[2],details[3],details[4],details[5],employeeid,false);
		                	empcounterforoffice[officenumber]++;
		                	employeeid++;
		                	empcounterforofficecont[officenumber]++;
		                	company.addEmployee(employee);}	                	
	                	else{System.out.println("Office is Full");}	                		                			                	
	                	break;
	                	
	                case "listEmployee": 
	                	company.listEmployee(details[1]);
	                	break;}		                	
	                }
	         } 	                           	                              	            
	         catch (FileNotFoundException e) {         
	            e.printStackTrace();}
		 
		 try {
			 File f2 = new File(input2);
	         Scanner s = new Scanner(f2);
	         
	         while(s.hasNextLine()){
	        	 String line2 = s.nextLine();
	             String[] details2 = line2.split(";");
	             String command2 = details2[0];
	             
	             switch(command2) {
	             
	             case "addCarRequest": 
	            	 String[]splitdate1=details2[6].split("\\.");
	            	 String[]splitdate2=details2[7].split("\\.");
	            	 int startday=Integer.valueOf(splitdate1[0]);
	            	 int startmonth=Integer.valueOf(splitdate1[1]);
	            	 int startyear=Integer.valueOf(splitdate1[2]);
	            	 int endday=Integer.valueOf(splitdate2[0]);
	            	 int endmonth=Integer.valueOf(splitdate2[1]);
	            	 int endyear=Integer.valueOf(splitdate2[2]);
	            	 Date startdate=new Date(startday,startmonth,startyear);
	            	 Date enddate=new Date(endday,endmonth,endyear);
	            	 carRequest = new CarRequest(details2[1],details2[2],details2[3],details2[4],
	            			                                details2[5],startdate,enddate,false);
	            	 System.out.println(">addCarRequest"+details2[1]+";"+details2[2]+";"+details2[3]+";"+details2[4]+";"+
	            			 details2[5]+";"+startdate.getDay()+"."+startdate.getMonth()+"."+startdate.getYear()+";"+enddate.getDay()+"."+enddate.getMonth()+"."+enddate.getYear());

	            	 
	            	 
	            	 
	            	 
	            	if(startdate.getDay()==date.getDay()){	                	 
	                   isDateAvailable = true;}
	                 
	                else {                	 
	                	 System.out.println("   Error:Car request must be for today.");  
	                	 isDateAvailable = false;}
	                	 
	                 if(enddate.getDay()-startdate.getDay()<=4 &&enddate.getDay()-startdate.getDay()>=0)
	                	 one_fourday = true;
	                 else{	                 
	                	 System.out.println("   Error:Car requests must be for 1-4 days");
	                     one_fourday = false;}	                 
	                	 
	                 int officenumberr=Integer.valueOf(details2[1]);
	                 if(empcounterforofficecont[officenumberr]>0) {
	                	 empcounterforofficecont[officenumberr]--;
	                	 isemployeeAvailable = true;}
	                 
	                 else{                 
	                	 System.out.println("   Error:No employee for the contract");
	                	 isemployeeAvailable = false;}
	                 
	                 company.isCarEmpty(details2[1],details2[3], details2[5]);             		
	         		 
	         			
	                 int emp_id=0;
	                 if(isDateAvailable==true&&isemployeeAvailable==true&&one_fourday==true)
	                 {
	                	 if(details2[3].equals("*") && details2[4].equals("*")) 
	                	 {
		            		 String a = company.Random1(details2[5]);
		            		 String[] randomSplitted = a.split(";");
		            		 String randomBrand = randomSplitted[0];
		            		 String randomModel = randomSplitted[1];
		            		 carRequest2 = new CarRequest(details2[1],details2[2],randomBrand,randomModel,details2[5],startdate,enddate,false );
		            		 }
		            	 
		            	 if(details2[4].equals("*") && details2[5].equals("*")) {
		            		 String b = company.Random2(details2[3]);
		            		 String[] randomSplitted = b.split(";");
		            		 String randomModel = randomSplitted[0];
		            		 String randomClass = randomSplitted[1];
		            		 carRequest2 = new CarRequest(details2[1],details2[2],details2[3],randomModel,randomClass,startdate,enddate,false);}
		            	 
	                	 emp_id = company.RandomEmployee(details2[1],employeecounter,empcounterforoffice[1],empcounterforoffice[2],empcounterforoffice[3],empcounterforoffice[4],empcounterforoffice[5]);
	                 }
	                 int cus_id = ThreadLocalRandom.current().nextInt(1, customercounter);
	                 carrequestcounter++;
	                 
	                 if(isDateAvailable==true&&isemployeeAvailable==true&&one_fourday==true)
	                 {	                  
	                	 contract=new Contract(emp_id,cus_id,carrequestcounter,startdate,enddate,false);
	                	 carRequest.setContract(true);
	                	 carRequest2.setContract(true);
	                	 company.addCarRequest2(carRequest2);
	                	 company.addContract(contract);
	                	 contractcounter++;
	                	 company.listContract1(contractcounter);
	                	 }
	                 company.addCarRequest(carRequest);
	                 
	                 break;
	            	 
	             case "listCarRequest":
	            	 company.listCarRequest();
	            	 break;	             
	             }	        	 
	         }	         			 
		 }catch (FileNotFoundException x) {         
	            x.printStackTrace();}
		 
		 
		 		 
		 boolean quit = false;
		 System.out.println("Please enter your commands!");
		 
		 while(!quit) {
		 Scanner scan = new Scanner(System.in);
		 String line3 = scan.nextLine();
		 String[] details3 = line3.split(";");
         String command3 = details3[0];
         
         switch(command3) {
         case "Quit":
        	 quit = true;
        	 break;
         case "quit":
         quit = true;
         break;
        	
         case "deleteOffice":
        	 company.deleteOffice(details3[1]);
        	 company.deleteEmployee(details3[1], "3");
        	 company.deleteEmployee(details3[1], "2");
        	 company.deleteEmployee(details3[1], "1");
        	 company.arrangement(details3[1]);
        	 int index =Integer.valueOf(details3[1]);
        	 empcounterforoffice[index]=0;
        	 break;
        	
         case "deleteEmployee":	
        	 company.deleteEmployee(details3[1], details3[2]);
        	 break;
        	 
         case "addOffice":	                 	
        	office = new Office(details3[1],details3[2],details3[3],officeid);
        	officeid++;
         	office_counter++;
         	empcounterforoffice[office_counter]=0;
            company.addOffice(office);
         	break;
         	
         case "listOffice":
         	company.listOffice();
         	break;
         	
         case "addCustomer":	
            customer = new Customer(details3[1],details3[2],customerid);
            customerid++;
            customercounter++;
         	company.addCustomer(customer);
         	break;
         	
         case "listCustomer":
         	company.listCustomer();
         	break;
         	
         case "addCar":
         	Car car = new Car(details3[1],details3[2],details3[3],details3[4],details3[5], true);
         	company.addCar(car);
         	break;
         	
         case "listCar": 
        	 company.listCar(details3[1]);
         	break;
         	
         case "addEmployee": 
        	employeecounter++;
        	int officenumber = Integer.valueOf(details3[5]);
         	if(empcounterforoffice[officenumber]<3){        	
         		Employee employee = new Employee(details3[1],details3[2],details3[3],details3[4],details3[5],employeeid,false);
             	empcounterforoffice[officenumber]++;
             	employeeid++;
            	empcounterforofficecont[officenumber]++;
             	company.addEmployee(employee);}
        	else{System.out.println("Office is Full");}         	         		         	
         	break;

         case "listEmployee": 
        	company.listEmployee(details3[1]);
         	break;
         	
         case "listContract":
        	 company.listContract();
        	 break;
        	 
         case "nextday":
        	 nextdaycounter++;
        	 date.setDay(nextdaycounter);
        	 System.out.println("--- Office Profits ----");
        	 company.Price();
        	 break;
        	 
         case "addCarRequest":
        	 String[]splitdate1=details3[6].split("\\.");
        	 String[]splitdate2=details3[7].split("\\.");
        	 int startday=Integer.valueOf(splitdate1[0]);
        	 int startmonth=Integer.valueOf(splitdate1[1]);
        	 int startyear=Integer.valueOf(splitdate1[2]);
        	 int endday=Integer.valueOf(splitdate2[0]);
        	 int endmonth=Integer.valueOf(splitdate2[1]);
        	 int endyear=Integer.valueOf(splitdate2[2]);
        	 Date startdate=new Date(startday,startmonth,startyear);
        	 Date enddate=new Date(endday,endmonth,endyear);
        	 carRequest = new CarRequest(details3[1],details3[2],details3[3],details3[4],
        			 details3[5],startdate,enddate,false);
        	 System.out.println(">addCarRequest"+details3[1]+";"+details3[2]+";"+details3[3]+";"+details3[4]+";"+
        			 details3[5]+";"+startdate.getDay()+"."+startdate.getMonth()+"."+startdate.getYear()+";"+enddate.getDay()+"."+enddate.getMonth()+"."+enddate.getYear());
             if(startdate.getDay()==date.getDay()){
            	 
               isDateAvailable = true;}
            else {           	 
            	 System.out.println("   Error:Car request must be for today.");  
            	 isDateAvailable = false;}
            	 
             if(enddate.getDay()-startdate.getDay()<=4 &&enddate.getDay()-startdate.getDay()>=0)
            	 one_fourday = true;
             else{            
            	 System.out.println("   Error:Car requests must be for 1-4 days");
                 one_fourday = false;}
             
            	 
             int officenumberr=Integer.valueOf(details3[1]);
             if(empcounterforofficecont[officenumberr]>0) {
            	 empcounterforofficecont[officenumberr]--;
            	 isemployeeAvailable = true;}
             
             else {            
            	 System.out.println("   Error:No employee for the contract");
            	 isemployeeAvailable = false;}
             
             company.isCarEmpty(details3[1],details3[3],details3[5]);
             
             int emp_id=78;
             if(isemployeeAvailable==true)
             {
            	 emp_id = company.RandomEmployee(details3[1],employeecounter,empcounterforoffice[1],empcounterforoffice[2],empcounterforoffice[3],empcounterforoffice[4],empcounterforoffice[5]);
             }
             int cus_id = ThreadLocalRandom.current().nextInt(1, customercounter);
             carrequestcounter++;
             if(isDateAvailable==true&&isemployeeAvailable==true&&one_fourday==true){            
            	 contract=new Contract(emp_id,cus_id,carrequestcounter,startdate,enddate,false);
            	 company.addContract(contract);
            	 carRequest.setContract(true);
            	 contractcounter++;
            	 company.listContract1(contractcounter);
            	 }            
             company.addCarRequest(carRequest);
             break;
        	      	 
        	 }		        	 
        }	        	 
	}
}
         
		 
		 
		
