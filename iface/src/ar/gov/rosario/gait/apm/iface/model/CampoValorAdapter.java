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
 * Adapter del Campo Valor
 * 
 * @author tecso
 */

public class CampoValorAdapter extends GaitAdapterModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "campoValorAdapterVO";
	public static final String ENC_NAME = "encCampoValorAdapterVO";

	private CampoValorVO campoValor = new CampoValorVO();
	private List<SiNo> listSiNo = new ArrayList<SiNo>();
	private List<Tratamiento> listTratamiento = new ArrayList<Tratamiento>();

	// Constructores
	public CampoValorAdapter() {
		super(ApmSecurityConstants.ABM_CAMPOVALOR);
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
	public CampoValorVO getCampoValor() {
		return campoValor;
	}

	/**
	 * @param campo the campo to set
	 */
	public void setCampoValor(CampoValorVO campoValor) {
		this.campoValor = campoValor;
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
	public String getVerCampoValorOpcionEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_CAMPOVALOR_OPCION, BaseSecurityConstants.VER);
	}
	public String getModificarCampoValorOpcionEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_CAMPOVALOR_OPCION, BaseSecurityConstants.MODIFICAR);
	}
	public String getEliminarCampoValorOpcionEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_CAMPOVALOR_OPCION, BaseSecurityConstants.ELIMINAR);
	}
	public String getAgregarCampoValorOpcionEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_CAMPOVALOR_OPCION, BaseSecurityConstants.AGREGAR);
	}    
}