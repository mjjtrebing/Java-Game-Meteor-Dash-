package javagame;

/*@author Matt Trebing
 * Play.java
 */
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.util.ArrayList;

public class Play extends BasicGameState
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
	boolean pause=false;
	boolean range=true;
	float time=1000;
	int timeCount=0;
	Animation bigBoom;
	Animation ship;
	Animation current;
	int[] dur={200,200,200,200};
	int[] dur2={1};
	Image endor;
	boolean plan=false;
	int pX=540;
	int pY=50;
	public Play(int state) throws SlickException
	{}
	
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		blasto1= new Image("res/NewBlast.png");
		blasto2= new Image("res/NewBlast.png");
		Y= new ArrayList<Float>();
		X1= new ArrayList<Float>();
		X2= new ArrayList<Float>();
		Image[] boom={new Image("res/BOOM/Boom1.png"),new Image("res/BOOM/Boom2.png"),new Image("res/BOOM/Boom3.png"),new Image("res/BOOM/Boom4.png")};
		Image[] shiP={new Image("res/Redship.png")};
		ship= new Animation(shiP,dur2,false);
		bigBoom=new Animation(boom, dur,false);
		current = ship;
		if(blastY==6)
		{
			blastY=503;
		}
	}
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException//render draws graphics
	{
		Image back = new Image("res/Sterwers.png");
		endor = new Image("res/Big Endor.png");
		Image eny= new Image("res/Small enemy.png");
		
		back.draw(xpos,ypos);
		current.draw(shipX,shipY);
		eny.draw(pX,pY);
		Input inp =gc.getInput();
		
		
		
		if(bool)
		{
			for(int i=0;i<count;i++)
			{
				
				blasto1.draw(X1.get(i), Y.get(i));
				blasto2.draw(X2.get(i), Y.get(i));
				//gc.sleep(100);
			}
		}
		
		
		
		if(inp.isKeyDown(Input.KEY_ESCAPE))
		{
			pause=true;
		}
		if(pause)
		{
			g.drawString("(PAUSED)", 500,300);
		}
		
		
		
		
		int yMouse=Mouse.getY()-660;
		int xMouse=Mouse.getX();
		yMouse=Math.abs(yMouse);
		String mouse = "Mousex: " +xMouse + "\nMouseY: " + yMouse;
		
		
		
		
		
		/*eny.draw(pX,pY);
		
		if(time<0&&timeCount<1)
		{
			System.out.print("TIME: ");
			timeCount++;
			time=1000;
			plan=true;
			
		}*/
		
		
		
		g.drawString(mouse, 0, 50);
	}
	
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException//updates imagery
	{
		Input inp =gc.getInput();
		
		time-=delta;
		if(plan)
		{
			
			pY=50;
			pX=540;
			
			pY-=delta */*0.000*/9f;
		}
		
		/*if(inp.isKeyDown(Input.KEY_K))
		{
			current=bigBoom;
			current.update(delta);
		}*/
		if(inp.isKeyPressed(Input.KEY_SPACE) || inp.isKeyPressed(Input.KEY_UP))
		{
			
			bool= true;
			X1.add(shipX+30);
			X2.add(shipX+60);
			Y.add((float) 503);
			count++;
			//}
		}
		if(inp.isKeyDown(Input.KEY_ESCAPE))
		{
			gc.pause();
			//g.drawString("(PAUSED)", 500,300);
		}
		if(inp.isKeyDown(Input.KEY_R))
		{
		
			gc.resume();
			pause=false;
		//g.clear();
		}
		
		pY += delta*0.009f;
		
		
		
		
		ypos += delta*0.009f;
		if(ypos==-700)
		{
			ypos=-4150;
		}
		
		
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
					
					
					Y.set(i,Y.get(i)-(delta * 1f));
					
					
					
				}
			}
		}
	}
	
	
	public int getID()
	{
		return 1;
	}
	
}
