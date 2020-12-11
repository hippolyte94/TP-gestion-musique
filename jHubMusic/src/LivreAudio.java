import java.util.ArrayList;
import java.util.UUID;

public class LivreAudio extends Audio {

    private Langue langue;
    private Cathegorie cathegorie;
    public LivreAudio(String titre, ArrayList<String> auteurs, long duree,Langue langue,Cathegorie cathegorie, UUID id) {
        super(titre, auteurs, duree, id);
        this.cathegorie = cathegorie;
        this.langue = langue;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public Cathegorie getCathegorie() {
        return cathegorie;
    }

    public void setCathegorie(Cathegorie cathegorie) {
        this.cathegorie = cathegorie;
    }
}
