import java.time.LocalDate;

public class JizdaVozidla {
    private LocalDate dattum;
    private Double spotrebaBenzinu;
    private String jmeno;
    private Integer ujeteKilometry;
    private Integer typ;

    public JizdaVozidla(LocalDate dattum, Double spotrebaBenzinu, String jmeno, Integer ujeteKilometry, Integer typ) {
        this.dattum = dattum;
        this.spotrebaBenzinu = spotrebaBenzinu;
        this.jmeno = jmeno;
        this.ujeteKilometry = ujeteKilometry;
        this.typ = typ;
    }

    public LocalDate getDattum() {
        return dattum;
    }

    public Double getSpotrebaBenzinu() {
        return spotrebaBenzinu;
    }

    public String getJmeno() {
        return jmeno;
    }

    public Integer getUjeteKilometry() {
        return ujeteKilometry;
    }

    public Integer getTyp() {
        return typ;
    }

    public void setDattum(LocalDate dattum) {
        this.dattum = dattum;
    }

    public void setSpotrebaBenzinu(Double spotrebaBenzinu) {
        this.spotrebaBenzinu = spotrebaBenzinu;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setUjeteKilometry(Integer ujeteKilometry) {
        this.ujeteKilometry = ujeteKilometry;
    }

    public void setTyp(Integer typ) {
        this.typ = typ;
    }
}
