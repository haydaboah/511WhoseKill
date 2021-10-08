import java.util.Scanner;


public class Test_Movement {

	public static void main(String[] args)
	{
		Hotel hotel = new Hotel();
		Map Map = new Map(hotel);
		
		//map start
		int[] loc = {5,2};
		
		
		
		hotel.Hotel[5][2].Room_Visited();
		hotel.Hotel[5][2].In_Room_Value(true);
		
		//hotel.Hotel[][].crime = true;
		
		Scanner s = new Scanner(System.in);
		
		String input = "";
		//int[] previousLoc = loc;

		
		System.out.println("Starting text\nYou start in the Lobby: \n");
		
		System.out.println(hotel.Hotel[5][2].initial_text);
		
		System.out.print("\n- If you wish to get a better view of the Hotel pull up the map\nCommand: ");
		//System.out.println("m - Map | n - Movements");
		//System.out.print("Select: ");

		//While loop testing -- Movement -- main loop
		while(!input.equals("q"))
		{
			
			Map.Update_Map(hotel);
			
			//System.out.print("\n- If you wish to get a better view of the Hotel pull up the map\nCommand: ");
			System.out.println("m - Map | n - Movements | q - Quit");
			System.out.print("Select: ");
			
			input = s.nextLine();
			
			if(input.equals("m"))
			{
				System.out.println(Map.map);
				System.out.println();
			}
			
			//Movements
			if(input.equals("n"))
			{
				String mov = "";
				while(!mov.equals("b"))
				{
					//Store previous location
					//int[] previousLoc = new int[2];
					
					System.out.println("1 - UP | 2 - RIGHT | 3 - DOWN | 4 - LEFT | b - BACK");
					mov = s.nextLine();
					System.out.println("");
					//--up
					if(mov.equals("1"))
					{
						int y = loc[0];

						hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);
						
						y--;
						loc[0] = y;
					}
					//--right
					if(mov.equals("2"))
					{
						int x = loc[1];

						hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);
						
						x++;
						loc[1] = x;
					}
			
					//--down
					if(mov.equals("3"))
					{
						int y = loc[0];

						hotel.Hotel[loc[0]][loc[1]].In_Room_Value(false);
						
						y++;
						loc[0] = y;
					}
			
					//--left
					if(mov.equals("4"))
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
					
					//New room
					//print text first then set visit to true
					Room currRoom = hotel.Hotel[loc[0]][loc[1]];
					
					if(!currRoom.crime)
						System.out.println(currRoom.Print_Text());
					else
						System.out.println(currRoom.Print_Crime_Text());
					
					
					Map.Update_Map(hotel);
					
					//in the room loop
					String inroom = "";
					while(!inroom.equals("b") & !currRoom.room_type.equals("Hallway"))
					{
						if(!currRoom.searched)
							System.out.println("1 - SEARCH | b - BACK TO MOVMENT");
						else
							System.out.println("1 - SEARCH AGAIN | b - BACK TO MOVMENT");
						
						inroom = s.nextLine();
						
						if(inroom.equals("1"))
						{
							if(currRoom.visited)
								System.out.println("You've already completted a thourgh search of this room");
							else
							{
								System.out.println("Seaching room");
								currRoom.Searched();
								currRoom.Room_Visited();
							}
						}
					}
					
					//Update value of new room location
					currRoom.Room_Visited();						//New room visited value true
					currRoom.In_Room_Value(true); 					//New room (in) value true
					
				}
			}
			
		 }
			
		
		
	}
	
}
