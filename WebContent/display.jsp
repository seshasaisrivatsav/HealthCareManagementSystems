    <%@ taglib uri="/struts-tags" prefix="s" %>  
      
    <h3>All Records:</h3>  
    <s:iterator  value="list">  
    <fieldset>  
<s:property value="appdate"/><br/>
<s:property value="name"/><br/> 
    </fieldset>  
    </s:iterator>  