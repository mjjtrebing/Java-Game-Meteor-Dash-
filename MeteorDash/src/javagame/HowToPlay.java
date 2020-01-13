package javagame;

/*@author Matt Trebing
 * Play.java
 */
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.util.ArrayList;

public class HowToPlay extends BasicGameState
{	
	float xpos=0;
	float ypos=-4150;
	float shipX=500;
	float shipY=500;
	Image blasto1;
	Image blasto2;
	float blastY=503;
	float blastX1=shipX+30;
	float blastX2=shipX+60;
	boolean bool=false;
	ArrayList<Float> Y;
	ArrayList<Float> X1;
	ArrayList<Float> X2;
	int count=0;
	public HowToPlay(int state) throws SlickException
	{}
	
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		blasto1= new Image("res/NewBlast.png");
		blasto2= new Image("res/NewBlast.png");
		Y= new ArrayList<Float>();
		X1= new ArrayList<Float>();
		X2= new ArrayList<Float>();
		
		
		
		if(blastY==6)
		{
			blastY=503;
		}
	}
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException//render draws graphics
	{
		Image back = new Image("res/Sterwers.png");
		Image ship = new Image("res/RedShip.png");
		back.draw(xpos,ypos);
		ship.draw(shipX,shipY);
		Input inp =gc.getInput();
		
		
		
		if(bool)
		{
			for(int i=0;i<count;i++)
			{
				blasto1.draw(X1.get(i), Y.get(i));
				blasto2.draw(X2.get(i), Y.get(i));
			}
		}
		
		
		
		
		
		
		
		
		
		int yMouse=Mouse.getY()-660;
		int xMouse=Mouse.getX();
		yMouse=Math.abs(yMouse);
		String mouse = "Mousex: " +xMouse + "\nMouseY: " + yMouse;
		
		
		///if(blastY==6)
		//{
			//blastY=503;
	//	}
		
		g.drawString(mouse, 0, 50);
	}
	
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException//updates imagery
	{
		Input inp =gc.getInput();
		
		if(inp.isKeyDown(Input.KEY_SPACE))
		{
			bool= true;
			X1.add(shipX+30);
			X2.add(shipX+60);
			Y.add((float) 503);
			count++;
		}
		
		
		
		
		
		ypos += delta*0.009f;
		
		if(shipX>=0)
		{
			if(inp.isKeyDown(Input.KEY_LEFT))
			{
				shipX-=delta *1f;
			}
		}
		if(shipX<975)
		{
			if(inp.isKeyDown(Input.KEY_RIGHT))
			{
			shipX+=delta *1f;
			}
		}
	//	if(blastY==6)
		//{
		//	blastY=503;
		//}
		if(bool)
		{
			for(int i=0;i<count;i++)
			{
				if(Y.get(i)>=-40)
				{
					
					
					//blastX1 -=delta * 0.9f;
					Y.set(i,Y.get(i)-(delta * 2f));
				}
			}
		}
	}
	
	
	public int getID()
	{
		return 2;
	}
	
}
