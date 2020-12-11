import java.util.ArrayList;
import java.util.UUID;

public class Musique extends Audio implements  Comparable<Musique>{

    private Genre genre;
    private UUID albumId;

    public Musique(String titre, ArrayList<String> auteurs, long duree, UUID id, Genre genre, UUID albumId) {
        super(titre, auteurs, duree, id);
        this.genre = genre;
        this.albumId = albumId;
    }

    public boolean isInAnAlbum(){
        if (albumId == null)
                return false;
        return true;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public UUID getAlbumId() {
        return albumId;
    }

    public void setAlbumId(UUID albumId) {
        this.albumId = albumId;
    }

    @Override
    public int compareTo(Musique o) {
        return this.albumId.compareTo(o.getAlbumId());
    }
}
