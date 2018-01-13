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

    public Map<Integer, List<String>> getCinnostiPodleMesicu() {
        return cinnostiPodleMesicu;
    }

    public void setCinnostiPodleMesicu(Map<Integer, List<String>> cinnostiPodleMesicu) {
        this.cinnostiPodleMesicu = cinnostiPodleMesicu;
    }

    public Map<String, List<Integer>> getMesicePodleCinnosti() {
        return mesicePodleCinnosti;
    }

    public void setMesicePodleCinnosti(Map<String, List<Integer>> mesicePodleCinnosti) {
        this.mesicePodleCinnosti = mesicePodleCinnosti;
    }

    public void nastavCinnostiVMesici(List<CinnostVMesici> cinnostiVMesici) {
        doplnCinnostiPodleMesicu(cinnostiVMesici);
        doplnMesicePodleCinnosti(cinnostiVMesici);
    }

    private void doplnMesicePodleCinnosti(List<CinnostVMesici> cinnostiVMesici) {

        mesicePodleCinnosti = new LinkedHashMap<>();

        for (CinnostVMesici cinnostVMesici : cinnostiVMesici) {
            mesicePodleCinnosti.put(cinnostVMesici.getCinnost(), new ArrayList<>());
        }

        for (CinnostVMesici cinnostVMesici : cinnostiVMesici) {
            List<Integer> prihradkaCinnosti = mesicePodleCinnosti.get(cinnostVMesici.getCinnost());
            prihradkaCinnosti.add(cinnostVMesici.getMesic());
        }
    }

    private void doplnCinnostiPodleMesicu(List<CinnostVMesici> cinnostiVMesici) {

        cinnostiPodleMesicu = new LinkedHashMap<Integer, List<String>>();

        cinnostiPodleMesicu.put(1, new ArrayList<>());
        cinnostiPodleMesicu.put(2, new ArrayList<>());
        cinnostiPodleMesicu.put(3, new ArrayList<>());
        cinnostiPodleMesicu.put(4, new ArrayList<>());
        cinnostiPodleMesicu.put(5, new ArrayList<>());
        cinnostiPodleMesicu.put(6, new ArrayList<>());
        cinnostiPodleMesicu.put(7, new ArrayList<>());
        cinnostiPodleMesicu.put(8, new ArrayList<>());
        cinnostiPodleMesicu.put(9, new ArrayList<>());
        cinnostiPodleMesicu.put(10, new ArrayList<>());
        cinnostiPodleMesicu.put(11, new ArrayList<>());
        cinnostiPodleMesicu.put(12, new ArrayList<>());

        for (CinnostVMesici cinnostVMesici : cinnostiVMesici) {

            int mesic = cinnostVMesici.getMesic();
            List<String> prihradkaMesicu = cinnostiPodleMesicu.get(mesic);
            prihradkaMesicu.add(cinnostVMesici.getCinnost());
        }
    }

    @Override
    public String toString() {
        return "Rostlina{" +
                "id=" + id +
                ", nazev='" + nazev + '\'' +
                ", popis='" + popis + '\'' +
                ", cinnostiPodleMesicu=" + cinnostiPodleMesicu +
                ", mesicePodleCinnosti=" + mesicePodleCinnosti +
                '}';
    }
}