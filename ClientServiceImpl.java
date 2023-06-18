package com.underskywoker.spring.mvc.bank_system.service;

import com.underskywoker.spring.mvc.bank_system.dao.ClientDAO;
import com.underskywoker.spring.mvc.bank_system.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;


    @Override
    @Transactional
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        clientDAO.saveClient(client);
    }

    @Override
    @Transactional
    public Client getClient(int id) {
        return clientDAO.getClient(id);
    }

    @Override
    @Transactional
    public void deleteClient(int id) {
        clientDAO.deleteClient(id);
    }

    @Override
    @Transactional
    public void accountReplenishment(int id, int money) {
        clientDAO.accountReplenishment(id,money);
    }

    @Override
    @Transactional
    public void withdraw(int id, int money) {
        clientDAO.withdraw(id,money);
    }
}
