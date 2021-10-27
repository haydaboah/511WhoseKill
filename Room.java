import java.util.*;

public class Room {

	//Room info
	boolean visited=false, crime=false, in_room=false;
	boolean searched=false;
	boolean locked=true;
	String initial_text 		= "Place Holder unvisited room text";
	String crime_text 			= "Place Holder Crime room text";
	String visited_room_text    = "Place Holder visited room text";
	String visited_crime_text	= "Place Holder visited crime room text";
	Evidence Evidence = null;
	String[] door_location;
	boolean hasNPC = false;			//Hayden addition
	boolean hasEvidence = false;	//Hayden addition
	NPC npc = null;					//Hayden addition
	boolean isPrivate, isPublic, isLobby; //Hayden additions
	//
	
	//Door location(s)
	boolean door_north=false, door_east=false, door_south=false, door_west=false;
	
	//List of npcs in a room. Will most likely be one but just in case you can add more to a room
	ArrayList <NPC> npcs = new ArrayList<NPC>();
	
	//Basic room info
	String room_name;
	String room_type;
	
	//Room constructor if hard code is needed
	public Room(String rn, String it, String ct, String vrt, String vct, String[] dr)
	{
		room_name = rn;			//EX: r1 (room 1), Lobby, Kitchen etc.
		initial_text = it;
		crime_text = ct;
		//visited_room_text = vrt;
		//visited_crime_text = vct;
		
		//setting doors
		for(String s : dr)
		{
			if(s.equals("North"))
				door_north = true;
			if(s.equals("East"))
				door_east = true;
			if(s.equals("South"))
				door_south = true;
			if(s.equals("West"))
				door_west = true;
		}
	}
	
	//Room constructor
	public Room(String rn, String rt, String[] dr, String dm, boolean isPrivate, boolean isPublic, boolean isLobby)
	{
		this.isPrivate = isPrivate;		//Hayden addition
		this.isPublic = isPublic;		//Hayden addition
		room_name = rn;
		room_type = rt;
		Set_Overall_Text(dm);
		
		if(!dm.equals(""))
			crime = true;
		
		//Unlockes room that isn't of priv room type
		if(!rt.equals("Room"))
			this.locked = false;
		

		door_location = dr;
		
		//setting doors
		for(String s : dr)
		{
			if(s.equals("North"))
				door_north = true;
			if(s.equals("East"))
				door_east = true;
			if(s.equals("South"))
				door_south = true;
			if(s.equals("West"))
				door_west = true;
		}
	}
	
	//Setting of text
	//---Just add more Strings of each type if more rooms are created
	//Should set text after crime room is figured out
	public void Set_Overall_Text(String dm)
	{
		//Initial text
		//String IRT  = "IRT";	//Room
		String IRT = 	"Each guest room has a simple assortment of furniture including a bed, nightstands, electric lamps, and a small sitting area. "+ 
						"They are well maintained and the sheets are expertly folded although faint hints of humanity seep through; an evening gown left crumpled on the floor or a dark liquid stain speak for the inhabitants.";
		
		//String ILT  = "ILT";	//Lobby
		String ILT = 	"This is the front of the hotel, the first thing every visitor sees. Lackadaisical ferns in garish pots chafe against the edges of the walls. " + 
						"The ceiling was originally painted with heavenly artwork, but smoke has yellowed the art to a dimmer shade.  The front desk is a wide brown bar in need of refinishing that commands the view across a brickwork floor colored dull green. " + 
						"The clerk looks up briefly toward you, then down again without much attention.";
		
		//String IHT  = "IHT";	//Hallway
		String IHT = 	"The hotel hallways are identical but not monotonous with well worn carpets and odd paintings of classical scenes. " + 
						"There are small plants throughout the building and the occasional window.";
		
		//String IKT  = "IKT";	//Kitchen
		String IKT =    "The hotel kitchen is an industrial operation with multiple ovens, several sinks, and a canopy of pots and pans. One of those newfangled electric ice boxes is in the corner. " + 
						"It appears spotless from the doorway, but upon closer inspection you see spots in the dishes and grime in the cracks of the floor.";
		
		//String IRrT = "IRrT";	//Restaurant
		String IRrT = 	"The dining room is a busy looking space with too many chairs and too few servers. The scent of this morning’s breakfast still carries from dishes left on a nearby table. " + 
						"Along the far wall you can see a conspicuously empty bar. Its great length is adorned by a single coffee machine; the shelves behind it are bare and dusty.";  
		
		//String ICT  = "ICT";	//Closet
		String ICT  = 	"This supply closet holds utilities for the cleaning and maintenance staff. It reeks of chemicals and moldy mop heads.";
		
		//String IBrT = "IBrT";	//Ballroom
		String IBrT = 	"The great space before you is warm and wide. The walls are punctuated by faux columns and friezes of dancing ladies. The chipped paint lends the room the aspect of an ancient ruin, but you think it\'s an unintentional effect. " + 
						"Scuff marks against the wall speak volumes about how well the room is actually maintained.";
		
		
		
		/*********************Crime Text**************************/
		
		String crime_text_Shot   	= 	"From the door your eyes are drawn to a body slumped against the wall. A curtain of blood hangs over it and a constellation of five holes stare back at you from the victim\'s chest. " + 
										"Aside from the tragic work in front of you, the rest of the room seems undisturbed. The coroner stands above the body, chewing on his pencil as if nothing is out of the ordinary.";
		
		String crime_text_Stabbed 	= 	"The crime scene is a bloody mess. The hapless victim lies on the floor with half a knife blade still poking from their chest. " + 
										"There’s blood on the walls, the ceiling, in the tiny spaces between things and even in the air like a faint, copper scented perfume. The coroner whistles for your attention and beckons you to him.";
		
		String crime_text_Strangled = 	"You approach the crime scene with some difficulty. The whole room has been tossed and broken furniture blocks a clear path to the body. " + 
										"The coroner kneels by the victim – a poor figure who’s face is the perfect picture of agony – and consults and notebook.";
		
		String crime_text_Possessed = 	"The air is wrong. The walls seem to slant when you are not looking directly at them. The coroner refuses to enter the crime scene and instead stands by the door muttering to himself. " + 
										"As for the victim…it pains you to think how their limbs came to settle that way or what force could have made their head turn that many times.";
		
		/*********************/
		
		/*********************Visited Crime Text******************/
		
		String visited_crime_text_Shot 		= "This is the scene of the crime. It remains much the same as it was when you were last here.";
		
		String visited_crime_text_Stabbed 	= "This is the scene of the crime. The blood seems less red now.";
		
		String visited_crime_text_Strangled = "This is the scene of the crime. The coroner has carefully cleared a path through the room for you.";
		
		String visited_crime_text_Possessed = "This is the scene of the crime. You hear a noise but can’t identify where it came from.";
		
		/*********************/
		
		//Crime text -- Room
		String CRT  = "CRT";
		
		if(dm.equals("shot"))
			CRT = crime_text_Shot;
		if(dm.equals("stabbed"))
			CRT = crime_text_Stabbed;
		if(dm.equals("strangled"))
			CRT = crime_text_Strangled;
		if(dm.equals("possessed"))
			CRT = crime_text_Possessed;
		
		
		//Visited crime text -- Room
		String VCRT  = "VCRT";
		
		if(dm.equals("shot"))
			VCRT = visited_crime_text_Shot;
		if(dm.equals("stabbed"))
			VCRT = visited_crime_text_Stabbed;
		if(dm.equals("strangled"))
			VCRT = visited_crime_text_Strangled;
		if(dm.equals("possessed"))
			VCRT = visited_crime_text_Possessed;

		
		//Setting text for Room
		if(room_type.equals("Room"))
		{
			initial_text = IRT;
			visited_room_text = Pick_Text(visited_text_Room);
			crime_text = CRT;
			visited_crime_text = VCRT;
		}
		
		//Setting text for Lobby
		if(room_type.equals("Lobby"))
		{
			initial_text = ILT;
			visited_room_text = Pick_Text(visited_text_Lobby);
			//crime_text = CLT;
			//visited_crime_text = VCLT;
		}
		
		//Setting text for Hallway
		if(room_type.equals("Hallway"))
		{
			initial_text = IHT;
			visited_room_text = Pick_Text(visited_text_Hallway);
			//crime_text = CHT;
			//visited_crime_text = VCHT;
		}
		
		//Setting text for Kitchen
		if(room_type.equals("Kitchen"))
		{
			initial_text = IKT;
			visited_room_text = Pick_Text(visited_text_Kitchen);
			//crime_text = CKT;
			//visited_crime_text = VCKT;
		}
		
		//Setting text for Restaurant
		if(room_type.equals("Restaurant"))
		{
			initial_text = IRrT;
			visited_room_text = Pick_Text(visited_text_Restaurant);
			//crime_text = CRrT;
			//visited_crime_text = VCRrT;
		}
		
		//Setting text for Closet
		if(room_type.equals("Closet"))
		{
			initial_text = ICT;
			visited_room_text = Pick_Text(visited_text_Closet);
			//crime_text = CCT;
			//visited_crime_text = VCCT;
		}
		
		//Ballroom
		if(room_type.equals("Ballroom"))
		{
			initial_text = IBrT;
			visited_room_text = Pick_Text(visited_text_Ballroom);
			//crime_text = CBrT;
			//visited_crime_text = VCBrT;
		}
	}
	
	String[] visited_text_Room = 
		{
			"This room has a faint odor.",
			"The guest room is void of interest.",
			"A collection of coins is scattered across the guest room coffee table. You think it best not to touch them.",
			"A maid is in the process of cleaning the room when you enter. She makes a faint squeak when she sees you.",
			"The window in this room is open. You hear bleating car horns and the faint notes of an argument."
		};
	
	//Lobby text
	String[] visited_text_Lobby =
		{
			"The hotel lobby, it smells like old cigars and the street.",
			"The hotel lobby, you\'ve been here before.",
			"This is the hotel lobby. Is it chilly or is it just you?"
		};
	
	//Hallway text
	String[] visited_text_Hallway =
		{
			"The hallway is long and seems to extend as you walk forward.",
			"You step into the hallway. An oil painting of dogs re-enacting Washington Crossing the Delaware greets you.",
			"A door opens as you walk by. It closes firmly when you look toward it.",
			"The hallway looks the same as all the others.",
			"This hallway looks the same as all the others, but a strange emptiness hangs about this section.",
			"Your feet ache from all this walking.",
			"The hallway smells clean. Too clean.",
			"The sound of whispers comes from behind a door. \"Be quiet,\" someone says.",
			"You pass a guest in the hall. They hold something behind them. When you glance back, their hands are in front of their person.",
			"You sense someone behind you and turn around. The Stoic Goon waves and disappears around a corner."
		};
	
	//Kitchen text
	String[] visited_text_Kitchen =
		{
			"The kitchen is quiet, save for a lone dishwasher scrubbing leisurely at his station.",
			"The lunchtime rush will be hitting, soon, but no one seems to be preparing food.",
			"This is the kitchen."
		};
	
	//Restaurant text
	String[] visited_text_Restaurant =
		{
			"The dining room is empty of people. You hear a faint skittering sound.",
			"A server welcomes you at the door and informs you that there is no lunch service today.",
			"This is the dining room. You know that.",
			"In the dining room, you notice a stray glass. It stinks of hooch."
		};
	
	//Closet text
	String[] visited_text_Closet =
		{
			"The closet seems ill-stocked. The maids must have just gone out.",
			"There is an empty bottle on the shelf. There is no label and the drops of liquid at the bottom are dark.",
			"A clothes hamper with someone’s intimates sits in the middle of the closet."
		};
	
	//Ballroom text -- still need text
	String[] visited_text_Ballroom =
		{
			"It smells like mold in here.",
			"The dance floor creaks underfoot"
		};

	//***********************Setters***********************//
	//Some of these aren't needed but are her just in case
	//Set boolean visited to true if the player has entered the room
	public void Room_Visited()
	{
		visited = true;
	}
	
	//Set boolean searched to true if the player searches the room
	public void Searched()
	{
		searched = true;
	}
	
	//Set boolean crime to true if this is the crime room
	public void Set_Crime_Value()
	{
		crime = true;
	}
	
	//Keeps track if the player is in this room 
	public void In_Room_Value(boolean b)
	{
		in_room = b;
	}
	
	//Set initial room entrance text
	public void Set_Initial_Text(String s)
	{
		initial_text = s;
	}
	
	//Set room evidence text
	public void Set_Evidence_Text(String s)
	{
		crime_text = s;
	}
	
	//Set room evidence
	public void Set_Evidence(Evidence ev)
	{
		Evidence = ev;
	}
	
	//Add npc to the room
	public void Add_NPC(NPC npc)
	{
		npcs.add(npc);
	}
	
	//Remove npc from the room
	public void Remove_NPC(NPC npc)
	{
		npcs.remove(npc);
	}

	//Pick text
	public String Pick_Text(String[] s)
	{
		Random rn = new Random();
		int num = rn.nextInt(s.length);
		return s[num];
	}
	
	//Print text -- test
	public String Print_Text()
	{
		if(!this.visited)
		{
			return this.initial_text;
		}
		else
		{
			if(this.room_type.equals("Room")) {
				this.visited_room_text = Pick_Text(visited_text_Room);
				//return Pick_Text(visited_text_Room);
				return this.visited_room_text;}
			
			if(this.room_type.equals("Lobby")) {
				this.visited_room_text = Pick_Text(visited_text_Lobby);
				//return Pick_Text(visited_text_Lobby);
				return this.visited_room_text;}
			
			if(this.room_type.equals("Hallway")) {
				this.visited_room_text = Pick_Text(visited_text_Hallway);
				//return Pick_Text(visited_text_Hallway);
				return this.visited_room_text;}
			
			if(this.room_type.equals("Kitchen")) {
				this.visited_room_text = Pick_Text(visited_text_Kitchen);
				//return Pick_Text(visited_text_Kitchen);
				return this.visited_room_text;}
			
			if(this.room_type.equals("Restaurant")) {
				this.visited_room_text = Pick_Text(visited_text_Restaurant);
				//return Pick_Text(visited_text_Restaurant);
				return this.visited_room_text;}
			
			if(this.room_type.equals("Closet")) {
				this.visited_room_text = Pick_Text(visited_text_Closet);
				//return Pick_Text(visited_text_Closet);
				return this.visited_room_text;}
			
			if(this.room_type.equals("Ballroom")) {
				this.visited_room_text = Pick_Text(visited_text_Ballroom);
				//return Pick_Text(visited_text_Ballroom);
				return this.visited_room_text;}
			else
				return "ERROR from Visited Text setter";
		}
			
	}
	
	public String Print_Crime_Text()
	{
		if(!this.visited)
			return this.crime_text;
		else
			return this.visited_crime_text;	
	}
	
	
	//Sets visited_room_text to a random string -- might not need this
	public void Pick_Visited_Text()
	{
		Random rn = new Random();
		
		if(this.room_type.equals("Room"))
		{
			int num = rn.nextInt(visited_text_Room.length);
			visited_room_text = visited_text_Room[num];
		}
		if(this.room_type.equals("Hallway"))
		{
			int num = rn.nextInt(visited_text_Hallway.length);
			visited_room_text = visited_text_Hallway[num];
		}
		if(this.room_type.equals("Lobby"))
		{
			int num = rn.nextInt(visited_text_Lobby.length);
			visited_room_text = visited_text_Lobby[num];
		}
		if(this.room_type.equals("Kitchen"))
		{
			int num = rn.nextInt(visited_text_Kitchen.length);
			visited_room_text = visited_text_Kitchen[num];
		}
		if(this.room_type.equals("Restaurant"))
		{
			int num = rn.nextInt(visited_text_Restaurant.length);
			visited_room_text = visited_text_Restaurant[num];
		}
		if(this.room_type.equals("Closet"))
		{
			int num = rn.nextInt(visited_text_Closet.length);
			visited_room_text = visited_text_Closet[num];
		}
		if(this.room_type.equals("Ballroom"))
		{
			int num = rn.nextInt(visited_text_Ballroom.length);
			visited_room_text = visited_text_Ballroom[num];
		}
	}
	
	//Returns a String list of all npcs' names in room 
	public String[] NPC_In_Room()
	{
		String[] npc = new String[npcs.size()];
		
		int index = 0;
		for(NPC np : npcs)
		{
			npc[index] = np.getCharName();
			index++;
		}
		
		return npc;
	}
		
	//ToString - for testing rn
	public String toString()
	{
		String s = "Room: " + room_name + "\nPeople: ";
		
		for(NPC np : npcs)
		{
			String temp = np.getCharName();
			s = s + temp + " ";
			//s = s + temp + " " + initial_text;
		}
		
		return s;
	}

	//getter for hasNPC
	public boolean getHasNPC() {					//Hayden addition
		return hasNPC;
	}

	//setter for hasNPC
	public void setHasNPC(Boolean hasNPC) {			//Hayden addition
		this.hasNPC = hasNPC;
	}

	//getter for hasEvidence
	public boolean getHasEvidence() {				//Hayden addition
		return hasEvidence;
	}

	//setter for hasEvidence
	public void setHasEvidence(Boolean hasEvidence) {//Hayden addition
		this.hasEvidence = hasEvidence;
	}

	public NPC getNPC() {
		return npc;
	}

	public void setNPC(NPC npc) {
		this.npc = npc;
		
		//unlocks room
		this.locked = false;
	}
		
}