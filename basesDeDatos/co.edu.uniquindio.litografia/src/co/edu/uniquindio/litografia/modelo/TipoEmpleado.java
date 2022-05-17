package co.edu.uniquindio.litografia.modelo;

public enum TipoEmpleado {
	
	JEFE_LITOGRAFIA(0), DISEÑADORA(1), SECRETARIA(2), CONTADORA(3);
	
	private static final long serialVersionUID = 1L;
	private int numEmpleado;

	/**
	 * Constructor
	 * @param numEmpleado
	 */
	private TipoEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	
	private TipoEmpleado() {}

	//----------Métodos Getters and Setters-------------------------------->
	public int getnumEmpleado() {
		return numEmpleado;
	}
	public void setnumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	//---------------------------------------------------------------------|
	
	public TipoEmpleado getTipoEmpleado(int index) {
		
		TipoEmpleado tipoEmpleado = switch (index) {
		
			case 0 -> TipoEmpleado.JEFE_LITOGRAFIA;
			
			case 1 -> TipoEmpleado.DISEÑADORA;

			case 2 -> TipoEmpleado.SECRETARIA;
			
			case 3 -> TipoEmpleado.CONTADORA;
			
			default -> null;
		};
		return tipoEmpleado;
	}

}
