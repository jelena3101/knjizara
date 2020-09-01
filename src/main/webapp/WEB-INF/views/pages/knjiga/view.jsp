

<title>Bookmate | Knjiga</title>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jspf" %>

    <div id="wrap">
        
        <%@ include file="../../common/navigation.jspf" %>
        
        <div id="content" class="content">
            <div class="row d-flex mt-5 pt-5 pb-5">
            
                <div class="container align-self-center gradient-card px-5 py-5 bg-white">
                    <div class="row justify-content-center">
                        
                        <div class="col-12 col-md-4">
                            <figure class="film-thumbnail">
                                <img src="${viewKnjiga.slika}" alt="Slika knjige" />
                            </figure>     
                        </div>
                        
                        <div class="col-12 col-md-8">
                            <h3>${viewKnjiga.naslov}</h3>
                            <p><span>${viewKnjiga.zanrovi}</span> | <span>${viewKnjiga.godina}</span></p>
                            <p>Autori:
                                <span>
                                    <c:forEach items="${viewKnjiga.autori}" var="aut" varStatus="i">
                                        ${aut}
                                        <c:if test="${viewKnjiga.autori.size() - i.index > 1}">
                                            ,
                                        </c:if>
                                    </c:forEach>
                                </span>
                            </p>
                            
                        </div>
                        
                    </div>
                            
                    <div class="row">
                        <div class="col-12">
                            <p class="text-justify">${viewKnjiga.opis}</p>
                        </div>
                    </div>
                            

                    
                </div>
            
            </div>
        </div>
        
        <%@ include file="../../common/footer.jspf" %>
        
    </div>