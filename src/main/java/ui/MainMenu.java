package ui;

import model.Podcast;
import model.Song;
import model.Playlist;
import service.AudioService;
import service.SpotifyService;
import util.ClearScreen;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import io.github.cdimascio.dotenv.Dotenv;

public class MainMenu {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String SPOTIFY_TOKEN = dotenv.get("SPOTIFY_API_TOKEN");
    private static final int PAGE_SIZE = 5;
    private final SpotifyService spotifyService;
    private final AudioService audioService;
    private final Playlist playlist;
    private final List<Podcast> podcasts;
    private int currentSongPage;
    private int currentPodcastPage;

    public MainMenu() {
        this.spotifyService = new SpotifyService(SPOTIFY_TOKEN);
        this.audioService = new AudioService();
        this.playlist = new Playlist();
        this.podcasts = loadPodcasts();
        this.currentSongPage = 0;
        this.currentPodcastPage = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            ClearScreen.clear();
            System.out.println("==============================");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar canciones");
            System.out.println("2. Mostrar podcasts");
            System.out.println("3. Salir");
            System.out.println("==============================\n");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showSongs(scanner);
                    break;
                case "2":
                    showPodcasts(scanner);
                    break;
                case "3":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private void showSongs(Scanner scanner) {
        ClearScreen.clear();
        List<Song> songs;
        try {
            songs = spotifyService.fetchSongs();
        } catch (IOException e) {
            System.out.println("Error al obtener canciones: " + e.getMessage());
            return;
        }

        while (true) {
            ClearScreen.clear();
            int start = currentSongPage * PAGE_SIZE;
            int end = Math.min(start + PAGE_SIZE, songs.size());

            for (int i = start; i < end; i++) {
                Song song = songs.get(i);
                System.out.println((i + 1) + ". " + song.getTitle() + " - " + song.getArtist());
            }
            System.out.println("==============================");
            System.out.println("A. Mostrar más");
            System.out.println("B. Volver al menú principal");
            System.out.println("C. Salir");
            System.out.println("==============================\n");

            String option = scanner.nextLine();

            switch (option.toUpperCase()) {
                case "A":
                    if (end < songs.size()) {
                        currentSongPage++;
                    } else {
                        System.out.println("No hay más canciones.");
                    }
                    break;
                case "B":
                    return;
                case "C":
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    try {
                        int songIndex = Integer.parseInt(option) - 1;
                        if (songIndex >= start && songIndex < end) {
                            handleSongOptions(scanner, songs.get(songIndex));
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Opción no válida.");
                    }
                    break;
            }
        }
    }

    private void handleSongOptions(Scanner scanner, Song song) {
        while (true) {
            ClearScreen.clear();
            System.out.println("Opciones para: " + song.getTitle() + " - " + song.getArtist());
            System.out.println("==============================");
            System.out.println("P. Reproducir");
            System.out.println("F. Añadir a favoritos");
            System.out.println("S. Compartir");
            System.out.println("G. Guardar en playlist");
            System.out.println("R. Calificar con estrellas");
            System.out.println("M. Mostrar más canciones");
            System.out.println("V. Volver al menú principal");
            System.out.println("C. Salir");
            System.out.println("==============================\n");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "P":
                    audioService.playAudio(song);
                    break;
                case "F":
                    audioService.addToFavorites(song);
                    System.out.println("Añadido a favoritos.");
                    break;
                case "S":
                    audioService.shareAudio(song);
                    System.out.println("Canción compartida.");
                    break;
                case "G":
                    playlist.addAudio(song);
                    System.out.println("Guardado en la playlist.");
                    break;
                case "R":
                    System.out.println("Califica la canción con estrellas (1-5):");
                    String rating = scanner.nextLine();
                    audioService.rateAudio(song, Integer.parseInt(rating));
                    System.out.println("Canción calificada con " + rating + " estrellas.");
                    break;
                case "M":
                    return;
                case "V":
                    return;
                case "C":
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println("Presiona Enter para continuar...");
            scanner.nextLine();
        }
    }

    private void showPodcasts(Scanner scanner) {
        ClearScreen.clear();
        int start = currentPodcastPage * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, podcasts.size());

        for (int i = start; i < end; i++) {
            Podcast podcast = podcasts.get(i);
            System.out.println((i + 1) + ". " + podcast.getTitle() + " - " + podcast.getArtist() + " - Episode: " + podcast.getEpisode());
        }
        System.out.println("==============================");
        System.out.println("A. Mostrar más");
        System.out.println("B. Volver al menú principal");
        System.out.println("C. Salir");
        System.out.println("==============================\n");

        String option = scanner.nextLine();

        switch (option.toUpperCase()) {
            case "A":
                if (end < podcasts.size()) {
                    currentPodcastPage++;
                } else {
                    System.out.println("No hay más podcasts.");
                }
                break;
            case "B":
                return;
            case "C":
                System.out.println("Saliendo...");
                System.exit(0);
                break;
            default:
                try {
                    int podcastIndex = Integer.parseInt(option) - 1;
                    if (podcastIndex >= start && podcastIndex < end) {
                        handlePodcastOptions(scanner, podcasts.get(podcastIndex));
                    } else {
                        System.out.println("Opción no válida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Opción no válida.");
                }
                break;
        }
    }

    private void handlePodcastOptions(Scanner scanner, Podcast podcast) {
        while (true) {
            ClearScreen.clear();
            System.out.println("Opciones para: " + podcast.getTitle() + " - " + podcast.getArtist());
            System.out.println("==============================");
            System.out.println("P. Reproducir");
            System.out.println("F. Añadir a favoritos");
            System.out.println("S. Compartir");
            System.out.println("G. Guardar en playlist");
            System.out.println("R. Calificar con estrellas");
            System.out.println("M. Mostrar más podcasts");
            System.out.println("V. Volver al menú principal");
            System.out.println("C. Salir");
            System.out.println("==============================\n");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "P":
                    audioService.playAudio(podcast);
                    break;
                case "F":
                    audioService.addToFavorites(podcast);
                    System.out.println("Añadido a favoritos.");
                    break;
                case "S":
                    audioService.shareAudio(podcast);
                    System.out.println("Podcast compartido.");
                    break;
                case "G":
                    playlist.addAudio(podcast);
                    System.out.println("Guardado en la playlist.");
                    break;
                case "R":
                    System.out.println("Califica el podcast con estrellas (1-5):");
                    String rating = scanner.nextLine();
                    audioService.rateAudio(podcast, Integer.parseInt(rating));
                    System.out.println("Podcast calificado con " + rating + " estrellas.");
                    break;
                case "M":
                    return;
                case "V":
                    return;
                case "C":
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println("Presiona Enter para continuar...");
            scanner.nextLine();
        }
    }

    private List<Podcast> loadPodcasts() {
        List<Podcast> podcastList = new ArrayList<>();

        Podcast p1 = new Podcast();
        p1.setTitle("Podcast 1");
        p1.setArtist("Artist 1");
        p1.setEpisode("Episode 1");
        podcastList.add(p1);

        Podcast p2 = new Podcast();
        p2.setTitle("Podcast 2");
        p2.setArtist("Artist 2");
        p2.setEpisode("Episode 2");
        podcastList.add(p2);

        Podcast p3 = new Podcast();
        p3.setTitle("Podcast 3");
        p3.setArtist("Artist 3");
        p3.setEpisode("Episode 3");
        podcastList.add(p3);

        Podcast p4 = new Podcast();
        p4.setTitle("Podcast 4");
        p4.setArtist("Artist 4");
        p4.setEpisode("Episode 4");
        podcastList.add(p4);

        Podcast p5 = new Podcast();
        p5.setTitle("Podcast 5");
        p5.setArtist("Artist 5");
        p5.setEpisode("Episode 5");
        podcastList.add(p5);

        Podcast p6 = new Podcast();
        p6.setTitle("Podcast 6");
        p6.setArtist("Artist 6");
        p6.setEpisode("Episode 6");
        podcastList.add(p6);

        return podcastList;
    }
    public static void main(String[] args) {
        new MainMenu().start();
    }
}
