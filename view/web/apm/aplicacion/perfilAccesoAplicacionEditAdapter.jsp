<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<!-- Tabla que contiene todos los formularios -->
<html:form styleId="filter" action="/apm/AdministrarPerfilAccesoAplicacion.do">
	
	<!-- Mensajes y/o Advertencias -->
	<%@ include file="/base/warning.jsp" %>
	<!-- Errors  -->
	<html:errors bundle="base"/>				
	
	<h1><bean:message bundle="apm" key="apm.perfilAccesoAplicacionEditAdapter.title"/></h1>	

	<table class="tablabotones" style="width: 100%;">
		<tr>			
			<td align="right">
	   			<html:button property="btnVolver"  styleClass="boton" onclick="submitForm('volver', '');">
					<bean:message bundle="base" key="abm.button.volver"/>
				</html:button>
			</td>
		</tr>
	</table>
	
	<!-- PerfilAccesoAplicacion -->
	<fieldset>
		<legend><bean:message bundle="apm" key="apm.perfilAccesoAplicacion.title"/></legend>
		
		<table class="tabladatos">
			<tr>
				<td><label><bean:message bundle="apm" key="apm.perfilAcceso.label"/>: </label></td>
				<td class="normal"><bean:write name="perfilAccesoAplicacionAdapterVO" property="perfilAccesoAplicacion.perfilAcceso.descripcion"/></td>
			</tr>
			<!-- Aplicacion -->
			<tr>	
				<td><label><bean:message bundle="apm" key="apm.aplicacion.label"/>: </label></td>
				<td class="normal">
					<html:select name="perfilAccesoAplicacionAdapterVO" property="perfilAccesoAplicacion.aplicacion.id" styleClass="select">
						<html:optionsCollection name="perfilAccesoAplicacionAdapterVO" property="listAplicacion" label="descripcion" value="id" />
					</html:select>
				</td>					
			</tr>
		</table>
	</fieldset>	
	<!-- PerfilAccesoAplicacion -->
	
	<table class="tablabotones" style="width: 100%;" >
	   	<tr>
  	   		<td align="left" width="50%">
	   	    	<html:button property="btnVolver" styleClass="boton" onclick="submitForm('volver', '');">
	   	    		<bean:message bundle="base" key="abm.button.volver"/>
	   	    	</html:button>
   	    	</td>
   	    	<td align="right" width="100%">
				<logic:equal name="perfilAccesoAplicacionAdapterVO" property="act" value="modificar">
					<html:button property="btnAceptar"  styleClass="boton" onclick="submitForm('modificar', '');">
						<bean:message bundle="base" key="abm.button.modificar"/>
					</html:button>
				</logic:equal>
				<logic:equal name="perfilAccesoAplicacionAdapterVO" property="act" value="agregar">
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