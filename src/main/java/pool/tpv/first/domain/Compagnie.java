package pool.tpv.first.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Compagnie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codeCompagine;

    private String raisonSociale;

    public Compagnie(){}

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeBranche")
    private List<Branche> branches;

    public Compagnie(String raisonSociale){
        super();
        this.raisonSociale = raisonSociale;
    }

    public Long getCodeCompagine() {
        return codeCompagine;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setCodeCompagine(Long codeCompagine){
        this.codeCompagine = codeCompagine;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }
}
