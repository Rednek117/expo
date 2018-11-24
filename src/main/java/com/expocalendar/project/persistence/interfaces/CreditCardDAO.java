package com.expocalendar.project.persistence.interfaces;

import com.expocalendar.project.entities.CreditCard;
/**
 * CreditCard Data Access Object interface
 */
public interface CreditCardDAO {
    /**
     * @param cardId identifier of Credit Card to be found in database
     * @return Credit Card found in database
     */
    CreditCard findCard(int cardId);

}
