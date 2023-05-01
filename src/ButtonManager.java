import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*Esta clase contiene no solo la acci�n para los botones, si no que tambien contiene
 *cada uno de estos botones y tambien "arreglos de configuraci�n", mediante los cuales podremos
 *saber en que estado se encuentra cada boton (El arreglo marks se encarga de esto), tambien tenemos
 *
 *una variable de tipo int llamada turno, que precisamente hace eso, cambiar el turno seg�n sea
 *necesario, por otro lado la variable de tipo boolean llamada win, ser� necesario saber su valor
 *para saber cuando el juego ha sido ganado o no.*/
public class ButtonManager implements ActionListener{
	
	protected GameWindow mainWindow;
	private JButton[][] botones;
	private JButton botonResetear;
	private String[][] marks;
	private int turno;
	private boolean win;
	private JLabel jugadorActual;
	
	//Constructor de la clase ButtonManager
	public ButtonManager (GameWindow mainWindow){
		
		this.mainWindow = mainWindow;
		
		/*Tanto el arreglo botones como el arreglo marks son arreglos bidimensionales, esto con el fin
		 *de usarlos como "tablas" o matrices, donde podemos separar las filas de las columnas para as�
		 *
		 *distribuir posteriormente de manera mas sencilla los botones en la ventana.
		 *otro punto importante es que el arreglo botones contiene tanto 3 filas como 3 columnas,
		 *ya que el triki contiene exactamente nueve espacios para llenar.
		 *
		 *Al multiplicar las filas (3), por las columnas (otras 3), nos da el resultado correcto
		 *del total de botones que necesitaremos para el triki. Esto significa que la matriz
		 *bidimensional ha sido correctamente dimensionada.*/
		this.botones = new JButton[3][3];
		this.botonResetear = new JButton("�Resetear!");
		/*Simplemente inicializamos el arreglo marks con la misma cantidad de filas y columnas
		 *que contenia la matriz de botones. Eso es lo que significa esta linea.*/
		this.marks = new String[this.botones.length][this.botones[0].length];
		this.jugadorActual = new JLabel("Turno: Jugador 1 (X)");
		this.turno = 0;
		this.win = false;
		
	}
	
	/*Esta funci�n permite saber cuando es que alg�n jugador ha ganado, y de haber ganado alguno
	 *haciendo primero unas comprobaci�nes, lo que hace es mostrar el ganador, luego cambia el
	 *valor booleano de la variable win a true
	 *
	 *despues al final con otra condicion se comprueba si el juego ha sido ganado
	 *(Esto debido a que puede que el programa nunca entre en ninguno de las condiciones)
	 *en donde en este caso no cambiara la variable win a true. si se entra a la condicional
	 *final se ejecuta la funci�n resetGame, que reseteara todos los valores del juego
	 *que sean necesarios para volverlo a jugar de cero.*/
	public void confirmWin() {
		
		//Comprobamos si se cumple alguna de cada posible victoria en X
		if(		
				//Comprobaci�nes horizontales de la X
				(
				 this.botones[0][0].getText().equals("X") &&
				 this.botones[0][1].getText().equals("X") &&
				 this.botones[0][2].getText().equals("X")
				)
				
				||
				
				(
				 this.botones[1][0].getText().equals("X") &&
				 this.botones[1][1].getText().equals("X") &&
				 this.botones[1][2].getText().equals("X")
				)
				
				||
				
				(
				 this.botones[2][0].getText().equals("X") &&
				 this.botones[2][1].getText().equals("X") &&
				 this.botones[2][2].getText().equals("X")
				)
				
				||
				
				//Comprobaci�nes verticales de la X
				(
				 this.botones[0][0].getText().equals("X") &&
				 this.botones[1][0].getText().equals("X") &&
				 this.botones[2][0].getText().equals("X")
				)
				
				||
				
				(
				 this.botones[0][1].getText().equals("X") &&
				 this.botones[1][1].getText().equals("X") &&
				 this.botones[2][1].getText().equals("X")
				)
				
				||
				
				(
				 this.botones[0][2].getText().equals("X") &&
				 this.botones[1][2].getText().equals("X") &&
				 this.botones[2][2].getText().equals("X")
				)
				
				||
				
				//Comprobaci�nes diagonales de la X
				(
				 this.botones[0][0].getText().equals("X") &&
				 this.botones[1][1].getText().equals("X") &&
				 this.botones[2][2].getText().equals("X")
				)
				
				||
				
				(
				 this.botones[0][2].getText().equals("X") &&
				 this.botones[1][1].getText().equals("X") &&
				 this.botones[2][0].getText().equals("X")
				)
		   
	    ) {
			
			JOptionPane.showMessageDialog(null, "�Ha ganado el jugador 1! (X)");
			this.win = true;
		
		//Comprobamos si se cumple alguna de cada posible victoria en O
		}else if(
				
			//Comprobaci�nes horizontales del circulo O
			(
			 this.botones[0][0].getText().equals("O") &&
			 this.botones[0][1].getText().equals("O") &&
			 this.botones[0][2].getText().equals("O")
			)
			
			||
			
			(
			 this.botones[1][0].getText().equals("O") &&
			 this.botones[1][1].getText().equals("O") &&
			 this.botones[1][2].getText().equals("O")
			)
			
			||
			
			(
			 this.botones[2][0].getText().equals("O") &&
			 this.botones[2][1].getText().equals("O") &&
			 this.botones[2][2].getText().equals("O")
			)
			
			||
			
			//Comprobaci�nes verticales del circulo O
			(
			 this.botones[0][0].getText().equals("O") &&
			 this.botones[1][0].getText().equals("O") &&
			 this.botones[2][0].getText().equals("O")
			)
			
			||
			
			(
			 this.botones[0][1].getText().equals("O") &&
			 this.botones[1][1].getText().equals("O") &&
			 this.botones[2][1].getText().equals("O")
			)
			
			||
			
			(
			 this.botones[0][2].getText().equals("O") &&
			 this.botones[1][2].getText().equals("O") &&
			 this.botones[2][2].getText().equals("O")
			)
			
			||
			
			//Comprobaci�nes diagonales del circulo O
			(
			 this.botones[0][0].getText().equals("O") &&
			 this.botones[1][1].getText().equals("O") &&
			 this.botones[2][2].getText().equals("O")
			)
			
			||
			
			(
			 this.botones[0][2].getText().equals("O") &&
			 this.botones[1][1].getText().equals("O") &&
			 this.botones[2][0].getText().equals("O")
			)
		
		) {
			
			JOptionPane.showMessageDialog(null, "�Ha ganado el jugador 2! (O)");
			this.win = true;
		
		/*En caso de que ninguno halla ganado a�n despues de todas las comprobaci�nes significa que
		 *ninguno de los dos jugadores gan�, por lo tanto se pasa a comprobar un empate valido.*/
		}else {
			
			/*La variable full representar� el estado en el que se encuentra el tablero,
			 *si el valor es falso, significa que a�n falta por llenar contenido,
			 *si el valor cambia a verdadero y sigue siendolo a�n a la hora de comprobar el
			 *condicional que sigue despues de los dos ciclos for, entonces.
			 *
			 *Mostraremos un mensaje de �EMPATE!, en pantalla y terminaremos el juego cambiando
			 *el valor de la variable win a true, que al toparse con el ultimo condicional
			 *reseteara todos los valores del juego.*/
			boolean full = false;
			
			/*Este doble ciclo for funciona de la siguiente manera:
			 * 
			 *outer representa una "etiqueta", por la cual podemos "controlar" a que ciclo se
			 *le alterara su flujo normal, en este caso si es un break, parara la ejecuci�n desde
			 *el ciclo al que se le haya asignado la etiqueta outer.
			 *
			 *Una vez dicho esto, con el primer ciclo for recorremos cada una de las filas del
			 *arreglo marks, y dentro de las filas, con otro ciclo for recorreremos cada una 
			 *de las columnas.
			 *
			 *Esto es lo mismo que recorrer cada uno de los elementos de
			 *este arreglo, luego dentro de el segundo ciclo for comprobamos por cada elemento si
			 *es null (Es decir si esta vaci�), en caso de que halla a�n una casilla vaci� en el tablero
			 *no queremos mostrar un empate, por lo que si alguna vez full fue true, al haber entrado
			 *en esta condici�n significa que esa casilla esta vacia.
			 *
			 *Por lo tanto no podemos a�n mostrar un empate ya que el juego no ha concluido, 
			 *as� que cambiamos el valor a la variable full de nuevo a false y en vez de seguir 
			 *analizando los demas elementos, lo que hacemos es simplemente utilizar break outer; 
			 *
			 *Esto nos permitira parar la ejecuci�n en este caso de todos los ciclos,
			 *(Ya que el primero el cual es al que le hemos dado la etiqueta outer, es el que 
			 *esta por encima de los otros) si este no se ejecuta los otros tampoco.
			 *
			 *Esto es usado para no tener que seguir comprobando mas elementos innecesariamente,
			 *(Una vez se comprueba que el juego no ha concluido y por lo tanto no se puede mostrar 
			 *un empate, resulta ilogico seguir comprobando los demas elementos si ya sabemos que 
			 *el tablero no esta lleno).
			 *
			 *Por ultimo simplemente con la ultima condicion fuera de los ciclos, si se comprobo
			 *el empate, se muestra el mensaje de empate y se termina el juego.*/
			outer : for(int i = 0; i < this.marks.length; i++) {
				
				for(int j = 0; j < this.marks[i].length; j++) {
					
					if(this.marks[i][j] == null) {
						
						full = false;
						break outer;
						
					}
					
					full = true;
					
				}
				
			}
			
			if(full) {
				
				JOptionPane.showMessageDialog(null, "�EMPATE!");
				this.win = true;
				
			}
			
		}
		
		if(this.win) {
			
			this.resetGame();
			
		}
		
	}
	
	/*Esta funci�n permite devolver el estado del juego al por defecto:
	 * 
	 *- Los botones sin rellenar
	 *- El turno al jugador 1
	 *- La variable win a false*/
	public void resetGame() {
		
		for(int i = 0; i < this.botones.length; i++) {
			
			for(int j = 0; j < this.botones[i].length; j++) {
				
				this.botones[i][j].setText("");
				this.marks[i][j] = null;
				
			}
			
		}
		
		this.turno = 0;
		this.win = false;
		this.jugadorActual.setText("Turno: Jugador 1 (X)");
		
	}
	
	/*A�ade a cada uno de los botones mediante la iteraci�n de cada uno de sus elementos un 
	 *ActionListener para poder as� detectar cuando cada uno de los botones fue presionado.*/
	public void addActionListeners() {
		
		for(int i = 0; i < this.botones.length; i++) {
			
			for(int j = 0; j < this.botones[i].length; j++) {
				
				this.botones[i][j].addActionListener(this);
				
			}
			
		}
		
		this.botonResetear.addActionListener(this);
		
	}
	
	//Crea, personaliza y a�ade cada uno de los botones a la ventana.
	public void addButtons(int rows, int cols, String textFont ,int textSize) {
		
		for(int i = 0; i < rows; i++) {
			
			for(int j = 0; j < cols; j++) {
				
				this.botones[i][j] = new JButton();
				this.botones[i][j].setFont(new Font(textFont, Font.BOLD, textSize));
				this.mainWindow.add(this.botones[i][j]);
				
			}
			
		}
		
		this.botonResetear.setFont(new Font("TimesNewRoman", Font.BOLD, 12));
		this.jugadorActual.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
		this.mainWindow.add(this.botonResetear);
		this.mainWindow.add(this.jugadorActual);
		
	}
	
	/*Distribuye de manera correcta el ancho y alto de cada boton y tambien las coordenadas
	 *de cada uno de estos.*/
	public void setButtonCoords(int x_, int y_, int w_, int h_) {
		
		//Ancho y alto que tendra cada boton
		final int widthSpace = (this.mainWindow.width / this.botones[0].length) - this.botones[0].length;
		final int heightSpace = 
				((this.mainWindow.height - 100) / this.botones.length) - this.botones.length;

		for(int x = 0; x < this.botones.length; x++) {
			
			for(int y = 0; y < this.botones[x].length; y++) {
				
				this.botones[x][y].setBounds(
						y *  widthSpace, x * heightSpace, 
						widthSpace, heightSpace
				);
				
			}
			
		}
		
		this.botonResetear.setBounds(x_, y_, w_, h_);
		this.jugadorActual.setBounds(w_ / 2, y_, w_ + 50, h_);
		
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		/*Cuando se clickeo sobre alguno de los botones se ejecuta esta funci�n, donde recorremos
		 *entonces cada uno de estos botones y comprobaremos con una condicion, cual es
		 *el boton que fue presionado, tambien antes de entrar en el condicional comprobamos si
		 *ese boton se encuentra vaci�, si es as�, entraremos al condicional y pasar�n varias cosas:
		 *
		 *1.) Si el turno es igual a 0 el contenido del boton ser� X (Jugador 1), de lo contrario
		 *ser� O (Jugador 2).
		 *
		 *2.) Si el turno es igual a 0 (Jugador 1), el valor del turno cambiara a ser 1
		 *(Jugador 2), pero si el turno no es igual 0 (Jugador 1) entonces pasara a ser cero (Jugador 2).
		 *
		 *3.) Al boton clickeado le cambiamos su contenido por su correspondiente turno.
		 *
		 *4.) Llamamos a la funci�n confirmWin, esta har� las comprobaci�nes pertinentes y har�
		 *lo comentado en ella.
		 *
		 *5.) Si hemos entrado al condicional y como solo podemos presionar un boton a la vez,
		 *no tiene sentido comprobar los demas botones, por lo que paramos la ejecuci�n de todos los
		 *ciclos con break outer; y as� concluimos la funci�n.
		 *
		 *6.) En caso de que el boton presionado halla sido el boton de resetear, simplemente
		 *resetearemos el juego.*/
		outer: for(int i = 0; i < this.botones.length; i++) {
			
			for(int j = 0; j < this.botones[i].length; j++) {
				
				if(ev.getSource().equals(this.botones[i][j]) && this.marks[i][j] == null) {
					
					String actual;
					this.marks[i][j] = this.turno == 0 ? "X" : "O";
					this.botones[i][j].setText(this.marks[i][j]);
					this.turno = this.turno == 0 ? 1 : 0;
					actual = this.turno == 0 ? "X" : "O";
					this.jugadorActual.setText(
						"Turno:" + " Jugador " + (turno + 1) + " (" + actual + ")"
					);
					this.confirmWin();
					break outer;
					
				}
				
			}
			
		}
		
		//Reseteamos el juego en caso de que el boton presionado fuera el de resetear.
		if(ev.getSource().equals(this.botonResetear)) {
			
			this.resetGame();
			
		}
		
	}
	
}
