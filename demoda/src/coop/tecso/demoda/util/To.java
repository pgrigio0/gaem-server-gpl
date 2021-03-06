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
package coop.tecso.demoda.util;

import java.util.Date;

public class To {

	private Object first(Object[] array) {
		return array.length == 0 ? null : array[0]; 
	}
	
	public String String(Object value) {
		return String(value, null);
	}
	
	public Integer Integer(Object value) {
		return Integer(value, null);
	}
	
	public Long Long(Object value) {
		return Long(value, null);
	}
	
	public Boolean Boolean(Object value) {
		return Boolean(value, null);
	}
	
	public String String(Object value, String defvalue) {
		if (value == null)
			return defvalue;

		if (value.getClass().isArray())
			value = first((Object[]) value);

		return value == null ? defvalue : value.toString();
	}
	
	public Long Long(Object value, Long defvalue) {
		if (value == null)
			return defvalue;

		if (value.getClass().isArray())
			value = first((Object[]) value);
		
		return value == null ? defvalue : Long.valueOf(value.toString());
	}
	
	public Integer Integer(Object value, Integer defvalue) {
		if (value == null)
			return defvalue;

		if (value.getClass().isArray())
			value = first((Object[]) value);
		
		return value == null ? defvalue : Integer.valueOf(value.toString());
	}
	
	public Boolean Boolean(Object value, Boolean defvalue) {
		if (value == null)
			return defvalue;

		if (value.getClass().isArray())
			value = first((Object[]) value);

		return value == null ? defvalue : Boolean.valueOf(value.toString());
	}
	
	public Object Double(Object value, Double defvalue) {
		if (value == null)
			return defvalue;

		if (value.getClass().isArray())
			value = first((Object[]) value);
		
		return value == null ? defvalue : Double.valueOf(value.toString());
	}
	
	public Object Float(Object value, Float defvalue) {
		if (value == null)
			return defvalue;

		if (value.getClass().isArray())
			value = first((Object[]) value);
		
		return value == null ? defvalue : Float.valueOf(value.toString());
	}

	public Object DateEpoch(Object value, Date defvalue) {
		if (value == null)
			return defvalue;
		
		if (value.getClass().isArray())
			value = first((Object[]) value);
		
		long epoch = Long.parseLong(value.toString());
		return value == null ? defvalue : new Date(epoch * 1000);
	}

	public Object DateMilliEpoch(Object value, Date defvalue) {
		if (value == null)
			return defvalue;
		
		if (value.getClass().isArray())
			value = first((Object[]) value);
		
		long epoch = Long.parseLong(value.toString());
		return value == null ? defvalue : new Date(epoch * 1000);
	}	
}
