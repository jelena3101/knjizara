<title>Bookmate</title>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jspf" %>

    <div id="wrap">
        
        <%@ include file="../../common/navigation.jspf" %>
        
        <div id="content" class="content">
            <div class="row d-flex mt-5 pt-5 pb-4">

                <div class="container">
                    <div class="row flex-row justify-content-center">
                        <div class="col-md-12 gradient-card bg-white px-5">
                            
                            <div class="stepwizard">
                                <div class="stepwizard-row setup-panel">
                                    <div class="stepwizard-step">
                                        <button type="button" class="btn btn-circle btn-primary"></button>
                                        <p style="text-transform: uppercase; font-weight: bold;" class="text-default" >Dodaj knjigu</p>
                                    </div>
                                    <div class="stepwizard-step">
                                        <button type="button" class="btn btn-circle btn-dark" disabled="disabled"></button>
                                        <p style="text-transform: uppercase; font-weight: bold;" class="text-default" >Dodaj autora</p>
                                    </div>
                                </div>
                            </div>



                            <div class="row setup-content justify-content-center" id="step-1">
                                <div class="col-12">
                                    <h2 class="text-center mt-2 mb-3">Informacije o knjizi</h2>
                                    <form:form method="POST" action="save" modelAttribute="knjiga">
                                        <div class="row justify-content-center">
                                            <div class="col-12 col-md-6">

                                                <div class="form-row form-group justify-content-center mt-5">
                                                    <form:input type="text" placeholder="Naslov" path="naslov" class="form-control" required="required"/>                                
                                                </div>

                                                <div class="form-row form-group justify-content-center">
                                                    <form:textarea placeholder="Opis" path="opis" rows="7" class="form-control" required="required"/>                             
                                                </div>
                                                                    
                                                <div class="form-row form-group justify-content-center">
                                                    <form:input type="text" placeholder="Link za sliku knjige" path="slika" class="form-control" required="required"/>                                
                                                </div>
                                                
                                            </div>
                                            <div class="col-12 col-md-6">

                                                <div class="form-row">
                                                    <div class="col-12 mt-3">
                                                        <form:label path="zanrovi">Žanr:</form:label>

                                                        <div class="form-group d-flex genre">

                                                            <form:select path="zanrovi" class="form-control mr-3" size="size" multiple="false" >
                                                                <form:option value="0" label="Izaberite žanr" disabled="true" selected="true" />
                                                                <c:forEach items="${sviZanrovi}" var="zanr">
                                                                    <form:option value="${zanr.zanrID}" label="${zanr.nazivZanra}" />
                                                                </c:forEach>
                                                            </form:select>

                                                        </div>

                                                        <div class="form-group d-flex genre">

                                                            <form:select path="zanrovi" class="form-control mr-3" size="size" multiple="false" >
                                                                <form:option value="0" label="Izaberite žanr" disabled="true" selected="true" />
                                                                <c:forEach items="${sviZanrovi}" var="zanr">
                                                                    <form:option value="${zanr.zanrID}" label="${zanr.nazivZanra}" />
                                                                </c:forEach>
                                                            </form:select>
                                                            <a href="#" class="btn btn-danger remove-field"><i class="fas fa-trash"></i></a>

                                                        </div>

                                                        <div class="form-group d-flex genre">

                                                            <form:select path="zanrovi" class="form-control mr-3" size="size" multiple="false" >
                                                                <form:option value="0" label="Izaberite žanr" disabled="true" selected="true" />
                                                                <c:forEach items="${sviZanrovi}" var="zanr">
                                                                    <form:option value="${zanr.zanrID}" label="${zanr.nazivZanra}" />
                                                                </c:forEach>
                                                            </form:select>
                                                            <a href="#" class="btn btn-danger remove-field"><i class="fas fa-trash"></i></a>

                                                        </div>

                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                  

                                                    <div class="col-6">
                                                        <div class="form-group">
                                                            <form:label path="godina">Godina:</form:label>
                                                            <form:input type="number" placeholder="Godina" path="godina" class="form-control" required="required" />
                                                        </div>
                                                    </div>
                                                     <div class="col-6">
                                                         
                                                     </div>   
                                                </div>

                                                <div class="form-row">

                                                    <div class="col-12">
                                                        <div class="form-group d-flex align-items-center">
                                                            <form:label path="jezik" class="mr-3 mb-0">Jezik: </form:label>
                                                            <form:select path="jezik" class="form-control mr-3" size="size" multiple="false" >
                                                                <form:option value="0" label="Izaberite jezik" selected="true" disabled="true" />
                                                                <form:option value="engleski" label="engleski" />
                                                                <form:option value="hrvatski" label="hrvatski" />
                                                                <form:option value="makedonski" label="makedonski" />
                                                                <form:option value="srpski" label="srpski" />
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="text-center mar-t-35">
                                                    <button class="btn btn-dark" type="submit">Dalje</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>

            </div>
        </div>
        
       
        
        <%@ include file="../../common/footer.jspf" %>
        <script src="<c:url value="/resources/js/removeField.js" />"></script>        
        <script src="<c:url value="/resources/js/search.js" />"></script>
        
        
    </div>