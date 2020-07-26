/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CyberCreditSystem;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author aaron
 */
public class CardSystem
{

    static ValidCardsType validTypes = new ValidCardsType();
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
       // loadValidTypes();
                readFromFile("ValidTypes.txt");

        validTypes.printValidTypes();
        enterCard();
    }
    public static void readFromFile(String fileName)
    {
        Scanner sc = new Scanner("");
        String name;
        int length;
        try
        {
            sc = new Scanner(new File(fileName));
            sc.useDelimiter("/");

            while (sc.hasNext())
            {
                name = sc.next().trim(); 
                length  = sc.nextInt(); 

                validTypes.addValidType(new CardType(name,length));
            }
        }

        catch (IOException e)
        {
            System.out.println("File Not Found. " + e.getMessage());
        }
        catch (InputMismatchException e)
        {
            System.out.println("Format Is Wrong" + e.getMessage());
        }
        finally
        {
            sc.close();
        }
    }
    public static void enterCard()
    {
        String type,cardNumber;
        try
        {
            System.out.print("\nEnter Card Type: ");
            type = keyboard.nextLine();
            System.out.print("\nEnter Card Number: ");
            cardNumber = keyboard.nextLine();
            validateCard(type, cardNumber);
        }
        catch (InputMismatchException | InvalidCardException e)
        {

            System.err.println( e.getLocalizedMessage());
        }
    }

    // read from a file
    public static void loadValidTypes()
    {
        CardType visa, masterCard, americanExpress, discover;
        visa = new CardType("Visa", 16);
        masterCard = new CardType("MasterCard", 16);
        americanExpress = new CardType("American Express", 15);
        discover = new CardType("Discover", 16);
        validTypes.addValidType(visa);
        validTypes.addValidType(masterCard);
        validTypes.addValidType(americanExpress);
        validTypes.addValidType(discover);
    }

    private static void validateCard(String type, String number) throws InvalidCardException
    {
        int index = validTypes.findTypeIndex(type);
        if(index > -1)
        {
          CardType card = validTypes.getValidTypes().get(index);
          if(card.getName().equalsIgnoreCase(type) && number.length() == card.getValidLength())
          {          
              // checks to see if number is actually a number and not a string of letters
              try
              {
                  Long.parseLong(number);
                // CANT BE DONE AS NUMBER WITH 16 DIGITS CREATES INTEGER OVERFLOW (Convert to long)
                //Integer.parseInt(number);
                return;
              }
              catch(NumberFormatException e)
              {
                throw new InvalidCardException("Invalid Card");
              }
              
          }
        }
        throw new InvalidCardException("Invalid Card");
    }


}
