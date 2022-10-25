package RentACar;


public class Employee { 
	 private String name;
	   private String surname;
	   private String gender;
	   private String birthdate;
	   private String office_id;
	   private int employeeid;
	   private boolean iscontract=false;
	   
	   
	   public Employee(String inputName, String inputSurname, String inputGender, String inputBirthdate, String inputOffice_id,int employeeid,boolean iscontract){      
		     name  = inputName;  
		     surname = inputSurname; 
		     gender = inputGender ;
		     birthdate = inputBirthdate;
		     office_id = inputOffice_id;
		     this.employeeid =employeeid;
		     this.iscontract = iscontract;} 
	   
	public boolean isIscontract() {
		return iscontract;
	}

	public void setIscontract(boolean iscontract) {
		this.iscontract = true;
	}

	
     
     public int getEmployeeid() {return employeeid;}			
	  public void setEmployeeid(int employeeid) {this.employeeid = employeeid;}	 		
	  public String getName(){return name;}         
    
     
     public void setName(String inputName){name = inputName;}       
     
 
     
     public String getSurname(){return surname;}       
     
     
     public void setSurname(String inputSurname){surname = inputSurname;}      
     
     
     
     public String getGender(){return gender;}      
     
     
     public void setGender(String inputGender){gender = inputGender;}       
     
     
     
     public String getBirthdate(){       
     return birthdate;}
     
     public void setBirthdate(String inputBirthdate){        
     birthdate = inputBirthdate;}
     
     
     public String getOffice_id(){        
     return office_id;}
     
     public void setOffice_id(String inputOffice_id){       
     office_id = inputOffice_id;}
}