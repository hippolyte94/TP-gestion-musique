import java.util.ArrayList;

public class Vue {

    public static void messageBienvenu(){
        System.out.println("Bienvennu dans jHubMusic !!!\n" +
                "Vous souhaitez ecouter vos musiques preferer et composer vos playlist personnel ? ");
    }

    public static void help(){
        System.out.println("c : rajout d'u8ne nouvelles chanson\n" +
                "a : rajout d'un nouvel album\n" +
                "+ : rajout d'une chanson existante à un album\n" +
                "l : rajout d'un nouveu livre audio\n" +
                "p : creation d'une nouvelle playlist a partir de chansons et de livre audio existants\n" +
                "- : suppression d'une playlist\n" +
                "s : sauvegarde des playlists, des albuls, des chasons et des livres audios dans les fichiers concernes\n" +
                "h : aides avec les details des commandes precedentes");
    }

    public static void affichePlaylist(ArrayList<E> pl){
        for (E s :pl)
            pl.toString();

    }



}
