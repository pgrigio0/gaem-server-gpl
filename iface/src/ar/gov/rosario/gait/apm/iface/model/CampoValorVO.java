package ar.gov.rosario.gait.apm.iface.model;



import java.util.ArrayList;
import java.util.List;

import ar.gov.rosario.gait.base.iface.model.GaitBussImageModel;
import coop.tecso.demoda.iface.model.SiNo;
import coop.tecso.demoda.iface.model.Tratamiento;


public class CampoValorVO extends GaitBussImageModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "campoValorVO";

	private Tratamiento tratamiento = Tratamiento.OpcionTodo;
	private String etiqueta;	
	private String valorDefault;
	private String tablaBusqueda;
	private SiNo obligatorio = SiNo.OpcionTodo;
	private SiNo soloLectura = SiNo.OpcionTodo;
	private CampoVO campo = new CampoVO();
	private String mascaraVisual;
	private String codigo;
	private List<CampoValorOpcionVO> listCampoValorOpcion = new ArrayList<>(); 

	public CampoValorVO() {
		super();
	}

	public CampoValorVO(int id) {
		super();
		setId(new Long(id));
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(String valorDefault) {
		this.valorDefault = valorDefault;
	}

	public String getTablaBusqueda() {
		return tablaBusqueda;
	}

	public void setTablaBusqueda(String tablaBusqueda) {
		this.tablaBusqueda = tablaBusqueda;
	}

	public SiNo getObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(SiNo obligatorio) {
		this.obligatorio = obligatorio;
	}

	public SiNo getSoloLectura() {
		return soloLectura;
	}

	public void setSoloLectura(SiNo soloLectura) {
		this.soloLectura = soloLectura;
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	public List<CampoValorOpcionVO> getListCampoValorOpcion() {
		return listCampoValorOpcion;
	}

	public void setListCampoValorOpcion(List<CampoValorOpcionVO> listCampoValorOpcion) {
		this.listCampoValorOpcion = listCampoValorOpcion;
	}

	public CampoVO getCampo() {
		return campo;
	}

	public void setCampo(CampoVO campo) {
		this.campo = campo;
	}

	public String getMascaraVisual() {
		return mascaraVisual;
	}

	public void setMascaraVisual(String mascaraVisual) {
		this.mascaraVisual = mascaraVisual;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}