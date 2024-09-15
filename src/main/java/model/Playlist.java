package model;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Audio> audios;

    public Playlist() {
        this.audios = new ArrayList<>();
    }

    public void addAudio(Audio audio) {
        audios.add(audio);
    }

    public List<Audio> getAudios() {
        return audios;
    }

    public void playAll() {
        for (Audio audio : audios) {
            audio.play();
        }
    }
}
