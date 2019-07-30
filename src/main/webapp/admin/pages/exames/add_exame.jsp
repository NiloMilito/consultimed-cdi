<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.com.consultemed.service.*"%>
<%@page import="java.util.List"%>
<%@page import="br.com.consultemed.model.*" %>
<%@page import="br.com.consultemed.dao.*" %>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_tamplate title="Dashboard">	
	<jsp:attribute name="content">	
		<section class="content">				
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Exames</li>
		  </ol>
		</nav>
		
		<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Novo Exame</h3>
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            
            <form role="form" method="POST">
            
              <div class="box-body">
              
              	<div class="form-group">
					<input type="hidden" name="id" value="${exame.id}" />
				</div>
              
                <div class="form-group">
                  <label for="nome">Nome</label>
                  <input type="text" name="nome" class="form-control" required="required" value="${exame.nome}" id="nome" placeholder="Informe o nome">
                </div>
                
                <div class="form-group">
                  <label for="tipo">Tipo</label>
                  <input type="text" name="text" class="form-control" required="required" value="${exame.tipo}" id="tipo" placeholder="Informe o tipo">
				</div> 
																
              </div>
				<div class="box-footer">
					<c:if test="${exame.id != null}">
						<button type="submit" class="btn btn-sm btn-warning">Editar</button>&nbsp;&nbsp;&nbsp;&nbsp;
	            	</c:if>
					
					<c:if test="${exame.id == null}">
						<button name="enviar" type="submit" class="btn btn-sm btn-primary">Salvar</button>&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					
					<a href="${pageContext.request.contextPath}/admin/exames?action=list" class="btn btn-sm btn-default">Exames</a>&nbsp;&nbsp;&nbsp;&nbsp;
						
				</div>
              
					
            </form>
      	</div>
			
	 </section>
  
	</jsp:attribute>
</mt:admin_tamplate>
