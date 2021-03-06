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
package ar.gov.rosario.gait.pro.iface.service;

import org.apache.log4j.Logger;

/**
 * Proceso - Service locator
 * @author tecso
 */
public class ProServiceLocator {

	static Logger log = Logger.getLogger(ProServiceLocator.class);

	// Implementaciones de servicio	
	private static String MODULO = "ar.gov.rosario.gait.pro.buss.service.";
	private static String CONSULTA_SERVICE_IMPL = MODULO + "ProConsultaServiceHbmImpl";
	private static String ADPPROCESO_SERVICE_IMPL = MODULO + "ProAdpProcesoServiceHbmImpl";
	
	// Instancia
	public static final ProServiceLocator INSTANCE = new ProServiceLocator();

	private IProConsultaService	consultaServiceHbmImpl;
	private IProAdpProcesoService	adpProcesoServiceHbmImpl;
	
	// Constructor de instancia
	public ProServiceLocator() {
		try {

			this.consultaServiceHbmImpl = (IProConsultaService)   Class.forName(CONSULTA_SERVICE_IMPL).newInstance();
			this.adpProcesoServiceHbmImpl = (IProAdpProcesoService)   Class.forName(ADPPROCESO_SERVICE_IMPL).newInstance();
			
		} catch (Exception e) {
			log.error("No se pudo crear la clase" + e);
		}
	}

	public static IProConsultaService getConsultaService(){
		return INSTANCE.consultaServiceHbmImpl;		
	}

	public static IProAdpProcesoService getAdpProcesoService(){
		return INSTANCE.adpProcesoServiceHbmImpl;		
	}
	
}
