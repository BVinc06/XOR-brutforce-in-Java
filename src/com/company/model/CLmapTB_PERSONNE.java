package com.company.model;

public class CLmapTB_PERSONNE {

    private int id;
    private String name;
    private String firstName;
    private String rq_sql;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRq_sql() {
        return rq_sql;
    }

    public void setRq_sql(String rq_sql) {
        this.rq_sql = rq_sql;
    }

    public String m_select(){
        return "SELECT * FROM TB_PERSONNE";
    }

    public String m_insert(String name, String firstName){
        this.setName(name);
        this.setFirstName(firstName);
        return "INSERT INTO TB_PERSONNE (name, firstName) VALUES ('" + this.getName() + "','" + this.getFirstName() + "')";
    }

}
