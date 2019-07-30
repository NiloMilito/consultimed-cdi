<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.com.consultemed.service.*"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="br.com.consultemed.model.*" %>

<!--<%@page import="br.com.acme.dao.*" %>-->

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>


<mt:admin_tamplate title="Dashboard">	
	
	<jsp:attribute name="content">
	
		<section class="content">
				
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Médicos</li>
		  </ol>
		</nav>
		
		<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Novo Médico</h3>
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            
            <form role="form" method="POST">
            
              <div class="box-body">
              
                <div class="form-group">
                  <label for="nome">Nome</label>
                  <input type="text" name="nome" class="form-control" required="required" value="${medico.nome}" id="nome" placeholder="Informe o nome">
                </div>
                
                 <div class="form-group">
					<label for="cpf">CPF</label>				
					<input type="text" name="cpf" required="required" value="${medico.cpf}" id="cpf" 
					placeholder="Informe o CPF" class="form-control" onkeypress="$(this).mask('000.000.000-00');">
                </div>
                
                <div class="form-group">
                  <label for="crm">CRM</label> 
                  <input type="text" name="crm" class="form-control" required="required" value="${medico.crm}" id="crm" placeholder="Informe o CRM">
				</div>
								
				<div class="form-group">
                  <label for="especialidade">Especialidade</label> 
                  <input type="text" name="especialidade" class="form-control" required="required" value="${medico.especialidade}" id="especialidade" placeholder="Informe a especialidade">
                </div>    
                                                          								
				<div class="form-group">
					<label for="dias">Dias de Atendimento</label> 
				</div>                  
									
				<div class="form-group col-md-2">						
					<label for="segunda">Segunda</label>
					<input type="checkbox" checked="${medico.diasAtendimento.segunda}" value="segunda"  name="segunda" /> 
				</div>	
				<div class="form-group col-md-2">
					<label for="terca">Terça</label>							
					<input type="checkbox" checked="${medico.diasAtendimento.terca}" value="terca"  name="terca" /> 
				</div>
				<div class="form-group col-md-2">						
					<label for="quarta">Quarta</label>
					<input type="checkbox" checked="${medico.diasAtendimento.quarta}" value="quarta"  name="segunda" /> 
				</div>	
				<div class="form-group col-md-2">
					<label for="quinta">Quinta</label>							
					<input type="checkbox" checked="${medico.diasAtendimento.quinta}" value="quinta" name="quinta" /> 
				</div>	
				<div class="form-group col-md-2">
					<label for="sexta">Sexta</label>							
					<input type="checkbox" checked="${medico.diasAtendimento.sexta}" value="sexta"  name="sexta" /> 
				</div>		
				<div class="form-group col-md-2">
					<label for="sabado">Sábado</label>							
					<input type="checkbox" checked="${medico.diasAtendimento.sabado}" value="sabado"  name="sabado" /> 
				</div>															
								
        </div>
				<div class="box-footer">
					<c:if test="${medico.id != null}">
						<button type="submit" class="btn btn-sm btn-warning">Editar</button>&nbsp;&nbsp;&nbsp;&nbsp;
	        </c:if>
					
					<c:if test="${medico.id == null}">
						<button name="enviar" type="submit" class="btn btn-sm btn-primary">Salvar</button>&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					
					<a href="${pageContext.request.contextPath}/admin/medicos?action=list" class="btn btn-sm btn-default">Médicos</a>&nbsp;&nbsp;&nbsp;&nbsp;
						
				</div>
              
					
      </form>
      	</div>
			
	 </section>
  
	</jsp:attribute>
</mt:admin_tamplate>
