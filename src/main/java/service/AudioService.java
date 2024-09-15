package service;

import model.Audio;

import java.util.ArrayList;
import java.util.List;

public class AudioService {

    private final List<Audio> favorites;

    public AudioService() {
        this.favorites = new ArrayList<>();
    }

    // Método para añadir un audio a la lista de favoritos
    public void addToFavorites(Audio audio) {
        if (!favorites.contains(audio)) {
            favorites.add(audio);
            System.out.println(audio.getTitle() + " ha sido añadido a favoritos.");
        } else {
            System.out.println(audio.getTitle() + " ya está en favoritos.");
        }
    }

    // Método para reproducir un audio
    public void playAudio(Audio audio) {
        System.out.println("Reproduciendo: " + audio.getTitle() + " por " + audio.getArtist());
    }

    // Método para compartir un audio
    public void shareAudio(Audio audio) {
        System.out.println("Compartiendo " + audio.getTitle() + " por " + audio.getArtist());
    }

    // Método para calificar un audio
    public void rateAudio(Audio audio, int stars) {
        System.out.println("Has calificado " + audio.getTitle() + " con " + stars + " estrellas.");
    }

    // Método para obtener la lista de favoritos
    public List<Audio> getFavorites() {
        return favorites;
    }
}
