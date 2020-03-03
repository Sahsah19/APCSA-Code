public class Square implements Shape{
   private double side;
   
   public Square(double side){
      this.side = side;
   }
   
   public double getPerimeter(){
      return this.side * 4;
   }
   
   public double getArea(){
      return this.side * this.side;
   }
   
   public String getInfo(){
      return "Square  perimeter: " + getPerimeter() + "  area: " + getArea();
   }
}