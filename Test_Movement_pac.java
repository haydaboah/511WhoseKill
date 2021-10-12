/*
 * This is a test of the Movement class.
 * You can move through the Hotel and whenever you enter a room that isn't a hallway or the lobby it will exit movement
 * Since this is only for movement then it will reset location by using Set_Loc() -- will move loc to middle of current row (so the Hallway)
 * Then it will call movement again
 */





public class Test_Movement_pac {
	
	public static void main(String[] args)
	{
		Movement Mov = new Movement();
		
		while(true)
		{
			Mov.Run();
			System.out.println("test of rerun of movement");
			System.out.println("Reseting location to previous room");   //Moves the current location to the middle of the current row since each room only connects to the middle room
			Mov.Set_Loc(Mov.loc[0],1);
		}
	}
}
