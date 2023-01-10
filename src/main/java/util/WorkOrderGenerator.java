package util;

import device.Device;
import device.TypeOfDevice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import person.Client;
import person.Technician;
import service.Service;
import service.ServiceType;
import workorder.BusinessHour;
import workorder.Diagnosis;
import workorder.WorkOrder;

import java.util.*;

public class WorkOrderGenerator {

    private static final Logger LOGGER = (Logger) LogManager.getLogger();
    public static Map<Integer, Client> clientMap = new HashMap<>();
    public static Map<Integer, Technician> technicianMap = new HashMap<Integer, Technician>();
    public static Map<Integer, WorkOrder> workOrderMap = new LinkedHashMap<>();
    static Map<Integer, Device> deviceMap = new HashMap<>();
    Scanner in = new Scanner(System.in);
    ArrayList<Device> deviceList = new ArrayList<>();
    ArrayList<Client> clientList = new ArrayList<>();
    ArrayList<Technician> technicianList = new ArrayList<>();
    ArrayList<Service> serviceList = new ArrayList<>();
    ArrayList<WorkOrder> workOrderList = new ArrayList<>();

    public static void addNewClient(Client newClient) {
        clientMap.put(newClient.getCLIENT_ID(), newClient);
    }

    public static void addNewDevice(Device newDevice) {
        deviceMap.put(newDevice.getSerialNumber(), newDevice);
    }

    public ArrayList<Device> generateDevice() {
        for (int i = 0; i < 10; i++) {
            deviceList.add(new Device("Model # " + (i + 1), ((i + 1) + 999), TypeOfDevice.getRandom()));
        }
        return deviceList;
    }

    public ArrayList<Client> generateClient() {
        Random vip = new Random();
        for (int i = 0; i < 10; i++) {
            clientList.add(new Client("" + ((i + 1) * 123456), "J.Doe #" + (i + 1), vip.nextBoolean()));
        }
        return clientList;
    }

    public ArrayList<Technician> generateTechnician() {
        Random specialist = new Random();
        for (int i = 0; i < 10; i++) {
            technicianList.add(new Technician(" " + ((i + 1) * 123456), "N.N #" + (i + 1),
                    ServiceType.getRandom(), specialist.nextBoolean()));
        }
        return technicianList;
    }

    public ArrayList<Service> generateService() {
        Random price = new Random();
        for (int i = 0; i < 10; i++) {
            serviceList.add(new Service(ServiceType.getRandom(), Math.round(price.nextFloat() * 1000)));
        }
        return serviceList;
    }

    public ArrayList<WorkOrder> generateWorkOrder(ArrayList<Device> device, ArrayList<Client> client,
                                                  ArrayList<Technician> technician, ArrayList<Service> service) {
        Random paid = new Random();
        Random delivered = new Random();
        Random workOrderState = new Random();
        Random rdm = new Random();
        for (int i = 0; i < 10; i++) {
            workOrderList.add(new WorkOrder(client.get(rdm.nextInt(client.size())),
                    new Diagnosis("xxxxxxxxxxxx"),
                    technician.get(rdm.nextInt(technician.size())), service.get(rdm.nextInt(service.size())),
                    device.get(rdm.nextInt(device.size())), paid.nextBoolean(), delivered.nextBoolean(),
                    workOrderState.nextBoolean(), BusinessHour.getRandom()));

        }
        return workOrderList;
    }

    public Map<Integer, WorkOrder> generateWorkOrderMap(ArrayList<WorkOrder> arrayList) {
        for (WorkOrder workOr : arrayList) {
            workOrderMap.put(workOr.getWORK_ORDER_ID(), workOr);
        }
        LOGGER.info(workOrderMap);
        return workOrderMap;
    }

    public Map<Integer, Technician> generateTechinicianMap(ArrayList<Technician> arrayList) {
        for (Technician technician : arrayList) {
            technicianMap.put(technician.getTECHNICIAN_ID(), technician);
        }
        LOGGER.info(technicianMap);
        return technicianMap;
    }

    public Map<Integer, Client> generateClientMap(ArrayList<Client> arrayList) {
        for (Client client : arrayList) {
            clientMap.put(client.getCLIENT_ID(), client);
        }
        LOGGER.info(clientMap);
        return clientMap;
    }

    public Map<Integer, Device> generateDeviceMap(ArrayList<Device> arrayList) {
        for (Device device : arrayList) {
            deviceMap.put(device.getSerialNumber(), device);
        }
        LOGGER.info(deviceMap);
        return deviceMap;
    }


}



