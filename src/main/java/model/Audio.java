package model;

public abstract class Audio {
    protected String title;
    protected String artist;
    protected int duration; // Duration in seconds
    protected int likes;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getLikes() { return likes; }
    public void like() { this.likes++; }

    public abstract void play();
}
