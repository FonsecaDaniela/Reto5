/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.retociclo3.ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danie
 */

@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorAuditorio {
    @GetMapping("/holaMundo")
	    public String saludad(){
	    return "Hola Mundo";
	    }

	    @Autowired
	    private ServiciosAuditorio servicio;
	    @GetMapping("all")
	    public List <Auditorio> getAuditorio(){
	        return servicio.getAll();
	    }
	    
	    @GetMapping("/{id}")
	    public Optional<Auditorio> getAuditorio(@PathVariable("id") int idAuditorio) {
	        return servicio.getAuditorio(idAuditorio);
	    }
	
	    @PostMapping("/save")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Auditorio save(@RequestBody Auditorio auditorio) {
	        return servicio.save(auditorio);
	    }
	    @PutMapping("/update")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Auditorio update(@RequestBody Auditorio auditorio) {
	        return servicio.update(auditorio);
	    }
	
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public boolean delete(@PathVariable("id") int auditorioId) {
	        return servicio.deleteAuditorio(auditorioId);
	    }
}   
