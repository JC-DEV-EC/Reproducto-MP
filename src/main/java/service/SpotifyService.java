package service;

import model.Song;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SpotifyService {

    private final String token;
    private final OkHttpClient client;

    public SpotifyService(String token) {
        this.token = token;
        this.client = new OkHttpClient();
    }

    public List<Song> fetchSongs() throws IOException {
        List<Song> songs = new ArrayList<>();
        String url = "https://api.spotify.com/v1/me/top/tracks"; // URL de ejemplo; usa la URL correcta de la API

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);

            // Asegúrate de que estás accediendo al campo correcto
            JSONArray items = jsonObject.getJSONArray("items");

            for (int i = 0; i < items.length(); i++) {
                JSONObject songJson = items.getJSONObject(i);

                // Accede a los campos de canción
                String title = songJson.getString("name");
                String artist = songJson.getJSONArray("artists")
                        .getJSONObject(0)
                        .getString("name");

                Song song = new Song();
                song.setTitle(title);
                song.setArtist(artist);
                songs.add(song);
            }
        }
        return songs;
    }
}
