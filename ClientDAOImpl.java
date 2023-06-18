package com.underskywoker.spring.mvc.bank_system.dao;

import com.underskywoker.spring.mvc.bank_system.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Client> getAllClients() {
        Session session = sessionFactory.getCurrentSession();
        Query<Client> query = session.createQuery("from Client", Client.class);
        List<Client> allClients = query.getResultList();
        return allClients;
    }

    @Override
    public void saveClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(client);
    }

    @Override
    public Client getClient(int id) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Client.class, id);
    }

    @Override
    public void deleteClient(int id) {

        Session session = sessionFactory.getCurrentSession();
        Query<Client> query = session.createQuery("delete from Client " +
                "where id = :clientId");

        query.setParameter("clientId", id);
        query.executeUpdate();
    }

    @Override
    public void accountReplenishment(int id, int money) {
        Session session = sessionFactory.getCurrentSession();
        Query<Client> query = session.createQuery("update Client " +
                "set bankAccount = bankAccount +:money " +
                "where id = :clientId");
        query.setParameter("money", money);
        query.setParameter("clientId", id);
        query.executeUpdate();
    }

    @Override
    public void withdraw(int id, int money) {

        Client client = getClient(id);
        if (client.getBankAccount()>=money) {
            Session session = sessionFactory.getCurrentSession();
            Query<Client> query = session.createQuery("update Client " +
                    "set bankAccount = bankAccount -:money " +
                    "where id = :clientId");
            query.setParameter("money", money);
            query.setParameter("clientId", id);

            query.executeUpdate();
        }
    }
}
