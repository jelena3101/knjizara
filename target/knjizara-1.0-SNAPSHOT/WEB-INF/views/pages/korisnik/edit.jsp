

<title>Bookmate</title>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="../../common/header.jspf" %>

    <div id="wrap">
        
        <%@ include file="../../common/navigation.jspf" %>
        
        <div id="content" class="content">
            <div class="row d-flex vh-100">
            
                <div class="container align-self-center">
                    <div class="row justify-content-center">
                        <div class="col-12 col-md-6">
                            <div class="logo-thumbnail ml-auto mr-auto">
                                <img src="<c:url value="/resources/img/bookmate_vertical.png" />" alt="bookmate logo">
                            </div>
                            <form:form method="POST" action="/knjizara/korisnik/save" modelAttribute="posetilac">
                                <div class="form-row justify-content-center pt-4 pb-4 text-center">
                                    <p>
                                        <font color="red">${errorMessage}</font>
                                    </p>
                                    
                                    <form:hidden path="posetilacID" value="${editPosetilac.posetilacID}" />
                                    <div class="col-5 mb-2">
                                        <form:input type="text" placeholder="Ime" path="ime" value="${editPosetilac.ime}" class="form-control" required="required"/>
                                    </div>
                                    
                                    <div class="col-5 mb-2">
                                        <form:input type="text" placeholder="Prezime" path="prezime" value="${editPosetilac.prezime}" class="form-control" required="required" />
                                    </div>
                                    
                                    <div class="col-10 mb-2">
                                        <form:input type="text" placeholder="Korisnicko ime" path="username" value="${editPosetilac.username}" class="form-control" required="required" />
                                    </div>
                                    
                                    <form:hidden path="password" value="${editPosetilac.password}"/>
                                    <form:hidden path="role" value="${editPosetilac.role}" />

<!--                                    <div class="col-10">
                                        <button type="submit" class="btn btn-primary mb-0">Sačuvaj</button>
                                        <button type="submit" class="btn btn-secondary btn-bordered mb-0">Odustani</button>
                                    </div>-->
                                    
                                    <div class="col-10">
                                        <button type="submit" class="btn btn-primary mb-0">Sačuvaj izmene</button>
                                    </div>

                                </div>
                            </form:form>

                        </div>
                    </div>
                </div>
            
            </div>
        </div>
        
        <%@ include file="../../common/footer.jspf" %>
        
    </div>
