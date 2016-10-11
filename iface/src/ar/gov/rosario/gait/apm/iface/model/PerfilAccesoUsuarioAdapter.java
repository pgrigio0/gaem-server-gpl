package ar.gov.rosario.gait.apm.iface.model;



import java.util.ArrayList;
import java.util.List;

import ar.gov.rosario.gait.apm.iface.util.ApmSecurityConstants;
import ar.gov.rosario.gait.base.iface.model.GaitAdapterModel;


/**
 * Adapter del Perfil Acceso Usuario
 * 
 * @author tecso
 */

public class PerfilAccesoUsuarioAdapter extends GaitAdapterModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "perfilAccesoUsuarioAdapterVO";


	private PerfilAccesoUsuarioVO perfilAccesoUsuario = new PerfilAccesoUsuarioVO();
	private List<PerfilAccesoVO> listPerfilAcceso = new ArrayList<PerfilAccesoVO>();
	private List<UsuarioApmVO> listUsuarioApm = new ArrayList<UsuarioApmVO>();
	
	
	// Constructores
	public PerfilAccesoUsuarioAdapter() {
		super(ApmSecurityConstants.ABM_PERFILACCESOUSUARIO);
	}

	// Getters y Setters

	

	public String getName() {
		return NAME;
	}



	public PerfilAccesoUsuarioVO getPerfilAccesoUsuario() {
		return perfilAccesoUsuario;
	}

	public void setPerfilAccesoUsuario(PerfilAccesoUsuarioVO perfilAccesoUsuario) {
		this.perfilAccesoUsuario = perfilAccesoUsuario;
	}

	public List<PerfilAccesoVO> getListPerfilAcceso() {
		return listPerfilAcceso;
	}

	public void setListPerfilAcceso(List<PerfilAccesoVO> listPerfilAcceso) {
		this.listPerfilAcceso = listPerfilAcceso;
	}

	public List<UsuarioApmVO> getListUsuarioApm() {
		return listUsuarioApm;
	}

	public void setListUsuarioApm(List<UsuarioApmVO> listUsuarioApm) {
		this.listUsuarioApm = listUsuarioApm;
	}





  
}