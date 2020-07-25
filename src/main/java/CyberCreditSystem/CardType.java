package CyberCreditSystem;

/**
 *
 * @author aaron
 */
public class CardType
{
    final private String NAME;
    final private int VALIDLENGTH;
    
    public CardType(String name, int length)
    {
        this.VALIDLENGTH = length;
        this.NAME = name;
    }
    public String getName()
    {
        return this.NAME;
    }
    public int getValidLength()
    {
       return this.VALIDLENGTH;
    }
    @Override
    public String toString()
    {
        return " name= " + this.getName() + ", length= " + this.getValidLength();
    }
}
