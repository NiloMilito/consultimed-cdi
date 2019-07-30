<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.com.consultemed.service.*"%>
<%@page import="java.util.Collection"%>
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
		    <li class="breadcrumb-item active" aria-current="page">Pacientes</li>
		  </ol>
		</nav>
		 
		<div class="box box-info">
      <div class="box-header with-border">
        <h3 class="box-title">Novo Paciente</h3>
          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
            </button>
            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
        </div>
      </div>
            
      <form role="form" method="POST" action="${pageContext.request.contextPath}/admin/pacientes?action=list">
        <div class="box-body">              
          <div class="form-group col-md-12">
            <input type="hidden" name="id" value="${paciente.id}" readonly="readonly" required="required" class="form-control" id="id" placeholder="Digite o nome">
          </div>
              
          <div class="form-group">
            <label for="nome">Nome</label>
            <input type="text" name="nome" class="form-control" value="${paciente.nome}" id="nome" placeholder="Informe o nome">
          </div>

          <div class="form-group">
            <label for="cpf">CPF</label>
            <input type="text" name="cpf" class="form-control" value="${paciente.cpf}" id="cpf" placeholder="Informe o cpf">
          </div>

          <h3 class="box-title">Endereço</h3>

          <div class="form-group">
            <label for="cep">CEP</label>
            <input type="text" name="cep" class="form-control" value="${paciente.endereco.cep}" id="cep" placeholder="Informe o cep">
          </div>

          <div class="form-group">
            <label for="uf">UF</label>
            <input type="text" name="uf" class="form-control" value="${paciente.endereco.estado}" id="estado" placeholder="Informe a cidade">
          </div>

          <div class="form-group">
            <label for="cidade">Cidade</label>
            <input type="text" name="cidade" class="form-control" value="${paciente.endereco.cidade}" id="cidade" placeholder="Informe a cidade">
          </div>

          <div class="form-group">
            <label for="rua">Rua</label>
            <input type="text" name="rua" class="form-control" value="${paciente.endereco.rua}" id="rua" placeholder="Informe a rua">
          </div>
                
          <div class="form-group">
            <label for="numero">Número</label>
            <input type="text" name="numero" class="form-control" value="${paciente.endereco.numero}" id="numero" placeholder="Informe o numero">
          </div>

          <div class="form-group">
            <label for="bairro">Bairro</label>
            <input type="text" name="bairro" class="form-control" value="${paciente.endereco.bairro}" id="bairro" placeholder="Informe o bairro">
          </div>    
        </div>

        <div class="box-footer">
          <c:if test="${paciente.id != null}">
            <button type="submit" class="btn btn-warning">Editar</button>
          </c:if>
          
          <c:if test="${paciente.id == null}">
            <button name="enviar" type="submit" class="btn btn-primary">Salvar</button>&nbsp;&nbsp;&nbsp;&nbsp;
          </c:if>
          <a href="${pageContext.request.contextPath}/admin/pacientes?action=list" class="btn btn-sm btn-default">Pacientes</a>&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
        </form>
      </div>		
  </section>
</jsp:attribute>
</mt:admin_tamplate>
