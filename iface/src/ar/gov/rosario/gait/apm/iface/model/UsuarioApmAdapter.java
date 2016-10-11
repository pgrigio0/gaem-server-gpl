package ar.gov.rosario.gait.apm.iface.model;

import java.util.ArrayList;
import java.util.List;

import ar.gov.rosario.gait.apm.iface.util.ApmSecurityConstants;
import ar.gov.rosario.gait.base.iface.model.GaitAdapterModel;
import ar.gov.rosario.gait.base.iface.model.GaitBussImageModel;
import ar.gov.rosario.gait.base.iface.util.BaseSecurityConstants;
import coop.tecso.demoda.iface.model.SiNo;

/**
 * Adapter del UsuarioApm
 * 
 * @author tecso
 */

public class UsuarioApmAdapter extends GaitAdapterModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "usuarioApmAdapterVO";
	public static final String ENC_NAME = "encUsuarioApmAdapterVO";

	private UsuarioApmVO usuarioApm = new UsuarioApmVO();
	private List<SiNo> listSiNo = new ArrayList<SiNo>();


	// Constructores
	public UsuarioApmAdapter() {
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

	public UsuarioApmVO getUsuarioApm() {
		return usuarioApm;
	}

	public void setUsuarioApm(UsuarioApmVO usuarioApm) {
		this.usuarioApm = usuarioApm;
	}

	// View getters
	// Permisos para ABM PERFIL ACCESO USUARIO
	public String getVerPerfilAccesoUsuarioEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_PERFILACCESOUSUARIO, BaseSecurityConstants.VER);
	}
	public String getModificarPerfilAccesoUsuarioEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_PERFILACCESOUSUARIO, BaseSecurityConstants.MODIFICAR);
	}
	public String getEliminarPerfilAccesoUsuarioEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_PERFILACCESOUSUARIO, BaseSecurityConstants.ELIMINAR);
	}
	public String getAgregarPerfilAccesoUsuarioEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_PERFILACCESOUSUARIO, BaseSecurityConstants.AGREGAR);
	}    

	// View getters
	// Permisos para ABM USUARIOAPMDM
	public String getVerUsuarioApmDMEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_USUARIOAPMDM, BaseSecurityConstants.VER);
	}
	public String getModificarUsuarioApmDMEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_USUARIOAPMDM, BaseSecurityConstants.MODIFICAR);
	}
	public String getEliminarUsuarioApmDMEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_USUARIOAPMDM, BaseSecurityConstants.ELIMINAR);
	}
	public String getAgregarUsuarioApmDMEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_USUARIOAPMDM, BaseSecurityConstants.AGREGAR);
	}  

	// Permisos para ABM_USUARIOIMPRESORA
	public String getVerUsuarioApmImpresoraEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_USUARIOAPMIMPRESORA, BaseSecurityConstants.VER);
	}
	public String getModificarUsuarioApmImpresoraEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_USUARIOAPMIMPRESORA, BaseSecurityConstants.MODIFICAR);
	}
	public String getEliminarUsuarioApmImpresoraEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_USUARIOAPMIMPRESORA, BaseSecurityConstants.ELIMINAR);
	}
	public String getAgregarUsuarioApmImpresoraEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_USUARIOAPMIMPRESORA, BaseSecurityConstants.AGREGAR);
	}  

}