package br.com.anderson.screenmatch;

import br.com.anderson.screenmatch.model.DadosSerie;
import br.com.anderson.screenmatch.service.ConsumoApi;
import br.com.anderson.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=a3cb1867");
		System.out.println(json);

		ConverteDados convesor = new ConverteDados();
		DadosSerie dados = convesor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
