/*  Sahil Gupta
    Stutler
    APCSA
    Shapes Lab - Use interfaces and OOP to create
      programs to find the area and perimeter of certain shapes */

public class RightTriangle extends Triangle{ //class declaration with extension of superclass
    
    public RightTriangle(double base, double height, double hypot, String name){ //constructor going back to the superclass
        super(base, height, hypot, name);
    }

    public String getInfo(){ //get info about the triangle
        return getName() + "  perimeter: " + getPerimeter() + "  area: " + getArea();
    }
}