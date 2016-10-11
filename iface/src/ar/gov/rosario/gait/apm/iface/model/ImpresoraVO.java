package ar.gov.rosario.gait.apm.iface.model;

import ar.gov.rosario.gait.base.iface.model.GaitBussImageModel;
import ar.gov.rosario.gait.def.iface.model.AreaVO;

public class ImpresoraVO extends GaitBussImageModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "perfilAccesoVO";

	private AreaVO area = new AreaVO();

	private String descripcion;
	
	private String numeroSerie;
	
	private String numeroUUID;
	
	// Constructores
	public ImpresoraVO() {
		super();
	}
	
	// Constructor 
	public ImpresoraVO(int id, String desc) {
		super();
		setId(new Long(id));
		setDescripcion(desc);
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public AreaVO getArea() {
		return area;
	}

	public void setArea(AreaVO area) {
		this.area = area;
	}

	/**
	 * @return the numeroSerie
	 */
	public String getNumeroSerie() {
		return numeroSerie;
	}

	/**
	 * @param numeroSerie the numeroSerie to set
	 */
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	/**
	 * @return the numeroUUID
	 */
	public String getNumeroUUID() {
		return numeroUUID;
	}

	/**
	 * @param numeroUUID the numeroUUID to set
	 */
	public void setNumeroUUID(String numeroUUID) {
		this.numeroUUID = numeroUUID;
	}


}