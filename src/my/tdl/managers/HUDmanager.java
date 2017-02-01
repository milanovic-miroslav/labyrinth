package my.tdl.managers;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import my.project.gop.main.Light;
import my.project.gop.main.Vector2F;
import my.project.gop.main.loadImageFrom;
import my.tdl.MovableObjects.Player;
import my.tdl.generator.World;
import my.tdl.main.Main;

public class HUDmanager {
	
	private Player player;
	private BufferedImage light; // osvetljavanje nacin I
	private World world;
	
	/*private BufferedImage lightmap = new BufferedImage(100*32, 100*32, BufferedImage.TYPE_INT_ARGB); // osvetljavanje
	private ArrayList<Light> lights = new ArrayList<Light>(); // osvetljavanje
	private Vector2F lightm = new Vector2F();
	*/
	public HUDmanager(Player player, World world){
		this.world = world;
		this.player = player;
		light = loadImageFrom.LoadImageFrom(Main.class, "Light.png"); // osvetljavanje nacin I
	//addtLights();
	}
	
/*private void addtLights() {
	// lights.add(new Light(player.getPos().xpos, player.getPos().ypos, 20, 120));
	//lights.add(new Light(300, 300, 220, 120));
	}
public void UpdateLights(){
	Graphics2D g = null;
	if(g == null){
		g = (Graphics2D) lightmap.getGraphics();
	}
	g.setColor(new Color (0,0,0,255));
	g.fillRect(0, 0, lightmap.getWidth(), lightmap.getHeight());
	g.setComposite(AlphaComposite.DstOut);
	
	for(Light light : lights){
		light.render(g);
		
	}
	g.dispose();
}*/
	private static Polygon up;
	private static Polygon down;
	private static Polygon right;
	private static Polygon left;

	public void render(Graphics2D g){
	//UpdateLights(); // osvetljavanje	
	//g.drawImage(lightmap, (int)lightm.getWorldLocation().xpos, (int)lightm.getWorldLocation().ypos, null); // osvetljavanje
	
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, Main.width, Main.height / 6);
	g.fillRect(0, 650, Main.width, Main.height / 6); // u zavisnosti od ekrana menjati vrednost 750
	g.setColor(Color.WHITE);
	g.drawImage(light, 0, 0, Main.width, Main.height, null); // osvetljavanje nacin I
	
	if(player.isDebuging()){
		g.drawString("[DEBUG]", 30, 30);
		g.drawString("[MapXpos]"+world.getWorldXpos(), 30, 60);
		g.drawString("[MapYpos]"+world.getWorldYpos(), 30, 90);
	//	g.drawString("[Loaded Blocks]"+world.getWorldBlocks().getBlocks, 30, 120); NEMA getBlocks u World class
	}
	/*UP*/
	//int[] ux = new int[]{1440,720,720,0};
	//int[] uy = new int[]{0,450,450,0};
	int[] ux = new int[]{1480,690,690,0};
	int[] uy = new int[]{0,380,380,0};
	up = new Polygon(ux, uy, ux.length);
	//g.drawPolygon(up); // crtanje linija poligona kako bi se videle na ekranu, a radi podesavanja
	
	/*DOWN*/
	//int[] dx = new int[]{1440,720,720,0};
	//int[] dy = new int[]{900,450,450,900};
	int[] dx = new int[]{1480,690,690,0};
	int[] dy = new int[]{900,380,380,900};
	down = new Polygon(dx, dy, dx.length);
	//g.drawPolygon(down);
	
	/*RIGHT*/
	//int[] rx = new int[]{1440,720,720,1440};
	//int[] ry = new int[]{900,450,450,0};
	int[] rx = new int[]{1480,690,690,1480};
	int[] ry = new int[]{900,380,380,0};
	right = new Polygon(rx, ry, rx.length);
	//g.drawPolygon(right);
	
	/*LEFT*/
	//int[] lx = new int[]{0,720,720,0};
	//int[] ly = new int[]{900,450,450,0};
	int[] lx = new int[]{0,690,690,0};
	int[] ly = new int[]{900,380,380,0};
	left = new Polygon(lx, ly, lx.length);
	//g.drawPolygon(left);
	}
	public static Polygon getUpPol() {
		return up;
	}
	public static Polygon getDownPol() {
		return down;
	}
	public static Polygon getRightPol() {
		return right;
	}
	public static Polygon getLeftPol() {
		return left;
	}
}
