package GUI.AdminFrames;


import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import linker.Controller;
import myException.EmptyFieldException;
import myException.EnteNotFoundException;
import myTools.myTemplates;
import myTools.myTxtFld;
import net.miginfocom.swing.MigLayout;


public class OrganizzatoreDialog extends JDialog {

	Controller controller;

	private myTemplates t;

	private JLabel OrganizzatoreLbl;
	private myTxtFld EmailFld;
	private myTxtFld TitoloFld;
	private myTxtFld NomeFld;
	private myTxtFld CognomeFld;
	private myTxtFld AfferenzaFld;
	int n = 1;

	public OrganizzatoreDialog(int idConferenza, Controller c) {

		controller = c;

		t = new myTemplates();
		setSize(400, 450);
		setModal(true);
		setLocationRelativeTo(null);
		setIconImage(t.miniLogo);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));

			OrganizzatoreLbl = new JLabel("Organizzatore 1");
			OrganizzatoreLbl.setPreferredSize(new Dimension(77, 50));
			OrganizzatoreLbl.setForeground(t.gray);
			OrganizzatoreLbl.setBorder(new EmptyBorder(10, 0, 0, 0));
			OrganizzatoreLbl.setFont(t.myFont(24));
			OrganizzatoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
			MainPanel.add(OrganizzatoreLbl, BorderLayout.NORTH);

			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(t.white);
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[][][][][]"));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);

				TitoloFld = new myTxtFld("Titolo", controller);
				CentrPanel.add(TitoloFld, "cell 0 0,growx,aligny center");

				EmailFld = new myTxtFld("Email", controller);
				CentrPanel.add(EmailFld, "cell 0 1,growx,aligny center");

				NomeFld = new myTxtFld("Nome", controller);
				CentrPanel.add(NomeFld, "cell 0 2,growx,aligny center");

				CognomeFld = new myTxtFld("Cognome", controller);
				CentrPanel.add(CognomeFld, "cell 0 3,growx,aligny center");

				AfferenzaFld = new myTxtFld("Afferenza", controller);
				CentrPanel.add(AfferenzaFld, "cell 0 4,growx,aligny center");

			JButton ConfermaBtn = new JButton("Conferma");
			ConfermaBtn.setPreferredSize(new Dimension(79, 40));
			ConfermaBtn.setForeground(t.white);
			ConfermaBtn.setBackground(t.scBlue);
			ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
			ConfermaBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					try {

						controller.addOrganizzatori(n);

					} catch (EmptyFieldException efe) {

						System.out.println(efe);
						JOptionPane.showMessageDialog(OrganizzatoreDialog.this, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);

					} catch (EnteNotFoundException enfe) {

						System.out.println(enfe);
						JOptionPane.showMessageDialog(OrganizzatoreDialog.this, enfe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
					}
					n++;
				}
			});
	}

	public String getEmail() { return  EmailFld.getText(); }

	public String getTitolo() { return TitoloFld.getText(); }

	public String getNome() { return NomeFld.getText(); }

	public String getCognome() { return CognomeFld.getText(); }

    public String getAfferenza() { return AfferenzaFld.getText(); }

    public void nextOrganizzatore() {

    	OrganizzatoreLbl.setText("Organizzatore " + (n + 1));

    	NomeFld.setText("Nome");
    	NomeFld.setForeground(t.altGray);
    	NomeFld.setFont(new Font("Calibri Light", Font.ITALIC, 14));

    	CognomeFld.setText("Cognome");
    	CognomeFld.setForeground(t.altGray);
    	CognomeFld.setFont(new Font("Calibri Light", Font.ITALIC, 14));

    	EmailFld.setText("Email");
    	EmailFld.setForeground(t.altGray);
    	EmailFld.setFont(new Font("Calibri Light", Font.ITALIC, 14));

    	TitoloFld.setText("Titolo");
    	TitoloFld.setForeground(t.altGray);
    	TitoloFld.setFont(new Font("Calibri Light", Font.ITALIC, 14));

    	AfferenzaFld.setText("Afferenza");
    	AfferenzaFld.setForeground(t.altGray);
    	AfferenzaFld.setFont(new Font("Calibri Light", Font.ITALIC, 14));
    }

    public boolean fieldsAreEmpty() {

    	if (isEmpty(getEmail(), "Email") || isEmpty(getTitolo(), "Titolo") || isEmpty(getNome(), "Nome")
    	   || isEmpty(getCognome(), "Cognome") || isEmpty(getAfferenza(), "Afferenza")) {

    		return true;

    	} else { return false; }
    }

    public boolean isEmpty(String txt, String txt2) {

		if (txt.isEmpty() || txt.equals(txt2)) { return true; }

		else { return false; }
	}
}