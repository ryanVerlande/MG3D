package resource;

public class Main {

	public static void main(String[] args) {
		
		ExempleJogl.avancerUnPasDeTemps();
		while (true) {
			try {
				Thread.sleep(10);
			} catch (Exception err) {}
			ExempleJogl.avancer();
		}
	}

}
