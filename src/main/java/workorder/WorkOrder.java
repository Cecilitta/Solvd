package workorder;

import device.Device;
import exception.InvalidContactException;
import exception.InvalidPayingMethodException;
import person.Client;
import person.Technician;
import service.Service;

import java.util.Objects;
import java.util.Scanner;

import static util.WorkOrderGenerator.workOrderMap;

public class WorkOrder implements ICalculateFinalPrice, IPay, IFix {
    private static int workOrderIdCounter;
    private final int WORK_ORDER_ID;
    private final Client client;
    private final Diagnosis diagnosis;
    Scanner in = new Scanner(System.in);
    private Technician technician;
    private Service service;
    private Device device;
    private boolean workOrderState;
    private boolean paid;
    private boolean delivered;
    private BusinessHour deliveryDate;

    //---------Constructor------------

    public WorkOrder(Client client, Diagnosis diagnosis, Technician technician, Service service, Device device, boolean workOrderState,
                     boolean paid, boolean delivered, BusinessHour deliveryDate) {

        this.WORK_ORDER_ID = 1 + workOrderIdCounter++;
        this.client = client;
        this.diagnosis = diagnosis;
        this.technician = technician;
        this.service = service;
        this.device = device;
        this.workOrderState = workOrderState;
        this.paid = paid;
        this.deliveryDate = deliveryDate;
        this.delivered = delivered;
    }
    //--------Getters and setters---------

    public int getWORK_ORDER_ID() {
        return WORK_ORDER_ID;
    }

    public Client getClient() {
        return client;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public boolean isWorkOrderState() {
        return workOrderState;
    }

    public void setWorkOrderState(boolean workOrderState) {
        this.workOrderState = workOrderState;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        if (paid) {
            System.out.println(" The service is paid");
        }
        this.paid = paid;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public void stateWorkOrder(boolean state) {
        if (state) {
            System.out.println("Your computer is ready");
        } else {
            System.out.println("Your computer is still in repair");
        }
    }

    public BusinessHour getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(BusinessHour deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    //--------Methods-----------------


    public void compareWorkOrder(WorkOrder a) {
        if (this.equals(a)) {
            System.out.println("The WorkOrders are equals");
        } else {
            System.out.println("The WorkOrders are different");
        }
        if (this.hashCode() == a.hashCode()) {
            System.out.println(" The WorkOrders have the same hashcode");
        } else {
            System.out.println("The WorkOrders have different hashcode");
        }
    }

    //----Override Methods------------------


    @Override
    public String toString() {
        return
                "\n WorkOrder Id: " + WORK_ORDER_ID +
                        ",\n Client: " + client +
                        ",\n Diagnosis: " + diagnosis +
                        ",\n Technician: " + technician +
                        ",\n Service detail: " + service +
                        ",\n Device: " + device +
                        ",\n Work Order State: " + workOrderState +
                        ",\n Paid: " + paid +
                        ",\n Delivered: " + delivered +
                        ",\n Due To: " + deliveryDate +
                        "." +
                        "\n    ------------------     ";
    }

    @Override
    public float calculateFinalPrice() {
        float total = service.getPrice() + diagnosis.getDIAGNOSIS_PRICE();
        if (client.isVip() && technician.isSpecialist()) {
            float total1 = (float) (total * 1.1);
            System.out.println("The final price is: $" + total1);
            return total1;
        } else if (technician.isSpecialist()) {
            float total2 = (float) (total * 1.2);
            System.out.println("The final price is: $" + total2);
            return total2;
        } else if (client.isVip()) {
            float total3 = (float) (total - (total * 0.1));
            System.out.println("The final price is: $" + total3);
            return total3;
        } else {
            System.out.println("The final price is: $" + total);
            return total;
        }

    }

    @Override
    public void pay(Integer id) throws InvalidPayingMethodException {
        System.out.println("Enter the paying method (CREDIT_CARD/DEBIT_CARD/PAYPAL): ");
        PayingMethod payingMethod;
        try {
            String payMet = in.nextLine().toUpperCase();
            payingMethod = PayingMethod.valueOf(payMet);
        } catch (Exception e){
            throw new InvalidPayingMethodException(" Must provide a valid paying method");
        }
        workOrderMap.get(id).calculateFinalPrice();
        workOrderMap.get(id).setPaid(true);
        System.out.println("The Work Order # " + id + "payment method is: " + payingMethod);
    }

    @Override
    public void fix(Integer id) {
        workOrderMap.get(id).setWorkOrderState(true);
        System.out.println(workOrderMap.get(id));
        System.out.println("The Work Order # " + id + "state is: done");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkOrder workOrder)) return false;
        return getWORK_ORDER_ID() == workOrder.getWORK_ORDER_ID() && isWorkOrderState() == workOrder.isWorkOrderState()
                && isPaid() == workOrder.isPaid() && isDelivered() == workOrder.isDelivered() &&
                getClient().equals(workOrder.getClient()) && getDiagnosis().equals(workOrder.getDiagnosis()) &&
                getTechnician().equals(workOrder.getTechnician()) && getService().equals(workOrder.getService()) &&
                getDevice().equals(workOrder.getDevice()) && getDeliveryDate() == workOrder.getDeliveryDate();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWORK_ORDER_ID(), getClient(), getDiagnosis(), getTechnician(), getService(), getDevice(),
                isWorkOrderState(), isPaid(), isDelivered(), getDeliveryDate());
    }
}
