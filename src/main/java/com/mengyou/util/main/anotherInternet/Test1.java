package com.mengyou.util.main.anotherInternet;

/**
 * Created by zhangfan on 2015/3/6.
 */

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;


public class Test1 {

    private String strin;
    private int in;
    private float floa;
    private double doubl;
    private boolean boolea;
    private BigDecimal bigDecima;
    private Double Dou;
    private Float Flo;
    private Integer Intege;
    private Boolean Boo;
    private java.sql.Date DateS;
    private java.util.Date DateU;
    private java.sql.Timestamp Timestam;
    private char cha;
    private Character Characte;
    private List list;
    private HashMap map;

    public BigDecimal getBigDecima() {
        return bigDecima;
    }

    public void setBigDecima(BigDecimal bigDecima) {
        this.bigDecima = bigDecima;
    }

    public Boolean getBoo() {
        return Boo;
    }

    public void setBoo(Boolean boo) {
        Boo = boo;
    }

    public boolean isBoolea() {
        return boolea;
    }

    public void setBoolea(boolean boolea) {
        this.boolea = boolea;
    }

    public char getCha() {
        return cha;
    }

    public void setCha(char cha) {
        this.cha = cha;
    }

    public Character getCharacte() {
        return Characte;
    }

    public void setCharacte(Character characte) {
        Characte = characte;
    }

    public java.sql.Date getDateS() {
        return DateS;
    }

    public void setDateS(java.sql.Date dateS) {
        DateS = dateS;
    }

    public java.util.Date getDateU() {
        return DateU;
    }

    public void setDateU(java.util.Date dateU) {
        DateU = dateU;
    }

    public Double getDou() {
        return Dou;
    }

    public void setDou(Double dou) {
        Dou = dou;
    }

    public double getDoubl() {
        return doubl;
    }

    public void setDoubl(double doubl) {
        this.doubl = doubl;
    }

    public Float getFlo() {
        return Flo;
    }

    public void setFlo(Float flo) {
        Flo = flo;
    }

    public float getFloa() {
        return floa;
    }

    public void setFloa(float floa) {
        this.floa = floa;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public Integer getIntege() {
        return Intege;
    }

    public void setIntege(Integer intege) {
        Intege = intege;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public HashMap getMap() {
        return map;
    }

    public void setMap(HashMap map) {
        this.map = map;
    }

    public String getStrin() {
        return strin;
    }

    public void setStrin(String strin) {
        this.strin = strin;
    }

    public java.sql.Timestamp getTimestam() {
        return Timestam;
    }

    public void setTimestam(java.sql.Timestamp timestam) {
        Timestam = timestam;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "strin='" + strin + '\'' +
                ", in=" + in +
                ", floa=" + floa +
                ", doubl=" + doubl +
                ", boolea=" + boolea +
                ", bigDecima=" + bigDecima +
                ", Dou=" + Dou +
                ", Flo=" + Flo +
                ", Intege=" + Intege +
                ", Boo=" + Boo +
                ", DateS=" + DateS +
                ", DateU=" + DateU +
                ", Timestam=" + Timestam +
                ", cha=" + cha +
                ", Characte=" + Characte +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
