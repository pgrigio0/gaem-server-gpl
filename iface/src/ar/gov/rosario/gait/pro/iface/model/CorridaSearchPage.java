package ar.gov.rosario.gait.pro.iface.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.gov.rosario.gait.base.iface.model.GaitPageModel;
import ar.gov.rosario.gait.pro.iface.util.ProSecurityConstants;
import coop.tecso.demoda.iface.helper.DateUtil;

/**
 * SearchPage del Corrida
 * 
 * @author Tecso
 *
 */
public class CorridaSearchPage extends GaitPageModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "corridaSearchPageVO";
	
	private CorridaVO corrida= new CorridaVO();
	private Date fechaDesde; 
	private Date fechaHasta; 
	
	private String fechaDesdeView; 
	private String fechaHastaView;
	
	private List<ProcesoVO> listProceso = new ArrayList<ProcesoVO>();
	private List<EstadoCorridaVO> listEstadoCorrida = new ArrayList<EstadoCorridaVO>();
	private List<TipoEjecucionVO> listTipoEjecucion = new ArrayList<TipoEjecucionVO>();
	
	// Constructores
	public CorridaSearchPage() {       
       super(ProSecurityConstants.ABM_CORRIDA);        
    }
	
	// Getters y Setters
	public CorridaVO getCorrida() {
		return corrida;
	}
	public void setCorrida(CorridaVO corrida) {
		this.corrida = corrida;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
		this.fechaDesdeView = DateUtil.formatDate(fechaDesde, DateUtil.ddSMMSYYYY_MASK);
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
		this.fechaHastaView = DateUtil.formatDate(fechaHasta, DateUtil.ddSMMSYYYY_MASK);
	}
	
	public ProcesoVO getProceso() {
		return corrida.getProceso();
	}
	public void setProceso(ProcesoVO proceso) {
		this.corrida.setProceso(proceso);
	}
	
	public List<EstadoCorridaVO> getListEstadoCorrida() {
		return listEstadoCorrida;
	}

	public void setListEstadoCorrida(List<EstadoCorridaVO> listEstadoCorrida) {
		this.listEstadoCorrida = listEstadoCorrida;
	}
	
	public List<TipoEjecucionVO> getListTipoEjecucion() {
		return listTipoEjecucion;
	}

	public void setListTipoEjecucion(List<TipoEjecucionVO> listTipoEjecucion) {
		this.listTipoEjecucion = listTipoEjecucion;
	}

	// View getters
	public void setFechaDesdeView(String fechaDesdeView) {
		this.fechaDesdeView = fechaDesdeView;
	}
	public String getFechaDesdeView() { 
		return fechaDesdeView;
	} 

	public void setFechaHastaView(String fechaHastaView) {
		this.fechaHastaView = fechaHastaView;
	}
	
	public String getFechaHastaView () {
		return fechaHastaView;
	}
	
	public List<ProcesoVO> getListProceso() {
		return listProceso;
	}

	public void setListProceso(List<ProcesoVO> listProceso) {
		this.listProceso = listProceso;
	}
}
