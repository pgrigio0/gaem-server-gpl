package ar.gov.rosario.gait.apm.iface.model;



import java.util.ArrayList;
import java.util.List;

import ar.gov.rosario.gait.apm.iface.util.ApmSecurityConstants;
import ar.gov.rosario.gait.base.iface.model.GaitAdapterModel;
import coop.tecso.demoda.iface.model.SiNo;


/**
 * Adapter del Aplicacion PErfil Campo
 * 
 * @author tecso
 */

public class AplPerfilSeccionCampoValorOpcionAdapter extends GaitAdapterModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "aplPerfilSeccionCampoValorOpcionAdapterVO";
	public static final String ENC_NAME = "encAplPerfilSeccionCampoValorOpcionAdapterVO";

	private AplPerfilSeccionCampoValorOpcionVO aplPerfilSeccionCampoValorOpcion = new AplPerfilSeccionCampoValorOpcionVO();
	

	private List<CampoValorOpcionVO> listCampoValorOpcion = new ArrayList<CampoValorOpcionVO>();
	
	private List<SiNo> listSiNo = new ArrayList<SiNo>();

	// Constructores
	public AplPerfilSeccionCampoValorOpcionAdapter() {
		super(ApmSecurityConstants.ABM_APLPERFILSECCION_CAMPO_VALOR_OPCION);
	}

	// Getters y Setters

	

	public String getName() {
		return NAME;
	}

	


	public AplPerfilSeccionCampoValorOpcionVO getAplPerfilSeccionCampoValorOpcion() {
		return aplPerfilSeccionCampoValorOpcion;
	}

	public void setAplPerfilSeccionCampoValorOpcion(AplPerfilSeccionCampoValorOpcionVO aplPerfilSeccionCampoValorOpcion) {
		this.aplPerfilSeccionCampoValorOpcion = aplPerfilSeccionCampoValorOpcion;
	}

	public List<CampoValorOpcionVO> getListCampoValorOpcion() {
		return listCampoValorOpcion;
	}

	public void setListCampoValorOpcion(List<CampoValorOpcionVO> listCampoValorOpcion) {
		this.listCampoValorOpcion = listCampoValorOpcion;
	}

	public List<SiNo> getListSiNo() {
		return listSiNo;
	}

	public void setListSiNo(List<SiNo> listSiNo) {
		this.listSiNo = listSiNo;
	}

	
	
	

  
}