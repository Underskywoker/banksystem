package com.underskywoker.spring.mvc.bank_system.service;

import com.underskywoker.spring.mvc.bank_system.entity.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClients();

    public void saveClient(Client client);

    public Client getClient(int id);

    public void deleteClient(int id);

    public void accountReplenishment(int id, int money);

    public void withdraw(int id, int money);
}
