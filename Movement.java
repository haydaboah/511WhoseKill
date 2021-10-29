import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Movement {

	//Creation of the Hotel and Map
	static Hotel hotel;
	static Map Map;
	
	//Start location
	int[] loc = {5,1};
	
	//Keep track of current possible moves
	String[] currMov = {"","","","",""};
	String[] lockedMov = {"",""};
	
	//locked room text
	String[] locked_text_Room =
		{
			"Locked 1",
			"Locked 2",
			"Locked 3"
		};
	
	//Variables
	boolean intro = false;

	public Room CurrentLocation()
    {
        return hotel.Hotel[loc[0]][loc[1]];
    }
	
	public Movement(Hotel hotel)
	{
		this.hotel = hotel;						//Hayden addition
		Map = new Map(hotel);					//Hayden addition
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
	
	//used for locked room random string
	public String Pick_Text(String[] s)
	{
		Random rn = new Random();
		int num = rn.nextInt(s.length);
		return s[num];
	}

	//Priority Function
	public void Run()
	{
		Scanner s = new Scanner(System.in);
		String input = "";
		boolean loop = true; //Hayden Addition
		
		//Intro text
		if(!intro)
		{
			System.out.println("You start in the Lobby: \n");
			System.out.println(hotel.Hotel[5][1].initial_text);
			intro = true;
		}
		
		//Main While loop
		while(loop == true)
		{
			//Resets Current possible move list to blanks
			int index = 0;
			int lockedindex = 0;
			for(String cm : currMov)
			{
				cm = "";
				currMov[index] = cm;
				index++;
			}
			
			Map.Update_Map(hotel);
			System.out.println(Map.map);

			Room currRoom = hotel.Hotel[loc[0]][loc[1]];
            String direction = "";
            
            //For direction checker
            index = 0;
            lockedindex = 0;

            //Creates the options for movement to be shown to player
            for(String d : currRoom.door_location)
            {
            	//To - Up
                if(d.equals("North")) {
                    direction += "W - UP ";
                    
                    if(hotel.Hotel[loc[0]-1][loc[1]].locked & !hotel.Hotel[loc[0]-1][loc[1]].crime) {
                    	direction += "-Locked- ";
                    	lockedMov[lockedindex] = "w";
                    	lockedindex++;}
                    else
                    	currMov[index] = "w";
                    
					direction += "(" + hotel.Hotel[loc[0]-1][loc[1]].room_type + ") | ";
					//currMov[index] = "w";
					}
                
                //To - Left
				if(d.equals("West"))  {
					direction += "A - LEFT ";
					
					if(hotel.Hotel[loc[0]][loc[1]-1].locked & !hotel.Hotel[loc[0]][loc[1]-1].crime) {
                    	direction += "-Locked- ";
                    	lockedMov[lockedindex] = "a";
                    	lockedindex++;}
					else
						currMov[index] = "a";
					
					direction += "(" + hotel.Hotel[loc[0]][loc[1]-1].room_type + ") | ";
					//currMov[index] = "a";
					}
				
				//To - Down
				if(d.equals("South")) {
					direction += "S - DOWN ";
					
					if(hotel.Hotel[loc[0]+1][loc[1]].locked & !hotel.Hotel[loc[0]+1][loc[1]].crime) {
                    	direction += "-Locked- ";
                    	lockedMov[lockedindex] = "s";
                    	lockedindex++;}
					else
						currMov[index] = "s";
					
					direction += "(" + hotel.Hotel[loc[0]+1][loc[1]].room_type + ") | ";
					//currMov[index] = "s";
					}
				
				//To - Right
				if(d.equals("East"))  {
					direction += "D - RIGHT ";
					
					if(hotel.Hotel[loc[0]][loc[1]+1].locked & !hotel.Hotel[loc[0]][loc[1]+1].crime) {
                    	direction += "-Locked- ";
                    	lockedMov[lockedindex] = "d";
                    	lockedindex++;}
					else
						currMov[index] = "d";
					
					direction += "(" + hotel.Hotel[loc[0]][loc[1]+1].room_type + ") | ";
					//currMov[index] = "d";
					}
				index++;
			}
            //Don't really need anymore
			//direction += "B - BACK";
            
            if(currRoom.room_type.equals("Lobby")) {
            	direction += "B - Linger";
            }
			
			currMov[index] = "b";

			System.out.println(direction);

			input = s.nextLine();
			
			System.out.println("-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-\n");
			
			//catches if player picks a invalid direction
			boolean validmov = false;
			List<String> MovList = new ArrayList<>(Arrays.asList(currMov));
			List<String> LockedMovList = new ArrayList<>(Arrays.asList(lockedMov));
			while(!validmov)
			{	
				if(MovList.contains(input))
				{
					validmov = true;
					break;
				}
				else
				{
					//Prints out a String from the locked_text_Room list at random
					if(LockedMovList.contains(input))
						System.out.println(Pick_Text(locked_text_Room));
						
					System.out.print("\nPick a valid movement: ");
					input = s.nextLine();
					System.out.println("\n-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-\n");
				}
				
			}

			//Responding to input
			//--up
			if(input.equals("w"))
			{
				int y = loc[0];
				hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);	
				y--;
				loc[0] = y;
			}

			//--right
			if(input.equals("d"))
			{					
				int x = loc[1];
				hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);
				x++;
				loc[1] = x;
			}

			//--down
			if(input.equals("s"))
			{
				int y = loc[0];
				hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);			
				y++;
				loc[0] = y;
			}

			//--left
			if(input.equals("a"))
			{
				int x = loc[1];
				hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);
				x--;
				loc[1] = x;
			}

			//--back -- Linger
			if(input.equals("b")) {
				loop = false;
			}

			//Update map 
			currRoom = hotel.Hotel[loc[0]][loc[1]];
					
			//Print intro text of room
			if(!currRoom.crime)
				System.out.println(currRoom.Print_Text());
			else
				System.out.println(currRoom.Print_Crime_Text());
								
			//Set new room to visited and in room
			currRoom.Room_Visited();						
			currRoom.In_Room_Value(true);
								
			Map.Update_Map(hotel);
			
			if(currRoom.crime || currRoom.hasNPC || (currRoom.isPublic && !currRoom.isLobby))
			{
				break;
			}
								
			
		}
	}
}
				
	
	// public void Run()
	// {
	// 	Scanner s = new Scanner(System.in);
	// 	String input = "";
		
	// 	//Intro text
	// 	if(!intro)
	// 	{
	// 		System.out.println("You start in the Lobby: \n");
	// 		System.out.println(hotel.Hotel[5][1].initial_text);
	// 		System.out.print("\n- If you wish to get a better view of the Hotel pull up the map\nCommand: ");
	// 		intro = true;
	// 	}
		
	// 	//Main While loop
	// 	while(!input.equals("q"))
	// 	{
	// 		Map.Update_Map(hotel);
			
	// 		System.out.println("m - Map | n - Movements | q - Quit");
	// 		System.out.print("Select: ");
			
	// 		input = s.nextLine();
			
	// 		//m -- Map option
	// 		if(input.equals("m"))
	// 		{
	// 			System.out.println(Map.map);
	// 			System.out.println();
	// 		}
			
	// 		//Movements
	// 		if(input.equals("n"))
	// 		{
	// 			String mov = "";
	// 			//Direction control
	// 			while(!mov.equals("b"))
	// 			{
	// 				System.out.println("W - UP | A - LEFT  | S - DOWN | D - RIGHT | B - BACK");
	// 				mov = s.nextLine();
	// 				System.out.println("");
					
	// 				//--up
	// 				if(mov.equals("w"))
	// 				{
	// 					int y = loc[0];
	// 					hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);	
	// 					y--;
	// 					loc[0] = y;
	// 				}
	// 				//--right
	// 				if(mov.equals("d"))
	// 				{					
	// 					int x = loc[1];
	// 					hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);
	// 					x++;
	// 					loc[1] = x;
	// 				}
			
	// 				//--down
	// 				if(mov.equals("s"))
	// 				{
	// 					int y = loc[0];
	// 					hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);			
	// 					y++;
	// 					loc[0] = y;
	// 				}
			
	// 				//--left
	// 				if(mov.equals("a"))
	// 				{
	// 					int x = loc[1];
	// 					hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);
	// 					x--;
	// 					loc[1] = x;
	// 				}
					
	// 				//quit
	// 				if(mov.equals("b"))
	// 					break;
					
	// 				//Update map 
	// 				Room currRoom = hotel.Hotel[loc[0]][loc[1]];
					
	// 				//Print intro text of room
	// 				if(!currRoom.crime)
	// 					System.out.println(currRoom.Print_Text());
	// 				else
	// 					System.out.println(currRoom.Print_Crime_Text());
					
	// 				//Set new room to visited and in room
	// 				currRoom.Room_Visited();						
	// 				currRoom.In_Room_Value(true);
					
	// 				Map.Update_Map(hotel);
					
	// 				//If the room isn't a Hallway then break out of this
	// 				if(!currRoom.room_type.equals("Hallway") & !currRoom.room_type.equals("Lobby"))
	// 				{
	// 					break;
	// 				}
	// 			}
	// 		}
	// 		if(!hotel.Hotel[loc[0]][loc[1]].room_type.equals("Hallway") & !hotel.Hotel[loc[0]][loc[1]].room_type.equals("Lobby"))
	// 		{
	// 			break;
	// 		}
	// 	}
		//Set_Loc(loc[0],1);
		//s.close();
