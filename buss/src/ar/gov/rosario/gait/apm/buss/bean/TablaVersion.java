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

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ar.gov.rosario.gait.apm.buss.dao.ApmDAOFactory;
import ar.gov.rosario.gait.apm.iface.util.ApmError;
import ar.gov.rosario.gait.base.iface.util.BaseError;
import coop.tecso.demoda.buss.bean.VersionableBO;
import coop.tecso.demoda.iface.helper.StringUtil;

@Entity
@Table(name = "apm_tablaVersion")
public class TablaVersion extends VersionableBO {

	private static final long serialVersionUID = 1L;

	@Column
	private String tabla;

	@Column
	private Integer lastVersion;

	// Constructores
	public TablaVersion() {
		super();
	}

	// Getters y Setters
	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public Integer getLastVersion() {
		return lastVersion;
	}

	public void setLastVersion(Integer lastVersion) {
		this.lastVersion = lastVersion;
	}

	// Metodos de Clase
	public static TablaVersion getById(Long id) {
		return (TablaVersion) ApmDAOFactory.getTablaVersionDAO().getById(id);
	}

	public static TablaVersion getByIdNull(Long id) {
		return (TablaVersion) ApmDAOFactory.getTablaVersionDAO().getByIdNull(id);
	}

	public static List<TablaVersion> getListActivos() {			
		return ApmDAOFactory.getTablaVersionDAO().getListActiva();
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
		if (StringUtil.isNullOrEmpty(getTabla())) {
			addRecoverableError(BaseError.MSG_CAMPO_REQUERIDO, ApmError.APLICACION_DESCRIPCION);
		}

		if (null == lastVersion) {
			addRecoverableError(BaseError.MSG_CAMPO_REQUERIDO, ApmError.APLICACION_DESCRIPCION);
		}

		if (hasError()) {
			return false;
		}

		return true;
	}
}