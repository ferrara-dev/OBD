package service.saleservice;

import model.salemodel.Payment;
import model.physicalobjects.Register;
import util.InsufficientPaymentException;

public class PaymentService {
    SaleService saleService;

    public PaymentService(SaleService saleService) {
        this.saleService = saleService;
    }



    public double processPayment(Register register,Payment payment) {
        register.enterPayment(payment);
        double change = saleService.getSale().getCost().getTotalCost() - payment.getAmountPayed();
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
