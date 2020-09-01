
<title>Bookmate | Login</title>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf" %>

    <div id="wrap">
        
        <%@ include file="../common/navigation.jspf" %>
        
        <div id="content" class="content">
            <div class="row d-flex vh-100">
            
                <div class="container align-self-center">
                    <div class="row justify-content-center">
                        <div class="col-12 col-md-6">
                            <div class="logo-thumbnail ml-auto mr-auto">
                                <img src="<c:url value="/resources/img/bookmate_vertical.png" />" alt="bookmate logo">
                            </div>
                            <form:form method="POST" action="/knjizara/welcome" modelAttribute="posetilac">
                                <div class="form-row justify-content-center pt-4 pb-4 text-center">
                                    <p>
                                        <font color="red">${errorMessage}</font>
                                    </p>
                                    
                                    <div class="col-10 mb-2">
                                        <form:input type="text" placeholder="Korisnicko ime" path="username" class="form-control" required="required" />
                                    </div>

                                    <div class="col-10 mb-2">
                                        <form:input type="password" placeholder="Lozinka" path="password" class="form-control" required="required" />
                                    </div>

                                    <div class="col-10">
                                        <button type="submit" class="btn btn-primary mb-0">Login</button>
                                    </div>

                                    <div>
                                        <p class="mb-0 text-white">Nemate nalog?</p>
                                        <a href="register">Registrujte se</a>
                                    </div>
                                    
                                </div>
                            </form:form>

                        </div>
                    </div>
                </div>
            
            </div>
        </div>
        
        <%@ include file="../common/footer.jspf" %>
        
    </div>