package com.project.HorasExtrasProject.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.HorasExtrasProject.Entity.tablaMarcaciones;



public interface GuardadoHoras extends JpaRepository<tablaMarcaciones, String>{

	@Modifying(clearAutomatically = true)
	@Query("update tablaMarcaciones v set v.fechainicio=?1, v.estado='A' where v.user=?2")
	public int guardado(Date fechainicio, String usuario);
	
	
	@Modifying(clearAutomatically = true)
    @Query("update tablaMarcaciones v set v.fechafin=?1, v.estado='I' where v.user=?2")
    public int guardadoFin(Date fechafin, String usuario);

    @Query("select a from tablaMarcaciones a where a.user= ?1")
    public tablaMarcaciones consultalogin(String usuarios);
}
