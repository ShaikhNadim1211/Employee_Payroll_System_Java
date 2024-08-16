import decrementAmount.*;
import incrementAmount.*;
import java.util.*;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public class Main 
{
    String empname, empid, startdate, enddate;
    double basicsalary, noofmonth;
    double overtimeamt, overtimehrs;
    double bonusamt;
    double commissionamt, sales;
    double additionalamt;
    double leavedays;
    double incometaxrate;
    double healthinsrate;
    double providentfundrate;
    double proffessionaltaxrate;
    double otherrate;
    double grosssalary, deductionamt, netsalary;

    double itinitialsalary, itovertimeamt, itbonus, itcommission, itadditional;

    double dtleave, dtincometax, dthealthins, dtother, dtprovidentfund, dtprofessionaltax;

    String payslip;

    int task;
    String taxFilePath;

    String dateFormat="yyyy-MM-dd";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main m = new Main();
        decrementAmountClass decrementAmountClass = new decrementAmountClass();
        incrementAmountClass incrementAmountClass = new incrementAmountClass();
        SimpleDateFormat sdf=new SimpleDateFormat(m.dateFormat);
        sdf.setLenient(false);

        try 
        {
            System.out.println("Employee Payroll System");
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println("Employee Details.....");
            System.out.print("Enter Employee ID: ");
            m.empid = scanner.nextLine();
            if (m.empid.length() == 0) 
            {
                throw m.new InvalidInputException();
            }
            System.out.println("Enter Employee Name: ");
            m.empname = scanner.nextLine();
            if (m.empname.length() == 0) 
            {
                throw m.new InvalidInputException();
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Payment Period.....(Date Format Is YYYY-MM-DD)");
            System.out.println("Enter The Start Date:");
            m.startdate = scanner.nextLine();
            sdf.parse(m.startdate);
            
            System.out.println("Enter The End Date:");
            m.enddate = scanner.nextLine();
            sdf.parse(m.enddate);

            LocalDate start=LocalDate.parse(m.startdate);
            LocalDate end=LocalDate.parse(m.enddate);
            Period diff=Period.between(start, end);
            m.noofmonth=diff.getYears()*12+diff.getMonths();
           
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Basic Salary.....");
            System.out.println("Enter Employee Basic Salary For A Month:");
            m.basicsalary = scanner.nextDouble();
            if (m.basicsalary < 0 || String.valueOf(m.basicsalary).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.basicsalary))) 
            {
                throw m.new InvalidInputException();
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Overtime Work.....");
            System.out.println("Enter Hours For  Which The Employee Works Over Time:");
            m.overtimehrs = scanner.nextDouble();
            if (m.overtimehrs < 0 || String.valueOf(m.overtimehrs).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.overtimehrs))) 
            {
                throw m.new InvalidInputException();
            }
            if (m.overtimehrs != 0) 
            {
                System.out.println("Enter Amount For  Overtime Per Hour:");
                m.overtimeamt = scanner.nextDouble();
                if (m.overtimeamt <=0 || String.valueOf(m.overtimeamt).length() == 0
                        || Pattern.matches("[a-zA-Z]", String.valueOf(m.overtimeamt))) 
                {
                    throw m.new InvalidInputException();
                }
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Bonus.....");
            System.out.println("Enter Bonus Amount If Any:");
            m.bonusamt = scanner.nextDouble();
            if (m.bonusamt < 0 || String.valueOf(m.bonusamt).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.bonusamt))) 
            {
                throw m.new InvalidInputException();
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Commission.....");
            System.out.println("Enter Sales Count:");
            m.sales = scanner.nextDouble();
            if (m.sales < 0 || String.valueOf(m.sales).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.sales))) 
            {
                throw m.new InvalidInputException();
            }
            if (m.sales != 0) 
            {
                System.out.println("Enter Commission Amount If Any:");
                m.commissionamt = scanner.nextDouble();
                if (m.commissionamt < 0 || String.valueOf(m.commissionamt).length() == 0
                        || Pattern.matches("[a-zA-Z]", String.valueOf(m.commissionamt))) 
                {
                    throw m.new InvalidInputException();
                }
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Additional.....");
            System.out.println("Enter Additional Increment If Any:");
            m.additionalamt = scanner.nextDouble();
            if (m.additionalamt < 0 || String.valueOf(m.additionalamt).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.additionalamt))) 
            {
                throw m.new InvalidInputException();
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Employee Leave.....");
            System.out.println("Enter Total Days He/She Has Been On Leave:");
            m.leavedays = scanner.nextDouble();
            if (m.leavedays < 0 || String.valueOf(m.leavedays).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.leavedays)))
            {
                throw m.new InvalidInputException();
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Income Tax.....");
            System.out.println("Enter The Percentage Rate:");
            m.incometaxrate = scanner.nextDouble();
            if (m.incometaxrate < 0 || String.valueOf(m.incometaxrate).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.incometaxrate)) || m.incometaxrate>100) 
            {
                throw m.new InvalidInputException();
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Health Insurance.....");
            System.out.println("Enter The Percentage Rate Of Health Insurance:");
            m.healthinsrate = scanner.nextDouble();
            if (m.healthinsrate < 0 || String.valueOf(m.healthinsrate).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.healthinsrate)) || m.healthinsrate>100) 
            {
                throw m.new InvalidInputException();
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Provident Fund.....");
            System.out.println("Enter The Percentage Rate Of Provident Fund");
            m.providentfundrate = scanner.nextDouble();
            if (m.providentfundrate < 0 || String.valueOf(m.providentfundrate).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.providentfundrate)) || m.providentfundrate>100) 
            {
                throw m.new InvalidInputException();
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Proffessional Tax.....");
            System.out.println("Enter The Amount Of Proffessional Tax");
            m.proffessionaltaxrate = scanner.nextDouble();
            if (m.proffessionaltaxrate < 0 || String.valueOf(m.proffessionaltaxrate).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.proffessionaltaxrate))) 
            {
                throw m.new InvalidInputException();
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            System.out.println("Other.....");
            System.out.println("Enter The Other Percentage Rate If Any");
            m.otherrate = scanner.nextDouble();
            if (m.otherrate < 0 || String.valueOf(m.otherrate).length() == 0
                    || Pattern.matches("[a-zA-Z]", String.valueOf(m.otherrate)) || m.otherrate>100) 
            {
                throw m.new InvalidInputException();
            }
            System.out.println("------------------------------------------------------------------------------------------------");

            m.itinitialsalary = incrementAmountClass.initialSalaryFt(m.basicsalary, m.noofmonth);
            m.itovertimeamt = incrementAmountClass.calOvertime(m.overtimeamt, m.overtimehrs);
            m.itbonus = incrementAmountClass.calBonus(m.bonusamt);
            m.itcommission = incrementAmountClass.calCommission(m.commissionamt, m.sales);
            m.itadditional = incrementAmountClass.calAdditionalAmt(m.additionalamt);

            m.grosssalary = m.itinitialsalary + m.itovertimeamt + m.itbonus + m.itcommission + m.itadditional;

            m.dtleave = decrementAmountClass.leaveAmount(m.basicsalary, m.leavedays);
            m.dtincometax = decrementAmountClass.calIncomeTax(m.itinitialsalary, m.incometaxrate);
            m.dthealthins = decrementAmountClass.calHealthInsurance(m.itinitialsalary, m.healthinsrate);
            m.dtother = decrementAmountClass.calOther(m.itinitialsalary, m.otherrate);
            m.dtprovidentfund = decrementAmountClass.calProvidentFund(m.itinitialsalary, m.providentfundrate);
            m.dtprofessionaltax = decrementAmountClass.calProffessionalTax(m.proffessionaltaxrate);

            m.deductionamt = m.dtleave + m.dtincometax + m.dthealthins + m.dtother + m.dtprovidentfund
                    + m.dtprofessionaltax;

            m.netsalary = m.grosssalary - m.deductionamt;
            
            m.payslip=m.empname +", Employee ID is " + m.empid
            + "\nPayment Details.....For "+m.noofmonth+" Month"+"\nIncrement!!!!!\nInitial Salary: "
            + m.itinitialsalary + "\nOvertime Amount: " + m.itovertimeamt + "\nBonus Amount: " + m.itbonus
            + "\nCommission Amount: " + m.itcommission
            + "\nAdditional Amount: " + m.itadditional + "\nDecrement!!!!!\nLeave Amount: " + m.dtleave
            + "\nIncome Tax: " + m.dtincometax +
            "\nHealth Insurance: " + m.dthealthins + "\nProvident Fund: " + m.dtprovidentfund
            + "\nProffessional Tax: " + m.dtprofessionaltax +
            "\nOther Decrement: " + m.dtother + "\nThe Gross Salary Is " + m.grosssalary
            + "\nThe Deduction Amount Is " + m.deductionamt
            + "\nThe Net Salary Is " + m.netsalary;
            System.out.println(m.payslip);

            
            while(true)
            {
                System.out.println("Menu.....\nPress 1 For Create Slip!\nPress 2 For Exit");
                m.task=scanner.nextInt();
                if(m.task==1)
                {
                    try
                    {
                        File obj=new File("Payslip of "+m.empname+" with "+m.empid+" from "+m.startdate+"to"+m.enddate+".txt");
                        if(obj.exists())
                        {

                        }
                        else
                        {
                            obj.createNewFile();
                        }
                        FileWriter fileWriter=new FileWriter("Payslip of "+m.empname+" with "+m.empid+" from "+m.startdate+"to"+m.enddate+".txt");
                        fileWriter.write(m.payslip);
                        fileWriter.close();
                    }
                    catch(IOException e)
                    {
                        System.out.println("An error has occcured");
                        e.printStackTrace();
                    }
                }
                else if(m.task==2)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid Choice! Please Enter Again.....");
                }
            }
        scanner.close();
        } 
        catch (InvalidInputException iie) 
        {
            System.err.println("Invalid Input!!, Restart");
        } 
        catch (Exception e) 
        {
            System.err.println("Invalid Input!!, Restart");
        }
    }

    public class InvalidInputException extends Exception 
    {
        InvalidInputException() 
        {

        }
    }
}
