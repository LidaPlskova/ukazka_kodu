package net.sevecek.zakladniwebapp;

public class CinnostVMesici {

    private int mesic;
    private String cinnost;

    public int getMesic() {
        return mesic;
    }

    public void setMesic(int mesic) {
        this.mesic = mesic;
    }

    public String getCinnost() {
        return cinnost;
    }

    public void setCinnost(String cinnost) {
        this.cinnost = cinnost;
    }

    public CinnostVMesici() {
    }

    public CinnostVMesici(int mesic, String cinnost) {
        this.mesic = mesic;
        this.cinnost = cinnost;
    }

    @Override
    public String toString() {
        return "CinnostVMesici{" +
                "mesic=" + mesic +
                ", cinnost='" + cinnost + '\'' +
                '}';
    }
}
