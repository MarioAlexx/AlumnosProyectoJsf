/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Alumno;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author Mario Alejandro
 */
public class DaoAlumno {

    public void registrarAlumno(Alumno a) {
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(a);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }

    public void eliminarAlumno(Alumno a) {
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.delete(a);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }

    public void modificarAlumno(Alumno a) {
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.update(a);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }

}
