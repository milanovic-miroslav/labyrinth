package my.tdl.inventory;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventoryMouse implements MouseListener {
	
	public static boolean isLeftClicked;
	public static boolean isRightClicked;

	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1){
			isLeftClicked = true;
			isRightClicked = false;
		}
		if(e.getButton() == MouseEvent.BUTTON3){
			isRightClicked = true;
			isLeftClicked = false;
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
		if(e.getButton() == MouseEvent.BUTTON1){
			isLeftClicked = false;
		
		}
		if(e.getButton() == MouseEvent.BUTTON3){
			isRightClicked = false;
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	
	}
		
	}

