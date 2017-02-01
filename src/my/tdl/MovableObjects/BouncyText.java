package my.tdl.MovableObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import my.project.gop.main.Vector2F;

public class BouncyText {
	
	private String text;
	Vector2F pos = new Vector2F();
	
	private boolean isAlive;
	private boolean jump;
	private boolean right;
	private boolean left;
	
	private float lifeTime = 1;
	private float maxUp = 2.5f;
	private float currUp;

	public BouncyText(float xpos, float ypos, String text) {
		this.pos.xpos = xpos;
		this.pos.ypos = ypos;
		this.text = text;
		isAlive = true;
		jump = true;
		Random ran = new Random();
		int rans = ran.nextInt(2);
		switch(rans){
		case 0:
			right = true;
			left = false;
			break;
		case 1:
			right = false;
			left = true;
			break;
		}
	}
	public void tick(){
		if(isAlive){
			if(lifeTime != 0){
				lifeTime -= 0.01;
			}
			if(lifeTime <= 0){
				isAlive = false;
			}
			if(jump){
				if(currUp != maxUp){
					currUp += 0.2;
					pos.ypos -= currUp;
				}
				if(currUp >= maxUp){
					jump = false;
				}
				if(right){
					pos.xpos += currUp * new Random().nextFloat()*maxUp * 2;
				}
				if(left){
					pos.xpos -= currUp * new Random().nextFloat()*maxUp * 2;
				}
			}
			if(!jump){
				if(currUp != 0){
					currUp -= 0.1;
					pos.ypos += currUp;
				}
				if(currUp <= 0){
					maxUp -= 0.2;
					jump = true;
				}
			}
		}else{
			if(this != null){
				PlayerStats.list.remove(this);
			}
		}
		
	}
	public void render(Graphics2D g){
		if(isAlive){
			g.setColor(Color.RED);
			g.drawString(text, pos.getWorldLocation().xpos, pos.getWorldLocation().ypos);
			g.setColor(Color.WHITE);
		}
	}
}
