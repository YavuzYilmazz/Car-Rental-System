package RentACar;

public class Car {
	   private String brand;
	   private String model;
	   private String class_;
	   private String km;
	   private int price;
	   private String office_id;
	   private boolean isAvailable;
	
	   
	   public Car(String inputBrand,String inputModel, String inputClass_, String km, String inputOffice_id,
			      boolean inputIsAvailable){	        
	        brand = inputBrand;  
	        model = inputModel;
	        class_ = inputClass_; 
	        office_id = inputOffice_id;
	        isAvailable = true;
	        price = 0;}
	         
	   		public int getPrice(){return price;}	        	        	        
	   		public void setPrice(int inputPrice){price = inputPrice;}
	   
	        public String getBrand(){return brand;}	        	        	        
	        public void setBrand(String inputBrand){brand = inputBrand;}	        
	                
	        public String getModel() {return model;}	        		        
	        public void setModel(String inputModel) {model = inputModel;}
	        	
	        public String getClass_(){return class_;}	        	        	        
	        public void setClass_(String inputClass_){class_ = inputClass_;}	        
	        	        
	        public String getKm() {return km;}	        		        
	        public void setKm(String inputKm) {km = inputKm;}
	        	       
	        public String getOffice_id(){return office_id;}        	        	        
	        public void setOffice_id(String inputOffice_id){office_id = inputOffice_id;}	        
	        	        
	        public Boolean getIsAvailable() {return isAvailable;}
	        public void setIsAvailable(boolean inputIsAvailable) {isAvailable = inputIsAvailable;}	
	        
	
}