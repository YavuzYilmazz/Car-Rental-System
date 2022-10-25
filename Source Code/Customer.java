package RentACar;

public class Customer {
	private String name;
	   private String surname;
	   private int customerid;

	   	   
	   public Customer(String inputName, String inputSurname,int Customerid){			   
			   name = inputName;
			   surname = inputSurname;
			   Customerid++;
			   } 

	   
	   public String getName(){	   
	   return name;}
	   
	   public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	   public void setName(String inputName){	   
	       name = inputName;}
	   
	   public String getSurname(){	   
		   return surname;}
		   
		   
	   public void setSurname(String inputSurname){	   
		   surname = inputSurname;} 
		   
	   			
	   
	   

	   
	   
}