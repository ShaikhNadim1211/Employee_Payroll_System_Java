package decrementAmount;

public class decrementAmountClass 
{
    public double leaveAmount(double amount, double days)
    {
        double perDayAmount=amount/30;
        return (perDayAmount*days);
    }

    public double calIncomeTax(double amount,double rate)
    {
        return (amount*(rate/100));
    }
    public double calHealthInsurance(double amount,double rate)
    {
        return (amount*(rate/100));
    }

    public double calOther(double amount,double rate)
    {
        return (amount*(rate/100));
    }

    public double calProvidentFund(double amount,double rate)
    {
        return (amount*(rate/100));
    }

    public double calProffessionalTax(double amount)
    {
        return amount;
    }
}
