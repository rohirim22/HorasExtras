package com.project.HorasExtrasProject.Services;

import java.sql.Timestamp;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.HorasExtrasProject.Entity.LoginRequest;
import com.project.HorasExtrasProject.Entity.Numreque;
import com.project.HorasExtrasProject.Entity.RequestMarcaciones;
import com.project.HorasExtrasProject.Entity.Respuesta;
import com.project.HorasExtrasProject.Entity.tablaMarcaciones;
import com.project.HorasExtrasProject.Repository.GuardadoHoras;




@Service
public class ProcMarcaciones {

	@Autowired
	GuardadoHoras guardadoMarcaciones;
	
	@Transactional
	public Respuesta IngresarHora(RequestMarcaciones reque) {
		int valor=0;
		Respuesta respo=new Respuesta();
		Numreque numre=new Numreque();
			try {
				
				if(reque.getFechaInicio()==0) {
					numre.setInicio(new Timestamp(System.currentTimeMillis()));
				}
			   valor=guardadoMarcaciones.guardado(numre.getInicio(), reque.getUsuario());
			    if(valor==1) {
			    	respo.setCode("0");
			    	respo.setMessage("Exito");
			    }else {
			    	respo.setCode("-1");
			    	respo.setMessage("Error");
			    }
		} catch (Exception e) {
			// TODO: handle exception
		}
			return respo;
		}
	@Transactional
	public Respuesta Finalizarjornada(RequestMarcaciones reque) {
		int valorres=0;
		Respuesta resp = new Respuesta();
		Numreque numreq= new Numreque();
		  
		try {
			if(reque.getFechaFin()==1) {
				numreq.setFin(new Date());
			}
			
			valorres=guardadoMarcaciones.guardadoFin(numreq.getFin(), reque.getUsuario());
			if(valorres==1) {
				resp.setCode("0");
				resp.setMessage("Exito al guardar");
			}else {
				resp.setCode("-1");
				resp.setMessage("Error al guardar");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resp;
	}
	
	
	public Respuesta Login(LoginRequest login) {
	Respuesta resp=new Respuesta();
	tablaMarcaciones logi=new tablaMarcaciones();
	try {
		logi=guardadoMarcaciones.consultalogin(login.getUsuarios());
		if(logi.getUser().equalsIgnoreCase(login.getUsuarios())) {
			resp.setCode("0");
			resp.setMessage("exito");
		}else {
			resp.setCode("-1");
			resp.setMessage("error, el usuario no existe");
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
		return resp;
	}
	
}
