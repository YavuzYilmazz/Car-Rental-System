package RentACar;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Company {
	   private String name;
	   
	    private Employee[] employee;
	    private int employeecounter;
	    private Car[] car;		
	    private int carcounter;
	    private int customercounter;
		private Customer [] customer;
		private Contract [] contract;
		private int contractcounter;
		
		private int [] bankforeveryoffice;
		private int [] maintenance1;
		private int [] maintenance2;
		private int [] maintenance3;
		private int [] bonus;
		private int [] empsalaries;
	    
		private boolean employee1_isavailable;
		private boolean employee2_isavailable;
		private boolean employee3_isavailable;
		
	    
	   private Office[] office;
	   private int officecounter;
	   
	   private CarRequest[] carRequest;
	   private int carrequestcounter;
	   private CarRequest[] carRequest2;
	   private int carrequest2counter;
	
	   public Company(String companyname) {
		   employee = new Employee[100];
		   employeecounter = 0;
		   
		   car = new Car[20];		   
		   carcounter = 0;
		   
		   bankforeveryoffice = new int[100];
		   maintenance1 = new int[100];
		   maintenance2 = new int[100];
		   maintenance3 = new int[100];
		   bonus = new int[100];
		   empsalaries = new int[100];
		   
		   employee1_isavailable =true;
		   employee2_isavailable =true;
		   employee3_isavailable =true;
		   name = companyname;
		    
		   office = new Office[10];
		   officecounter=0;
		    
	   	   carRequest = new CarRequest[100];
	   	   carrequestcounter = 0;
	   	   
	   	   carRequest2 = new CarRequest[100];
	   	   carrequest2counter = 0;
	   	   
	   	   contract = new Contract[100];
	   	   contractcounter = 0;
	   	   
	   	   customer = new Customer[100];
		   customercounter=0;}
	   
				
	   public boolean isEmployee1_isavailable() {return employee1_isavailable;}	
	   public void setEmployee1_isavailable(boolean employee1_isavailable) {this.employee1_isavailable = employee1_isavailable;}	  
	   public boolean isEmployee2_isavailable() {return employee2_isavailable;}	  
	   public void setEmployee2_isavailable(boolean employee2_isavailable) {this.employee2_isavailable = employee2_isavailable;}	  
	   public boolean isEmployee3_isavailable() {return employee3_isavailable;}	  
	   public void setEmployee3_isavailable(boolean employee3_isavailable) {this.employee3_isavailable = employee3_isavailable;}
	   
	   public String getName(){return name;}  	        	  
	   public void setName(String inputName){name = inputName;}	 
	   
	   
	   
	   
	   public void Price() {

		   int off_id = 1;
		   String car_class = "";
		   boolean flag=false;
		   boolean flag1=false;
		   int a = 0;
		   int economycounter=0; 
		   int sportscounter=0;
		   int luxurycounter=0;
		   int control =1;
		   
		   int OFFICERENT = 100;
		   int empcounteveryoffice = 0;
		   
		   for (int l = 0; l < 100; l++) {
				bankforeveryoffice[l]=0;
				bonus[l]=0;
				maintenance1[off_id]=0;
				maintenance2[off_id]=0;
				maintenance3[off_id]=0;
			}
		   
		   for (int i = 0; i < carrequest2counter; i++) 
		   {
			   flag=false;
			   for (int j = 0; j < contractcounter; j++) 
				{
					for (int k = 0; k < employeecounter; k++) 
					{
						if(employee[k].getOffice_id().equals(off_id))
							empsalaries[off_id] +=30;
						if(employee[k].getEmployeeid() == contract[j].getEmployeeID()&&contract[j].isPayment()==false)
						{
							
							contract[j].setPayment(true);	
							off_id= Integer.valueOf(employee[k].getOffice_id());
							
							if(carRequest2[i].isContract()==true)
							{
								if(off_id!=control) {
									System.out.println("Office "+(off_id-1)+" incomes: "+bankforeveryoffice[off_id-1]);									
									int expenses = OFFICERENT + bonus[off_id-1] + maintenance1[off_id-1]+maintenance2[off_id-1]+maintenance3[off_id-1]+ empsalaries[off_id-1];
									int incomes = Integer.valueOf(bankforeveryoffice[off_id-1]);
									System.out.println("   Office rent: "+ OFFICERENT);
									System.out.println("   Employee Salaries: " + empsalaries[off_id-1]);
									System.out.println("   Employee performance bonuses: "+ bonus[off_id-1]);
									System.out.println("   Car Maintance: "+maintenance1[off_id-1]+"+"+maintenance2[off_id-1]+"+"+maintenance3[off_id-1]);
									System.out.println("Office "+(off_id-1)+" expenses: "+expenses);
									System.out.println("Office "+(off_id-1)+" profit: "+ (incomes - expenses));
									System.out.println("------------------------------------------------------");
									
								}
								control = Integer.valueOf(employee[k].getOffice_id());
								car_class = carRequest2[i].getClass_();
								if(car_class.equals("economy")) {
									   bankforeveryoffice[off_id]+=100;
								       a=100;
								       bonus[off_id] += 5;
								       maintenance1[off_id] += 20;
								       empsalaries[off_id] +=30;
								       System.out.println("  Car"+contract[j].getCarID()+": " + a);
								       flag=true;
								       break;}
								   
								   else if(car_class.equals("sports")) {
									   bankforeveryoffice[off_id]+=200;
								       a=200;
								       bonus[off_id] += 10;
								       maintenance2[off_id] += 70;
								       empsalaries[off_id] +=30;
								       System.out.println("  Car"+contract[j].getCarID()+": " + a);
								       flag=true;
								       break;}
								   
								   else if(car_class.equals("luxury")) {
									   bankforeveryoffice[off_id]+=300;
								       a=300;
								       bonus[off_id] += 15;
								       maintenance3[off_id] += 120;
								       empsalaries[off_id] +=30;
								       System.out.println("  Car"+contract[j].getCarID()+": " + a);
								       flag=true;
								       break;}}}}	
					if(flag==true)
						break;}}

		   
		   System.out.println("Office"+off_id+" incomes: "+bankforeveryoffice[off_id]);
		   
		    int expenses = OFFICERENT + bonus[off_id] + maintenance1[off_id]+maintenance2[off_id]+maintenance3[off_id]+empsalaries[off_id];
			int incomes = Integer.valueOf(bankforeveryoffice[off_id]);

			System.out.println("  Office rent: "+ OFFICERENT);
			System.out.println("  Employee Salaries: " + empsalaries[off_id]);
			System.out.println("  Employee performance bonuses: "+ bonus[off_id]);
			System.out.println("  Car Maintance: "+maintenance1[off_id]+"+"+maintenance2[off_id]+"+"+maintenance3[off_id]);
			System.out.println("Office"+off_id+" expenses: " + expenses);
			System.out.println("Office "+(off_id)+" profit: "+ (incomes - expenses));	
			System.out.println("------------------------------------------------------");
			
		   }
		      
		   
	   
	   public void addEmployee(Employee e) {		   
		   employee[employeecounter] = e;
		   employeecounter++;}
		   
	   
	   public void addCar(Car c) {
		   car[carcounter] = c;
		   carcounter++;}
	   
		  
	   public void addCarRequest(CarRequest cr) {
		   carRequest[carrequestcounter] = cr;
		   carrequestcounter++;}
	   
	   
	   public void addOffice(Office o) {
		   office[officecounter] = o;
		   officecounter++;}
	   
	   
	   public void deleteOffice(String id) {
		   int index = Integer.valueOf(id);
		   for (int i = index-1; i < officecounter - 1; i++) {
			   office[i] = office[i + 1];}
		       officecounter--;}  
	   
	   
	   Random r = new Random();
	   
	   public int RandomEmployee(String inputOfficeID,int employeecounter, int empcounterforoffice1, int empcounterforoffice2, int empcounterforoffice3, int empcounterforoffice4, int empcounterforoffice5) {
		     int empID = 1;
		     boolean flag=false;
		     while(true)
		     {
		    	 if(flag==true)
		    		 break;
		    	 
		    	 if(inputOfficeID.equals("1"))
		    	 {
		    		 int a =employeecounter-empcounterforoffice2-empcounterforoffice3-empcounterforoffice4-empcounterforoffice5;
		    		 
		    		 int index = ThreadLocalRandom.current().nextInt(0, a);	 
				    	 if(employee[index].getOffice_id().equals(inputOfficeID)&&employee[index].isIscontract()==false) 
				    	 {
				    		 flag=true;
				    		 employee[index].setIscontract(true);
				    		 empID = employee[index].getEmployeeid();
				    		 break;
					     }	
		    	 }
		    	 
		    	 else if(inputOfficeID.equals("2"))
		    	 {
		    		 int a=employeecounter-empcounterforoffice3-empcounterforoffice4-empcounterforoffice5;
		    		 int b=empcounterforoffice1;
		    		 int index = ThreadLocalRandom.current().nextInt(b, a);	 
				     for(int j = 0; j < employeecounter; j++) {
				    	 if(employee[index].getOffice_id().equals(inputOfficeID)&&employee[index].isIscontract()==false) 
				    	 {
				    		 flag=true;
				    		 employee[index].setIscontract(true);
					    	 empID = employee[index].getEmployeeid();
					    	 break;
					    }
				   }	
		    	 }
		    	 else if(inputOfficeID.equals("3"))
		    	 {
		    		 int a=employeecounter-empcounterforoffice4-empcounterforoffice5;
		    		 int b=empcounterforoffice1+empcounterforoffice2;
		    		 int index = ThreadLocalRandom.current().nextInt(b, a);	 
				     for(int j = 0; j < employeecounter; j++) {
				    	 if(employee[index].getOffice_id().equals(inputOfficeID)&&employee[index].isIscontract()==false) {
				    		 flag=true;
				    		 employee[index].setIscontract(true);
					    	 empID = employee[index].getEmployeeid();
					    	 break;}}	
		    	 }
		    	 else if(inputOfficeID.equals("4"))
		    	 {
		    		 int a=employeecounter-empcounterforoffice5;
		    		 int b=empcounterforoffice1+empcounterforoffice2+empcounterforoffice3;
		    		 int index = ThreadLocalRandom.current().nextInt(b, a);	 
				     for(int j = 0; j < employeecounter; j++) {
				    	 if(employee[index].getOffice_id().equals(inputOfficeID)&&employee[index].isIscontract()==false) {
				    		 flag=true;
				    		 employee[index].setIscontract(true);
					    	 empID = employee[index].getEmployeeid();
					    	 break;}}	
		    	 }
		    	 else if(inputOfficeID.equals("5"))
		    	 {
		    		 int a=employeecounter;
		    		 int b=empcounterforoffice1+empcounterforoffice2+empcounterforoffice3+empcounterforoffice4;
		    		 int index = ThreadLocalRandom.current().nextInt(b, a);	 
				     for(int j = 0; j < employeecounter; j++) {
				    	 if(employee[index].getOffice_id().equals(inputOfficeID)&&employee[index].isIscontract()==false) {
				    		 flag=true;
				    		 employee[index].setIscontract(true);
					    	 empID = employee[index].getEmployeeid();
					    	 break;}}	
		    	 }
			     
		     }
		     return empID;
			}
		     
	   
	   public int RandomCustomer() {
		     int cusID=0;
		     int index = r.nextInt(customercounter);			 
		     for(int i = 0; i < customercounter; i++) {
		    	 cusID = customer[index].getCustomerid();}	     		     		     		     		     
			 return cusID;}
			    
	   
	   
	   public String Random1(String inputClass) {
		   //model brand random
		   String x = "";
		   String y = "";
		   for(int i = 0; i < carcounter; i++) {
			   if(car[i].getClass_().equals(inputClass) && car[i].getIsAvailable()==true) {
				   x = car[i].getModel();
				   y = car[i].getBrand();}}		   
		   return y + ";" + x;}
		   
	   
	   public String Random2(String inputBrand) {
		   // model clas random
		   String x = "";
		   String y = "";
		   
		   for(int i = 0; i < carcounter; i++) {
			   if(car[i].getBrand().equals(inputBrand) && car[i].getIsAvailable()==true) {
				   x = car[i].getModel();
				   y = car[i].getClass_();}}		   
		   return x + ";" +  y;}
		   
	   
	   
	   public String Random3() {
		   //hepsi random
		   String x = "";
		   String y = "";
		   String z = "";
		   
		   int index = r.nextInt(carcounter);
		   x = car[index].getBrand();
		   y = car[index].getModel();
		   z = car[index].getClass_();		      
		   return x + ";" + y + ";" + z;} 
	     
	   
	   public void listEmployee(String id) {			
			 System.out.println(">listEmployee;" + id);
			 int counter= 0;
			 for(int i=0; i < employeecounter; i++) {
			       if(employee[i].getOffice_id().equals(id)) {
			    	   counter++;
				   System.out.println(counter + "." +"Employee;"+ employee[i].getName() + ";" + employee[i].getSurname() + ";" + employee[i].getGender() +
						   ";" +  employee[i].getBirthdate() + ";" + employee[i].getOffice_id());}}}

			   			   
	   public void listCar(String idd){
		   System.out.println(">listCar;"+idd);
		   for(int i=0; i < carcounter; i++) {
			   if(car[i].getOffice_id().equals(idd))
				   if((car[i].getKm() == null || car[i].getKm() == "0") && car[i].getIsAvailable() == true) {
					   car[i].setKm("0");
			   	       System.out.println(i+1 + "." +"Car;"+ car[i].getBrand()+ ";" + car[i].getModel()+ ";"+
					   car[i].getClass_()+ ";"+	car[i].getKm() + ";"+ car[i].getOffice_id() + " - available");}
			   
				   else if((car[i].getKm() == null || car[i].getKm() == "0") && car[i].getIsAvailable() == false) {
					   car[i].setKm("0");
					   System.out.println(i+1 + "." +"Car;"+ car[i].getBrand()+ ";" + car[i].getModel()+ ";"+
		               car[i].getClass_()+ ";"+	car[i].getKm() + ";"+ car[i].getOffice_id() + " - not available");}}}
	   
	   
	   public void deleteEmployee(String off_id,String emp_id){ 	   
		     int index = Integer.valueOf(emp_id);		     
		     for (int i = index-1; i < employeecounter - 1; i++){ 		     
		    	 if(off_id.equals(employee[i].getOffice_id())) {employee[i] = employee[i + 1];}		    	 
		    	 	 employeecounter--;}}
		      		    	 

	public void arrangement(String ar) {
		int index =Integer.valueOf(ar);
		for (int i =0; i < employeecounter + 1; i++){	
			int empindex = Integer.valueOf(employee[i].getOffice_id());
			if(empindex>index){			
				empindex--;
				String new_office_id = String.valueOf(empindex);
				employee[i].setOffice_id(new_office_id);}}}
	
  

	   public void listCarRequest() {
		   System.out.println(">listCarRequest");
		   for(int i=0; i < carrequestcounter; i++){System.out.println(i+1 +". CarRequest;"+carRequest[i].getOffice_id()
				   +";"+carRequest[i].getCustomer_id()+";"+carRequest[i].getBrand()+";"+carRequest[i].getModel()
				   +";"+carRequest[i].getClass_()+";"+carRequest[i].getStart_date().getDay()+"."+
				   carRequest[i].getStart_date().getMonth() +"."+carRequest[i].getStart_date().getYear()+
				  ";"+carRequest[i].getEnd_date().getDay()+"."+carRequest[i].getEnd_date().getMonth()
				  + "."+carRequest[i].getEnd_date().getYear());}}

	   
	   public void listOffice() {
		   System.out.println(">listOffice");
		   for(int i=0; i < officecounter; i++) {System.out.println(i+1 + "." + "Office;"+ office[i].getPhone()+ ";" + office[i].getAddress()
			   + ";" + office[i].getCity());}}


	public String Random4(String inputBrand, String inputClass) {
       String x = "";
       for(int i = 0; i < carcounter; i++) {
         if(car[i].getBrand().equals(inputBrand) && car[i].getClass_().equals(inputClass)){
           x = car[i].getModel();}}
  
       return x;}
     


	public void isCarEmpty(String officenumber,String brand, String carClass) {
		for(int i=0;i<carcounter;i++)
		{
		if(!(brand.equals("*")) && car[i].getOffice_id().equals(officenumber) && car[i].getBrand().equals(brand))
		if((carClass.equals("*") || car[i].getClass_().equals(carClass)) && car[i].getIsAvailable()==false)
		{
		System.out.println("   Error:Car not available");
		break;
		}

		}
		}
						
	
	 public void addCustomer(Customer c) {     
		   customer[customercounter] = c;
		   customercounter++;}
					   			   			   		
	 
	   public void listCustomer() {System.out.println(">listCustomer");
		   for(int i=0; i < customercounter; i++){System.out.println(i+1 + "." + "Customer;"+ customer[i].getName()+ ";" + customer[i].getSurname());}}

	   
	public void addContract(Contract c) {
		contract[contractcounter]= c;	
		int emp_id = contract[contractcounter].getEmployeeID();
		int off_id = 0;
		int index = 0;
		
		for(int i = 0; i < employeecounter; i++) {
			if(emp_id == employee[i].getEmployeeid()) {
				off_id = Integer.valueOf(employee[i].getOffice_id());}}
		for(int i = 0; i < carcounter; i++) {
			if(Integer.valueOf(car[i].getOffice_id()) == off_id) {
				index = i;}}				
		car[index].setIsAvailable(false);
		contractcounter++;}
	


	public void listContract() {
		System.out.println(">>>listContract");
		int counter= 0;
		for(int i=0; i<contractcounter;i++){		
			counter++;
			int emp_id =Integer.valueOf(contract[i].getEmployeeID());
			System.out.println(counter+"."+"Contract"+":"+"Employee"+(emp_id+1)+";"+"Customer"+contract[i].getCustomerID()+";"+"Car"+contract[i].getCarID()+";"+contract[i].getStartdate().getDay()+"."+
					contract[i].getStartdate().getMonth() +"."+contract[i].getStartdate().getYear()+
						  ";"+contract[i].getEnddate().getDay()+"."+contract[i].getEnddate().getMonth()
						  + "."+contract[i].getEnddate().getYear());}}


	public void listContract1(int contractcounterr) {	
		    int emp_id =Integer.valueOf(contract[contractcounterr-1].getEmployeeID());
			System.out.println("   "+"Contract"+":"+"Employee"+(emp_id+1)+";"+"Customer"+contract[contractcounterr-1].getCustomerID()+";"+"Car"+contract[contractcounterr-1].getCarID()+";"+contract[contractcounterr-1].getStartdate().getDay()+"."+
					contract[contractcounterr-1].getStartdate().getMonth() +"."+contract[contractcounterr-1].getStartdate().getYear()+
						  ";"+contract[contractcounterr-1].getEnddate().getDay()+"."+contract[contractcounterr-1].getEnddate().getMonth()
						  + "."+contract[contractcounterr-1].getEnddate().getYear());}


	public void addCarRequest2(CarRequest cr2) {
		
			   carRequest2[carrequest2counter] = cr2;
			   carrequest2counter++;
		
	}	
	}
	
		
		   
	   

	   
	   

