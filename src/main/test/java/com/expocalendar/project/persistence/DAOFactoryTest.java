package com.expocalendar.project.persistence;

import com.expocalendar.project.persistence.impl.mysql.MySQLDAOFactory;
import com.expocalendar.project.persistence.interfaces.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DAOFactoryTest {


    private DAOFactory daoFactory;

    @Test
    @Before
    public void getMySQLDAOFactory() {
        daoFactory = DAOFactory.getDAOFactory(1);
        assertTrue(daoFactory instanceof MySQLDAOFactory);
    }

    @Test
    public void getMySQLAccountDAO() {
        AccountDAO expected = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getAccountDAO();
        AccountDAO actual = daoFactory.getAccountDAO();
        assertEquals(expected, actual);

    }

    @Test
    public void getExpoHallDAO() {
        ExpoHallDAO expected = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getExpoHallDAO();
        ExpoHallDAO actual = daoFactory.getExpoHallDAO();
        assertEquals(expected, actual);
    }

    @Test
    public void getExpositionDAO() {
        ExpositionDAO expected = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getExpositionDAO();
        ExpositionDAO actual = daoFactory.getExpositionDAO();
        assertEquals(expected, actual);
    }

    @Test
    public void getCreditCardDAO() {
        CreditCardDAO expected = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getCreditCardDAO();
        CreditCardDAO actual = daoFactory.getCreditCardDAO();
        assertEquals(expected, actual);
    }

    @Test
    public void getOrderDAO() {
        OrderDAO expected = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getOrderDAO();
        OrderDAO actual = daoFactory.getOrderDAO();
        assertEquals(expected, actual);
    }
}