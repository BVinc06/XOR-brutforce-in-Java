package com.company.view;

import com.company.controller.CLctrlCrypt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class frm_decrypt extends JFrame  implements ActionListener{

    JButton open = new JButton("Sélectionner un fichier"); //nouveau bouton open
    JTextField status = new JTextField("Pas de fichier chargé!"); //nouveau champs de texte
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser

    public frm_decrypt() {
        super("Test d'ouverture d'un JFileChooser"); //titre
        System.out.println("CALLA");
        setSize(screen.width/2,screen.height/2); //taille
        setLocation(screen.width/4,screen.height/4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fermeture
        status.setEditable(false);
        open.addActionListener(this);//ajout d'un actionlistener
        JPanel pane = new JPanel();
        BorderLayout bord = new BorderLayout();
        pane.setLayout(bord);
        pane.add("North", status);
        pane.add("Center", open);
        setContentPane(pane);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("EVENTSSS");
        chooser.setApproveButtonText("Choix du fichier..."); //intitulé du bouton
        chooser.showOpenDialog(null); //affiche la boite de dialogue
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            String pathFile = chooser.getSelectedFile().getAbsolutePath();
            status.setText(pathFile); //si un fichier est selectionné, récupérer le fichier puis sont path et l'afficher dans le champs de texte
            String replacePath = pathFile.replace("\\", "\\\\");
            String finalPath = replacePath.replace("\'", "\\'");
            System.out.println("PATH EDITED " + finalPath);

            String destinationPath = finalPath.replace(".txt","_decrypted.txt");
            System.out.println("PATH destination " + destinationPath);
            CLctrlCrypt fichier = new CLctrlCrypt();
            String reponse = fichier.lireFichierSimple(finalPath);
            fichier.generate_alphabet("awqpmndfgtej",0,reponse,destinationPath);



        }
    }


}