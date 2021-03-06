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
package ar.gov.rosario.gait.base.iface.util;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import coop.tecso.demoda.iface.model.DemodaStringMsg;


public class GaitUtil {
    
	static Logger log = Logger.getLogger(GaitUtil.class);

	/**
	 * Dada una clave recibida, obtiene el valor de los archivos de properties
	 * 
	 * 
	 * @param str
	 * @return
	 */
	public static String getValueFromBundle(String str){
		String msg = str;
		
		try {
			
			String[] arrPkgNames = str.split("\\.");
			String resBundle = "";
			
			if (arrPkgNames.length > 0)
				resBundle = arrPkgNames[0]; 
			
			resBundle = "resources." + resBundle; 
			
			String msgRecuperado = ResourceBundle.getBundle(resBundle).getString(str);
			
			log.debug("msgRecuperado: " + msgRecuperado);
			
			return msgRecuperado;
			
		} catch(Exception e){				
			log.error(" error en getValueFromBundle(): key " + str + " no encontrada " );
			//e.printStackTrace();
			return msg;
		}		
	}
	
	
	/**
	 *  Valida que la estructura de la string manzana
	 *  sea como las que utiliza Catastro para representar
	 *  un manzana de la ciudad. Es decir, Seccion/Nro. Correlativo. 
	 * */
	public static boolean validateManzana(String manzana) {
		try {
			
			String[] secNum = manzana.split("/");
			
			// Validamos que la seccion sea un entero valido 
			Integer seccion = new Integer(secNum[0]);
			// Validamos que  el numero correlativo sea valido
			Integer num = new Integer(secNum[1]);
			
			if (secNum.length != 2 || seccion <= 0 || num < 0)
				return false;
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	/**
	 *	Calcula el bimestre correspondiente al mes
	 *	pasado como argumento
	 *  Ej: Mes: 3 (Marzo), Bimestre: 2
	 * */
	public static int calcularBimestre (int mes) {
		return mes/2 + mes % 2; 
	} 

	/**
	 * Devuelve un array string, con los valores de los errores.
	 * 
	 * 
	 * @param lista
	 * @return
	 */
	public static String[] getStringValueErrors(List<DemodaStringMsg> lista) {
		log.debug("entrando getStringValueErrors: lista " + lista.size() );
	
		String[] arrValues = new String[lista.size()];
		int j = 0;
		
		for (DemodaStringMsg  dsm:  lista) {
			
			String msg = "";
				
			// Si no tiene parametros
			if (dsm.params() == null || dsm.params().length == 0){

				// si el demoda Strin message contiene un valor
				if (dsm.isValue() ) {
					arrValues[j] =  dsm.key().substring(1);
				} 
				
				// si el demoda Strin message contiene una key				
				if (dsm.isKey() ) {
					msg = getValueFromBundle(dsm.key());
					arrValues[j] = msg;
				} 
			
			// Si posee parametros
			} else {
				msg = getValueFromBundle(dsm.key());
				
				Object[] objParam = new Object[dsm.params().length];
				
				for (int i=0 ; i < dsm.params().length; i++ ){					
					String  strParam = (String) dsm.params()[i];
					
					if ( strParam.startsWith("&") ) {
						// si el parametro contiene un valor
						objParam[i] = strParam.substring(1);
					} else {
						// si el parametro contiene una key
						// si la key contiene la cadena .formatError la cambio por label 
						if (strParam.contains("formatError"))	
							strParam = strParam.replaceAll("formatError", "label");
						
						String strKey = strParam;
						
						try {
							if (strParam.contains(" ")){
								String[] arrSpaces = strParam.split(" ");
								strKey = arrSpaces[1];
							}
						} catch(Exception e){				
							log.error(" error en getKeyFromStringError()");			
						}		
						
						objParam[i] =  getValueFromBundle(strKey);
					}
				
					msg = msg.replace("{" + i + "}", (String)objParam[i]);
					
				}
				
				log.debug(msg);
				
				arrValues[j]  = msg;
				
			}
		
			j++;
		}
		
		return arrValues;
	}

}
