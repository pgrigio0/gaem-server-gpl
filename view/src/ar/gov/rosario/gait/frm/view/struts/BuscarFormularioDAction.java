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
package ar.gov.rosario.gait.frm.view.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ar.gov.rosario.gait.base.view.struts.BaseDispatchAction;
import ar.gov.rosario.gait.base.view.util.UserSession;
import ar.gov.rosario.gait.frm.iface.model.FormularioSearchPage;
import ar.gov.rosario.gait.frm.iface.service.FrmServiceLocator;
import ar.gov.rosario.gait.frm.iface.util.FrmSecurityConstants;
import ar.gov.rosario.gait.frm.view.util.FrmConstants;
import coop.tecso.demoda.iface.helper.DemodaUtil;

public final class BuscarFormularioDAction extends BaseDispatchAction {

	private Logger log = Logger.getLogger(BuscarFormularioDAction.class);

	public ActionForward inicializar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		String act = getCurrentAct(request);
		if (log.isDebugEnabled()) log.debug(funcName + ": enter");

		UserSession userSession = canAccess(request, mapping, FrmSecurityConstants.ABM_FORMULARIO, act); 
		if (userSession == null) return forwardErrorSession(request);

		try {
			FormularioSearchPage formularioSearchPageVO = FrmServiceLocator.getFormularioService().getFormularioSearchPageInit(userSession);

			// Tiene errores recuperables
			if (formularioSearchPageVO.hasErrorRecoverable()) {
				log.error("recoverable error en: "  + funcName + ": " + formularioSearchPageVO.infoString()); 
				saveDemodaErrors(request, formularioSearchPageVO);
				return forwardErrorRecoverable(mapping, request, userSession, FormularioSearchPage.NAME, formularioSearchPageVO);
			} 

			// Tiene errores no recuperables
			if (formularioSearchPageVO.hasErrorNonRecoverable()) {
				log.error("error en: "  + funcName + ": " + formularioSearchPageVO.errorString()); 
				return forwardErrorNonRecoverable(mapping, request, funcName, FormularioSearchPage.NAME, formularioSearchPageVO);
			}

			// Si no tiene error
			baseInicializarSearchPage(mapping, request, userSession , FormularioSearchPage.NAME, formularioSearchPageVO);

			return mapping.findForward(FrmConstants.FWD_FORMULARIO_SEARCHPAGE);
		} catch (Exception exception) {
			return baseException(mapping, request, funcName, exception, FormularioSearchPage.NAME);
		}
	}

	public ActionForward limpiar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		return this.baseRefill(mapping, form, request, response, funcName, FormularioSearchPage.NAME);
	}

	public ActionForward buscar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		if (log.isDebugEnabled()) log.debug(funcName + ": enter");		
		UserSession userSession = getCurrentUserSession(request, mapping); 
		if (userSession == null) return forwardErrorSession(request);

		try {

			// Bajo el searchPage del userSession
			FormularioSearchPage formularioSearchPageVO = (FormularioSearchPage) userSession.get(FormularioSearchPage.NAME);

			// Si es nulo no se puede continuar
			if (formularioSearchPageVO == null) {
				log.error("error en: "  + funcName + ": " + FormularioSearchPage.NAME + " IS NULL. No se pudo obtener de la sesion");
				return forwardErrorSessionNullObject(mapping, request, funcName, FormularioSearchPage.NAME); 
			}

			// si el buscar diparado desde la pagina de busqueda
			if (((String)userSession.get("reqAttIsSubmittedForm")).equals("true")) {
				// Recuperamos datos del form en el vo
				DemodaUtil.populateVO(formularioSearchPageVO, request);
				// Setea el PageNumber del PageModel				
				formularioSearchPageVO.setPageNumber(new Long((String)userSession.get("reqAttPageNumber")));
			}

			// Tiene errores recuperables
			if (formularioSearchPageVO.hasErrorRecoverable()) {
				log.error("recoverable error en: "  + funcName + ": " + formularioSearchPageVO.infoString()); 
				saveDemodaErrors(request, formularioSearchPageVO);
				return forwardErrorRecoverable(mapping, request, userSession, FormularioSearchPage.NAME, formularioSearchPageVO);
			}

			// Llamada al servicio	
			formularioSearchPageVO = FrmServiceLocator.getFormularioService().getFormularioSearchPageResult(userSession, formularioSearchPageVO);			

			// Tiene errores recuperables
			if (formularioSearchPageVO.hasErrorRecoverable()) {
				log.error("recoverable error en: "  + funcName + ": " + formularioSearchPageVO.infoString()); 
				saveDemodaErrors(request, formularioSearchPageVO);
				return forwardErrorRecoverable(mapping, request, userSession, FormularioSearchPage.NAME, formularioSearchPageVO);
			}

			// Tiene errores no recuperables
			if (formularioSearchPageVO.hasErrorNonRecoverable()) {
				log.error("error en: "  + funcName + ": " + formularioSearchPageVO.errorString());
				return forwardErrorNonRecoverable(mapping, request, funcName, FormularioSearchPage.NAME, formularioSearchPageVO);
			}

			// Envio el VO al request
			request.setAttribute(FormularioSearchPage.NAME, formularioSearchPageVO);
			// Subo en el el searchPage al userSession
			userSession.put(FormularioSearchPage.NAME, formularioSearchPageVO);

			return mapping.findForward(FrmConstants.FWD_FORMULARIO_SEARCHPAGE);
		} catch (Exception exception) {
			return baseException(mapping, request, funcName, exception, FormularioSearchPage.NAME);
		}
	}

	//TODO:
	public ActionForward baseImprimir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		if (log.isDebugEnabled()) log.debug(funcName + ": enter");		
		UserSession userSession = getCurrentUserSession(request, mapping); 
		if (userSession == null) return forwardErrorSession(request);

		try {

			// Bajo el searchPage del userSession
			FormularioSearchPage formularioSearchPageVO = (FormularioSearchPage) userSession.get(FormularioSearchPage.NAME);

			// Si es nulo no se puede continuar
			if (formularioSearchPageVO == null) {
				log.error("error en: "  + funcName + ": " + FormularioSearchPage.NAME + " IS NULL. No se pudo obtener de la sesion");
				return forwardErrorSessionNullObject(mapping, request, funcName, FormularioSearchPage.NAME); 
			}

			// si el buscar diparado desde la pagina de busqueda
			if (((String)userSession.get("reqAttIsSubmittedForm")).equals("true")) {
				// Recuperamos datos del form en el vo
				DemodaUtil.populateVO(formularioSearchPageVO, request);
				// Setea el PageNumber del PageModel				
				formularioSearchPageVO.setPageNumber(new Long((String)userSession.get("reqAttPageNumber")));
			}

			// Tiene errores recuperables
			if (formularioSearchPageVO.hasErrorRecoverable()) {
				log.error("recoverable error en: "  + funcName + ": " + formularioSearchPageVO.infoString()); 
				saveDemodaErrors(request, formularioSearchPageVO);
				return forwardErrorRecoverable(mapping, request, userSession, FormularioSearchPage.NAME, formularioSearchPageVO);
			}

			// Llamada al servicio	
			formularioSearchPageVO = FrmServiceLocator.getFormularioService().imprimirFormularioSearchPageResult(userSession, formularioSearchPageVO);			

			// Tiene errores recuperables
			if (formularioSearchPageVO.hasErrorRecoverable()) {
				log.error("recoverable error en: "  + funcName + ": " + formularioSearchPageVO.infoString()); 
				saveDemodaErrors(request, formularioSearchPageVO);
				return forwardErrorRecoverable(mapping, request, userSession, FormularioSearchPage.NAME, formularioSearchPageVO);
			}

			// Tiene errores no recuperables
			if (formularioSearchPageVO.hasErrorNonRecoverable()) {
				log.error("error en: "  + funcName + ": " + formularioSearchPageVO.errorString());
				return forwardErrorNonRecoverable(mapping, request, funcName, FormularioSearchPage.NAME, formularioSearchPageVO);
			}

			String fileName = formularioSearchPageVO.getReport().getReportFileName();
			// realiza la visualizacion del reporte
			baseResponseEmbedContent(response, fileName, "application/pdf");
			return null;

			//			
			//			// Envio el VO al request
			//			request.setAttribute(FormularioSearchPage.NAME, formularioSearchPageVO);
			//			// Subo en el el searchPage al userSession
			//			userSession.put(FormularioSearchPage.NAME, formularioSearchPageVO);
			//
			//			return mapping.findForward(FrmConstants.FWD_FORMULARIO_SEARCHPAGE);
		} catch (Exception exception) {
			return baseException(mapping, request, funcName, exception, FormularioSearchPage.NAME);
		}
	}




	public ActionForward ver(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		return forwardVerSearchPage(mapping, request, funcName, FrmConstants.ACTION_ADMINISTRAR_FORMULARIO);
	}

	public ActionForward agregar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		return forwardAgregarSearchPage(mapping, request, funcName, FrmConstants.ACTION_ADMINISTRAR_ENC_FORMULARIO);
	}

	public ActionForward modificar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		return forwardModificarSearchPage(mapping, request, funcName, FrmConstants.ACTION_ADMINISTRAR_FORMULARIO);
	}

	public ActionForward eliminar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		return forwardEliminarSearchPage(mapping, request, funcName, FrmConstants.ACTION_ADMINISTRAR_FORMULARIO);
	}

	public ActionForward activar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		return forwardActivarSearchPage(mapping, request, funcName, FrmConstants.ACTION_ADMINISTRAR_FORMULARIO);			
	}

	public ActionForward desactivar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		return forwardDesactivarSearchPage(mapping, request, funcName, FrmConstants.ACTION_ADMINISTRAR_FORMULARIO);
	}

	public ActionForward seleccionar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		String funcName = DemodaUtil.currentMethodName();
		return baseSeleccionar(mapping, request, response, funcName, FormularioSearchPage.NAME);
	}

	public ActionForward volver(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		return baseVolver(mapping, form, request, response, FormularioSearchPage.NAME);
	}
}