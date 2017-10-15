package caos;

public class Secuencia {

	private int cantLatas;
	private int posInicio;
	private int posFin;
	
	public Secuencia() {
		this.cantLatas = 0;
		this.posInicio = 0;
		this.posFin = 0;
	}
	
	public Secuencia(int cantLatas, int posInicio, int posFin) {
		this.cantLatas = cantLatas;
		this.posInicio = posInicio;
		this.posFin = posFin;
	}

	public int getCantLatas() {
		return cantLatas;
	}

	public int getPosInicio() {
		return posInicio;
	}

	public int getPosFin() {
		return posFin;
	}
	
}
