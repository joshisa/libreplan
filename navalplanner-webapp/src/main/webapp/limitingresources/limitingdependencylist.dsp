<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.zkoss.org/dsp/zk/core" prefix="z" %>

<c:set var="self" value="${requestScope.arg.self}"/>

<div id="${self.uuid}" z.type="limitingresources.limitingdependencylist.LimitingDependencylist" z.autoz="true"${self.outerAttrs}">

<div id="listlimitingdependencies">
    <c:forEach var="child" items="${self.children}">
        ${z:redraw(child, null)}
    </c:forEach>
</div>

</div>