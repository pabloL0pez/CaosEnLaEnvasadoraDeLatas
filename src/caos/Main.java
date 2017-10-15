package caos;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		try {
			LatasEtiquetadas latas = new LatasEtiquetadas("latas.in");
			latas.resolver();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
