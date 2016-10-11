package ar.gov.rosario.gait.def.buss.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ar.gov.rosario.gait.base.buss.dao.GenericDAO;
import ar.gov.rosario.gait.def.buss.bean.Direccion;
import ar.gov.rosario.gait.def.iface.model.DireccionSearchPage;
import coop.tecso.demoda.db.HibernateQueryMaker;
import coop.tecso.demoda.db.QueryMaker;
import coop.tecso.demoda.iface.helper.DemodaUtil;
import coop.tecso.demoda.iface.helper.StringUtil;
import coop.tecso.demoda.iface.model.Estado;

public class DireccionDAO extends GenericDAO {

	private Logger log = Logger.getLogger(DireccionDAO.class);
	
	public DireccionDAO() {
		super(Direccion.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Direccion> getBySearchPage(DireccionSearchPage direccionSearchPage) throws Exception {
		String funcName = DemodaUtil.currentMethodName();
		if (log.isDebugEnabled()) log.debug(funcName + ": enter");
		
		QueryMaker query = HibernateQueryMaker.make();
		
		query.add("FROM Direccion t WHERE 1=1 ");
		// estado
		query.add(" AND t.estado = ?", Estado.ACTIVO.getId());
		// descripcion
		query.addIfNotNull(" AND UPPER(TRIM(t.descripcion)) LIKE ?", StringUtil.toUpperLike(direccionSearchPage.getDireccion().getDescripcion()));
		
		//tratamiento
		query.addIfNotNull(" AND t.esDGI = ?", direccionSearchPage.getDireccion().getEsDGI().getBussId());

			// Order by
		query.add(" ORDER BY t.id");
		
		if (log.isDebugEnabled()) log.debug(funcName + ": Query: " + query);

		
		List<Direccion> listDireccion = (ArrayList<Direccion>) executeCountedSearch(query, direccionSearchPage);

		if (log.isDebugEnabled()) log.debug(funcName + ": exit");
		return listDireccion;
	}
	
	
}
