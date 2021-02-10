package beans;

public class Acteur {
	private int tete;
	private int pieds;
	private int torse;
	private int jambes;
	
	public int getTete() {
		return tete;
	}

	public int getPieds() {
		return pieds;
	}

	public int getTorse() {
		return torse;
	}

	public int getJambes() {
		return jambes;
	}
	
	public Acteur(int tete, int pieds, int torse, int jambes) {
		this.tete = tete;
		this.pieds = pieds;
		this.torse = torse;
		this.jambes = jambes;
	}

	public String toString() {
		return "Acteur [tete=" + tete + ", pieds=" + pieds + ", torse=" + torse + ", jambes=" + jambes + "]";
	}
}
