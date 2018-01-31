<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="<c:url value="/resources/js/login.js" />"></script>
<div class="loginBox">
    <div class="left col-lg-12 titleBox">
        <h3>Java WebApp Core Codes <c:out value="${version.stringValue}"/></h3>
    </div>
<!--     <div id="flashDiv"> -->
		    
<!--     </div> -->
    <div class="col-lg-12 inputForm loginForm">
        <h4>Account Login</h4>
		<form:form method="POST" action="login.html" command="loginForm" id="loginFormId">
			<div class="inputField">Username:</div>
			<div class="inputField"><form:input path="username"></form:input></div>
			
			<div class="inputField">Password:</div>
			<div class="inputField"><form:password path="password"></form:password></div>
<!--             <div class="inputField"> -->
<!--                 <a href="#">Can't access your account? <span>Click here<span></a> -->
<!--             </div> -->
			<div class="inputButtons">
				<input type="button" value="Login" id="loginBtn">
			</div>
		</form:form>
	</div>
</div>
