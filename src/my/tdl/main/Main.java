package my.tdl.main;

import java.awt.Cursor;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import my.project.gop.main.GameWindow;
import my.project.gop.main.SpriteSheet;
import my.tdl.MovableObjects.Player;
import my.tdl.gameloop.GameLoop;
import my.tdl.inventory.InventoryMouse;
import my.tdl.managers.Mousemanager;


public class Main {
	
	public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static int width = gd.getDisplayMode().getWidth();
	public static int height = gd.getDisplayMode().getHeight(); //PODESAVANJE FULLSCREEN
	
	
	public static void main(String[] args) {
		GameWindow frame = new GameWindow("TheDlooter", width, height);
		frame.setFullscreen(1);
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // tooklit za pravljenje cursor-a
		Cursor cursor = toolkit.createCustomCursor(toolkit.getImage(""), new Point(0, 0), "Cursor");
		frame.setCursor(cursor);
		
		frame.addMouseListener(new InventoryMouse());
		frame.addMouseListener(new Mousemanager());
		frame.addMouseMotionListener(new Mousemanager());
		frame.addMouseWheelListener(new Mousemanager());
		
		frame.addKeyListener(new Player());
		frame.add(new GameLoop(width, height));
		frame.setVisible(true);
		
	}
}
