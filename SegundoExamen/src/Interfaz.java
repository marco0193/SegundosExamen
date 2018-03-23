import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Interfaz extends JFrame{
	
	Contenedor cont;
	
	public Interfaz(){
		setTitle("Convertir");
		setSize(200,207);
		setLayout (new BorderLayout());
		
		cont = new Contenedor(null);
		add(cont, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) throws Exception{
		Interfaz Vent = new Interfaz();
		Vent.setVisible(true);
	}

}