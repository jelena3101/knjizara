
<title>Bookmate | Korisnik</title>
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
                            
                                <div class="form-row justify-content-center pt-4 pb-4 text-center">
                                    
                                    <div class="col-10 mb-2 bg-info text-center">
                                        <p class="text-white">Korisnik: ${viewPosetilac.ime} ${viewPosetilac.prezime}</p>
                                    </div>
                                    
                                    <div class="col-10 mb-2 bg-info text-center">
                                        <p class="text-white">Username: ${viewPosetilac.username}</p>
                                    </div>

<!--                                    <div class="col-10">
                                        <button type="submit" class="btn btn-primary mb-0">Sačuvaj</button>
                                        <button type="submit" class="btn btn-secondary btn-bordered mb-0">Odustani</button>
                                    </div>-->
                                    
                                    <div class="col-10">
                                        <a href="/knjizara/korisnik/edit/${viewPosetilac.posetilacID}" class="btn btn-primary mb-0">Izmeni</a>
                                    </div>
                                </div>

                        </div>
                    </div>
                </div>
            
            </div>
        </div>
        
        <%@ include file="../../common/footer.jspf" %>
        
    </div>
