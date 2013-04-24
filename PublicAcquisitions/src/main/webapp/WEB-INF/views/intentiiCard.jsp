<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>
<script type="text/javascript">
$(document).ready(function(){
	/* ------------------------------------------------------------------------------------- */
	//var pid = ${intentionId};
	//$("#intentionId").val(pid);
	
	setMenuSelection("intentii");
	var w = screen.width*0.98;
	var curLangRef = "${pageContext.response.locale}" + 'Value';
	
	function getItemTranslation(item){
		if (curLangRef == "mdValue") {
			return item.mdValue;
		} 
		if (curLangRef == "ruValue") {
			return item.ruValue;
		} 
		if (curLangRef == "enValue") {
			return item.enValue;
		}
		return item.mdValue;
	} 
	/* ------------------------------------------------------------------------------------- */            
         
	console.log( intentionItem );
      	
}); 
</script>

<html>
<center>
<!-- 	<table id="t0" border="1" width="100%" height=14 cellspacing="0" -->
<!-- 		cellpadding="0" style="background-color: #708EA7; color: #FFFFFF" > -->
<!-- 		<tr> -->
<!-- 			<td width="93%" align="left" valign="middle"> -->
<!-- 				<div id="headerLine"> -->
<!-- 					<div class="form-buttons" style="display: inline-block;"> -->
<!-- 					  	<input id="backToIntentionList" type="button" value="Back" /> -->
<!-- 					</div> -->
<!-- 					<input id="intentionId" readonly="readonly" disabled="disabled"> <br> -->
<%-- 					<fmt:formatDate value="31/12/2013" pattern="dd.MM.yyyy"/> --%>
<!-- 					<div align="center"> -->
<%-- 						<spring:message code="label.header1"/>${intentionItem.regNumber}   --%>
<%-- 						<spring:message code="label.header2"/>&nbsp; <fmt:formatDate value="${intentionItem.bulletinPublishDate}" type="both" pattern="dd.MM.yyyy" /> --%>
<%-- 						<spring:message code="label.header3"/>&nbsp; ${intentionItem.forWhoPurchase} --%>
<!--   					</div> -->
  
<!-- 				</div> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
	
<div id="headerDiv">
	<span id="headerLine" style="position:relative; top:5px">
		<spring:message code="label.header1"/>${intentionItem.regNumber}  
		<spring:message code="label.header2"/>&nbsp; <fmt:formatDate value="${intentionItem.bulletinPublishDate}" type="both" pattern="dd.MM.yyyy" />
		<spring:message code="label.header3"/>&nbsp; ${intentionItem.forWhoPurchase}
	</span>
</div>	
<div id="form-div">
	<form action="" style="width: 100%;">
		<fieldset  style="background-color: #F3F3F3; width: 90%;">
	
	<div style="text-align:center">
	<span style="white-space: nowrap; margin-bottom:10px">
		<img src="resources/images/datele_1.png" style="margin-bottom:-5px" />
		<span id="form-header" style="float:none">
			<spring:message code="label.commonInfo"/>
		</span>
	</span>
	</div>
	
	<hr width="90%" class='dotted'>
	<div style="text-align: left;" >
			<label for="pRegNumber" 			style="display:inline-block; width: 200px; text-align: right;">
			<spring:message code="label.intentionCard_regNumber"/></label>
			<input id="pRegNumber" 	value="${intentionItem.regNumber}"		
				type="text" class="k-widget" style="width: 80px; text-align: center;"/>
			<label for="pBulletinNumber" 		style="display:inline-block; width: 300px; text-align: right;">
			<spring:message code="label.intentionCard_publicatInBuletin"/></label>			
			<input id="pBulletinNumber" value="${intentionItem.bulletinNumber}"	
				type="text" class="k-widget" style="width: 80px; text-align: center;"/>
			<label for="pBulletinPublishDate" 	style="display:inline-block; width: 10px; text-align: center;"> 
			<spring:message code="label.intentionCard_din"/></label>		
			<input id="pBulletinPublishDate" 
				value="<fmt:formatDate value="${intentionItem.bulletinPublishDate}" type="both" pattern="dd.MM.yyyy" />" 
			type="text" class="k-widget" style="width: 80px;  text-align: center;"/>	
			

			<br>
			<label for="pBudgetPeriod_year" 			style="display:inline-block; width: 200px; text-align: right;">
			<spring:message code="label.intentionCard_perioadaBugetara"/></label>
			<input id="pBudgetPeriod_year" value="${intentionItem.budgetPeriod.year}" 			
				type="text" class="k-widget" style="width: 80px;  text-align: center;" />
			<label for="pPlannedSum" 		style="display:inline-block; width: 150px; text-align: right;">
			<spring:message code="label.intentionCard_sumaPlanificata"/></label>			
			<input id="pPlannedSum"  value="${intentionItem.plannedSum}"	
				type="text" class="k-widget" style="width: 70px; text-align: center;" />
			<label for="pPurchaseQuarter" 	style="display:inline-block; width: 190px; text-align: right;"> 
			<spring:message code="label.intentionCard_perioadaPetrecerii"/></label>			
			<input id="pPurchaseQuarter"  value="${intentionItem.purchaseQuarter}"
				type="text" class="k-widget" style="width: 60px; text-align: center;" />
			<br>
			
				
			<label for="pTenderType" 	style="display:inline-block; width: 200px; text-align: right;"> 
			<spring:message code="label.intentionCard_tipulProcedurii"/></label>		
			<input id="pTenderType"  
			value="${pageContext.response.locale=='ru'?intentionItem.tenderType.ruValue:
 					(pageContext.response.locale=='md'?intentionItem.tenderType.mdValue:intentionItem.tenderType.enValue)}" 
				type="text" class="k-widget" style="width: 650px;" />	
			<br>	

			<label for="pPositionDescr" 	style="display:inline-block; width: 200px; text-align: right; vertical-align: top;"> 
			<spring:message code="label.intentionCard_descriereaObiectului"/></label>	
			<textarea id="pPositionDescr" readonly="readonly" class="k-widget"   
					  style="width: 646px; resize: none; " cols="1" rows="2">${intentionItem.positionDescr}
			</textarea>
			<br>
			
			<label for="pForWhoPurchase" 	style="display:inline-block; width: 200px; text-align: right;"> 
			<spring:message code="label.intentionCard_destinatarulAchizitiei"/></label>			
			<input id="pForWhoPurchase" value="${intentionItem.forWhoPurchase}" 
				type="text" class="k-widget" style="width: 650px;" />
			<br>	
			
			<label for="pPurchaserComment" 	style="display:inline-block; width: 200px; text-align: right; vertical-align: top;"> 
			<spring:message code="label.intentionCard_comentarii"/></label>		
 			<textarea id="pPurchaserComment" readonly="readonly" class="k-widget"   
					  style="width: 646px; resize: none; " cols="1" rows="2">${intentionItem.purchaserComment} 
 			 </textarea>
			<br>
			<label for="pCPVCode" 	style="display:inline-block; width: 200px; text-align: right; vertical-align: top;"> 
			<spring:message code="label.codeCPV"/></label>		
			<input id="pCPVCode" 	value="${intentionItem.goods.code}   ${pageContext.response.locale=='ru'?intentionItem.goods.ruValue:
 					(pageContext.response.locale=='md'?intentionItem.goods.mdValue:intentionItem.goods.enValue)}"
				type="text" class="k-widget" style="width: 650px;" />
			<br>					
	</div>

	<div style="text-align:center">
	<span style="white-space: nowrap; margin-bottom:10px">
		<img src="resources/images/procedura_1.png" style="margin-bottom:-5px" />
		<span id="form-header" style="float:none">
			<spring:message code="label.contractAuthority"/>
		</span>
	</span>
	</div>
	
	<hr width="90%" class='dotted'>
	<div style="text-align: left;" >
			<label for="pCode" 			style="display:inline-block; width: 200px; text-align: right;">
			<spring:message code="label.intentionCard_idno"/></label>
				<input id="pCode" value="${intentionItem.stateOrg.code}" 		
				type="text" class="k-widget" style="width: 100px; text-align: center;" />
			<label for="pCutam" 		style="display:inline-block; width: 100px; text-align: right;">
			<spring:message code="label.intentionCard_okpo"/></label>
				<input id="pCutam" value="${intentionItem.stateOrg.cuatm}"  	
				type="text" class="k-widget" style="width: 100px; text-align: center;" />
			<br>
			
			<label for="pOrgName" 		style="display:inline-block; width: 200px; text-align: right;">
			<spring:message code="label.intentionCard_denumirea"/></label>			
				<input id="pOrgName" value="${intentionItem.stateOrg.orgName}"  	
				type="text" class="k-widget" style="width: 650px;" />
			<br>
			
			<label for="pOrgLegalForm" 		style="display:inline-block; width: 200px; text-align: right;">
			<spring:message code="label.intentionCard_formaJuridica"/></label>			
				<input id="pOrgLegalForm" 
				value="${pageContext.response.locale=='ru'?intentionItem.stateOrg.orgLegalForm.ruValue:
 					(pageContext.response.locale=='md'?intentionItem.stateOrg.orgLegalForm.mdValue:intentionItem.stateOrg.orgLegalForm.enValue)}" 
				type="text" class="k-widget" style="width: 650px;" />
			<br>			
			
			<label for="pAddress" 		style="display:inline-block; width: 200px; text-align: right;">
			<spring:message code="label.intentionCard_adresa"/></label>
				<input id="pAddress" value="${intentionItem.stateOrg.address}"  	
				type="text" class="k-widget" style="width: 650px;" />
			<br>			
			
			<label for="pPhone" 		style="display:inline-block; width: 200px; text-align: right;">
			<spring:message code="label.intentionCard_telefon"/></label>			
				<input id="pPhone" value="${intentionItem.stateOrg.phone}"  	
				type="text" class="k-widget" style="width: 100px;  text-align: center;" />
			<label for="pEmail" 		style="display:inline-block; width: 100px; text-align: right;">
			<spring:message code="label.intentionCard_email"/></label>			
				<input id="pEmail" value="${intentionItem.stateOrg.email}"  	
				type="text" class="k-widget" style="width: 400px;" />				
			<br>
			<br>			
			<br>		
			
		</div>	
			
									
							
		</fieldset>
	</form>				
</div>	

<%-- 			<form:input id="pTenderType"   path="intentionItem.tenderType.ruValue"    --%>
<%-- 				type="text" class="k-widget" style="width: 860px;" /> --%>
<%-- 			<spring:eval expression=""></spring:eval> --%>


<!-- 	<table id="tIntentionCard" border="1" width="95%"> -->

<!-- 		<tr> -->
<%-- 			<td width="20%" align="right"><spring:message --%>
<%-- 					code="label.procedureRegNumber" /></td> --%>
<!-- 			<td width="29%" align="center"><input id="regNumber" type="text" -->
<!-- 				style="width: 90%;" readonly="readonly"></td> -->
<%-- 			<td width="20%" align="right"><spring:message --%>
<%-- 					code="label.currentStatus" /></td> --%>
<!-- 			<td width="29%" align="center"><input id="tenderStatus" -->
<!-- 				type="text" style="width: 90%;" readonly="readonly"></td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
	
	
</center>
</html>

			
		 


		 