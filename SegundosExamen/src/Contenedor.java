import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Contenedor extends JPanel{
	private Interfaz Principal;
	private JTextField fieldDato, tD, tH, tM, tS;
	private JLabel labSegundos, lDia, lHora, lMinuto, lSegundo;
	private JButton convertir;
	private JPanel panelSuperior, panelInferior;
	private Integer dias, horas, minutos, segundos, num;
	
	public Contenedor ( Interfaz v){
		Principal=v;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		TitledBorder border = BorderFactory.createTitledBorder("Introduce");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		construyePanelSuperior();
		add(panelSuperior);
		
		convertir = new JButton("Convertir");
		add(convertir);
		
		construyePanelInferior();
		add(panelInferior);
		
		AccionBoton oyenteBoton = new AccionBoton();
		convertir.addActionListener(oyenteBoton);
	}
	
	void construyePanelSuperior(){
		panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(1,2));
        
        labSegundos = new JLabel("Segundos: ");
        panelSuperior.add(labSegundos);
        
        fieldDato = new JTextField();
        panelSuperior.add(fieldDato);
        
	}
	
	void construyePanelInferior(){
		panelInferior = new JPanel();
		panelInferior.setLayout(new GridLayout(4,2));
		
		TitledBorder border1 = BorderFactory.createTitledBorder("Resultado");
		border1.setTitleColor(Color.BLUE);
		panelInferior.setBorder(border1);
		
		lDia = new JLabel("Días: ");
		tD = new JTextField();
		tD.setEnabled(true);
		panelInferior.add(lDia);
		panelInferior.add(tD);
        lHora = new JLabel("Horas: ");
        tH = new JTextField();
		tH.setEnabled(true);
		panelInferior.add(lHora);
		panelInferior.add(tH);
        lMinuto = new JLabel("Minutos: ");
        tM = new JTextField();
		tM.setEnabled(true);
		panelInferior.add(lMinuto);
		panelInferior.add(tM);
        lSegundo = new JLabel("Segundos: ");
        tS = new JTextField();
		tS.setEnabled(true);
		panelInferior.add(lSegundo);
		panelInferior.add(tS);
		
	}
	
	class AccionBoton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String datos = fieldDato.getText();
			num = Integer.parseInt(datos);
			dias = num/86400;
			horas = (num-(86400*dias))/3600;
			minutos = (num-(86400*dias)-(horas*3600))/60;
			segundos = (num-(86400*dias)-(horas*3600)-(minutos*60));
			
			tD.setText(Integer.toString(dias));
			tH.setText(Integer.toString(horas));
			tM.setText(Integer.toString(minutos));
			tS.setText(Integer.toString(segundos));
		}
		
		
	}
}
