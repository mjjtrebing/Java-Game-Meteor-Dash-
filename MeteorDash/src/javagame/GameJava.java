package javagame;

/*@author Matt Trebing
 * GameJava.java
 */

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
//state based game has changing screens
public class GameJava extends StateBasedGame
{//fps counter comes by default
	public static String gameName = "Meteor Dash";
	public static int menu = 0;
	public static int play = 1;
	public static int play2 = 2;
	public static int play3 = 3;

	

	public GameJava(String gameName) throws SlickException
	{
		super(gameName);

		this.addState(new Menu(menu)); 
		this.addState(new Play(play));
		this.addState(new HowToPlay(play2));
		//this.addState(new Play(play3));
		
		
	}
	
	
	public void initStatesList(GameContainer gc) throws SlickException
	{
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);//initializes states
		this.getState(play2).init(gc, this);
		//this.getState(play3).init(gc, this);
		
		
		
		
		this.enterState(menu);
		
		gc.setVSync(true);                     // Turn VSync
		gc.setMaximumLogicUpdateInterval(800); // Max. 200 miliseconds can pass
		gc.setMinimumLogicUpdateInterval(10); 
	}
	
	

	public static void main(String[] args) 
	{
		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new GameJava(gameName));//what game will be in this window?
			appgc.setDisplayMode(1080, 660, false/*for full screen*/);//setting size
			appgc.start();
			
			
			
		}catch(SlickException e)
		{
			e.printStackTrace();
		}
		
	}
		
}


