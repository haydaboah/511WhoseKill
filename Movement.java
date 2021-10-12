import java.util.Scanner;

public class Movement {

	//Creation of the Hotel and Map
	static Hotel hotel = new Hotel();
	static Map Map = new Map(hotel);
	
	//Start location
	int[] loc = {5,1};
	
	//Variables
	boolean intro = false;
	
	public Movement()
	{
		hotel.Hotel[5][1].Room_Visited();
		hotel.Hotel[5][1].In_Room_Value(true);
	}
	
	//use this at the end of the main game loop -- Will set location back to the previous hallway
	public void Set_Loc(int r, int c)
	{
		hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);
		
		loc[0] = r;
		loc[1] = c;
		
		Room currRoom = hotel.Hotel[loc[0]][loc[1]];
		currRoom.Room_Visited();						
		currRoom.In_Room_Value(true);
		
	}
	
	public void Run()
	{
		Scanner s = new Scanner(System.in);
		String input = "";
		
		//Intro text
		if(!intro)
		{
			System.out.println("You start in the Lobby: \n");
			System.out.println(hotel.Hotel[5][1].initial_text);
			System.out.print("\n- If you wish to get a better view of the Hotel pull up the map\nCommand: ");
			intro = true;
		}
		
		//Main While loop
		while(!input.equals("q"))
		{
			Map.Update_Map(hotel);
			
			System.out.println("m - Map | n - Movements | q - Quit");
			System.out.print("Select: ");
			
			input = s.nextLine();
			
			//m -- Map option
			if(input.equals("m"))
			{
				System.out.println(Map.map);
				System.out.println();
			}
			
			//Movements
			if(input.equals("n"))
			{
				String mov = "";
				//Direction control
				while(!mov.equals("b"))
				{
					System.out.println("W - UP | A - LEFT  | S - DOWN | D - RIGHT | B - BACK");
					mov = s.nextLine();
					System.out.println("");
					
					//--up
					if(mov.equals("w"))
					{
						int y = loc[0];
						hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);	
						y--;
						loc[0] = y;
					}
					//--right
					if(mov.equals("d"))
					{					
						int x = loc[1];
						hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);
						x++;
						loc[1] = x;
					}
			
					//--down
					if(mov.equals("s"))
					{
						int y = loc[0];
						hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);			
						y++;
						loc[0] = y;
					}
			
					//--left
					if(mov.equals("a"))
					{
						int x = loc[1];
						hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);
						x--;
						loc[1] = x;
					}
					
					//quit
					if(mov.equals("b"))
						break;
					
					//Update map 
					Room currRoom = hotel.Hotel[loc[0]][loc[1]];
					
					//Print intro text of room
					if(!currRoom.crime)
						System.out.println(currRoom.Print_Text());
					else
						System.out.println(currRoom.Print_Crime_Text());
					
					//Set new room to visited and in room
					currRoom.Room_Visited();						
					currRoom.In_Room_Value(true);
					
					Map.Update_Map(hotel);
					
					//If the room isn't a Hallway then break out of this
					if(!currRoom.room_type.equals("Hallway") & !currRoom.room_type.equals("Lobby"))
					{
						break;
					}
				}
			}
			if(!hotel.Hotel[loc[0]][loc[1]].room_type.equals("Hallway") & !hotel.Hotel[loc[0]][loc[1]].room_type.equals("Lobby"))
			{
				break;
			}
		}
		//Set_Loc(loc[0],1);
		//s.close();
	}
	
	
}
