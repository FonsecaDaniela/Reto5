/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.retociclo3.ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniela fonseca
 */
@Service
public class ServiciosAuditorio {
    @Autowired
	    private RepositorioAuditorio metodosCrud;
	    
	    public List<Auditorio> getAll(){
	        return metodosCrud.getAll();
	    }
	    
	    public Optional<Auditorio> getAuditorio(int idAuditorio){
	        return metodosCrud.getAuditorio(idAuditorio);
	    }
	    
	    public Auditorio save(Auditorio auditorio){
	        if(auditorio.getId()==null){
	            return metodosCrud.save(auditorio);
	        }else{
	            Optional<Auditorio> evt=metodosCrud.getAuditorio(auditorio.getId());
	            if(evt.isEmpty()){
	                return metodosCrud.save(auditorio);
	            }else{
	                return auditorio;
	            }
	        }
	    }
            public Auditorio update(Auditorio auditorio){
	        if(auditorio.getId()!=null){
	            Optional<Auditorio> e=metodosCrud.getAuditorio(auditorio.getId());
	            if(!e.isEmpty()){
	                if(auditorio.getName()!=null){
	                    e.get().setName(auditorio.getName());
	                }
	                if(auditorio.getOwner()!=null){
	                    e.get().setOwner(auditorio.getOwner());
	                }
	                if(auditorio.getCapacity()!=null){
	                    e.get().setCapacity(auditorio.getCapacity());
	                }
	                if(auditorio.getDescription()!=null){
	                    e.get().setDescription(auditorio.getDescription());
	                }
	                if(auditorio.getCategory()!=null){
	                    e.get().setCategory(auditorio.getCategory());
	                }
	                metodosCrud.save(e.get());
	                return e.get();
	            }else{
	                return auditorio;
	            }
	        }else{
	            return auditorio;
	        }
	    }
	public boolean deleteAuditorio(int auditorioId) {
	        Boolean aBoolean = getAuditorio(auditorioId).map(auditorio -> {
	            metodosCrud.delete(auditorio);
	            return true;
	        }).orElse(false);
	        return aBoolean;
	    }

}

