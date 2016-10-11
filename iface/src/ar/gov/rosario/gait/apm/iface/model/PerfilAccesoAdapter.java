package ar.gov.rosario.gait.apm.iface.model;

import java.util.ArrayList;
import java.util.List;

import ar.gov.rosario.gait.apm.iface.util.ApmSecurityConstants;
import ar.gov.rosario.gait.base.iface.model.GaitAdapterModel;
import ar.gov.rosario.gait.base.iface.model.GaitBussImageModel;
import ar.gov.rosario.gait.base.iface.util.BaseSecurityConstants;
import ar.gov.rosario.gait.def.iface.model.AreaVO;
import ar.gov.rosario.gait.def.iface.util.DefSecurityConstants;

public class PerfilAccesoAdapter extends GaitAdapterModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "perfilAccesoAdapterVO";
	public static final String ENC_NAME = "encPerfilAccesoAdapterVO";

	private PerfilAccesoVO perfilAcceso = new PerfilAccesoVO();
	private List<AreaVO> listArea = new ArrayList<AreaVO>();

	// Constructores
	public PerfilAccesoAdapter() {
		super(ApmSecurityConstants.ABM_PERFILACCESO);
	}

	// Getters y Setters
	public PerfilAccesoVO getPerfilAcceso() {
		return perfilAcceso;
	}

	public void setPerfilAcceso(PerfilAccesoVO perfilAccesoVO) {
		this.perfilAcceso = perfilAccesoVO;
	}

	public String getName() {
		return NAME;
	}

	public List<AreaVO> getListArea() {
		return listArea;
	}

	public void setListArea(List<AreaVO> listArea) {
		this.listArea = listArea;
	}

	// View getters
	// Permisos para ABM Area Aplicacion Perfil
	public String getVerAreaAplicacionPerfilEnabled() {
		return GaitBussImageModel.hasEnabledFlag(DefSecurityConstants.ABM_AREAAPLICACIONPERFIL,BaseSecurityConstants.VER);
	}

	public String getModificarAreaAplicacionPerfilEnabled() {
		return GaitBussImageModel.hasEnabledFlag(DefSecurityConstants.ABM_AREAAPLICACIONPERFIL,BaseSecurityConstants.MODIFICAR);
	}

	public String getEliminarAreaAplicacionPerfilEnabled() {
		return GaitBussImageModel.hasEnabledFlag(DefSecurityConstants.ABM_AREAAPLICACIONPERFIL,BaseSecurityConstants.ELIMINAR);
	}

	public String getAgregarAreaAplicacionPerfilEnabled() {
		return GaitBussImageModel.hasEnabledFlag(DefSecurityConstants.ABM_AREAAPLICACIONPERFIL,BaseSecurityConstants.AGREGAR);
	}
	
	public String getVerPerfilAccesoAplicacionEnabled() {
//		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_PERFILACCESOAPLICACION, BaseSecurityConstants.VER);
		return ENABLED;
	}
	
	public String getAgregarPerfilAccesoAplicacionEnabled() {
//		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_PERFILACCESOAPLICACION,BaseSecurityConstants.AGREGAR);
		return ENABLED;
	}
	
	public String getModificarPerfilAccesoAplicacionEnabled() {
//		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_PERFILACCESOAPLICACION,BaseSecurityConstants.MODIFICAR);
		return ENABLED;
	}

	public String getEliminarPerfilAccesoAplicacionEnabled() {
//		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_PERFILACCESOAPLICACION,BaseSecurityConstants.ELIMINAR);
		return ENABLED;
	}
}