import java.util.ArrayList;
import java.util.UUID;

public abstract class Audio {

    private String titre;
    private ArrayList<String> auteurs;
    private long duree;
    private UUID id;
    private String contenu = null;

    public Audio(String titre, ArrayList<String> auteurs, long duree, UUID id) {
        this.titre = titre;
        this.auteurs = auteurs;
        this.duree = duree;
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ArrayList<String> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(ArrayList<String> auteurs) {
        this.auteurs = auteurs;
    }

    public long getDuree() {
        return duree;
    }

    public void setDuree(long duree) {
        this.duree = duree;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
