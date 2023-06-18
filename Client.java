package com.underskywoker.spring.mvc.bank_system.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;


    @Column(name = "bank_account")

    @Min(value = -1)
    private int bankAccount;

    public Client() {
    }

    public Client(String name, String surname, int bankAccount) {
        this.name = name;
        this.surname = surname;
        this.bankAccount = bankAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
