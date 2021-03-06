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
package ar.gov.rosario.gait.def.iface.model;

import java.util.ArrayList;
import java.util.List;

import ar.gov.rosario.gait.base.iface.model.GaitBussImageModel;
import coop.tecso.demoda.iface.model.SiNo;

/**
 * Value Object del Direccion
 * @author tecso
 *
 */
public class DireccionVO extends GaitBussImageModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "direccionVO";
	
	private String descripcion; 
	private SiNo esDGI = SiNo.OpcionTodo;
	private List<AreaVO> listArea = new ArrayList<AreaVO>();
	private List<DireccionAplicacionPerfilVO> listDireccionAplicacionPerfil= new ArrayList<DireccionAplicacionPerfilVO>();
	// Buss Flags
	
	
	// View Constants
	
	
	// Constructores
	public DireccionVO() {
		super();
	}
	
	// Constructor para utilizar este VO en un combo como valor SELECCIONAR, TODOS, etc.
	public DireccionVO(int id, String desc) {
		super();
		setId(new Long(id));
		setDescripcion(desc);
	}
	
	// Getters y Setters
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public SiNo getEsDGI() {
		return esDGI;
	}

	public void setEsDGI(SiNo esDGI) {
		this.esDGI = esDGI;
	}

	public List<AreaVO> getListArea() {
		return listArea;
	}

	public void setListArea(List<AreaVO> listArea) {
		this.listArea = listArea;
	}

	public List<DireccionAplicacionPerfilVO> getListDireccionAplicacionPerfil() {
		return listDireccionAplicacionPerfil;
	}

	public void setListDireccionAplicacionPerfil(
			List<DireccionAplicacionPerfilVO> listDireccionAplicacionPerfil) {
		this.listDireccionAplicacionPerfil = listDireccionAplicacionPerfil;
	}
	
	// Buss flags getters y setters
	
	
	// View flags getters
	
	
	// View getters
}
