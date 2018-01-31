<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <tiles:insertAttribute name="includes"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="headerWrapper">
                <tiles:insertAttribute name="header" />
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 contentWrapper container">
                <tiles:insertAttribute name="menu" />

                <div class="contentContainer">
					<div>
						<div >
							<c:if test="${FLASH_MESSAGE != null}" >
								<div class="flash">${FLASH_MESSAGE}</div>
							</c:if>
						</div>
					</div>
					
                    <tiles:insertAttribute name="body" />
                </div>
                <tiles:insertAttribute name="footer" />
            </div>
        </div>	
</body>
</html>
