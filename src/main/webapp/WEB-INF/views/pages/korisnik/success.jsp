
<title>Bookmate</title>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jspf" %>

    <div id="wrap">
        
        <%@ include file="../../common/navigation.jspf" %>
        
        <div id="content" class="content">
            <div class="row d-flex vh-100">
            
                <div class="container align-self-center">
                    <div class="row justify-content-center">
                        <div class="col-12 col-md-6 text-center">

                            <h1>Uspešno ste izmenili korisnika!</h1>
                            <a href="get/${editPosetilac.posetilacID}" class="btn btn-success">Prikaži korisnika</a>

                        </div>
                    </div>
                </div>
            
            </div>
        </div>
        
        <%@ include file="../../common/footer.jspf" %>
        
    </div>