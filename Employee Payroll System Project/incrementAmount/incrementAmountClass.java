package incrementAmount;

public class incrementAmountClass
{
    public double initialSalaryFt(double salary, double month)
    {
        return (salary*month);
    }

    public double calOvertime(double amount,double hours)
    {
        return (amount*hours);
    }

    public double calBonus(double amount)
    {
        return amount;
    }

    public double calCommission(double amount,double sales)
    {
        return (amount*sales);
    }

    public double calAdditionalAmt(double amount)
    {
        return amount;
    }

}