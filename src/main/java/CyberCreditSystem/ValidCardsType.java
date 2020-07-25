/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CyberCreditSystem;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aaron
 */
public class ValidCardsType
{
    List<CardType> validTypes = new ArrayList<>();
    
    public ValidCardsType()
    {
        
    }
    public ValidCardsType(List<CardType> validTypes)
    {
        this.validTypes = validTypes;
    }
    public List<CardType> getValidTypes()
    {
        return this.validTypes;
    }
    public void setValidTypes(List<CardType> validCardTypes)
    {
        this.validTypes = validCardTypes;
    }
    public Boolean addValidType(CardType type)
    {
        // if already there returns falce and doesnt add it to list (Duplicate)
        if(this.findTypeIndex(type.getName()) > -1)
        {
            return false;
        }
        // returns true or false if added or not
        return this.getValidTypes().add(type);
    }
    public Boolean removeValidType(CardType type)
    {
       return this.getValidTypes().remove(type);
    }
    public Boolean removeValidType(String typeName)
    {
        int index = this.findTypeIndex(typeName);
        if(index > -1)
        {
           this.getValidTypes().remove(index);
           return true;
        }
        return false;
    }
    
    public void printValidTypes()
    {
        System.out.println(String.format("%-20s%7s", "Name","Length"));
        for(CardType c: this.getValidTypes())
        {
            System.out.println(String.format("%-20s%5s",c.getName(), c.getValidLength()));
        }
    
    }
    
    public int findTypeIndex(String name)
    {
        int i = 0;
        while(i < this.getValidTypes().size())
        {
            if(this.getValidTypes().get(i).getName().equalsIgnoreCase(name))
            {
                return i;
            }
            i++;
        }
        return -1;
    }
    @Override
    public String toString()
    {
        return this.getValidTypes().toString();
    }
}
