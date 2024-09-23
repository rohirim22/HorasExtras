package com.project.HorasExtrasProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.HorasExtrasProject.Entity.LoginRequest;
import com.project.HorasExtrasProject.Entity.RegisterRequest;
import com.project.HorasExtrasProject.Entity.RequestMarcaciones;
import com.project.HorasExtrasProject.Entity.Respuesta;
import com.project.HorasExtrasProject.Services.ProcMarcaciones;


@RestController
@RequestMapping("SistemaHorasExtras")
@CrossOrigin(origins = "http://localhost:8100")
public class PrincipalControl {
	@Autowired
	ProcMarcaciones marcas;
	 
	
	
	@PostMapping(path = "/Marcar")
	public Respuesta Inicio(@RequestBody RequestMarcaciones request ) {
		Respuesta resp=new Respuesta();
		try {
			 resp=marcas.IngresarHora(request);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return resp;
	} 
	
	@PostMapping(path="/Cerrar")
	public Respuesta finSecion(@RequestBody RequestMarcaciones request) {
			Respuesta resp = new Respuesta();
		try {
			resp= marcas.Finalizarjornada(request);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resp;
	}
	
    @PostMapping(path="/Resgistro")
    public void RegistroUsuarios(@RequestBody RegisterRequest register) {
    	try {
			System.out.println("Inicio de proceso de registro de usuarios");
		    
    	} catch (Exception e) {
			// TODO: handle exception
		}
    }
	
	@PostMapping(path="/Login")
	public Respuesta InicioSesion(@RequestBody LoginRequest login) {
		Respuesta resp=new Respuesta();
		try {
			resp=marcas.Login(login);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return resp;
	}
	
}
