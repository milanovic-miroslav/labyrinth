package my.tdl.inventory;

import java.awt.Graphics2D;
import java.util.concurrent.CopyOnWriteArrayList;

import my.project.gop.main.Vector2F;

public class Inventory {

	private Vector2F pos = new Vector2F();
	private int dimention;
	private CopyOnWriteArrayList<Slot> slots;
	private boolean toggle;
	
	public Inventory(float xpos, float ypos, int dimention) {
	
		this.pos.xpos = xpos;
		this.pos.ypos = ypos;
		this.dimention = dimention;
	}

	public void init(){
		slots = new CopyOnWriteArrayList<Slot>();
		
		for(int x = 0; x < dimention; x++){
			for(int y =0; y < dimention; y++){
				
				slots.add(new Slot(pos.xpos+y*48, pos.ypos+x*48));
				
			}
		}
	}
	
	public void toggle (){
		toggle = !toggle;
	}
	public void tick(){
		if(toggle){
			for(Slot slot : slots){
				slot.tick();
			}
		}
	}
	public void render(Graphics2D g){
		if(toggle){
			for(Slot slot : slots){
				slot.render(g);
			}
		}
	}
	public void addItem(Item item){
		for(Slot slot : slots){
			if(slot.isAir()){
				slot.setItem(item);
				break;
			}else{
				if(slot.hasSameID(item)){
					if(!slot.isFull()){
						slot.addItemToStack(item);
						break;
					}
				}
			}
		}
		}
		public void addItem(Item item, int slotNum){
			if(slotNum < slots.size()){
				Slot slot = slots.get(slotNum);
				
				if(slot.isAir()){
					slot.setItem(item);
				}else{
					if(slot.hasSameID(item)){
						if(!slot.isFull()){
							slot.addItemToStack(item);
						}
					}
				}
			}else{
				System.err.println("OUT OF BOUNDS : INVENTORY");
			}
	}
}
