import device.Device;
import device.TypeOfDevice;
import exception.InvalidContactException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import person.Client;
import person.Technician;
import service.Service;
import service.ServiceType;
import util.Menu;
import util.WorkOrderGenerator;
import workorder.BusinessHour;
import workorder.Diagnosis;
import workorder.WorkOrder;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputerServiceMain {

    public static void main(String[] args) throws InvalidContactException {
        Logger LOGGER = LogManager.getLogger();
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();

        WorkOrderGenerator workOrdGen = new WorkOrderGenerator();
        ArrayList<Device> devicesList = workOrdGen.generateDevice();
        ArrayList<Client> clientsList = workOrdGen.generateClient();
        ArrayList<Technician> techniciansList = workOrdGen.generateTechnician();
        ArrayList<Service> servicesList = workOrdGen.generateService();
        ArrayList<WorkOrder> workOrdersList = workOrdGen.generateWorkOrder(devicesList, clientsList, techniciansList,
                servicesList);

        LOGGER.info(workOrdersList.toString());

        workOrdGen.generateWorkOrderMap(workOrdersList);
        workOrdGen.generateClientMap(clientsList);
        workOrdGen.generateTechinicianMap(techniciansList);
        workOrdGen.generateDeviceMap(devicesList);


        System.out.println("---------------------------------------------");

        Client client1 = new Client("4446093", "José Gonzalez", true);
        Technician technician1 = new Technician("tech1@gmail.com", "María Lopez", ServiceType.SOFTWARE,
                true);

        Device device1 = new Device("Motorola G7", 8291, TypeOfDevice.MOBILE);

        Diagnosis diagnosis1 = new Diagnosis("Need to reset from factory");
        Service service1 = new Service(ServiceType.SOFTWARE, 200F);
        WorkOrder workOrder1 = new WorkOrder(client1, diagnosis1, technician1, service1, device1, false,
                false, false, BusinessHour.THURSDAY);
        workOrder1.calculateFinalPrice();

        menu.printMenu();

        in.close();
        System.out.println("---------------------------------------------");


    }
}

