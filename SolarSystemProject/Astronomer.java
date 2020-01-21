public class Astronomer {
	public static void main(String[] args) {
		SolarSystem ss = new SolarSystem();

		Planet prikotoMinya = new Planet("Prikoto Minya", 69420666, "red", 0, 4.20 * 108, 16420.7);
		Planet donaldDuck = new Planet("Donald Duck", 20000, "blue",Math.pow(1.03, Math.pow(10,24)), 0.2 * 108, 4142.0);
		Planet bobbyBob = new Planet("Bobby Bob", 183839, "brown", 2.05 * Math.pow(10, 24), 1.2 * 108, 5906.9);

		prikotoMinya.setMass(7.420 * Math.pow(10, 24));

        ss.addPlanet(prikotoMinya.getName()); ss.getObject(prikotoMinya);
        ss.addPlanet(donaldDuck.getName()); ss.getObject(donaldDuck);
        ss.addPlanet(bobbyBob.getName()); ss.getObject(bobbyBob);
		
		System.out.println(prikotoMinya.planetInfo());
		System.out.println(donaldDuck.planetInfo());
		System.out.println(bobbyBob.planetInfo());
		
		System.out.println(ss.getClosestPlanet());
		
		System.out.print(ss.planetPrint());
	}
}