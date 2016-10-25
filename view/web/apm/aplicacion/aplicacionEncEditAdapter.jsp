<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<!-- Tabla que contiene todos los formularios -->
<html:form styleId="filter" action="/apm/AdministrarEncAplicacion.do">
	
	<!-- Mensajes y/o Advertencias -->
	<%@ include file="/base/warning.jsp" %>
	<!-- Errors  -->
	<html:errors bundle="base"/>				
	
	<h1><bean:message bundle="apm" key="apm.aplicacionEditAdapter.title"/></h1>	
	<table class="tablabotones" width="100%">
		<tr>			
			<td align="right">
    			<html:button property="btnVolver"  styleClass="boton" onclick="submitForm('volver', '');">
					<bean:message bundle="base" key="abm.button.volver"/>
				</html:button>
			</td>
		</tr>
	</table>
	
	<!-- Aplicacion -->
	<fieldset>
		<legend><bean:message bundle="apm" key="apm.aplicacion.title"/></legend>
		<table class="tabladatos">
			
			<tr>
				<!-- Codigo -->
				
				<td><label>(*)&nbsp;<bean:message bundle="apm" key="apm.aplicacion.codigo.label"/>: </label></td>
				<td class="normal"><html:text name="encAplicacionAdapterVO" property="aplicacion.codigo" size="20" maxlength="100" styleClass="datos" /></td>
				
				<!-- Descripci�n -->
				
				<td><label>(*)&nbsp;<bean:message bundle="apm" key="apm.aplicacion.descripcion.label"/>: </label></td>
				<td class="normal"><html:text name="encAplicacionAdapterVO" property="aplicacion.descripcion" size="20" maxlength="100" styleClass="datos" /></td>
	
			</tr>
		
			<tr>
				<!-- Package name -->
				<td><label><bean:message bundle="apm" key="apm.aplicacion.packageName.label"/>: </label></td>
				<td class="normal"><html:text name="encAplicacionAdapterVO" property="aplicacion.packageName" size="20" maxlength="100" styleClass="datos" /></td>
				<!-- Class Name -->
				<td><label><bean:message bundle="apm" key="apm.aplicacion.className.label"/>: </label></td>
				<td class="normal"><html:text name="encAplicacionAdapterVO" property="aplicacion.className" size="20" maxlength="100" styleClass="datos" /></td>
			</tr>
			
			
				
		</table>
	</fieldset>	
	<!-- Aplicacion -->
	
	<table class="tablabotones" width="100%" >
	   	<tr>
  	   		<td align="left" width="50%">
	   	    	<html:button property="btnVolver" styleClass="boton" onclick="submitForm('volver', '');">
	   	    		<bean:message bundle="base" key="abm.button.volver"/>
	   	    	</html:button>
   	    	</td>
   	    	<td align="right" width="50%">
				<logic:equal name="encAplicacionAdapterVO" property="act" value="modificar">
					<html:button property="btnAceptar"  styleClass="boton" onclick="submitForm('modificar', '');">
						<bean:message bundle="base" key="abm.button.modificar"/>
					</html:button>
				</logic:equal>
				<logic:equal name="encAplicacionAdapterVO" property="act" value="agregar">
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