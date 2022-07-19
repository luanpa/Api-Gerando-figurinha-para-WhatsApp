package alura;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhaWhatsapp<Buffreredimage> {
	
	public static void cria (InputStream inputStream, String nomeArquivo) throws IOException {
		
		// leitura de imagem
		
		
		/**Buscar na Pasta a Imagem
		InputStream inputSream = new FileInputStream(new File("entrada/filme.jpg"));
		*/
		
		/*Buscar no Url
		 * InputStream inputStream = new URL("https://www.alura.com.br/assets/img/alura-share.1647533642.png").openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		*/
		
		
		// leitura de imagem
		
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		//cria nova imagem em memoria com trasparencia e com tamanho novo
		int largura = imagemOriginal.getHeight();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura,BufferedImage.TYPE_USHORT_555_RGB);
		
		
		// copiar a imagem original (pra nova imagem em memoria)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, null, 0, 0);
		
		//configurar Fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 80);
		graphics.setColor(Color.orange);
		graphics.setFont(fonte);
		
		// escrever uma imagem na nova imagem
		graphics.drawString("Imersão Java ", 100, novaAltura - 100);
		
		//escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File("nomeAquivo"));
	}

	
}
