public class Map {
	
	public String map = "";
	
	//Constructor
	public Map(Hotel h)
	{
		Update_Map(h);
	}
	
	//Update Map values
	//Very similar to the Constructor
	public String Update_Map(Hotel h)
	{
		map = "";
		map += "=================\n";
		for(Room[] x : h.Hotel)
		{
			map += "|";
			for(Room y : x)
			{
				
				//Crime In_room Visited
				if(y.crime == true & y.in_room == true & y.visited == true)
				{
					if(y.room_type.equals("Restaurant"))
						map += "-^Rr*";
					else
						map += "-^" + y.room_type.charAt(0) +"* ";
					continue;
				}
				else if(y.crime == true & y.in_room == true)
				{
					if(y.room_type.equals("Restaurant"))
						map += " ^Rr*";
					else
						map += " ^" + y.room_type.charAt(0) +"* ";
					continue;
				}
				else if(y.crime == true & y.visited == true)
				{
					if(y.room_type.equals("Restaurant"))
						map += "-^Rr ";
					else
						map += "-^" + y.room_type.charAt(0) +"  ";
					continue;
				}
				
				//In_room Visited
				if(y.in_room == true & y.visited == true)
				{
					if(y.room_type.equals("Restaurant"))
						map += " -Rr*";
					else
						map += " -" +  y.room_type.charAt(0) +"* " ;
					continue;
				}
				
				if(y.crime == true)
				{
					if(y.room_type.equals("Restaurant"))
						map += " ^Rr ";
					else
						map += " ^" + y.room_type.charAt(0) +"  ";
					continue;
				}
				
				if(y.in_room == true)
				{
					if(y.room_type.equals("Restaurant"))
						map += "   Rr*";
					else
						map += "  " + y.room_type.charAt(0) +"* ";
					continue;
				}
				
				if(y.visited == true)
				{
					if(y.room_type.equals("Restaurant"))
						map += " -Rr ";
					else
						map += " -" + y.room_type.charAt(0) +"  ";
					continue;
				}
				
				else {
					if(y.room_type.equals("Restaurant"))
						map += "  Rr ";
					else  
						map += "  " + y.room_type.charAt(0) +"  ";}
			}
			map += "|\n";
		}
		map += "=================\n";
		map += "Key| * : Current Location\n";
		map += "   | - : Visited Location\n";
		map += "   | ^ : Crime   Location\n";
		return map;
	}
}