/*  Sahil Gupta
    Stutler
    APCSA
    Shapes Lab - Use interfaces and OOP to create
      programs to find the area and perimeter of certain shapes */

public abstract class Triangle implements Shape, Object{ //triangle super class declaration with implementation of 

    //field declarations
    private double base;
    private double sideOne;
    private double sideTwo;
    private String name;

    public Triangle(double base, double sideOne, double sideTwo, String name){ //constructor
        this.base = base;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.name = name;

        //see if the triangle is valid
        if(base + sideOne >= sideTwo){
            if(base + sideTwo >= sideOne){
                if(sideOne + sideTwo >= base){

                }else{
                    throw new IllegalArgumentException(getName());
                }
            }else{
                throw new IllegalArgumentException(getName());
        }
        }else{
            throw new IllegalArgumentException(getName());
        }
    }

    public double getPerimeter(){ //get perimeter method
        return this.base + this.sideOne + this.sideTwo;
    }

    public double getArea(){ //get the area using Heron's law
        double s = getPerimeter() / 2;
        double area = (s) * (s - this.base) * (s - this.sideOne) * (s - this.sideTwo);
        return Math.sqrt(area);
    }

    public String getName(){ //get the name of the shape
        return this.name;
    }

    public boolean equals(Shape shape){ //check the area and perimeter with another shape
        boolean isEqual = false;
        if(shape.getArea() == getArea()){
            if(shape.getPerimeter() == getArea()){
                isEqual = true;
            }
        }
        return isEqual;
    }

}