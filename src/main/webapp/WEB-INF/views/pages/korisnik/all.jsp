

<title>Bookmate | All Users</title>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jspf" %>

    <div id="wrap">
        
        <%@ include file="../../common/navigation.jspf" %>
        
        <div id="content" class="content">
            <div class="row d-flex mt-5 pt-4 pb-4">
            
                <div class="container align-self-center">
                    <div class="row justify-content-center">
                        
                        <div class="form-group has-search d-flex">
                            <span class="fas fa-search form-control-search"></span>
                            <input id="inputFilter" type="text" class="form-control icon mr-2" placeholder="Search" name="pretraga" onkeyup="searchFunction()" />
                        </div>
                        
                        <div class="col-12">
                            
                            <table id="tableFilter" class="table table-light table-hover">
                                <thead>
                                    <tr>
                                        <th>Korisnik</th>
                                        <th>Korisničko ime</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${korisnici}" var="korisnik"> 
                                        <tr>
                                            <td>${korisnik}</td>
                                            <td>${korisnik.username}</td>
                                            <td>
                                                <a href="get/${korisnik.posetilacID}" class="btn btn-info"><i class="fas fa-eye"></i> View</a>
                                                <c:if test="${tip == 'admin'}">
                                                    <a href="edit/${korisnik.posetilacID}" class="btn btn-primary"><i class="fas fa-pen"></i> Edit</a>
                                                    <a href="delete/${korisnik.posetilacID}" class="btn btn-danger"><i class="fas fa-trash"></i> Delete</a>
                                                </c:if>
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
        
        <%@ include file="../../common/footer.jspf" %>
        <script src="<c:url value="/resources/js/search.js" />"></script>
    </div>