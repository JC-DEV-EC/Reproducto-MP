# Desafío - Reproductor de Audio en Java

![Estado del Proyecto](https://img.shields.io/badge/estado-en%20desarrollo-yellow.svg)
![Versión](https://img.shields.io/badge/versión-1.0.0-brightgreen.svg)
[![MIT License](https://img.shields.io/badge/licencia-MIT-blue.svg)](LICENSE)

![Reproductor de Audio](https://cdn1.gnarususercontent.com.br/6/408785/217bbdb0-d321-4e7b-be86-7b6472c85a60.png)


**Desafío - Reproductor de Audio en Java** es una aplicación de consola que permite gestionar y reproducir canciones y podcasts de manera interactiva. El usuario puede ver listas de canciones/podcasts, reproducirlas, añadirlas a favoritos, compartirlas, guardarlas en playlists, y calificarlas. Todo desde una interfaz de consola intuitiva.

## 🚀 Descripción

Este proyecto incluye las siguientes funcionalidades:

- **Mostrar Canciones**: Visualiza una lista de canciones que se pueden reproducir, añadir a favoritos o guardar en una playlist.
- **Mostrar Podcasts**: Accede a una lista de podcasts con las mismas opciones que las canciones.
- **Reproducir Canciones/Podcasts**: Elige una canción o podcast para reproducir desde la consola.
- **Añadir a Favoritos**: Guarda tus canciones o podcasts favoritos.
- **Compartir**: Opción para simular el compartir el contenido.
- **Guardar en Playlist**: Añade canciones o podcasts a una playlist personalizada.
- **Calificar**: Opción para calificar una canción o podcast con estrellas.

## 🛠️ Tecnologías Utilizadas

- **Java**: Lenguaje principal de desarrollo.
- **OkHttp**: Para realizar peticiones HTTP a la API de Spotify.
- **org.json**: Para procesar las respuestas en formato JSON.
- **.env**: Para gestionar de manera segura el token de la API de Spotify.

## 🏗️ Instalación

Para ejecutar este proyecto localmente, sigue los pasos:

1. **Clona el repositorio**:

    ```bash
    git clone https://github.com/JC-DEV-EC/Reproducto-MP.git
    ```

2. **Navega al directorio del proyecto**:

    ```bash
    cd Reproducto-MP
    ```

3. **Configura tu token de Spotify**:
    - Crea un archivo `.env` en la raíz del proyecto.
    - Añade tu token de la API de Spotify dentro del archivo `.env` con el siguiente formato:

    ```plaintext
    SPOTIFY_API_TOKEN=TU_TOKEN_DE_SPOTIFY
    ```

    > **Nota:** Deberás obtener tu propio token de la API de Spotify desde [Spotify Developer](https://developer.spotify.com/dashboard/login) y reemplazar `TU_TOKEN_DE_SPOTIFY` con el valor del token.

4. **Compila y ejecuta el programa** usando tu IDE de Java favorito o desde la terminal:

    ```bash
    javac Main.java
    java Main
    ```

## 🖥️ Uso

- **Mostrar canciones/podcasts**: Elige la opción correspondiente en el menú para visualizar la lista de canciones o podcasts disponibles.
- **Seleccionar opciones**: Cada canción o podcast tiene opciones para reproducir, añadir a favoritos, compartir, guardar en una playlist o calificar.
- **Navegar por la lista**: Puedes avanzar o volver al menú principal según las opciones que elijas.

## 🔑 Manejo de API y Token de Spotify

Este proyecto utiliza la API de Spotify para obtener canciones y podcasts. Para evitar exponer tus credenciales, sigue estos pasos:

1. **Obtener el Token**: Dirígete a [Spotify Developer](https://developer.spotify.com/dashboard/login) para obtener un token de acceso.
2. **Agregar Token al Archivo `.env`**: Crea el archivo `.env` como se describió anteriormente y pega tu token.
3. **Actualizar el Token**: El token de Spotify tiene una duración limitada, por lo que tendrás que renovarlo manualmente o implementar un mecanismo de actualización automática.

> **Importante**: El archivo `.env` no debe ser subido a GitHub. Asegúrate de incluirlo en tu archivo `.gitignore` para proteger la privacidad de tu token.

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, sigue estos pasos:

1. **Haz un fork del repositorio**.
2. **Crea una nueva rama** para tus cambios (`git checkout -b mi-rama`).
3. **Haz commit** de tus cambios (`git commit -am 'Añadí una nueva función'`).
4. **Push** a la rama (`git push origin mi-rama`).
5. **Crea un Pull Request** en GitHub.

## 🙏 Agradecimientos

Este proyecto ha sido desarrollado como parte de un desafío personal para mejorar habilidades en Java y trabajar con la API de Spotify.

## 👤 Autor

Este proyecto fue creado y es mantenido por [JC-DEV-EC](https://github.com/JC-DEV-EC).

## 📜 Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.
