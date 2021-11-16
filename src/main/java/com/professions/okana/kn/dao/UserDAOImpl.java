package com.professions.okana.kn.dao;

import com.professions.okana.kn.dao.DAO;
import com.professions.okana.kn.dao.UserDAO;
import com.professions.okana.kn.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Repository
public class UserDAOImpl implements DAO<User>, UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findById(int id) {
        return sessionFactory.openSession().get(User.class, id);
    }

    @Override
    public User findBySurname(String surname) {
        return sessionFactory.openSession().get(User.class, surname);
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT a FROM User a", User.class).getResultList();
    }

    @Override
    public User create(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User users = session.get(User.class, id);
        session.delete(users);
        transaction.commit();
        session.close();
    }

    @Override
    public int avgUserAge() {
        Session session = sessionFactory.openSession();
        double avgAge = (double) session.createQuery("select avg (age) from User ").getSingleResult();
        return (int) avgAge;
    }

    @Override
    public User findByEmail(String email) {
        return (User) sessionFactory.openSession().createQuery("from User where email = :email").setParameter("email", email).getSingleResult();
    }


}
