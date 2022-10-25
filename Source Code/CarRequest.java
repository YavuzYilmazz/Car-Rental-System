package RentACar;

public class CarRequest {
	   private String office_id;
	   private String customer_id;
	   private String brand;
	   private String model;
	   private String class_;
	   private Date start_date;
	   private Date end_date;
	   private Contract[] contracts;
	   private int contractcounter;
	   private boolean isContract =false;

	public CarRequest(String inputOffice_id, String inputCustomer_id, String inputBrand,String inputModel,String inputClass_,
			             Date inputStart_date,Date inputEnd_date,boolean isContract){			   
		   office_id = inputOffice_id;
		   customer_id = inputCustomer_id;
		   brand = inputBrand;
		   model = inputModel;
		   class_ = inputClass_;
		   start_date = inputStart_date;
		   end_date = inputEnd_date;
		   contractcounter = 0;
		   this.isContract = isContract;}
		   

	   public boolean isContract() {
		return isContract;
	}


	public void setContract(boolean contract) {
		this.isContract = contract;
	}


	public String getOffice_id(){return office_id;}	   	           
	   public void setOffice_id(String inputOffice_id){office_id = inputOffice_id;}	  
	   
	   public String getCustomer_id(){return customer_id;}	   
	   public void setCustomer_id(String inputCustomer_id){customer_id = inputCustomer_id;}	 
	   
	   public String getBrand(){return brand;}
	   public void setBrand(String inputBrand){brand = inputBrand;}	   
	   
	   public String getModel(){return model;}	   	        	   
	   public void setModel(String inputModel){model = inputModel;}	  
	   
	   public String getClass_(){return class_;}	   
	   public void setClass_(String inputClass_){class_ = inputClass_;}
	   
	   public Date getStart_date(){return start_date;}	   	           
	   public void setStart_date(Date inputStart_date){start_date = inputStart_date;}	 
	   
	   public Date getEnd_date(){return end_date;}	   	          
	   public void setEnd_date(Date inputEnd_date){end_date = inputEnd_date;} 
	   
	   public void addContract(Contract c){
		   contracts[contractcounter] = c;
		   contractcounter++;}


	   
		   
}