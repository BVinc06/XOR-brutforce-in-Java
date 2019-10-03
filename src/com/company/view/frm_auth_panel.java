package com.company.view;

import com.company.controller.wkf_cpte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class frm_auth_panel extends JPanel  implements ActionListener, KeyListener {

    private JLabel labelUsername = new JLabel("Enter username: ");
    private JLabel labelPassword = new JLabel("Enter password: ");
    private JTextField textUsername = new JTextField(20);
    private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton buttonOk = new JButton("OK");
    private wkf_cpte compte = new wkf_cpte();

    private String user, pwd;

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    int widthScreen = screen.width;
    int heightScreen = screen.height;

    public frm_auth_panel() {
        //ADD COMPONENTS TO JPANEL
        this.add(labelUsername);
        this.add(textUsername);
        this.add(labelPassword);
        this.add(fieldPassword);
        this.add(buttonOk);
        //EVENTS
        this.textUsername.addKeyListener(this);
        this.fieldPassword.addKeyListener(this);
        this.buttonOk.addKeyListener(this);
        this.buttonOk.addActionListener(this::actionPerformed);
    }

    public void paintComponent(Graphics g){
        System.out.println("Je suis exécutée !");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        this.user = this.textUsername.getText();
        this.pwd = new String(this.fieldPassword.getPassword());
        System.out.println(this.user + " --- " + this.pwd);

        //TODO : APPELER VERIFICATION LOGIN -> SI OK : RENVOYER LA VUE EXPLORATEUR FICHIER
        if(this.checkIfLoginIsOK()){
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.setVisible(false);
            System.out.println("GOOD ENTRER");
            new frm_decrypt();
        } else {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JOptionPane.showMessageDialog(topFrame, "Erreur de connexion, merci de vérifier vos identifiants.");
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyReleased(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER){

            this.user = this.textUsername.getText();
            this.pwd = new String(this.fieldPassword.getPassword());
            System.out.println(this.user + " --- " + this.pwd);
            System.out.println("ENTER");
            //TODO : APPELER VERIFICATION LOGIN -> SI OK : RENVOYER LA VUE EXPLORATEUR FICHIER
            if(this.checkIfLoginIsOK()){
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                topFrame.setVisible(false);
                System.out.println("GOOD");
                 new frm_decrypt();
            } else {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                JOptionPane.showMessageDialog(topFrame, "Erreur de connexion, merci de vérifier vos identifiants.");
            }
        }
    }

    private boolean checkIfLoginIsOK(){
        //TODO : APPELER VERIFICATION LOGIN

        return compte.pcs_authentifier(this.user, this.pwd);
    }

}
