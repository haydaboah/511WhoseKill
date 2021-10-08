import java.util.*;
public class Hotel 
{
	//Hotel
	Room[][] Hotel;
	
	/*
	 * The way the room constructor works - ("Room Name","Room Type","List of door locations","The crime scene text (ex: shot, stabbed)")
	 */
	
	//Rooms going from top left to right
	//Row 1
	Room H1    = new Room("H1","Hallway",new String[] {"East","South"},"");
	Room H2    = new Room("H2","Hallway",new String[] {"East","West"},"");
	Room H3    = new Room("H3","Hallway",new String[] {"East","South","West"},"");
	Room H4    = new Room("H4","Hallway",new String[] {"East","West"},"");
	Room H5    = new Room("H5","Hallway",new String[] {"East","South","West"},"");
	Room R1    = new Room("R1","Room",   new String[] {"West"},"");					
	
	//Row2
	Room H6    = new Room("H6","Hallway",new String[] {"North","South"},"");
	Room K1    = new Room("K1","Kitchen",new String[] {"East"},"");
	Room H7    = new Room("H7","Hallway",new String[] {"North","South","West"},"");
	Room R2    = new Room("R2","Room",   new String[] {"East"},"");
	Room H8    = new Room("H8","Hallway",new String[] {"North","East","South","West"},"");
	Room K2    = new Room("K2","Kitchen",new String[] {"West"},"");
	
	//Row3
	Room H9    = new Room("H9","Hallway", new String[] {"North","South"},"");
	Room C1    = new Room("C1","Closet",  new String[] {"East"},"");
	Room H10   = new Room("H10","Hallway",new String[] {"North","South","West"},"");
	Room R11   = new Room("R11","Room",   new String[] {"East"},"");
	Room H11   = new Room("H11","Hallway",new String[] {"North","East","South","West"},"");
	Room R12   = new Room("R12","Restaurant",   new String[] {"North","West"},"");						

	//Row4
	Room H12   = new Room("H12","Hallway",new String[] {"North","East","South"},"");
	Room R13   = new Room("R13","Room",   new String[] {"West"},"");
	Room H13   = new Room("H13","Hallway",new String[] {"North","South"},"");
	Room R14   = new Room("R14","Room"   ,new String[] {"East"},"");
	Room H14   = new Room("H14","Hallway",new String[] {"North","East","South","West"},"");
	Room R15   = new Room("R15","Room"   ,new String[] {"West"},"");
	
	//Row5
	Room H15   = new Room("H15","Hallway",new String[] {"North","East","South"},"");
	Room R16   = new Room("R16","Room"   ,new String[] {"West"},"");				
	Room H16   = new Room("H16","Hallway",new String[] {"North","East","South"},"");
	Room C2    = new Room("C2","Closet"  ,new String[] {"West"},"");
	Room H17   = new Room("H17","Hallway",new String[] {"North","East","South"},"");
	Room C3    = new Room("C3","Closet"  ,new String[] {"West"},"");
	
	//Row6
	Room H18   = new Room("H18","Hallway",new String[] {"North","East"},"");
	Room H19   = new Room("H19","Hallway",new String[] {"East","West"},"");
	Room Lobby = new Room("Lobby","Lobby",new String[] {"North","East","South","West"},"");
	Room H20   = new Room("H20","Hallway",new String[] {"East","West"},"");
	Room H21   = new Room("H21","Hallway",new String[] {"North","East","West"},"");
	Room B1    = new Room("B1","Ballroom",new String[] {"West"},"");
	
	//Constructor -- Just the size for now it can be changed at any time
	public Hotel()
	{
		Room[][] hotel = 
		{
				{H1,  H2,  H3,    H4,  H5,  R1 },
			    {H6,  K1,  H7,    R2,  H8,  K2 },
			    {H9,  C1,  H10,   R11, H11, R12},
			    {H12, R13, H13,   R14, H14, R15},
			    {H15, R16, H16,   C2,  H17, C3 },
			    {H18, H19, Lobby, H20, H21, B1 },
		};
		Hotel = hotel;
	}
}
