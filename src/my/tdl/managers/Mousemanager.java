package my.tdl.managers;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

import my.tdl.MovableObjects.Player.PlayerActions;
import my.tdl.generator.World;
import my.tdl.main.Assets;

public class Mousemanager implements MouseListener, MouseMotionListener, MouseWheelListener {

	private static int mouseMovedX, mouseMovedY;
	public static Point mouse;
	
	public static boolean pressed;
	
	public void tick(){
		mouse = new Point(mouseMovedX, mouseMovedY);
		
		if(World.getPlayer() != null){
		if(World.getPlayer().getPlayerActions().hasCompleted()){
			if(World.getPlayer().getPlayerActions().attacked()){
			if(HUDmanager.getUpPol() != null){
				if(HUDmanager.getUpPol().contains(mouse)){
					if(pressed){
				World.getPlayer().getPlayerActions().attackUP();
				pressed = false;
				World.getPlayer().ps.damage(new Random().nextInt(10));
				}
			}
		}
		if(HUDmanager.getDownPol() != null){
			if(HUDmanager.getDownPol().contains(mouse)){
				if(pressed){
					World.getPlayer().getPlayerActions().attackDOWN();
					pressed = false;
					}
				}
			}
		if(HUDmanager.getRightPol() != null){
			if(HUDmanager.getRightPol().contains(mouse)){
				if(pressed){
					World.getPlayer().getPlayerActions().attackRIGHT();
					pressed = false;
					}
				}
			}
		if(HUDmanager.getLeftPol() != null){
			if(HUDmanager.getLeftPol().contains(mouse)){
				World.getPlayer().getPlayerActions().attackLEFT();
				if(pressed){
				
					}
				}
			}
			}
		}
	}
	}
	public void render(Graphics2D g){
		g.fillRect(mouseMovedX, mouseMovedY, 4, 4);
		
		if(pressed){
			g.drawImage(Assets.getMouse_pressed(), mouseMovedX, mouseMovedY, 32, 32, null);
		}else{
			g.drawImage(Assets.getMouse_unpressed(), mouseMovedX, mouseMovedY, 32, 32, null);
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMovedX = e.getX();
		mouseMovedY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseMovedX = e.getX();
		mouseMovedY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			pressed = true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			pressed = false;
		}
	}
}
