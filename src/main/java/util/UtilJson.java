package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.net.ssl.HttpsURLConnection;

public class UtilJson {

	private UtilJson() {
	}

	public static JsonValue leeJSON(String ruta) {
		try {
			if (ruta.toLowerCase().startsWith("http://")) {
				return leerHttp(ruta);
			} else if (ruta.toLowerCase().startsWith("https://")) {
				return leerHttps(ruta);
			} else {
				return leerFichero(ruta);
			}
		} catch (IOException e) {
			System.out.println("Error procesando documento Json " +
					e.getLocalizedMessage());
			return null;
		}
	}

	private static JsonValue leerFichero(String ruta) throws FileNotFoundException {
		try (JsonReader reader = Json.createReader(new FileReader(ruta))) {
			return reader.read();
			/*
			 * JsonStructure jsonSt = reader.read();
			 * System.out.println(jsonSt.getValueType());
			 * JsonObject jsonObj = reader.readObject();
			 * System.out.println(jsonObj.getValueType());
			 * JsonArray jsonArr = reade r.readArray();
			 * System.out.println(jsonArr.getValueType());
			 */
		}
	}

	@SuppressWarnings("deprecation")
	private static JsonValue leerHttp(String direccion) throws IOException {
		URL url = new URL(direccion);
		try (InputStream is = url.openStream();
				JsonReader reader = Json.createReader(is)) {
			return reader.read();
		}
	}

	@SuppressWarnings("deprecation")
	private static JsonValue leerHttps(String direccion) throws IOException {
		URL url = new URL(direccion);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		try (InputStream is = conn.getInputStream();
				JsonReader reader = Json.createReader(is)) {
			return reader.read();
		} finally {
			conn.disconnect();
		}
	}

	public void escribeJSON(JsonValue json, File f) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(f);
		JsonWriter writer = Json.createWriter(pw);
		// writer.write((JsonStructure) json);
		if (json.getValueType() == JsonValue.ValueType.OBJECT) {
			writer.writeObject(json.asJsonObject());
			// writer.writeObject((JsonObject)json);
		} else if (json.getValueType() == JsonValue.ValueType.ARRAY) {
			writer.writeArray(json.asJsonArray());
			// writer.writeArray((JsonArray)json);
		} else
			System.out.println("No se soporta la escritura");
		writer.close();
	}
}
