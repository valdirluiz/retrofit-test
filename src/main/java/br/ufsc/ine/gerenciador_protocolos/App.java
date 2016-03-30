package br.ufsc.ine.gerenciador_protocolos;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Teste com chamada de webservice
 *
 */
public class App {

	public static final String API_URL = "https://api.github.com";

	public static void main(String... args) throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create())
				.build();

		GitHub github = retrofit.create(GitHub.class);

		Call<List<Contributor>> call = github.contributors("square", "retrofit");

		List<Contributor> contributors = call.execute().body();
		for (Contributor contributor : contributors) {
			System.out.println(contributor.login + " (" + contributor.contributions + ")");
		}
	}
}
