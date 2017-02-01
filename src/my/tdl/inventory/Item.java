package my.tdl.inventory;

import java.awt.image.BufferedImage;

import my.tdl.main.Assets;

public enum Item {

	//RED_BALL("Red Ball", 1, Assets.getCorner_left_bottom()),
	//GREEN_BALL("Green Ball", 2, Assets.getCheckboard_down_left_mid()),
	//YELLOW_BALL("Yellow Ball", 3, Assets.getCheckboard_down_left_mid());
	RED_BALL("Red Ball", 1, Assets.getBrick_1()),
	GREEN_BALL("Green Ball", 2, Assets.getBrick_1()),
	YELLOW_BALL("Yellow Ball", 3, Assets.getBrick_1());
	
	private String itemName;
	private int itemID;
	private BufferedImage itemImage;
	
	private Item(String itemName, int itemID, BufferedImage image) {
		this.itemName = itemName;
		this.itemID = itemID;
		this.itemImage = itemImage;
	}
	public String getItemName(){
		return itemName;
	}
	public int getItemID(){
		return itemID;
	}
	public BufferedImage getItemImage(){
		return itemImage;
	}
}
