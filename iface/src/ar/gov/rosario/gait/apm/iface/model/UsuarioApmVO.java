package ar.gov.rosario.gait.apm.iface.model;

import java.util.ArrayList;
import java.util.List;

import ar.gov.rosario.gait.base.iface.model.GaitBussImageModel;

/**
 * 
 * @author tecso.coop
 *
 */
public class UsuarioApmVO extends GaitBussImageModel {

	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "usuarioApmVO";

	private String nombre;

	private String username;

	private String usertoken;
	
	private String numeroInspector;
	
	private String usercert; // certificado encriptado en base64
	
	private List<PerfilAccesoUsuarioVO> listPerfilAccesoUsuario = new ArrayList<PerfilAccesoUsuarioVO>(); 
	private List<UsuarioApmDMVO> listUsuarioApmDM = new ArrayList<UsuarioApmDMVO>();
	private List<UsuarioApmImpresoraVO> listUsuarioApmImpresora = new ArrayList<UsuarioApmImpresoraVO>(); 

	// Constructores
	public UsuarioApmVO() {
		super();
	}
	
	// Constructor para utilizar este VO en un combo como valor SELECCIONAR, TODOS, etc.
	public UsuarioApmVO(int id, String nombre) {
		super();
		setId(Integer.valueOf(id).longValue());
		setNombre(nombre);
	}

	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertoken() {
		return usertoken;
	}

	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}
	
	public String getNumeroInspector() {
		return numeroInspector;
	}

	public void setNumeroInspector(String numeroInspector) {
		this.numeroInspector = numeroInspector;
	}

	public String getUsercert() {
		return usercert;
	}

	public void setUsercert(String usercert) {
		this.usercert = usercert;
	}

	public List<PerfilAccesoUsuarioVO> getListPerfilAccesoUsuario() {
		return listPerfilAccesoUsuario;
	}

	public void setListPerfilAccesoUsuario(
			List<PerfilAccesoUsuarioVO> listPerfilAccesoUsuario) {
		this.listPerfilAccesoUsuario = listPerfilAccesoUsuario;
	}

	public List<UsuarioApmDMVO> getListUsuarioApmDM() {
		return listUsuarioApmDM;
	}

	public void setListUsuarioApmDM(List<UsuarioApmDMVO> listUsuarioApmDM) {
		this.listUsuarioApmDM = listUsuarioApmDM;
	}

	public List<UsuarioApmImpresoraVO> getListUsuarioApmImpresora() {
		return listUsuarioApmImpresora;
	}

	public void setListUsuarioApmImpresora(
			List<UsuarioApmImpresoraVO> listUsuarioApmImpresora) {
		this.listUsuarioApmImpresora = listUsuarioApmImpresora;
	}
}