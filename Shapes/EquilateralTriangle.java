/*  Sahil Gupta
    Stutler
    APCSA
    Shapes Lab - Use interfaces and OOP to create
      programs to find the area and perimeter of certain shapes */

public class EquilateralTriangle extends Triangle{ //class declaration with extension of superclass

    public EquilateralTriangle(double side, String name){ //constructor which relays to superclass
        super(side, side, side, name);
    }

    public String getInfo(){ //get the info of the shape
        return getName() + "  perimeter: " + getPerimeter() + "  area: " + getArea();
    }

    
}