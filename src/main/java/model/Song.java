package model;

public class Song extends Audio {
    private String source;

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo la canción: " + title);
    }
}
