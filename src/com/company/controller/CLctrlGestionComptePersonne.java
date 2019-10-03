package com.company.controller;

import com.company.model.*;
import com.company.view.*;
import com.company.controller.*;

import java.sql.ResultSet;

public class CLctrlGestionComptePersonne {

    private CLcad con;
    private CLmapTB_PERSONNE map;

    public CLctrlGestionComptePersonne() {
        this.con = new CLcad("jdbc:mysql://localhost:3306/tb_personne?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false& serverTimezone=UTC", "root", "");
        this.map = new CLmapTB_PERSONNE();
        System.out.println("CONNECTION :" + con.getCon());
    }

    public ResultSet listerLesComptes(){
        // EXECUTION QUERY REQUEST
       return this.con.m_getRows(this.map.m_select());

    }

    public void CreeUnCompte(String name, String firstName){
        // EXECUTION UPDATE OR INSERT QUERY
        System.out.println(this.con.m_actionRows(this.map.m_insert(name,firstName)));
    }


}
