package model;

public class Podcast extends Audio{
    private String episode;

    public String getEpisode() {
        return episode;
    }
    public void setEpisode(String episode) {
        this.episode = episode;
    }

    @Override
    public void play() {
        System.out.println("Escuchando podcast: " + title);
    }
}
