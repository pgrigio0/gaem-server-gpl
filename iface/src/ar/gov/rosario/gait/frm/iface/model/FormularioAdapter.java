package ar.gov.rosario.gait.frm.iface.model;

import ar.gov.rosario.gait.base.iface.model.GaitAdapterModel;
import ar.gov.rosario.gait.base.iface.model.GaitBussImageModel;
import ar.gov.rosario.gait.base.iface.util.BaseSecurityConstants;
import ar.gov.rosario.gait.frm.iface.util.FrmSecurityConstants;
import coop.tecso.demoda.iface.model.ReportVO;

/**
 * Adapter del Formulario
 * 
 * @author tecso
 */
public class FormularioAdapter extends GaitAdapterModel{
	
	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "formularioAdapterVO";
	
    private FormularioVO formulario = new FormularioVO();
    
    // Constructores
    public FormularioAdapter(){
    	super(FrmSecurityConstants.ABM_FORMULARIO);
    }
    
    //  Getters y Setters
	public FormularioVO getFormulario() {
		return formulario;
	}

	public void setFormulario(FormularioVO formularioVO) {
		this.formulario = formularioVO;
	}

	public String getName(){
		return NAME;
	}
	
	// View getters
	// Permisos para ABM FormularioDetalle
	public String getVerFormularioDetalleEnabled(){
		return GaitBussImageModel.hasEnabledFlag(FrmSecurityConstants.ABM_FORMULARIODETALLE, BaseSecurityConstants.VER);
	}
	public String getModificarFormularioDetalleEnabled(){
		return GaitBussImageModel.hasEnabledFlag(FrmSecurityConstants.ABM_FORMULARIODETALLE, BaseSecurityConstants.MODIFICAR);
	}
	public String getEliminarFormularioDetalleEnabled(){
		return GaitBussImageModel.hasEnabledFlag(FrmSecurityConstants.ABM_FORMULARIODETALLE, BaseSecurityConstants.ELIMINAR);
	}
	public String getAgregarFormularioDetalleEnabled(){
		return GaitBussImageModel.hasEnabledFlag(FrmSecurityConstants.ABM_FORMULARIODETALLE, BaseSecurityConstants.AGREGAR);
	}    
			
	public void prepareReport(Long format) {
		 
		 ReportVO report = this.getReport(); // no instanciar una nueva
		 report.setReportFormat(format);	
		 report.setReportTitle("Reporte de Formulario");     
		 report.setReportBeanName("Formulario");
		 report.setReportFileName(this.getClass().getName());
		 
		// carga de filtros: ninguno
		// Order by: no 
		 
		 ReportVO reportFormulario = new ReportVO();
		 reportFormulario.setReportTitle("Datos del Formulario");
		 // carga de datos
	     
	     //C�digo
		 reportFormulario.addReportDato("C�digo", "codFormulario");
		 //Descripci�n
		 reportFormulario.addReportDato("Descripci�n", "desFormulario");
	     
		 report.getListReport().add(reportFormulario);
	
	}
	
	// View getters
}