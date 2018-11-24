package com.expocalendar.project.persistence;

import com.expocalendar.project.persistence.impl.mysql.MySQLDAOFactory;
import com.expocalendar.project.persistence.interfaces.*;

public abstract class DAOFactory {

    public static final int MYSQL = 1;

    /**
     * @return instance of concrete AccountDAO implementation.
     */
    public abstract AccountDAO getAccountDAO();

    /**
     * @return instance of concrete ExpoHallDAO implementation.
     */
    public abstract ExpoHallDAO getExpoHallDAO();
    /**
     * @return instance of concrete ExpositionDAO implementation.
     */
    public abstract ExpositionDAO getExpositionDAO();
    /**
     * @return instance of concrete CreditCardDAO implementation.
     */
    public abstract CreditCardDAO getCreditCardDAO();
    /**
     * @return instance of concrete OrderDAO implementation.
     */
    public abstract OrderDAO getOrderDAO();

    /**
     * @return concrete DAOFactory implementation
     */
    public static DAOFactory getDAOFactory(int factory) {
        DAOFactory daoFactory = null;

        switch (factory) {
            case MYSQL:
                daoFactory = new MySQLDAOFactory();
        }
        return daoFactory;
    }


}
