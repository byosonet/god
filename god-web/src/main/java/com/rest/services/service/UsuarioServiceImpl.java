/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.service;

import com.rest.services.god.persistence.dao.UsuarioDao;
import com.rest.services.god.persistence.hbm.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Component("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
private final Logger log = Logger.getLogger(UsuarioServiceImpl.class);

    @Transactional
    public List<Usuario> getListaUsuarios() {
        this.log.info(" -- Obteniendo lista de usuarios::::");
        List<Usuario> lista = this.usuarioDao.getUser();
        if(!lista.isEmpty()){
            for(Usuario u: lista){
                 this.log.info(" idUsuario: "+u.getIdUsuario()+" Nombre: "+u.getNombre());
            } 
        }
        return lista;
    }
    
    
@Autowired
private UsuarioDao usuarioDao;

    @Transactional
    public Usuario validaUsuario(String email, String password) {
        this.log.info(" -- Validando Usuario by: "+email);
        Usuario usuario = this.usuarioDao.validaUsuario(email, password);
        if(usuario!=null){
            this.log.info(" -- Usuario encontrado llamado: "+usuario.getNombre());
        }else{
            this.log.info(" -- Usuario no fue localizado by: "+email);
        }
        return usuario;
    }
    
}
