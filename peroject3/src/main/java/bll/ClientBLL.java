package bll;

import abstractDAO.ClientDAO;
import bll.validator.EmailValidator;
import bll.validator.Validator;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Petrica scrie clase ca si in model
 * Si nici el nu stie ce face
 */
public class ClientBLL {

    private List<Validator<Client>> validators;
    private final ClientDAO clientDAO;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        clientDAO = new ClientDAO();
    }

    public Client findClientById(int id) {
        Client st = clientDAO.findById(id);
        if (st == null) {
            System.out.println("The client with id =" + id + " was not found!");
        }
        return st;
    }

    public boolean insert(Client client){
        boolean client1=clientDAO.insert(client);
        if(!client1){
            System.out.println("The client=" + client + " was not added in db");
            return  false;
        }
        return true;
    }
    public boolean delete(Client client) {
        boolean client1=clientDAO.delete(client);
        if(!client1){
            System.out.println("The client=" + client.toString() + " was not deleted in db");
            return  false;
        }
        return true;
    }

    public boolean updateClient(Client client) {
        boolean client1=clientDAO.update(client);
        if(!client1){
            System.out.println("The client=" + client.toString() + " was not updated in db");
            return  false;
        }
        return true;
    }

    public ArrayList<Client> getAllClients() {
        return clientDAO.findAll();
    }

}

