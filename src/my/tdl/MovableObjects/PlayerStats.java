package my.tdl.MovableObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.concurrent.CopyOnWriteArrayList;

import my.tdl.main.Assets;

public class PlayerStats {

	private Player player;
	
	private float health = 130;
	private float maxHealth = 1;
	private float healthScale = health / maxHealth;
	
	private float dmrt = health / maxHealth;
	private int waitTime = 20;
	
	public static CopyOnWriteArrayList<BouncyText> list = new CopyOnWriteArrayList<BouncyText>();
	
	public PlayerStats(Player player) {
		this.player = player;
	}
	public void tick(){
		for(BouncyText text : list){
			text.tick();
		}
	}
	public void render(Graphics2D g){
		
		g.setColor(Color.RED);
		if(!player.isDamaged()){
			if(dmrt > healthScale){
				if(waitTime != 0){
					waitTime--;
				}
				if(waitTime == 0){
					dmrt-=1f;
					if(dmrt <= healthScale){
						waitTime = 20;
					}		
				}
			}
			g.fillRect(
					(int)player.getPos().xpos +5 - 30*5 / 2 + 32 / 2,
					(int)player.getPos().ypos - 25*2-11, (int)dmrt,25);
		}
		for(BouncyText text : list){
			text.render(g);
		}
		
		g.setColor(Color.GREEN);
		g.fillRect(
				(int)player.getPos().xpos +5 - 30*5 / 2 + 32 / 2,
				(int)player.getPos().ypos - 25*2-11, (int)maxHealth*(int)healthScale,25);
		g.drawImage(Assets.getHealth_g_bar(),
				(int)player.getPos().xpos - 30*5 / 2 + 32 / 2,
				(int)player.getPos().ypos - 25*2-11,28*5,25, null);
	}
	public void damage(float amount){
		if(healthScale > 0 && !player.isDamaged()){
			healthScale -= amount;
			player.setDamaged(true);
			list.add(new BouncyText(
					player.pos.xpos - player.pos.getWorldLocation().xpos + player.pos.xpos,
					player.pos.ypos - player.pos.getWorldLocation().ypos + player.pos.ypos,
					String.valueOf(amount)));
			
		}else{
			System.err.println("cant be damaged"+amount);
		}
	}
}
