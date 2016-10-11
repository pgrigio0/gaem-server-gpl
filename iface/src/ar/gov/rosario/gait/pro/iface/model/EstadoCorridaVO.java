package ar.gov.rosario.gait.pro.iface.model;

import coop.tecso.demoda.iface.model.BussImageModel;

public class EstadoCorridaVO extends BussImageModel {
	private static final long serialVersionUID = 0;

	private String desEstadoCorrida; // VARCHAR(100) NOT NULL,

	// Contructores	
	public EstadoCorridaVO() {
		super();
	}
	// Constructor para utilizar este VO en un combo como valor SELECCIONAR, TODOS, etc.
	public EstadoCorridaVO(int id, String desEstadoCorrida) {
		super();
		setId(new Long(id));
		setDesEstadoCorrida(desEstadoCorrida);
	}
	

	// Getters y Setters	
	public String getDesEstadoCorrida() {
		return desEstadoCorrida;
	}
	public void setDesEstadoCorrida(String desEstadoCorrida) {
		this.desEstadoCorrida = desEstadoCorrida;
	}
}
