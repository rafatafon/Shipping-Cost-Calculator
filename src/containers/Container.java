package containers;

public abstract class Container {

	private double height;
    private double width;
    private double length;
    
  //Creating Constructors with Field 
	public Container(double height, double width, double length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}


    //Creating Constructors without Field 
	public Container() {
	}
	
    //Creating calculateVolumeMehtod
	 public double calculateVolume() {
	        return height * width * length;
	    }
	
	//Creating Getters and Setters
	 public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}


	public String toString() {
	        return "Container: [Height: " + height + " cm, Width: " + width + " cm, Length: " + length + " cm]";
	    }
      
	 
	 
}
