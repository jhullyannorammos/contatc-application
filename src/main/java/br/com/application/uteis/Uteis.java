package br.com.ciceroednilson.uteis;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

public class Uteis {
	
	private static String atencao = "Atenção:";
	private static String alerta = "Alerta";
	
	public static EntityManager JpaEntityManager(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request  = (HttpServletRequest)externalContext.getRequest();
		return (EntityManager) request.getAttribute("entityManager");
	}
	
	//MOSTRAR MENSAGEM
	public static void Mensagem(String mensagem){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(alerta, mensagem));
	}

	//MOSTRAR MENSAGEM
	public static void MensagemAtencao(String message){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, atencao, message));
	}
	
	//MOSTRAR MENSAGEM
	public static void MensagemInfo(String message){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", message));
	}

}
