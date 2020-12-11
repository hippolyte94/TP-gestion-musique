import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Album {

    private ArrayList<Musique> listMusique;
    private String titre;
    private ArrayList<String> artiste;
    private long dureeEnS;
    private Date dateSortie;
    private UUID id;

    public Album(String titre, ArrayList<String> artiste, long dureeEnS, Date dateSortie, ArrayList<Musique> listMusique,UUID id) {
        this.titre = titre;
        this.artiste = artiste;
        this.dureeEnS = dureeEnS;
        this.dateSortie = dateSortie;
        this.id = id;
        this.listMusique =  listMusique;
    }

    public ArrayList<Musique> getListMusique() {
        return listMusique;
    }

    public void setListMusique(ArrayList<Musique> listMusique) {
        this.listMusique = listMusique;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ArrayList<String> getArtiste() {
        return artiste;
    }

    public void setArtiste(ArrayList<String> artiste) {
        this.artiste = artiste;
    }

    public long getDureeEnS() {
        return dureeEnS;
    }

    public void setDureeEnS(long dureeEnS) {
        this.dureeEnS = dureeEnS;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
