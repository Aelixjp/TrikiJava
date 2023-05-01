import java.awt.Color;
public class triki {

	//Metodo principal por el cual se ejecutara todo el programa.
	public static void main(String[] args) {
		
		//Creamos un objeto GameWindow y le damos a la ventana un ancho un alto, un titulo y un color.
		GameWindow trikiWindow = new GameWindow(600,700,"�Triki!",Color.white);
		
		/*Iniciamos las configuraci�nes que va a tener la ventana y le a�adimos tanto los botones,
		 *como tambien el evento que se va a ejecutar cada vez que pulsemos estos.
		 *tambien le damos un tama�o y fuente personalizada a cada uno de los botones, para que as�
		 *se vea mejor a la hora de mostrar la informaci�n de juego en pantalla.
		 *
		 *Tambien le damos el tama�o y las pocisiones adecuadas a cada uno de los botones.*/
		trikiWindow.settings();
		trikiWindow.eventManager.addButtons(3, 3, "Algerian",80);
		trikiWindow.eventManager.setButtonCoords(
				(trikiWindow.width / 2) - 50, (trikiWindow.height - 80), 100,30
		);
		trikiWindow.eventManager.addActionListeners();

	}

}
