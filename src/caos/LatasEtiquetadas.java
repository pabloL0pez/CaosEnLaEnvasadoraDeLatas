package caos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LatasEtiquetadas {

	private static final String FIN = "F";
	private static final String GARBANZOS = "G";

	private Secuencia primerSecuencia;
	private Secuencia segundaSecuencia;
	private int distanciaEntreSecuencias = 0;

	private ArrayList<String> latas;

	public LatasEtiquetadas(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		String latita;
		this.primerSecuencia = new Secuencia();
		this.segundaSecuencia = new Secuencia();
		this.latas = new ArrayList<String>();

		while(!((latita = scanner.next()).trim()).equals(FIN)) {
			latas.add(latita);
		}
		
		scanner.close();
	}

	public void resolver() {
		int posInicio = 0;
		int posFin = 0;
		int cantLatas = 0;
		for (int i = 0 ; i < this.latas.size() ; i++) {
			if (this.latas.get(i).equals(GARBANZOS)) {
				posInicio = i;
				cantLatas++;
				i++;
				while (i < this.latas.size() && this.latas.get(i).equals(GARBANZOS)) {
					cantLatas++;
					i++;
				}
				posFin = i-1;
				if (cantLatas > this.primerSecuencia.getCantLatas()) {
					this.segundaSecuencia = primerSecuencia;
					this.primerSecuencia = new Secuencia(cantLatas, posInicio, posFin);
				}
				else {
					if (cantLatas > this.segundaSecuencia.getCantLatas()) {
						this.segundaSecuencia =  new Secuencia(cantLatas, posInicio, posFin);
					}
				}
				cantLatas = 0;
			}
		}
		calcularDistancia();
		escribirSolucion();
	}

	private void calcularDistancia() {
		if (this.primerSecuencia.getCantLatas() == 0 || this.segundaSecuencia.getCantLatas() == 0) {
			this.distanciaEntreSecuencias = 0;
			return;
		}
		if (this.primerSecuencia.getPosInicio() < this.segundaSecuencia.getPosFin()) {
			this.distanciaEntreSecuencias = this.segundaSecuencia.getPosInicio() - this.primerSecuencia.getPosFin() - 1;
		}
		else {
			this.distanciaEntreSecuencias = this.primerSecuencia.getPosInicio() - this.segundaSecuencia.getPosFin() - 1;
		}
	}
	
	private void escribirSolucion() {
		try {
			FileWriter  file = new FileWriter("latas.out");
			BufferedWriter buffer = new BufferedWriter(file);
			buffer.write(String.valueOf(this.latas.size()));
			buffer.newLine();
			buffer.write(String.valueOf(this.primerSecuencia.getCantLatas()));
			buffer.newLine();
			buffer.write(String.valueOf(this.segundaSecuencia.getCantLatas()));
			buffer.newLine();
			buffer.write(String.valueOf(this.distanciaEntreSecuencias));
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void mostrarLatas() {
		for(int i = 0 ; i < this.latas.size() ; i++) {
			System.out.println(this.latas.get(i) + " ");
		}
	}
}
