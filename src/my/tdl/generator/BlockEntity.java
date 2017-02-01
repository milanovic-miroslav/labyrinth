package my.tdl.generator;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import my.project.gop.main.Vector2F;

public class BlockEntity extends Rectangle {

	private Vector2F pos;
	private BufferedImage block_image;
	private double rotation;
	private double rotation_speed = 0.8;
	private double blockSize = 24;
	private boolean isAlive;
	private int lifeTime = 100;
	private boolean isDying;
	private float lifeFade = 1;
	
	public BlockEntity(Vector2F pos, BufferedImage block_image) {
		this.pos = pos;
		this.block_image = block_image;
		rotation = new Random().nextInt(180);
		lifeTime = new Random().nextInt(500);
			if(lifeTime < 300){
				lifeTime = new Random().nextInt(500);
			}
		setBounds((int)pos.xpos, (int)pos.ypos, (int)blockSize, (int)blockSize);
		isAlive = true;
	}
	public void tick(double deltaTime){
		if(isAlive){
		setBounds((int)pos.xpos, (int)pos.ypos, (int)blockSize, (int)blockSize);
		rotation -= rotation_speed;
		
		if(!isDying){
		if(lifeTime !=0){
			lifeTime--;
		}
		if(lifeTime ==0){
			isDying = true;
			World.removeDropedBlockEntity(this);
				}
			}
			if(isDying){
				if(lifeFade != 0.000010000){
					lifeFade -= 0.01;
				}
				
				if(lifeFade <= 0.000010000){
					// World.removeDropedEntity(this);
					isAlive = false;
				}
			}
		}
	}
	public void render(Graphics2D g){
		if(isAlive){
			
			if(isDying){

				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, lifeFade));
			}
			
		g.rotate(Math.toRadians(rotation), pos.getWorldLocation().xpos + blockSize / 2, pos.getWorldLocation().ypos + blockSize / 2);
		//################################## sve sto se rotira je unutra
		
		g.drawImage(block_image, (int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, (int) blockSize, (int) blockSize, null);
		g.drawRect((int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, (int) blockSize, (int) blockSize);
		
		//##################################
		
		
		g.rotate(-Math.toRadians(rotation), pos.getWorldLocation().xpos + blockSize / 2, pos.getWorldLocation().ypos + blockSize / 2);
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
		}
	}
	public Vector2F getPos(){
		return pos;
	}
	public void setPos(Vector2F pos){
		this.pos = pos;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
