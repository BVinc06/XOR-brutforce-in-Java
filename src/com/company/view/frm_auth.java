package com.company.view;

import javax.swing.*;
import java.awt.*;

public class frm_auth {

    JFrame fen;
    frm_auth_panel pan;

    public frm_auth() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int widthScreen = screen.width;
        int heightScreen = screen.height;

        fen = new JFrame();
        pan = new frm_auth_panel();

        fen.setTitle("FORMULAIRE D\'AUTHENTIFICATION");
        fen.setLocation(widthScreen/4,heightScreen/4);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setSize(widthScreen/2, heightScreen/2);
        fen.setResizable(false);
        fen.setAlwaysOnTop(true);
        fen.setContentPane(pan);
        fen.setVisible(true);

    }
}
