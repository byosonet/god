/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.service;

import com.rest.services.model.Empleado;
import java.util.List;

/**
 *
 * @author User
 */
public interface ListaEmpleadosService {
    List<Empleado> getEmpleados ();
    Empleado getEmpleadoById(String id);
}
