package items;

public class Item {
	
	private String name;
    private double length;
    private double width;
    private double height;
    private double weight;
    
  //Creating Constructors with Field 
	public Item(String name, double length, double width, double height, double weight) {
		this.name = name;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}
	
	 //Creating Constructors without Field 
	public Item() {
	}

	//Creating Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
    //Creating Calculate Volume Method 
	 public double calculateVolume() {
	        return length * width * height;
	    }
	 
	 public String toString() {
	        return name + ": [Length: " + length + " cm, Width: " + width + " cm, Height: " + height + " cm, Weight: "
	                + weight + " kg]";
	    }
	
}
