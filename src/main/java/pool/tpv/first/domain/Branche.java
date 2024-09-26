package pool.tpv.first.domain;

import jakarta.persistence.*;

@Entity
public class Branche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codeBranche;

    private String nomBranche;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codeCompagnie")
    private Compagnie codeCompagnie;

    public Branche(){}

    public Branche(String nomBranche, Compagnie codeCompagnie){
        super();
        this.nomBranche = nomBranche;
        this.codeCompagnie = codeCompagnie;
    }

    public Compagnie getCodeCompagnie() {
        return codeCompagnie;
    }

    public void setCodeCompagnie(Compagnie codeCompagnie) {
        this.codeCompagnie = codeCompagnie;
    }

    public Long getCodeBranche() {
        return codeBranche;
    }

    public String getNomBranche() {
        return nomBranche;
    }

    public void setCodeBranche(Long codeBranche) {
        this.codeBranche = codeBranche;
    }

    public void setNomBranche(String nomBranche) {
        this.nomBranche = nomBranche;
    }
}
