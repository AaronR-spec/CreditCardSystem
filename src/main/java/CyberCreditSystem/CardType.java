package CyberCreditSystem;

/**
 *
 * @author aaron
 */
public class CardType
{
     private String name;
     private int validLength;

    
    public CardType(String name, int length)
    {
        this.validLength = length;
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public int getValidLength()
    {
       return this.validLength;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setValidLength(int validLength)
    {
        this.validLength = validLength;
    }
    
    @Override
    public String toString()
    {
        return " name= " + this.getName() + ", length= " + this.getValidLength();
    }
}
