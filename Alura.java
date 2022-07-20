package alura;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Alura {
	
	public static void main(String[] args) throws IOException, InterruptedException {
			
		// pegar os dados da http
		
		String url = "https://api.mocki.io/v2/549a5d8b";
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		
		
		// Pegar dados ( titulo, poster....)
		var parser = new Jsonparser();
		List<Map<String, String>> ListaDeFilmes = parser.parse(body);
		
		//exibir e manipular os dados
		
		var geradora = new GeradorDeFigurinhaWhatsapp<>();
        for (Map<String,String> filme : ListaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            GeradorDeFigurinhaWhatsapp.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();
			
			
			
			
		}
		
		
	}

}
