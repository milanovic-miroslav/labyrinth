package my.tdl.main;

import java.awt.Image;
import java.awt.image.BufferedImage;

import my.project.gop.main.SpriteSheet;
import my.project.gop.main.loadImageFrom;

public class Assets {
	SpriteSheet blocks = new SpriteSheet();
	public static SpriteSheet player = new SpriteSheet();
	
	public static BufferedImage stone_1;
	public static BufferedImage wall_1;
	public static BufferedImage brick_1;
	private static BufferedImage mouse_pressed;
	private static BufferedImage mouse_unpressed;
	private static BufferedImage button_heldover;
	private static BufferedImage button_notover;
	private static BufferedImage getUp;
	private static BufferedImage getDown;
	private static BufferedImage getLeft;
	private static BufferedImage getRight;
	private static BufferedImage getHealth;
	private static BufferedImage damaged;
	
	public void init(){
		
		blocks.setSpriteSheet(loadImageFrom.LoadImageFrom(Main.class, "spritesheet.png"));
		player.setSpriteSheet(loadImageFrom.LoadImageFrom(Main.class, "PlayerSheet.png"));
		
		stone_1 = blocks.getTitle(0, 0, 16, 16); // od 0-tog pixela u X osi slike "spritesheet"
		wall_1 = blocks.getTitle(16, 0, 16, 16); // od 16-tog pixela u X osi slike "spritesheet"
		brick_1 = blocks.getTitle(32, 0, 16, 16);
		
		mouse_pressed = player.getTitle(64+32+8, 8, 8, 8);
		mouse_unpressed = player.getTitle(64+32, 8, 8, 8);
		
		button_heldover = player.getTitle(64+64+32, 32, 48, 16);
		button_notover = player.getTitle(64+48, 32, 48, 16);
		
		getUp = player.getTitle(64+48, 0, 16, 8);
		getDown = player.getTitle(64+48, 8, 16, 8);
		getLeft = player.getTitle(64+64, 0, 8, 16);
		getRight = player.getTitle(64+64+8, 0, 8, 16);
		
		getHealth = player.getTitle(64+32, 25, 31, 7);
		
		damaged = player.getTitle(0, 48 , 16, 16);
	}
	public static BufferedImage getStone_1(){
		return stone_1;
	}
	public static BufferedImage getWall_1(){
		return wall_1;
	}
	public static BufferedImage getBrick_1(){
		return brick_1;
	}
	public static BufferedImage getMouse_pressed(){
		return mouse_pressed;
	}
	public static BufferedImage getMouse_unpressed(){
		return mouse_unpressed;
	}
	public static BufferedImage getButton_heldover(){
		return button_heldover;
	}
	public static BufferedImage getButton_notover(){
		return button_notover;
	}
	public static BufferedImage getUp_attack(){
		return getUp;
	}
	public static BufferedImage getDown_attack(){
		return getDown;
	}
	public static BufferedImage getRight_attack(){
		return getRight;
	}
	public static BufferedImage getLeft_attack(){
		return getLeft;
	}
	public static BufferedImage getHealth_g_bar() {
		return getHealth;
	}
	public static BufferedImage beingDamaged() {
		return damaged;
	}
}
	
