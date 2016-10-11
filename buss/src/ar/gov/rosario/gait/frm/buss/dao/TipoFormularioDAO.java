package ar.gov.rosario.gait.frm.buss.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import ar.gov.rosario.gait.base.buss.dao.GaitHibernateUtil;
import ar.gov.rosario.gait.base.buss.dao.GenericDAO;
import ar.gov.rosario.gait.frm.buss.bean.TipoFormulario;
import ar.gov.rosario.gait.frm.iface.model.TipoFormularioSearchPage;
import coop.tecso.demoda.db.HibernateQueryMaker;
import coop.tecso.demoda.db.QueryMaker;
import coop.tecso.demoda.iface.helper.DemodaUtil;
import coop.tecso.demoda.iface.helper.StringUtil;
import coop.tecso.demoda.iface.model.Estado;

public class TipoFormularioDAO extends GenericDAO {

	private Logger log = Logger.getLogger(TipoFormularioDAO.class);
	
	public TipoFormularioDAO() {
		super(TipoFormulario.class);
	}

	/**
	 * Obtiene un TipoFormulario por su codigo
	 */
	public TipoFormulario getByCodigo(String codigo) {
		TipoFormulario tipoFormulario;
		String queryString = "from TipoFormulario t where t.codigo = :codigo";
		Session session = GaitHibernateUtil.currentSession();

		Query query = session.createQuery(queryString).setString("codigo", codigo);
		tipoFormulario = (TipoFormulario) query.uniqueResult();	

		return tipoFormulario; 
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoFormulario> getBySearchPage(TipoFormularioSearchPage tipoFormularioSearchPage) throws Exception {
		String funcName = DemodaUtil.currentMethodName();
		if (log.isDebugEnabled()) log.debug(funcName + ": enter");
		
		QueryMaker query = HibernateQueryMaker.make();
		
		query.add("FROM TipoFormulario t WHERE 1=1 ");
		// estado
		query.add(" AND t.estado = ?", Estado.ACTIVO.getId());
		// etiqueta
		query.addIfNotNull(" AND UPPER(TRIM(t.codigo	)) LIKE ?", StringUtil.toUpperLike(tipoFormularioSearchPage.getTipoFormulario().getCodigo()));
		//tratamiento
		query.addIfNotNull(" AND UPPER(TRIM(t.descripcion	)) LIKE ?", StringUtil.toUpperLike(tipoFormularioSearchPage.getTipoFormulario().getDescripcion()));
		//tratamiento
		// Order by
		query.add(" ORDER BY t.id");
		
		if (log.isDebugEnabled()) log.debug(funcName + ": Query: " + query);
		
		if (log.isDebugEnabled()) log.debug(funcName + ": exit");
		
		List<TipoFormulario> listTipoFormulario = (ArrayList<TipoFormulario>) executeCountedSearch(query, tipoFormularioSearchPage);

		if (log.isDebugEnabled()) log.debug(funcName + ": exit");
		return listTipoFormulario;
	}
}
