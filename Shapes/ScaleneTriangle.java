/*  Sahil Gupta
    Stutler
    APCSA
    Shapes Lab - Use interfaces and OOP to create
      programs to find the area and perimeter of certain shapes */

public class ScaleneTriangle extends Triangle{ //class declaration with extension of superclass

    public ScaleneTriangle(double base, double sideOne, double sideTwo, String name){ //constructor with call to superclass
        super(base, sideOne, sideTwo, name);
    }

    public String getInfo(){ //get info for the shape
        return getName() + "  perimeter: " + getPerimeter() + "  area: " + getArea();
    }
}