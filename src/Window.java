import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Window  {

	JFrame frame;
	public boolean wypiszKonfiguracje=false;

	/*
	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 */

	/**
	 * Create the application.
	 */
	public Window(String file) {
		
		initialize(file);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String file){
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTak = new JButton("tak");
		btnTak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean wypiszKonfiguracje = true;
			    //System.out.print("Hello World");
			    // DASDASDA
				
			    Maszyna maszyna;
				try {
					maszyna = new Maszyna(wypiszKonfiguracje, file);
					maszyna.wypiszMape();
					maszyna.obliczSlowo();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnTak.setBounds(15, 97, 115, 29);
		frame.getContentPane().add(btnTak);
		
		JButton btnNie = new JButton("nie");
		btnNie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean wypiszKonfiguracje = false;
			    //System.out.print("Hello World");
			    // DASDASDA
				
			    Maszyna maszyna;
				try {
					maszyna = new Maszyna(wypiszKonfiguracje, file);
					maszyna.wypiszMape();
					maszyna.obliczSlowo();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNie.setBounds(197, 97, 115, 29);
		frame.getContentPane().add(btnNie);
		
		JLabel lblCzyWypisacKolejne = new JLabel("czy wypisac kolejne konfiguracje maszyny?");
		lblCzyWypisacKolejne.setBounds(15, 16, 309, 44);
		frame.getContentPane().add(lblCzyWypisacKolejne);
	}
}
