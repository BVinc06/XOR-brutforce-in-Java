package com.company.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CLcad {

    private String connectionUrl;
    private String login;
    private String psw;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    /**** GETTERS AND SETTERS *****/
    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    /******************************/

    public CLcad() {
        this.setConnectionUrl(null);
        this.setLogin(null);
        this.setPsw(null);
        this.setStmt(null);
        this.setRs(null);
        /*
        // Chargement du driver JDBC pour MySQL
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            this.setCon(DriverManager.getConnection( this.getConnectionUrl(), this.getLogin(), this.getPsw() ));
            System.out.println(this.getCon());
        } catch (ClassNotFoundException | SQLException e ) {
            // Gérer les éventuelles erreurs ici.
        } finally {
            if ( this.getCon() != null )
                try {
                    System.out.println("FERMETURE");
                    // Fermeture de la connexion
                    this.getCon().close();
                } catch ( SQLException ignore ) {
                    // Si une erreur survient lors de la fermeture, il suffit de l'ignorer.
                }
        }
        */
    }

    public CLcad(String connectionUrl, String login, String psw) {
        this.setConnectionUrl(connectionUrl);
        this.setLogin(login);
        this.setPsw(psw);
        /* Chargement du driver JDBC pour MySQL */
        try {
            //System.out.println("CONNECTION");
            this.setCon(DriverManager.getConnection( this.getConnectionUrl(), this.getLogin(), this.getPsw() ));
        } catch ( SQLException e ) {
            /* Gérer les éventuelles erreurs ici. */
            e.printStackTrace();
        } /*finally {
            System.out.println("FINALLY");
            if ( this.getCon() != null )
                try {
                    System.out.println("FERMETURE");
                    // Fermeture de la connexion
                    this.getCon().close();
                } catch ( SQLException ignore ) {
                    // Si une erreur survient lors de la fermeture, il suffit de l'ignorer.
                     ignore.printStackTrace();
                }
        }*/
    }

    public ResultSet m_getRows(String request){
        try {

            this.setStmt(this.getCon().createStatement());

            this.setRs(this.getStmt().executeQuery(request));
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return this.getRs();
    }
    public ArrayList<String> m_getAllRows(String request){
        try {
            ArrayList<String> list= new ArrayList<String>();
            this.setStmt(this.getCon().createStatement());

            ResultSet req_res = this.getStmt().executeQuery(request);
            while (req_res.next())
            {
                //String nom = req_res.getString("mot");
                // print the results
                list.add(req_res.getString("mot"));
            }
            return list;
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int m_actionRows(String request){
        try {
            this.setStmt(this.getCon().createStatement());
            int status = this.getStmt().executeUpdate(request);
            return status;
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
