import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

// Gere la lecture/Ecriture des fichiers
public class Gestion implements Serializable{

    private static final long serialVersionUID = 1L;

    final static String csvFile_Musique = "path";
    final static String csvFile_LivreAudio = "path";
    final static String csvFile_Album = "path";
    final static String csvFile_Playlist = "path";
    private ArrayList<String> musique;
    private ArrayList<String> livreAudio;
    private ArrayList<String> album;
    private ArrayList<String> playList;
    private Set<Musique> listMusiques;
    private ArrayList<Album> listAlbums;
    private Map<UUID, ArrayList<UUID>> multimap;

    public Gestion (){
        listMusiques = new TreeSet<>();
        listAlbums = new ArrayList<>();
        multimap = new HashMap<>();
        allFileReader();
        gestionMusique();
        gestionAlbum();
    }

    private void allFileReader() {
        musique = fileReader(csvFile_Musique);
        livreAudio = fileReader(csvFile_LivreAudio);
        album = fileReader(csvFile_Album);
        playList = fileReader(csvFile_Playlist);
    }

    private void gestionMusique(){
        String titre;
        ArrayList<String> artistes = new ArrayList<>();
        long duree;
        UUID id;
        Genre genre;
        UUID albumId;
        // Remplie la liste des musiques apres avoir traité chaque ligne.
        for (int i = 0; i < musique.size(); i++) {

            String[] temp = musique.get(i).split(";");
            String[] artistesTemp = temp[1].split(",");

            artistes.addAll(Arrays.asList(artistesTemp));
            titre = temp[0];
            duree = Long.parseLong(temp[2]);
            id = UUID.fromString(temp[3]);
            genre = Genre.valueOf(temp[4].toUpperCase());
            albumId = UUID.fromString(temp[5]);
            Musique musiccTemp = new Musique(titre,artistes,duree,id,genre,albumId);
            listMusiques.add(musiccTemp);
        }

    }

    private void gestionAlbum() {
        ArrayList<Musique> listMusique = new ArrayList<>();
        String titre;
        ArrayList<String> artistes = new ArrayList<>();
        long duree;
        Date date = null;
        UUID id;
        Set<Musique> tempList = listMusiques;

        for(int i = 0; i < this.album.size(); i++) {
            String[] temp = album.get(i).split(";");
            String[] artistesTemp = temp[2].split(",");

            id = UUID.fromString(temp[0]);
            titre = temp[1];
            artistes.addAll(Arrays.asList(artistesTemp));
            duree = Long.parseLong(temp[3]);
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(temp[4]);
            }catch (Exception e){
                System.out.println(e);
            }

            Iterator<Musique> iterator = tempList.iterator();
            while (iterator.hasNext()){
                Musique tmp = iterator.next();
                if(tmp.isInAnAlbum() && tmp.getAlbumId().compareTo(id) == 0) {
                    listMusique.add(tmp);
                    iterator.remove();
                }
            }

            Album tempAlbum = new Album(titre,artistes,duree,date,listMusique,id);
            listAlbums.add(tempAlbum);
        }

    }

    private ArrayList<String> fileReader(String path){

        ArrayList<String> allLine = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine;

            while ((currentLine = reader.readLine()) != null)
                allLine.add(currentLine);

            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return allLine;
    }

    private boolean fileWriter(String path, String content){

        boolean result = true;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path,false))){

            writer.write(content);
            writer.flush();

            writer.close();

        } catch (IOException e) {
            result = false;
            e.printStackTrace();
        }


        return result;
    }

    public boolean addingContent(String type, String content){

        boolean result = true;

        if (type != null)
            switch (type) {
                case "Musique":
                    result = fileWriter(csvFile_Musique,content);
                    break;

                case "Playlist":
                    result = fileWriter(csvFile_Playlist,content);
                    break;

                case "Album":
                    result = fileWriter(csvFile_Album,content);
                    break;

                case "LivreAudio":
                    result = fileWriter(csvFile_LivreAudio,content);
                    break;

            }
        return result;
    }

    public ArrayList<String> getMusique() {
        return musique;
    }

    public ArrayList<String> getLivreAudio() {
        return livreAudio;
    }

    public ArrayList<String> getAlbum() {
        return album;
    }

    public ArrayList<String> getPlayList() {
        return playList;
    }
}
