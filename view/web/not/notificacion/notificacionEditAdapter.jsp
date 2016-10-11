<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<!-- Tabla que contiene todos los formularios -->
<html:form styleId="filter" action="/not/AdministrarNotificacion.do">
	
	<!-- Mensajes y/o Advertencias -->
	<%@ include file="/base/warning.jsp" %>
	<!-- Errors  -->
	<html:errors bundle="base"/>				
	
	<h1><bean:message bundle="not" key="not.notificacionEditAdapter.title"/></h1>	
	<table class="tablabotones" width="100%">
		<tr>			
			<td align="right">
    			<html:button property="btnVolver"  styleClass="boton" onclick="submitForm('volver', '');">
					<bean:message bundle="base" key="abm.button.volver"/>
				</html:button>
			</td>
		</tr>
	</table>
	
	<!-- Notificacion -->
	<fieldset>
		<legend><bean:message bundle="not" key="not.notificacion.title"/></legend>
		
		<table class="tabladatos">
			<tr>
				<!-- TextCodigo -->
				<td><label>(*)&nbsp;<bean:message bundle="not" key="not.notificacion.descripcionReducida.label"/>: </label></td>
				<td class="normal"><html:text name="notificacionAdapterVO" property="notificacion.descripcionReducida" size="20" maxlength="100"/></td>			
				<!-- TextDescripcion -->
				<td><label>(*)&nbsp;<bean:message bundle="not" key="not.notificacion.descripcionAmpliada.label"/>: </label></td>
				<td class="normal"><html:textarea name="notificacionAdapterVO" property="notificacion.descripcionAmpliada" cols="50" rows="5"/></td>			
			</tr>
			<tr>	
				<!-- Tipo Notificacion  -->
				<td><label>(*)&nbsp;<bean:message bundle="not" key="not.notificacion.tipoNotificacion.label"/>: </label></td>
				<td class="normal">
					<html:select name="notificacionAdapterVO" property="notificacion.tipoNotificacion.id" styleClass="select">
						<html:optionsCollection name="notificacionAdapterVO" property="listTipoNotificacion" label="descripcion" value="id" />
					</html:select>
				<!-- Aplicacion  -->
				</td>	
				<td><label>(*)&nbsp;<bean:message bundle="not" key="not.notificacion.aplicacion.label"/>: </label></td>
				<td class="normal">
					<html:select name="notificacionAdapterVO" property="notificacion.aplicacion.id" styleClass="select">
						<html:optionsCollection name="notificacionAdapterVO" property="listAplicacion" label="descripcion" value="id" />
					</html:select>
				</td>					
			</tr>
			<tr>	
				<!-- Dispositivo -->
				<td><label><bean:message bundle="not" key="not.notificacion.dispositivoMovil.label"/>: </label></td>
				<td class="normal">
					<html:select name="notificacionAdapterVO" property="notificacion.dispositivoMovil.id" styleClass="select">
						<html:optionsCollection name="notificacionAdapterVO" property="listDispositivoMovil" label="descripcion" value="id" />
					</html:select>
				</td>					
			</tr>
		</table>
	</fieldset>	
	<!-- Notificación -->
	<table class="tablabotones" width="100%" >
	   	<tr>
  	   		<td align="left" width="50%">
	   	    	<html:button property="btnVolver" styleClass="boton" onclick="submitForm('volver', '');">
	   	    		<bean:message bundle="base" key="abm.button.volver"/>
	   	    	</html:button>
   	    	</td>
   	    	<td align="right" width="50%">
				<logic:equal name="notificacionAdapterVO" property="act" value="modificar">
					<html:button property="btnAceptar"  styleClass="boton" onclick="submitForm('modificar', '');">
						<bean:message bundle="base" key="abm.button.modificar"/>
					</html:button>
				</logic:equal>
				<logic:equal name="notificacionAdapterVO" property="act" value="agregar">
					<html:button property="btnAceptar"  styleClass="boton" onclick="submitForm('agregar', '');">
						<bean:message bundle="base" key="abm.button.agregar"/>
					</html:button>
				</logic:equal>
   	    	</td>   	    	
   	    </tr>
   	</table>
	
	<input type="hidden" name="method" value=""/>
	<input type="hidden" name="anonimo" value="<bean:write name="userSession" property="isAnonimoView"/>"/>
	<input type="hidden" name="urlReComenzar" value="<bean:write name="userSession" property="urlReComenzar"/>"/>

	<input type="hidden" name="selectedId" value=""/>
	<input type="hidden" name="isSubmittedForm" value="true"/>

	<!-- Inclusion del Codigo Javascript del Calendar-->
	<div id="calendarDiv" style="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;"></div>
</html:form>
<!-- Fin Tabla que contiene todos los formularios -->
