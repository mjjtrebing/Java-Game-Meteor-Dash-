package javagame;

/*@author Matt Trebing
 * 
 * Menu.java
 */

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState
{
	int yMouse;
	int xMouse;
	
	
	
	public Menu(int state)
	{}

	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException//initially draws things on the screen
	{
		Image title = new Image("res/Title screen.png");
		title.draw(0,0);
		yMouse=Mouse.getY()-660;
		xMouse=Mouse.getX();
		yMouse=Math.abs(yMouse);
		String mouse = "MouseX: " +xMouse + "\nMouseY: " + yMouse;
		
		
		g.drawString(mouse, 0, 50);
		Image cat = new Image("res/NyanCat.png");
		//cat.draw(30,40);
		
		Image start = new Image("res/Mars.png");
		start.draw(250,280);
		g.drawString("////START\\\\\\\\",282, 355);
		
		Image exit = new Image("res/Socar.png");
		exit.draw(650,280);
		g.drawString("EXIT",699, 335);
		
		Image how2 = new Image("res/PSaturn.png");
		how2.draw(820,100);
		g.drawString("How to \n play",915, 170);
		
		Image options = new Image("res/Earth.png");
		options.draw(50,250);
		g.drawString("Options",90, 315);
	}
	
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException//updates imagery
	{
		Input inp =gc.getInput();
		
		if(xMouse>=250 && xMouse<=433 && xMouse>=285 && xMouse<=465)
		{
			if(inp.isMouseButtonDown(0))
			{
				sbg.enterState(1);
			}
		}
		
		if(yMouse>=280 && yMouse<418 &&xMouse>658 && xMouse<790)
		{
			if(inp.isMouseButtonDown(0))
			{
				System.exit(0);
			}
		}
		if(xMouse>890 && xMouse<1006 && yMouse>128 &&yMouse<248)
		{
			if(inp.isMouseButtonDown(0))
			{
				sbg.enterState(2);
			}
		}
		
		
	}
	
	
	public int getID()
	{
		return 0;
	}
	
}
