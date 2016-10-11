package ar.gov.rosario.gait.apm.iface.model;

import java.util.ArrayList;
import java.util.List;

import ar.gov.rosario.gait.apm.iface.util.ApmSecurityConstants;
import ar.gov.rosario.gait.base.iface.model.GaitAdapterModel;
import ar.gov.rosario.gait.base.iface.model.GaitBussImageModel;
import ar.gov.rosario.gait.base.iface.util.BaseSecurityConstants;
import coop.tecso.demoda.iface.model.SiNo;
import coop.tecso.demoda.iface.model.Tratamiento;

/**
 * Adapter del Campo
 * 
 * @author tecso
 */

public class CampoAdapter extends GaitAdapterModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "campoAdapterVO";
	public static final String ENC_NAME = "encCampoAdapterVO";

	private CampoVO campo = new CampoVO();
	private List<SiNo> listSiNo = new ArrayList<SiNo>();
	private List<Tratamiento> listTratamiento = new ArrayList<Tratamiento>();

	// Constructores
	public CampoAdapter() {
		super(ApmSecurityConstants.ABM_CAMPO);
	}

	// Getters y Setters

	public List<SiNo> getListSiNo() {
		return listSiNo;
	}

	public void setListSiNo(List<SiNo> listSiNo) {
		this.listSiNo = listSiNo;
	}

	public String getName() {
		return NAME;
	}

	/**
	 * @return the campo
	 */
	public CampoVO getCampo() {
		return campo;
	}

	/**
	 * @param campo the campo to set
	 */
	public void setCampo(CampoVO campo) {
		this.campo = campo;
	}

	/**
	 * @return the listTratamiento
	 */
	public List<Tratamiento> getListTratamiento() {
		return listTratamiento;
	}

	/**
	 * @param listTratamiento the listTratamiento to set
	 */
	public void setListTratamiento(List<Tratamiento> listTratamiento) {
		this.listTratamiento = listTratamiento;
	}


	// View getters
	// Permisos para ABM CampoValor
	public String getVerCampoValorEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_CAMPOVALOR, BaseSecurityConstants.VER);
	}
	public String getModificarCampoValorEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_CAMPOVALOR, BaseSecurityConstants.MODIFICAR);
	}
	public String getEliminarCampoValorEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_CAMPOVALOR, BaseSecurityConstants.ELIMINAR);
	}
	public String getAgregarCampoValorEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_CAMPOVALOR, BaseSecurityConstants.AGREGAR);
	}    
}