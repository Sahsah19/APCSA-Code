public class Square extends Rectangle{
   
   public Square(double side){
      super(side, side);   
   }
      
   public String getInfo(){
      return "Square  perimeter: " + getPerimeter() + "  area: " + getArea();
   }
}