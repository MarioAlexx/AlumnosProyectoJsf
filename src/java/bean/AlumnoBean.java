/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DaoAlumno;
import entity.Alumno;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author Mario Alejandro
 */
@ManagedBean
@ViewScoped
public class AlumnoBean {

    private List<Alumno> alumno;
    private Alumno alum;

    /**
     * Creates a new instance of AlumnoBean
     */
    public AlumnoBean() {
        alum = new Alumno();
    }

    @PostConstruct
    public void init() {
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction txt = session.beginTransaction();
        alumno = session.createQuery("from entity.Alumno").list();

        txt.commit();
    }

    public List<Alumno> getAlumno() {
        return alumno;
    }

    public void setAlumno(List<Alumno> alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlum() {
        return alum;
    }

    public void nuevo(ActionEvent actionEvent) {
        alum = new Alumno();
    }

    public void setAlum(Alumno alum) {
        this.alum = alum;
    }

    public void insertarAlumnoBean() {
        DaoAlumno dao = new DaoAlumno();
        dao.registrarAlumno(alum);
        alum = new Alumno();
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Bien!", "Registro exitoso"));
    }

    public void modificarAlumnoBean() {
        DaoAlumno dao = new DaoAlumno();
        dao.modificarAlumno(alum);
        alum = new Alumno();
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Bien!", "Datos actualizados"));

    }

    public void eliminarAlumnoBean() {
        DaoAlumno dao = new DaoAlumno();
        dao.eliminarAlumno(alum);
        alum = new Alumno();
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Bien!", "Eliminado exitosamente"));
    }

    public void cancelar() {
        alum = new Alumno();
    }
    
    public void validarNombre(){
        
    }

}
