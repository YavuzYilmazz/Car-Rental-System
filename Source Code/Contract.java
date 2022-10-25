package RentACar;

public class Contract {
	   private int employeeID;
	   private int customerID;
	   private int carID;
	   private Date startdate;
	   private Date enddate;
	   private boolean payment;

	    public Contract(int employeeID, int customerID, int carID, Date startdate, Date enddate,boolean payment) {
	        this.employeeID = employeeID;
	        this.customerID = customerID;
	        this.carID = carID;
	        this.startdate = startdate;
	        this.enddate = enddate;
	        this.payment=payment;}


	    public boolean isPayment() {
			return payment;
		}


		public void setPayment(boolean payment) {
			this.payment = payment;
		}


		public int getEmployeeID() {
	    	return employeeID;}



	    public void setEmployeeID(int employeeID) {
	    	this.employeeID = employeeID;}



	    public int getCustomerID() {
	    	return customerID;}



	    public void setCustomerID(int customerID) {
	    	this.customerID = customerID;}



	    public int getCarID() {return carID;}
	        
	    

	    public void setCarID(int carID) {this.carID = carID;
	        
	    }


		public Date getStartdate() {
			return startdate;
		}


		public void setStartdate(Date startdate) {
			this.startdate = startdate;
		}


		public Date getEnddate() {
			return enddate;
		}


		public void setEnddate(Date enddate) {
			this.enddate = enddate;
		}

	   
		
	
}