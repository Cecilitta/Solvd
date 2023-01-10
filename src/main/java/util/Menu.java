package util;

import device.Device;
import device.TypeOfDevice;
import exception.InvalidContactException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import person.Client;
import person.Technician;
import service.Service;
import service.ServiceType;
import workorder.BusinessHour;
import workorder.Diagnosis;
import workorder.WorkOrder;

import java.util.Map;
import java.util.Scanner;

import static util.WorkOrderGenerator.*;

public final class Menu implements ISearch {

    private static final Logger LOGGER = LogManager.getLogger();
    boolean closeWhile = true;
    Scanner in = new Scanner(System.in);

    public Menu() {
    }

    public void printMenu() {
        while (closeWhile) {
            LOGGER.info("Enter an option:\n" +
                    "        1. New Work Order \n" +
                    "        2. Search Client, Device or Work Order \n" +
                    "        3. Pay Service \n" +
                    "        4. Filter Work Order (state/ paid/ delivered) \n" +
                    "        5. Change Work Order state to done \n" +
                    "        6. Change Work Order to delivered" +
                    "        7. Delete Work order\n" +
                    "        8. Quit \n" +
                    "\n");

            String option = in.nextLine();
            switch (option) {

                case "1"  -> {
                    Client newClient = addClient();
                    Device newDevice = createDevice();
                    Diagnosis newDiagnosis = toDiagnosis();
                    Service newService = createService();
                    ServiceType techSpec = newService.getType();
                    LOGGER.info("Technical Specialist needed (True/False): ");
                    boolean specialist = Boolean.parseBoolean(in.nextLine());
                    Technician newTechnician = selectTechnician(techSpec, specialist);
                    BusinessHour dueDate = dueTo();
                    WorkOrder newWorkOrder = new WorkOrder(newClient, newDiagnosis, newTechnician, newService,
                            newDevice, false, false, false, dueDate);
                    float totalPrice = newWorkOrder.calculateFinalPrice();
                    LOGGER.info(newWorkOrder + "The total price is: $" + totalPrice);
                }

                case "2" -> search();

                case "3" -> filterWorkOrder();

                case "4" -> {
                    LOGGER.info("Enter the Work Order Id to pay: ");
                    Integer id = Integer.parseInt(in.nextLine());
                    workOrderMap.get(id).pay(id);
                }

                case "5" -> {
                    LOGGER.info("Enter the Work Order Id to change status: ");
                    Integer id = Integer.parseInt(in.nextLine());
                    workOrderMap.get(id).fix(id);
                }

                case "6" -> {
                    LOGGER.info("Enter the Work Order Id delivered: ");
                    Integer id = Integer.parseInt(in.nextLine());
                    workOrderMap.get(id).setDelivered(true);
                }

                case "7" -> {
                    LOGGER.info("Enter the Work Order Id to delete: ");
                    Integer id = Integer.parseInt(in.nextLine());
                    workOrderMap.remove(id);
                    LOGGER.info("The Work Order # " + id + "is deleted");
                }

                case "8" -> {
                    closeWhile = false;
                    LOGGER.info("Quiting program.");
                }

                default -> LOGGER.info("no valid option");
            }
        }
    }

    public Service createService() {
        LOGGER.info("Type of service (Software/Hardware): ");
        String serviceStr = in.nextLine().toUpperCase();
        ServiceType service = ServiceType.valueOf(serviceStr);
        LOGGER.info("Service price: $");
        float servicePrice = in.nextFloat();
        Service newSer = new Service(service, servicePrice);
        return newSer;
    }

    public Client addClient() {
        LOGGER.info("Is a new client? (Y/N): ");
        String answer = in.nextLine().toUpperCase();
        Client newClient = Client.compareClient(answer);
        return newClient;
    }

    public BusinessHour dueTo() {
        LOGGER.info("Due to (Monday/Tuesday/Wednesday/Thursday/Friday/Saturday: ");
        String dueStr = in.nextLine().toUpperCase();
        BusinessHour dueDate = BusinessHour.valueOf(dueStr);
        return dueDate;
    }

    public Diagnosis toDiagnosis() {
        LOGGER.info("Diagnosis: ");
        String diangosis = in.nextLine();
        Diagnosis newDiagnosis = new Diagnosis(diangosis);
        return newDiagnosis;
    }

    public Technician selectTechnician(ServiceType specialty, boolean specialist) {
        for (Map.Entry<Integer, Technician> entry : technicianMap.entrySet()) {
            Technician t = entry.getValue();
            if (t.isSpecialist() == specialist && t.getTechnicalSpecialty() == specialty) {
                return t;
            } else {
                Technician newTech = new Technician("jose@gmail.com", "José", specialty, specialist);
                return newTech;
            }
        }
        return null;
    }

    public Device createDevice() {
        LOGGER.info("Device Info: \n Model: ");
        String model = in.nextLine();
        LOGGER.info("Serial Number: #");
        int serialNumber = Integer.parseInt(in.nextLine());
        LOGGER.info("Type of Device (Desktop/Notebook/Tablet/Mobile): ");
        String typeStr = in.nextLine().toUpperCase();
        TypeOfDevice type = TypeOfDevice.valueOf(typeStr);
        Device newDevice = new Device(model, serialNumber, type);
        WorkOrderGenerator.addNewDevice(newDevice);
        LOGGER.info(newDevice);
        return newDevice;
    }

    @Override
    public void search() {
        LOGGER.info("Enter what do you want to search (Client/Device/WorkOrder) ");
        String option = in.nextLine().toLowerCase();
        switch (option) {
            case ("client") -> {
                LOGGER.info("Enter the Client Id: ");
                Integer id = Integer.parseInt(in.nextLine());
                LOGGER.info(clientMap.get(id).toString());
            }
            case ("device") -> {
                LOGGER.info("Enter the Serial Number of the Device: ");
                Integer id = Integer.parseInt(in.nextLine());
                LOGGER.info(deviceMap.get(id).toString());
            }
            case ("workorder") -> {
                LOGGER.info("Enter the Work Order Id: ");
                Integer id = Integer.parseInt(in.nextLine());
                LOGGER.info(workOrderMap.get(id).toString());
            }
        }

    }
    public void filterWorkOrder() {
        LOGGER.info("\n  Enter the attribute to filter (state/ paid/ delivered): ");
        String option = in.nextLine().toLowerCase();
        LOGGER.info("\n  Enter the  value of the attribute:  ");
        boolean attribute = Boolean.parseBoolean(in.nextLine());

        switch (option) {
            case ("state") -> {
                LOGGER.info("\n WorK Order Delivered Status (" + attribute + "):\n");
                workOrderMap.entrySet().stream().filter((e) -> e.getValue().isDelivered() == attribute)
                        .forEach(e -> LOGGER.info(e.getValue()));
            }
            case ("paid") -> {
                LOGGER.info("\n WorK Order paid Status (" + attribute + "): \n");
                workOrderMap.entrySet().stream().filter((e) -> e.getValue().isPaid() == attribute)
                        .forEach(e -> LOGGER.info(e.getValue()));
            }
            case ("delivered") -> {
                LOGGER.info("\n  WorK Order Status (" + attribute + "): \n");
                workOrderMap.entrySet().stream().filter((e) -> e.getValue().isWorkOrderState() == attribute)
                        .forEach(e -> LOGGER.info(e.getValue()));
            }
        }

    }
}





