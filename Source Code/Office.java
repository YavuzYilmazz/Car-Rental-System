package RentACar;

public class Office {
	private String phone;
    private String address;
    private String city;

	

	private int officeid = 0;
	

    
   public Office(String inputPhone, String inputAddress, String inputCity, int officeid){			   
	   phone = inputPhone;
	   address = inputAddress;
	   city = inputCity;
	   
	   officeid++;}
	   
   	   	   		  
   
   public int getOfficeid() {return officeid;}					
   public void setOfficeid(int inputOfficeid) {officeid = inputOfficeid;}	
	




// Getter
   public String getPhone(){return phone;}	   
        
   
   // Setter
   public void setPhone(String inputPhone){phone = inputPhone;}	   
       
   

   public String getAddress(){return address;}	   
       
   	   
   public void setAddress(String inputAddress){address = inputAddress;}	   
       
   
   
   public String getCity(){return city;}	   
       
   	   
   public void setCity(String inputCity){city = inputCity;}	   
       
   
  
	   	   
   


}         
			   
		   
	  
	   
	   



