package com.company.controller;

import com.company.model.CAD;
import com.company.model.Map_P;

import java.sql.ResultSet;

public class wkf_cpte {
    private CAD con;
    private Map_P map;
    private ResultSet data;

    public boolean pcs_authentifier(String login, String password) {
        this.con = new CAD("jdbc:mysql://localhost:3306/tb_personne?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false& serverTimezone=UTC", "root", "");
        this.map = new Map_P();
        System.out.println("CONNECTION :" + con.getCon());
        data = con.GetRows(map.selectIDbyLoginPassword(login,password));
        try {
           return data.last();
        } catch (java.sql.SQLException s) {
            s.printStackTrace();
        }
        return false;
    }
}
