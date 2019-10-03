package com.company.model;

import java.sql.*;

public class CAD {
    private String connectionUrl;
    private String login;
    private String psw;
    private Connection con;
    private Statement stmt;
    private ResultSet dataSet;

    public CAD(String connectionUrl, String login, String psw) {
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

    public ResultSet getDataSet() { return dataSet; }

    public void setDataSet(ResultSet dataSet) { this.dataSet = dataSet; }

    /******************************/

    public ResultSet GetRows(String rq_sql) {
        try {
            this.setStmt(this.getCon().createStatement());
            this.setDataSet(this.getStmt().executeQuery(rq_sql));
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return this.getDataSet();
    }

}
