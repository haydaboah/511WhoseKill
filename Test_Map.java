
public class Test_Map {

	
	public static void main(String[] args)
	{
		Hotel hotel = new Hotel();
		
		//Create Map
		Map map = new Map(hotel);
		
		//System.out.println(map.map);
		
		//testing visited and in_room values
		hotel.Hotel[0][0].visited = true;
		hotel.Hotel[0][0].in_room = true;
		hotel.Hotel[0][1].in_room = true;
		hotel.Hotel[0][2].visited = true;
		
		hotel.Hotel[0][3].crime = true;
		
		hotel.Hotel[0][4].crime = true;
		hotel.Hotel[0][4].visited = true;
		
		hotel.Hotel[0][5].crime = true;
		hotel.Hotel[0][5].visited = true;
		hotel.Hotel[0][5].in_room = true;
		
		//Changing room values after map creation
		hotel.Hotel[1][0].visited = true;
		//System.out.println(map.map);
		
		//Updating map after a room value was changed once map was created
		map.Update_Map(hotel);
		
		//new map after value change
		System.out.println(map.map);
		
		Room[] test_row = hotel.Hotel[0];
		
		Room X = test_row[0];
		
		/*System.out.println(X.visited_room_text);
		X.Pick_Visited_Text();
		System.out.println(X.visited_room_text);*/
		
		System.out.println(hotel.Hotel[0][5].crime_text);
	}
	
}
