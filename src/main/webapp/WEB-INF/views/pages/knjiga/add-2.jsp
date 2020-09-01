

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
                                    <div class="row justify-content-center">
                                        <div class="col-12 col-md-6">
                                            <form:form method="POST" action="autori/save" modelAttribute="autori">

                                                <div class="row">
                                                    <div class="col-12 col-md-6">
                                                        <div class="form-row">

                                                            <div class="col-12">
                                                                <div class="form-group">
                                                                    <label>Autori </label>
                                                                    
                                                                    <c:forEach items="${saveKnjiga.autori}" var="a">
                                                                        <div class="form-group d-flex flex-column">
                                                                            <form:input path="" readonly="true" value="${a}" class="form-control" />
                                                                            <a href="autori/delete/${a.autorID}" class="btn btn-danger"><i class="fas fa-trash"></i></a>
                                                                        </div>
                                                                    </c:forEach>
                                                                   
                                                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#autorsModal">
                                                                      <i class="fas fa-plus"></i> &nbsp; Dodaj autora
                                                                    </button>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="text-center mar-t-35">
                                                    <button class="btn btn-dark" type="submit">Dalje</button>
<!--                                                    <br>
                                                    <a href="add-1" class="btn btn-link text-primary prevBtn" style="text-transform:none; font-weight: normal;">Nazad</a>-->
                                                </div>
                                                                    
                                            </form:form>

                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            
            </div>
        </div>
        
        <!-- Autors Modal -->
        <div class="modal fade" id="autorsModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Izaberite autora</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                  <div class="container-fluid">
                      
                    <div class="row justify-content-center">
                        <div class="col-12 col-md-12">
                            
                            <div class="form-group has-search d-flex">
                                <span class="fas fa-search form-control-search"></span>
                                <input id="inputFilter" type="text" class="form-control icon mr-2" placeholder="Search" name="pretraga" onkeyup="searchFunction()" />
                            </div>

                            <div class="form-group">
                                <table id="tableFilter" class="table table-dark">
                                    <thead>
                                        <tr>
                                            <td>Autor</td>
                                            <td></td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sviAutori}" var="autor">
                                            <tr>
                                                <td>${autor}</td>
                                                <td>
                                                    <a href="autori/get/${autor.autorID}" class="btn btn-success">Izaberi</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                      
                  </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Zatvori</button>
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#newAutorModal">Dodaj novog autora</button>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Add new autor Modal -->
        <div class="modal fade" id="newAutorModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Dodajte autora</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                  <div class="container-fluid">
                      
                    <div class="row justify-content-center">
                        <div class="col-12 col-md-12">
                            
                            <div class="form-group">
                                
                                <form:form method="POST" action="autor/save" modelAttribute="autor">
                                    
                                    <div class="form-row justify-content-center">
                                        <div class="col-12">
                                            <div class="form-group">
                                                <form:input type="text" placeholder="Ime" path="ime" class="form-control" />
                                                <form:errors path="ime"/>
                                            </div>
                                        </div>
                                    </div>
                                            
                                    <div class="form-row">
                                        <div class="col-12">
                                            <div class="form-group">
                                                <form:input type="text" placeholder="Prezime" path="prezime" class="form-control" />
                                                <form:errors path="prezime"/>
                                            </div>
                                        </div>
                                    </div>
                                            
                                    <div class="form-row">
                                        <button type="submit" class="btn btn-success">Submit</button>
                                    </div>
                                            
                                </form:form>
                                
                            </div>
                            
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