package javagame;

public class Missle 
{
	float blastY=503;
	float blastX1=30;
	float blastX2=60;
	public void setBlastX1(float fl)
	{
		blastX1+=fl;
	}
	public void setBlastX2(float fl)
	{
		blastX2+=fl;
	}
	public void setBlastY(float fl)
	{
		blastY=fl;
	}
	public float getBlastX1()
	{
		return blastX1;
	}
	public float getBlastX2()
	{
		return blastX2;
	}
	public float getBlastY()
	{
		return blastY;
	}
}
