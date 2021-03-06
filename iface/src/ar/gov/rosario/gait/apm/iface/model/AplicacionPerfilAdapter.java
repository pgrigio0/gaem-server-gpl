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
package ar.gov.rosario.gait.apm.iface.model;



import java.util.ArrayList;
import java.util.List;

import ar.gov.rosario.gait.apm.iface.util.ApmSecurityConstants;
import ar.gov.rosario.gait.base.iface.model.GaitAdapterModel;
import ar.gov.rosario.gait.base.iface.model.GaitBussImageModel;
import ar.gov.rosario.gait.base.iface.util.BaseSecurityConstants;
import ar.gov.rosario.gait.frm.iface.model.TipoFormularioVO;


/**
 * Adapter del Aplicacion PErfil
 * 
 * @author tecso
 */

public class AplicacionPerfilAdapter extends GaitAdapterModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "aplicacionPerfilAdapterVO";
	public static final String ENC_NAME = "encAplicacionPerfilAdapterVO";

	private AplicacionPerfilVO aplicacionPerfil = new AplicacionPerfilVO();
	private List<AplicacionVO> listAplicacion = new ArrayList<AplicacionVO>();
	
	private List<TipoFormularioVO> listTipoFormulario = new ArrayList<TipoFormularioVO>();

	// Constructores
	public AplicacionPerfilAdapter() {
		super(ApmSecurityConstants.ABM_APLICACIONPERFIL);
	}

	// Getters y Setters

	

	public String getName() {
		return NAME;
	}

	public AplicacionPerfilVO getAplicacionPerfil() {
		return aplicacionPerfil;
	}

	public void setAplicacionPerfil(AplicacionPerfilVO aplicacionPerfil) {
		this.aplicacionPerfil = aplicacionPerfil;
	}  

	
	public List<AplicacionVO> getListAplicacion() {
		return listAplicacion;
	}

	public void setListAplicacion(List<AplicacionVO> listAplicacion) {
		this.listAplicacion = listAplicacion;
	}
	
	public List<TipoFormularioVO> getlistTipoFormulario() {
		return listTipoFormulario;
	}

	public void setlistTipoFormulario(List<TipoFormularioVO> listTipoFormulario) {
		this.listTipoFormulario = listTipoFormulario;
	}


	// View getters
	// Permisos para ABM Perfil Seccion
	public String getVerAplicacionPerfilSeccionEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLICACIONPERFILSECCION, BaseSecurityConstants.VER);
	}
	public String getModificarAplicacionPerfilSeccionEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLICACIONPERFILSECCION, BaseSecurityConstants.MODIFICAR);
	}
	public String getEliminarAplicacionPerfilSeccionEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLICACIONPERFILSECCION, BaseSecurityConstants.ELIMINAR);
	}
	public String getAgregarAplicacionPerfilSeccionEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLICACIONPERFILSECCION, BaseSecurityConstants.AGREGAR);
	}
	
	// View getters
	// Permisos para ABM Perfil PARAMETRO
	public String getVerAplicacionPerfilParametroEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLICACIONPERFILPARAMETRO, BaseSecurityConstants.VER);
	}
	public String getModificarAplicacionPerfilParametroEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLICACIONPERFILPARAMETRO, BaseSecurityConstants.MODIFICAR);
	}
	public String getEliminarAplicacionPerfilParametroEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLICACIONPERFILPARAMETRO, BaseSecurityConstants.ELIMINAR);
	}
	public String getAgregarAplicacionPerfilParametroEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLICACIONPERFILPARAMETRO, BaseSecurityConstants.AGREGAR);
	}



  
}