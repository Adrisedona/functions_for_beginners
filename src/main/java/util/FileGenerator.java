package util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Clase para generar archivos con un tamaño determinado
 */
public class FileGenerator {
	
	private File file;
	private static final Random rnd = new Random();
	/**
	 * Ruta relativa para el archivo por defecto
	 */
	public static final String DEFAULT = "archivo.dat";

	public FileGenerator() {
		file = new File(DEFAULT);
	}

	public FileGenerator(File file) {
		this.file = file;
	}

	public FileGenerator(String path) {
		this.file = new File(path);
	}

	private byte randomByte() {
		return ((byte) rnd.nextInt(256));
	}

	@SuppressWarnings("unused")
	private int randomInt() {
		return rnd.nextInt(Integer.MAX_VALUE);
	}

	private long randomLong() {
		return rnd.nextLong(Long.MAX_VALUE);
	}

	public boolean generateFile(int bytes) {
		try (DataOutputStream dOut = new DataOutputStream(new FileOutputStream(file))) {
			for (int i = 0; i < bytes; i++) {
				dOut.writeByte(randomByte());
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public boolean generateFileMB(int megaBytes) {
		long longs = megaBytes / 8 * (1 << 20) ;
		try (DataOutputStream dOut = new DataOutputStream(new FileOutputStream(file))) {
			for (long i = 0; i < longs; i++) {
				dOut.writeLong(randomLong());
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public boolean generateFileGB(int gigaBytes) {
		long longs = gigaBytes / 8 * (1 << 30);
		try (DataOutputStream dOut = new DataOutputStream(new FileOutputStream(file))) {
			for (long i = 0; i < longs; i++) {
				dOut.writeLong(randomLong());
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
