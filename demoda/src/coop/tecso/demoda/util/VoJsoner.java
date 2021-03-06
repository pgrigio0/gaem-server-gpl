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

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import coop.tecso.demoda.iface.model.Common;
import coop.tecso.demoda.iface.model.CommonView;
import coop.tecso.demoda.iface.model.IDemodaEmun;
import coop.tecso.demoda.sys.Jsoner;

public class VoJsoner implements Jsoner {
	
	private GsonBuilder builder = builder();
	
	private static class MyExclusionStrategy implements ExclusionStrategy {

		@Override
		public boolean shouldSkipClass(Class<?> k) {
			return false;
		}

		@Override
		public boolean shouldSkipField(FieldAttributes field) {
			Class<?> klass = field.getDeclaringClass();
			
			if (field.getName().equals("id"))
				return false;
			
			if (klass.equals(CommonView.class)){
				return true;
			}
			
			if (klass.equals(Common.class)){
				return true;
			}
			
//			if(field.getDeclaredClass().getCanonicalName().contains("iface.model")){
//				return true;
//			}
			
			return false;
		}
		
	}

	private GsonBuilder builder() {
		GsonBuilder gsb = new GsonBuilder()
			.addSerializationExclusionStrategy(new MyExclusionStrategy())
			.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
				@Override
				public JsonElement serialize(Date date, Type type, JsonSerializationContext context) {
					return new JsonPrimitive(date.getTime());
				}
			})
			.registerTypeHierarchyAdapter(IDemodaEmun.class, new JsonSerializer<IDemodaEmun>() {
				@Override
				public JsonElement serialize(IDemodaEmun e, Type type, JsonSerializationContext context) {
					return new JsonPrimitive(e.getId());
				}
			})
			.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
				@Override
				public Date deserialize(JsonElement e, Type arg1, JsonDeserializationContext context) {
					return new Date(e.getAsJsonPrimitive().getAsLong());
				}
			});
		
		return gsb;
	}

	@Override
	public String toJson(Object obj) {
		return builder.create().toJson(obj);
	}

	@Override
	public <T> T fromJson(String json, Class<T> klass) {
		return builder.create().fromJson(json, klass);
	}
	
	@Override
	public <T> T fromJson(String json, Type typeOf) {
		return builder.create().fromJson(json, typeOf);
	}
}