package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscrevendoJSON {
	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("979.796.810-37");
		usuario1.setLogin("admin");
		usuario1.setSenha("123456");
		usuario1.setNome("Leonardo Villar");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("092.026.200-75");
		usuario2.setLogin("admin2");
		usuario2.setSenha("789456");
		usuario2.setNome("Giovanna Sousa");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\Leonardo\\git\\repository12\\Arquivos-TXT\\src\\arquivos\\filejson.json");
		
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		/* -------------- LENDO O ARQUIVO JSON -------------- */
		
		System.out.println("==================================================");
		
		FileReader fileReader = new FileReader("C:\\Users\\Leonardo\\git\\repository12\\Arquivos-TXT\\src\\arquivos\\filejson.json");
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listaUsuarios.add(usuario);
		}
		
		System.out.println("Leitura do arquivo JSON: " + listaUsuarios);
	}
}
