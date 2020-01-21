public class Planet {
   private String name;
   private int age;
   private String color;
   private double mass;
   private double orbitalRadius;
   private double diameter;

   public Planet(String name, int age, String color, double mass, double orbitalRadius, double diameter) {
      this.name = name;
      this.age = age;
      this.color = color;
      this.mass = mass;
      this.orbitalRadius = orbitalRadius;
      this.diameter = diameter;
   }

   public Planet(String name, int age, double mass, double orbitalRadius, double diameter) {
      this.name = name;
      this.age = age;
      this.color = "undefined";
      this.mass = mass;
      this.orbitalRadius = orbitalRadius;
      this.diameter = diameter;
   }

   public String planetInfo() {
      String info = "Here is some information about Planet " + this.name + ":\n   " + this.name + " is " + this.age
            + " years old\n   " + this.name + " has a color of " + this.color + " and weighs " + this.mass + " kg\n   "
            + this.name + " is " + this.orbitalRadius + " km away from the Sun and has a diameter of " + this.diameter
            + " km.";

      return info;
   }

   public double getOrbitalRadius() {
      return this.orbitalRadius;
   }

   public void setOrbitalRadius(double newRadius) {
      this.orbitalRadius = newRadius;
   }

   public String getName() {
      return this.name;
   }

   public void setMass(double newMass){
      this.mass = newMass;
   }
}