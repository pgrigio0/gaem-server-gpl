package ar.gov.rosario.gait.apm.buss.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ar.gov.rosario.gait.apm.buss.dao.ApmDAOFactory;
import ar.gov.rosario.gait.apm.iface.util.ApmError;
import ar.gov.rosario.gait.base.iface.util.BaseError;
import coop.tecso.demoda.buss.bean.VersionableBO;

@Entity
@Table(name="apm_usuarioapmdm")
public class UsuarioApmDM extends VersionableBO {

	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)  
	@JoinColumn(name = "idUsuario")
	private UsuarioApm usuarioApm;

	@ManyToOne(optional = false)  
	@JoinColumn(name = "idDispositivoMovil")
	private DispositivoMovil dispositivoMovil;

	// Constructores
	public UsuarioApmDM() {
		super();
	}

	// Getters y Setters
	public UsuarioApm getUsuarioApm() {
		return usuarioApm;
	}

	public void setUsuarioApm(UsuarioApm usuarioApm) {
		this.usuarioApm = usuarioApm;
	}

	public DispositivoMovil getDispositivoMovil() {
		return dispositivoMovil;
	}

	public void setDispositivoMovil(DispositivoMovil dispositivoMovil) {
		this.dispositivoMovil = dispositivoMovil;
	}

	public static boolean hasAccess(String username, String deviceid){
		return 	ApmDAOFactory.getUsuarioApmDMDAO().hasAccess(username, deviceid);
	}

	// Metodos de Clase
	public static UsuarioApmDM getById(Long id) {
		return (UsuarioApmDM) ApmDAOFactory.getUsuarioApmDMDAO().getById(id);
	}

	public static UsuarioApmDM getByIdNull(Long id) {
		return (UsuarioApmDM) ApmDAOFactory.getUsuarioApmDMDAO().getByIdNull(id);
	}

	public static List<UsuarioApmDM> getList() {
		return (ArrayList<UsuarioApmDM>) ApmDAOFactory.getUsuarioApmDMDAO().getList();
	}

	public static List<UsuarioApmDM> getListActivos() {			
		return ApmDAOFactory.getUsuarioApmDMDAO().getListActiva();
	}

	// Validaciones 
	public boolean validateCreate() throws Exception {
		// limpiamos la lista de errores
		clearError();

		if (!this.validate()) {
			return false;
		}

		// Validaciones de Negocio
		return true;
	}

	public boolean validateUpdate() throws Exception {
		// limpiamos la lista de errores
		clearError();

		if (!this.validate()) {
			return false;
		}

		// Validaciones de Negocio

		return true;		
	}

	public boolean validateDelete() {
		//limpiamos la lista de errores
		clearError();

		if (hasError()) {
			return false;
		}

		return true;
	}

	private boolean validate() throws Exception {
		
		if (null == getDispositivoMovil()) {
			addRecoverableError(BaseError.MSG_CAMPO_REQUERIDO, ApmError.DISPOSITIVOMOVIL_LABEL);
		}
		
		if (hasError()) {
			return false;
		}
		return true;
	}
}