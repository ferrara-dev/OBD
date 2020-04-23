package model.customer;

import integration.customerdb.MemberService;
import util.Member;

public class CustomerService {
    MemberService db= new MemberService();

    /***********  Call to dbhandler **************
     * Calls dbhandler to register a new member
     * returns true if registration is successful
     *********************************************/
    public String registerMember(Member member){
        final String registrationSuccessful = member.getName() + " was registered successfully!";
        boolean success = db.registerMember(member);
        if(success)
            return registrationSuccessful;
        return " Registration unsuccessfull";
    }

    public String findCustomer(int customerId){
        return null;
    }
}
