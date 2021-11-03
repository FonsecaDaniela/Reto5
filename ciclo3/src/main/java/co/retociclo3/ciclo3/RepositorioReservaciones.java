/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.retociclo3.ciclo3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class RepositorioReservaciones {
    @Autowired
    private InterfaceReservaciones crud4;
	    
    public List<Reservaciones> getAll(){
    return (List<Reservaciones>) crud4.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
    return crud4.findById(id);
    }
    public Reservaciones save(Reservaciones reservaciones){
    return crud4.save(reservaciones);
	    }
    public void delete(Reservaciones reservaciones){
    crud4.delete(reservaciones);
    }
    
    public List<Reservaciones> ReservacionStatusRepositorio (String status){
	     return crud4.findAllByStatus(status);
	     }
	     
	public List<Reservaciones> ReservacionTiempoRepositorio (Date a, Date b){
	    return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
	     
	     }
	     
	public List<ContadorClientes> getClientesRepositorio(){
	    List<ContadorClientes> res = new ArrayList<>();
	    List<Object[]> report = crud4.countTotalReservationsByCliente();
	    for(int i=0; i<report.size(); i++){
                res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
	    }
	    return res;
	    }
}
