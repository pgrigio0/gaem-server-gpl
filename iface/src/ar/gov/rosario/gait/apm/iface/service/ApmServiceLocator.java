package ar.gov.rosario.gait.apm.iface.service;

import org.apache.log4j.Logger;

/**
 * ${Nombre Largo Modulo} - Service locator
 * @author tecso
 */
public class ApmServiceLocator {

	static Logger log = Logger.getLogger(ApmServiceLocator.class);

	// Implementaciones de servicio	
	private static String MODULO = "ar.gov.rosario.gait.apm.buss.service.";
	private static String APLICACION_SERVICE_IMPL = MODULO + "ApmAplicacionServiceHbmImpl";
	private static String PANICO_SERVICE_IMPL = MODULO + "ApmPanicoServiceHbmImpl";
												  
	
	// Instancia
	public static final ApmServiceLocator INSTANCE = new ApmServiceLocator();

	private IApmAplicacionService   aplicacionServiceHbmImpl;
	private IApmPanicoService   	panicoServiceHbmImpl;
	
	// Constructor de instancia
	public ApmServiceLocator() {
		try {
			this.aplicacionServiceHbmImpl = (IApmAplicacionService) Class.forName(APLICACION_SERVICE_IMPL).newInstance();			
			this.panicoServiceHbmImpl 	  = (IApmPanicoService) Class.forName(PANICO_SERVICE_IMPL).newInstance();	
		} catch (Exception e) {
			log.error("No se pudo crear la clase" + e);
		}
	}

	public static IApmAplicacionService getAplicacionService(){
		return INSTANCE.aplicacionServiceHbmImpl;		
	}

	public static IApmPanicoService getPanicoService(){
		return INSTANCE.panicoServiceHbmImpl;		
	}
}