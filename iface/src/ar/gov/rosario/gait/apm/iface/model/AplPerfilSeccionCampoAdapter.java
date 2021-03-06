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
import coop.tecso.demoda.iface.model.SiNo;


/**
 * Adapter del Aplicacion PErfil Campo
 * 
 * @author tecso
 */

public class AplPerfilSeccionCampoAdapter extends GaitAdapterModel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "aplPerfilSeccionCampoAdapterVO";
	public static final String ENC_NAME = "encAplPerfilSeccionCampoAdapterVO";

	private AplPerfilSeccionCampoVO aplPerfilSeccionCampo = new AplPerfilSeccionCampoVO();
	
	
	private List<CampoVO> listCampo = new ArrayList<CampoVO>();

	private List<SiNo> listSiNo = new ArrayList<SiNo>();
	
	
	// Constructores
	public AplPerfilSeccionCampoAdapter() {
		super(ApmSecurityConstants.ABM_APLPERFILSECCION_CAMPO);
	}

	// Getters y Setters

	

	public String getName() {
		return NAME;
	}

	
	public AplPerfilSeccionCampoVO getAplPerfilSeccionCampo() {
		return aplPerfilSeccionCampo;
	}

	public void setAplPerfilSeccionCampo(AplPerfilSeccionCampoVO aplPerfilSeccionCampo) {
		this.aplPerfilSeccionCampo = aplPerfilSeccionCampo;
	}


	// View getters
	// Permisos para ABM Perfil Seccion Campo
	public String getVerAplPerfilSeccionCampoValorEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLPERFILSECCION_CAMPO_VALOR, BaseSecurityConstants.VER);
	}
	public String getModificarAplPerfilSeccionCampoValorEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLPERFILSECCION_CAMPO_VALOR, BaseSecurityConstants.MODIFICAR);
	}
	public String getEliminarAplPerfilSeccionCampoValorEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLPERFILSECCION_CAMPO_VALOR, BaseSecurityConstants.ELIMINAR);
	}
	public String getAgregarAplPerfilSeccionCampoValorEnabled(){
		return GaitBussImageModel.hasEnabledFlag(ApmSecurityConstants.ABM_APLPERFILSECCION_CAMPO_VALOR, BaseSecurityConstants.AGREGAR);
	}

	public List<CampoVO> getListCampo() {
		return listCampo;
	}

	public void setListCampo(List<CampoVO> listCampo) {
		this.listCampo = listCampo;
	}

	public List<SiNo> getListSiNo() {
		return listSiNo;
	}

	public void setListSiNo(List<SiNo> listSiNo) {
		this.listSiNo = listSiNo;
	}



  
}