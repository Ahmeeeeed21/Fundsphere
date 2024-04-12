package tn.esprit.fundsphere.Services.CreditService;

import lombok.AllArgsConstructor;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.fundsphere.Config.EmailService;
import tn.esprit.fundsphere.Config.Mail;
import tn.esprit.fundsphere.Entities.AccountManagment.Account;
import tn.esprit.fundsphere.Entities.CrediMangment.Credit;
import tn.esprit.fundsphere.Entities.CrediMangment.Tranche;
import tn.esprit.fundsphere.Repositories.AccountRepository.AccountRepository;
import tn.esprit.fundsphere.Repositories.CreditRepository.CreditRepository;
import tn.esprit.fundsphere.Repositories.CreditRepository.TrancheRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CreditServiceImpl implements ICreditService{

    @Autowired



    private CreditRepository creditRepository;
    private TrancheRepository trancheRepository;
    private final EmailService emailService;
    private final SMSService smsService;
    private AccountRepository accountRepository ;

    @Override
    public Credit addCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public void deleteCredit(Long idCredit) {
         creditRepository.deleteById(idCredit);

    }

    @Override
    public String verifCondition(Credit credit,int idCredit) {
        idCredit=credit.getIdCredit();
        credit=creditRepository.getById((long) idCredit);
        float recoveryTemp;
        recoveryTemp = (float) ((credit.getCreditAmount() * credit.getInterestRate()) / (1 - (Math.pow((1 + credit.getInterestRate()), (-credit.getRecoverySince()))))) / 12;;
        float Salary = credit.getSalary();
        if (recoveryTemp <= Salary * 0.4)
        {
            credit.setAmountRecoveryMonth(recoveryTemp);
            creditRepository.save(credit);
            return ("Recovery amout per month = " +recoveryTemp+" : Condition verified for "+credit.getSurnameClient()+" "+credit.getNameClient());
        }else

            return ("Recovery amout per month = " +recoveryTemp+" : Inverified condition for "+credit.getSurnameClient()+" "+credit.getNameClient());
    }
    @Override
    public Credit updateStateCredit(Credit credit) {
        if (credit.getState() == 1)
        {
            
            long period = (credit.getRecoverySince()*12);
            float amoutPerMonth = credit.getAmountRecoveryMonth();

            System.out.println(period);
            System.out.println(amoutPerMonth);
            
            for (int i=0 ; i<period ; i++)
            {
                Tranche tranche = new Tranche();

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.MONTH, i+1); // Move to the next month
                calendar.set(Calendar.DAY_OF_MONTH, 1); // Set to the first day of the month

                tranche.setDateLimit(calendar.getTime());
                tranche.setCredit(credit);
                tranche.setAmount(amoutPerMonth);
                tranche.setRateRecovery(0);


                trancheRepository.save(tranche);
            }
            

            System.out.println("Mrs,Mr "+credit.getSurnameClient()+" "+credit.getNameClient()+" , we inform you that your credit application has been Accepted. Your interest rate is "+ credit.getInterestRate()+" and your recovery per month is "+credit.getAmountRecoveryMonth()+" and you will return your credit on "+credit.getRecoverySince()+" years");


            // Mail mail = new Mail();

            // mail.setSubject("Credit application decision");
            // mail.setTo("mayssendridi21@gmail.com");
            // mail.setContent("Mrs,Mr"+credit.getSurnameClient()+" "+credit.getNameClient()+" , we inform you that your credit application has been Accepted. Your interest rate is "+ credit.getInterestRate()+" and your recovery per month is "+credit.getAmountRecoveryMonth()+" and you will return your credit on "+credit.getRecoverySince()+" years");
            // emailService.sendSimpleEmail(mail);

            // smsService.sendSMS(String.valueOf(50585563),"Welcome to FundSphere \n\r"
            //      .concat("Mrs,Mr : "
            //              .concat(credit.getSurnameClient()
            //                      .concat(" "+credit.getNameClient())
            //                         .concat("\"we inform you that your credit application has been Accepted.\n\r "
            //                                 .concat("\n\r")
            //                                 .concat("Your interest rate is "+credit.getInterestRate()+"\n\r Your recovery per month is "+credit.getAmountRecoveryMonth()+"\n\r You will return your credit on "+credit.getRecoverySince()+" years")
            //                              ))));

        } else if (credit.getState()==2) {

            Mail mail = new Mail();

            mail.setSubject("Credit application decision");
            mail.setTo("mayssendridi21@gmail.com");
            mail.setContent("Mrs,Mr "+credit.getSurnameClient()+" "+credit.getNameClient()+" , we inform you that your credit application has been Declined.");
            emailService.sendSimpleEmail(mail);

            smsService.sendSMS(String.valueOf(50585563),"Welcome to FundSphere \n\r"
                    .concat("Mrs,Mr : "
                            .concat(credit.getSurnameClient()
                                    .concat(" "+credit.getNameClient())
                                    .concat("\"we inform you that your credit application has been Declined.\n\r "))));

        }else
        {
            creditRepository.save(credit);

        }
        return creditRepository.save(credit);
    }

    @Override
    public List<Credit> getAllCredits() {
        return creditRepository.findAll();    }

    @Override
    public Credit getCredit(Long idCredit) {
        return creditRepository.findById(idCredit).get();
    }

    public void assignCreditToAccount( Long idCredit , Long idAccount) {
        Credit credit = creditRepository.findById(idCredit).get();
        Account account = accountRepository.findById(idAccount).get();
// on set le fils dans le parent :
        credit.setAccount(account);
        creditRepository.save(credit);
    }


    public void unassignCreditToAccount(Long idCredit) {
        Credit credit = creditRepository.findById(idCredit).get();
// on set le fils dans le parent :
        credit.setAccount(null);
        creditRepository.save(credit);
    }

}
