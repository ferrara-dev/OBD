package service.saleservice;

import model.salemodel.Payment;
import model.physicalobjects.Register;
import util.InsufficientPaymentException;

public class PaymentService {
    SaleService saleService;
    Payment payment;

    public PaymentService(SaleService saleService) {
        this.saleService = saleService;
    }

    public void setPayment(double amount) {
        payment = new Payment(saleService.getSale().getRunningTotal(), amount);
    }

    public double processPayment(Register register) {
        register.enterPayment(payment);
        double change = payment.getPriceToPay() - payment.getAmountPayed();
        saleService.getSale().setRunningTotal(change);
        if (change > 0)
            throw new InsufficientPaymentException();

        change = change * -1;
        register.setBalance(register.getBalance() + change);
        saleService.getSale().setCashBack(change);
        saleService.getSale().setRunningTotal(0);
        return change;
    }

}
