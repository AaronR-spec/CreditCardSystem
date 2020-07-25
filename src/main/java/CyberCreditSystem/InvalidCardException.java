/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CyberCreditSystem;

import java.sql.SQLException;

/**
 *
 * @author aaron
 */
public class InvalidCardException extends SQLException
{
    public InvalidCardException()
    {
    
    }
    
    public InvalidCardException(String message)
    {
        super(message);
    }
}
