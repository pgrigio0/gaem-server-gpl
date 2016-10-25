<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<!-- Tabla que contiene todos los formularios -->
<html:form styleId="filter" action="/frm/AdministrarMotivoAnulacionTipoFormulario.do">
	
	<!-- Mensajes y/o Advertencias -->
	<%@ include file="/base/warning.jsp" %>
	<!-- Errors  -->
	<html:errors bundle="base"/>				
	
	<h1><bean:message bundle="frm" key="frm.motivoAnulacionTipoFormularioEditAdapter.title"/></h1>	
	<table class="tablabotones" width="100%">
		<tr>			
			<td align="right">
    			<html:button property="btnVolver"  styleClass="boton" onclick="submitForm('volver', '');">
					<bean:message bundle="base" key="abm.button.volver"/>
				</html:button>
			</td>
		</tr>
	</table>
	
	<!-- MotivoAnulacionTipoFormulario -->
	<fieldset>
		<legend><bean:message bundle="frm" key="frm.motivoAnulacionTipoFormulario.title"/></legend>
		
		<table class="tabladatos">
			<tr>
				<td><label><bean:message bundle="frm" key="frm.motivoAnulacionTipoFormulario.tipoFormulario.label"/>: </label></td>
				<td class="normal">
					<html:select name="motivoAnulacionTipoFormularioAdapterVO" property="motivoAnulacionTipoFormulario.tipoFormulario.id" styleClass="select">
						<html:optionsCollection name="motivoAnulacionTipoFormularioAdapterVO" property="listTipoFormulario" label="descripcion" value="id" />
					</html:select>
				</td>								
				<td><label><bean:message bundle="frm" key="frm.motivoAnulacionTipoFormulario.descripcion.label"/>: </label></td>
				<td class="normal"><html:text name="motivoAnulacionTipoFormularioAdapterVO" property="motivoAnulacionTipoFormulario.descripcion" size="20" maxlength="100" styleClass="datos" /></td>
			</tr>
		</table>
	</fieldset>	
	<!-- MotivoAnulacionTipoFormulario -->
	
	<table class="tablabotones" width="100%" >
	   	<tr>
  	   		<td align="left" width="50%">
	   	    	<html:button property="btnVolver" styleClass="boton" onclick="submitForm('volver', '');">
	   	    		<bean:message bundle="base" key="abm.button.volver"/>
	   	    	</html:button>
   	    	</td>
   	    	<td align="right" width="50%">
				<logic:equal name="motivoAnulacionTipoFormularioAdapterVO" property="act" value="modificar">
					<html:button property="btnAceptar"  styleClass="boton" onclick="submitForm('modificar', '');">
						<bean:message bundle="base" key="abm.button.modificar"/>
					</html:button>
				</logic:equal>
				<logic:equal name="motivoAnulacionTipoFormularioAdapterVO" property="act" value="agregar">
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


