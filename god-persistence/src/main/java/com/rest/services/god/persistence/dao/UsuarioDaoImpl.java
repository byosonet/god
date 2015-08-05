package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.cp.HibernateUtil;
import com.rest.services.god.persistence.hbm.Usuario;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author User
 */
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao{
    private final Logger log = Logger.getLogger(UsuarioDaoImpl.class);

    public List<Usuario> getUser() {
       this.log.info(" -- Buscando por lista de usuarios::");
        return (List<Usuario>) this
                .getSession()
                .createQuery("FROM Usuario u " + "ORDER BY u.idUsuario ASC").list();
    }

    public Object findByKey(Object llave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object saveByEntityReturnID(Object entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object saveByEntity(Object entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Object> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateByEntity(Object entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteByKey(Object llave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteByEntity(Object entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Session sesion;
    private Transaction tx;
    
    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public Usuario validaUsuario(String email, String password) {
        this.log.info(" -- Buscando usuario by email:: "+email);
        return (Usuario) this
                .getSession()
                .createQuery("FROM Usuario u WHERE u.email = :email AND u.password = :password")
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResult();
    }

    public void actualizarConexionUsuario(Usuario usuario) {
         try {
            iniciaOperacion();
            if(usuario!=null){
                Timestamp stamp = new Timestamp(System.currentTimeMillis());
                this.log.info("-- Datetime::: "+stamp);
                Date date = new Date(stamp.getTime());
                this.log.info("-- Date::: "+date);
                usuario.setUltConexion(date);
                this.sesion.saveOrUpdate(usuario);
                this.sesion.flush();
                 tx.commit();
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public int agregarUsuario(Usuario usuario) {
        try {
            iniciaOperacion();
            Number maximo = (Number) this.getSession().createQuery(
                    "SELECT COUNT(*) "
                    + "FROM Usuario")
                    .uniqueResult();

            long id = maximo == null ? 1 : maximo.longValue() + 1;
            usuario.setIdUsuario(Integer.parseInt(String.valueOf(id)));
            this.sesion.save(usuario);
            this.sesion.flush();

            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return usuario.getIdUsuario();
    }
    
}
