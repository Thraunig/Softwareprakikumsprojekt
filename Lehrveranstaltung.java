package at.aau.raunig;

public class Lehrveranstaltung {
	public int nummer;
	public Typ typ;
	public String name;
	public int semester;
	public LVLeiter leiter;
	public Slot slot;
	public boolean typMathematik;
	public boolean block;


	public enum Slot{
		M8,M10,M12,M14,M16,M18,
		D8,D10,D12,D14,D16,D18,
		MI8,MI10,MI12,MI14,MI16,MI18,
		DO8,DO10,DO12,DO14,DO16,DO18,
		F8,F10,F12,F14,F16,F18;
	}
	public enum Typ{
		UE,VK,VC,KU,KS,VO,TU,CT, PV, PR,VU, SE,PVSE, NONE;
	}

	public Lehrveranstaltung(int nummer, Typ typ, String name, int semester, LVLeiter leiter, Slot slot) {
		this.nummer = nummer;
		this.typ = typ;
		this.name = name;
		this.semester = semester;
		this.leiter = leiter;
		this.slot = slot;
	}

	public String LVtoString(){

		if(leiter == null){
		if(nummer!= 0){
			if(semester == 0 ){
				return nummer + " " + typ + " " + name + " | " ;
			}else {
				return nummer + " " + typ + " " + name + " | " + semester;
			}}
			else{
				return name;

		}
		}
		if(nummer!= 0){
		if(semester == 0 ){
			return nummer + " " + typ + " " + name + "" + leiter.LVLeitertoString() + " | " ;
		}else {
			return nummer + " " + typ + " " + name + "" + leiter.LVLeitertoString() + " | " + semester;
		}}
		else {
			return name;
		}
	}
	
	
	
	
}
