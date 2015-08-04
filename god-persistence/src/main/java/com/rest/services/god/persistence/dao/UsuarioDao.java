/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.Usuario;
import java.util.List;

/**
 *
 * @author User
 */
public interface UsuarioDao extends Dao<Object, Object>{
    List<Usuario> getUser();
    Usuario validaUsuario(String email, String password);
    void actualizarConexionUsuario(Usuario usuario);
}
