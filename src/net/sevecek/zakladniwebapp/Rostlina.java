package net.sevecek.zakladniwebapp;

import java.util.*;

public class Rostlina {

    private int id;
    private String nazev;
    private String popis;
    private Map<Integer, List<String>> cinnostiPodleMesicu;
    private Map<String, List<Integer>> mesicePodleCinnosti;

    public Rostlina() {
    }

    @Override
    public String toString() {
        return "Rostlina{" +
                "id=" + id +
                ", nazev='" + nazev + '\'' +
                ", popis='" + popis + '\'' +
                ", cinnostiPodleMesicu=" + cinnostiPodleMesicu +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public void setCinnostiPodleMesicu(Map<Integer, List<String>> cinnostiPodleMesicu) {
        this.cinnostiPodleMesicu = cinnostiPodleMesicu;
    }

    public Map<Integer, List<String>> getCinnostiPodleMesicu() {
        return cinnostiPodleMesicu;
    }
}