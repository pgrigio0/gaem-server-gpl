package ar.gov.rosario.gait.not.iface.service;

import ar.gov.rosario.gait.not.iface.model.EstadoNotificacionAdapter;
import ar.gov.rosario.gait.not.iface.model.EstadoNotificacionSearchPage;
import ar.gov.rosario.gait.not.iface.model.EstadoNotificacionVO;
import ar.gov.rosario.gait.not.iface.model.NotificacionAdapter;
import ar.gov.rosario.gait.not.iface.model.NotificacionSearchPage;
import ar.gov.rosario.gait.not.iface.model.NotificacionVO;
import ar.gov.rosario.gait.not.iface.model.TipoNotificacionAdapter;
import ar.gov.rosario.gait.not.iface.model.TipoNotificacionSearchPage;
import ar.gov.rosario.gait.not.iface.model.TipoNotificacionVO;
import coop.tecso.demoda.iface.DemodaServiceException;
import coop.tecso.demoda.iface.model.CommonKey;
import coop.tecso.demoda.iface.model.UserContext;

public interface INotNotificacionService {
	
	
	// ---> ABM Notificacion
	
	public NotificacionSearchPage getNotificacionSearchPageInit(UserContext usercontext) throws DemodaServiceException;
	public NotificacionSearchPage getNotificacionSearchPageResult(UserContext usercontext,NotificacionSearchPage NotificacionSearchPage) throws DemodaServiceException;

	public NotificacionAdapter getNotificacionAdapterForView(UserContext userContext, CommonKey commonKey) throws DemodaServiceException;
	public NotificacionAdapter getNotificacionAdapterForCreate(UserContext userContext) throws DemodaServiceException;
	public NotificacionAdapter getNotificacionAdapterForUpdate(UserContext userContext, CommonKey commonKey) throws DemodaServiceException;
	
	public NotificacionVO createNotificacion(UserContext userContext, NotificacionVO NotificacionVO ) throws DemodaServiceException;
//	public NotificacionVO updateNotificacion(UserContext userContext, NotificacionVO NotificacionVO ) throws DemodaServiceException;

	// ---> ABM TipoNotificacion
	public TipoNotificacionSearchPage getTipoNotificacionSearchPageInit(UserContext usercontext) throws DemodaServiceException;
	public TipoNotificacionSearchPage getTipoNotificacionSearchPageResult(UserContext usercontext, TipoNotificacionSearchPage tipoNotificacionSearchPage) throws DemodaServiceException;

	public TipoNotificacionAdapter getTipoNotificacionAdapterForView(UserContext userContext, CommonKey commonKey) throws DemodaServiceException;
	public TipoNotificacionAdapter getTipoNotificacionAdapterForCreate(UserContext userContext) throws DemodaServiceException;
	public TipoNotificacionAdapter getTipoNotificacionAdapterForUpdate(UserContext userContext, CommonKey commonKey) throws DemodaServiceException;
			
	public TipoNotificacionVO createTipoNotificacion(UserContext userContext, TipoNotificacionVO tipoNotificacionVO ) throws DemodaServiceException;
	public TipoNotificacionVO updateTipoNotificacion(UserContext userContext, TipoNotificacionVO tipoNotificacionVO ) throws DemodaServiceException;
	public TipoNotificacionVO deleteTipoNotificacion(UserContext userContext, TipoNotificacionVO tipoNotificacionVO ) throws DemodaServiceException;
	// <--- ABM TipoNotificacion
	
	// ---> ABM EstadoNotificacion
	public EstadoNotificacionSearchPage getEstadoNotificacionSearchPageInit(UserContext usercontext) throws DemodaServiceException;
	public EstadoNotificacionSearchPage getEstadoNotificacionSearchPageResult(UserContext usercontext, EstadoNotificacionSearchPage estadoNotificacionSearchPage) throws DemodaServiceException;

	public EstadoNotificacionAdapter getEstadoNotificacionAdapterForView(UserContext userContext, CommonKey commonKey) throws DemodaServiceException;
	public EstadoNotificacionAdapter getEstadoNotificacionAdapterForCreate(UserContext userContext) throws DemodaServiceException;
	public EstadoNotificacionAdapter getEstadoNotificacionAdapterForUpdate(UserContext userContext, CommonKey commonKey) throws DemodaServiceException;
				
	public EstadoNotificacionVO createEstadoNotificacion(UserContext userContext, EstadoNotificacionVO estadoNotificacionVO ) throws DemodaServiceException;
	public EstadoNotificacionVO updateEstadoNotificacion(UserContext userContext, EstadoNotificacionVO estadoNotificacionVO ) throws DemodaServiceException;
	public EstadoNotificacionVO deleteEstadoNotificacion(UserContext userContext, EstadoNotificacionVO estadoNotificacionVO ) throws DemodaServiceException;
	// <--- ABM EstadoNotificacion
	
}
