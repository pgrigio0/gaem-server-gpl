/*******************************************************************************
 * Copyright (c) 2016 Municipalidad de Rosario, Coop. de Trabajo Tecso Ltda.
 *
 * This file is part of GAEM.
 *
 * GAEM is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * GAEM is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with GAEM.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package ar.gov.rosario.gait.pro.iface.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.gov.rosario.gait.base.iface.model.GaitAdapterModel;
import ar.gov.rosario.gait.pro.iface.util.ProSecurityConstants;

/**
 * Adapter del Corrida
 * 
 * @author tecso
 */
public class CorridaAdapter extends GaitAdapterModel{
	
	private static final long serialVersionUID = 1L;

	public static final String NAME = "corridaAdapterVO";
	
	private CorridaVO corrida= new CorridaVO();
	private Date 	fechaDesde; 
	private Date 	fechaHasta; 
	
	private String 	fechaDesdeView; 
	private String 	fechaHastaView; 
	
	private List<ProcesoVO> listProceso = new ArrayList<ProcesoVO>();
	
	// Su utilizan para mostrar los reportes del proceso
	private List<FileCorridaVO> listFileCorrida = new ArrayList<FileCorridaVO>();
	private boolean paramProcesadoOk = false;
	
	// Constructores
	public CorridaAdapter() {       
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
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	public ProcesoVO getProceso() {
		return corrida.getProceso();
	}
	public void setProceso(ProcesoVO proceso) {
		this.corrida.setProceso(proceso);
	}
		
	public List<FileCorridaVO> getListFileCorrida() {
		return listFileCorrida;
	}

	public void setListFileCorrida(List<FileCorridaVO> listFileCorrida) {
		this.listFileCorrida = listFileCorrida;
	}

	public boolean isParamProcesadoOk() {
		return paramProcesadoOk;
	}

	public void setParamProcesadoOk(boolean paramProcesadoOk) {
		this.paramProcesadoOk = paramProcesadoOk;
	}

	// View getters
	public List<ProcesoVO> getListProceso() {
		return listProceso;
	}

	public void setListProceso(List<ProcesoVO> listProceso) {
		this.listProceso = listProceso;
	}
}
