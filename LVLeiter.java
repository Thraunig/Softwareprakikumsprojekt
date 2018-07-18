package at.aau.raunig;

public class LVLeiter {
public String name;
public int LeiterID;

public boolean[][] keineZeit  = new boolean[][]{{false,false,false,false,false,false},{false,false,false,false,false,false},
	{false,false,false,false,false,false},	{false,false,false,false,false,false},
	{false,false,false,false,false,false},	{false,false,false,false,false,false}};


	public LVLeiter(String name, int leiterID) {
		this.name = name;
		LeiterID = leiterID;
	}


}






