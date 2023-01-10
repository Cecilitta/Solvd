package person;

import exception.InvalidContactException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.WorkOrderGenerator;

import java.util.Objects;
import java.util.Scanner;

import static util.WorkOrderGenerator.clientMap;

public final class Client extends Person {

    private static final Logger LOGGER = LogManager.getLogger();
    static Scanner in = new Scanner(System.in);
    private static int clientCounter;
    private final int CLIENT_ID;
    private final boolean vip;


    // -----Constructors-----

    public Client(String contact, String name, boolean vip)  {
        super(contact, name);
        clientCounter++;
        this.vip = vip;
        this.CLIENT_ID = clientCounter;
    }

    public static Client compareClient(String cl) {
        if (cl.equals("Y")) {
            LOGGER.info("Client Info: \n Contact: ");
            String contact = in.nextLine();
            LOGGER.info(" Name: ");
            String name = in.nextLine();
            LOGGER.info("Is vip? (True/False): ");
            boolean vip = Boolean.parseBoolean(in.nextLine());
            Client newClient = new Client(contact, name, vip);
            WorkOrderGenerator.addNewClient(newClient);
            LOGGER.info(newClient);
            return newClient;
        } else {
            LOGGER.info("Enter Client ID: ");
            int clientId = in.nextInt();
            return clientMap.get(clientId);
        }
    }

    // -----Getters and setters--------
    public int getCLIENT_ID() {
        return CLIENT_ID;
    }

    // -----Methods-------

    public boolean isVip() {
        return vip;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Client Id: " + CLIENT_ID +
                ", is vip: " + vip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        if (!super.equals(o)) return false;
        return getCLIENT_ID() == client.getCLIENT_ID() && isVip() == client.isVip();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCLIENT_ID(), isVip());
    }
}
