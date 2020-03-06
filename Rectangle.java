public class Rectangle implements Shape{
   
   private double width;
   private double length;

   public Rectangle(double width, double length){
      this.width = width;
      this.length = length;
   }
   
   public double getPerimeter(){
     return (this.width * 2) + (this.length * 2);
   }
   
   public double getArea(){
      return this.width * this.length;
   }
   
   public String getInfo(){
      return "Rectangle  perimeter: " + getPerimeter() + "  area: " + getArea();
   }

}