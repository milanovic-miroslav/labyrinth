package my.tdl.generator;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import my.project.gop.main.Vector2F;
import my.tdl.main.Assets;

public class Block extends Rectangle {

	public Vector2F pos = new Vector2F();
	private int Blocksize = 48;
	private BlockType blocktype;
	private BufferedImage block;
	private boolean isSolid;
	private boolean isAlive;
	private boolean droped = false;
	
	public Block(Vector2F pos) {
		setBounds((int)pos.xpos, (int)pos.ypos, Blocksize, Blocksize);
		this.pos = pos;
		isAlive = true;
	}
	
	public Block(Vector2F pos, BlockType blocktype) {
		setBounds((int)pos.xpos, (int)pos.ypos, Blocksize, Blocksize);
		this.pos = pos;
		isAlive = true;
		this.blocktype = blocktype;
		init();
	}
	
	public Block isSolid(boolean isSolid){
		this.isSolid = isSolid;
		return this;
	}
	
	public void init(){
		switch(blocktype){
		case STONE_1:
			block = Assets.getStone_1();
			break;
			
		case WALL_1:
			block = Assets.getWall_1();
			break;
		 
		case BRICK_1:
			block = Assets.getBrick_1();
			break;
		}
	}
	public void tick(double deltaTime){
		if (isAlive){
		setBounds((int)pos.xpos, (int)pos.ypos, Blocksize, Blocksize);
	}
	}
	public void render (Graphics2D g){
		if (isAlive){
			if (block != null){
				g.drawImage(block, (int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, Blocksize, Blocksize, null);
			}else{
				g.fillRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, Blocksize, Blocksize);
			}
		// g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, Blocksize, Blocksize);
		
		if(isSolid){
			g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, Blocksize, Blocksize);
		//}else{
		//	if(!droped){
		//		float xpos = pos.xpos + 24 - 12;
		//		float ypos = pos.ypos + 24 - 12;
				
		//		Vector2F newpos = new Vector2F(xpos, ypos);
		//		World.dropBlockEntity(newpos, block);
				
		//		droped = true;
		}
		}
	}
	public enum BlockType{
		STONE_1,
		 WALL_1,
		 BRICK_1
	}
	public boolean isSolid() {
		return isSolid;
	}
	private boolean isAlive(){
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

//	public Object getBlockLocation() {
//		return null;
//`	}
}
