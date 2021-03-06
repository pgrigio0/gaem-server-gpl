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

/**
 * 
 * @author tecso.coop
 * 
 */
@Entity
@Table(name = "apm_aplicacionTabla")
public class AplicacionTabla extends VersionableBO {

	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idAplicacion")
	private Aplicacion aplicacion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idTablaVersion")
	private TablaVersion tablaVersion;

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public TablaVersion getTablaVersion() {
		return tablaVersion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void setTablaVersion(TablaVersion tablaVersion) {
		this.tablaVersion = tablaVersion;
	}

	// Metodos de Clase
	public static AplicacionTabla getById(Long id) {
		return (AplicacionTabla) ApmDAOFactory.getAplicacionTablaDAO().getById(id);
	}

	public static AplicacionTabla getByIdNull(Long id) {
		return (AplicacionTabla) ApmDAOFactory.getAplicacionTablaDAO().getByIdNull(id);
	}

	public static List<AplicacionTabla> getList() {
		return (ArrayList<AplicacionTabla>) ApmDAOFactory.getAplicacionTablaDAO().getList();
	}

	public static List<AplicacionTabla> getListActivos() {
		return ApmDAOFactory.getAplicacionTablaDAO().getListActiva();
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

	public boolean validateDelete() throws Exception {
		// limpiamos la lista de errores
		clearError();

		if (!this.validate()) {
			return false;
		}

		if (hasError()) {
			return false;
		}

		return true;
	}

	private boolean validate() throws Exception {

		// Validaciones
		if (null == aplicacion) {
			addRecoverableError(BaseError.MSG_CAMPO_REQUERIDO,
					ApmError.APLICACION_DESCRIPCION);
		}

		if (null == tablaVersion) {
			addRecoverableError(BaseError.MSG_CAMPO_REQUERIDO,
					ApmError.APLICACION_DESCRIPCION);
		}

		if (hasError()) {
			return false;
		}

		return true;
	}

}
