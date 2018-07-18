package at.aau.raunig;

public class Lehrveranstaltung {
	public int semester;
	public LVLeiter leiter;
	public Slot slot;
	public boolean typMathematik;
	public boolean block;

	public enum Slot{
		M8,M10,M12,M14,M16,M18,
		D8,D10,D12,D14,D16,D18,
		MI8,MI10,MI12,MI14,MI16,MI18,
		DO8,DO10,D012,DO14,DO16,DO18,
		F8,F10,F12,F14,F16,F18;
	}
	

	
	public Lehrveranstaltung(int semester, LVLeiter leiter, Slot slot) {
		super();
		this.semester = semester;
		this.leiter = leiter;
		this.slot = slot;
	}
	
	
	
	
}
