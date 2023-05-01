import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;
import javax.swing.*;

/*Esta clase se encargara principalmente de hacer las configuraciónes necesarias a la ventana,
 *tambien atravez de ella es que añadimos un objeto de tipo ButtonManager con el cual vamos a
 *manejar tanto la estetica de nuestros botones, como la funciónalidad y distribuición de estos.*/
public class GameWindow extends JFrame {
	
	/*Ancho, alto, titulo, color y contenedor de la ventana, tambien tenemos screenSize, que
	 *es la variable que almacenara el tamaño entero de todo el monitor y el objeto de tipo
	 *ButtonManager que manejara cada uno de los butones.*/
	protected int width;
	protected int height;
	protected String title;
	protected Color bgcolor;
	protected Container contenedor;
	protected Dimension screenSize;
	protected ButtonManager eventManager;

	//Constructor de la clase GameWindow
	public GameWindow(int w, int h, String title, Color bg_color) {
		
		this.width = w;
		this.height = h;
		this.title = title;
		this.bgcolor = bg_color;
		this.contenedor = getContentPane();
		this.screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
	}
	
	/*Mediante esta función hacemos todas las configuraciónes necesarias a la ventana para que
	 *funcione correctamente.*/
	public void settings() {
		
		//Añadimos todas las configuraciones a la ventana y la mostramos.
		setTitle(this.title);
		setSize(this.width , this.height);
		setBackground(this.bgcolor);
		
		/*Importante añadir un layout null, ya que si no añadimos un layout null, por alguna razón
		 *la ventana tomara como fondo uno de los botones, ademas escondera a los otros cada vez que
		 *este boton faltante sea "focuseado"*/
		contenedor.setLayout(null);
		
		//Centramos la ventana.
		this.setLocation(
			this.screenSize.width / 2 - this.width / 2, 
			this.screenSize.height / 2 - this.height / 2
		);
		
		this.setResizable(false);
		this.setFocusable(true);
		this.show(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.eventManager = new ButtonManager(this);
		
	}
	
}