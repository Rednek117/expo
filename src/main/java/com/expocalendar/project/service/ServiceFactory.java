package com.expocalendar.project.service;

import com.expocalendar.project.persistence.DAOFactory;
import com.expocalendar.project.service.impl.AdminServiceImpl;
import com.expocalendar.project.service.impl.AuthorizationServiceImpl;
import com.expocalendar.project.service.impl.OrderServiceImpl;
import com.expocalendar.project.service.impl.SelectionServiceImpl;
import com.expocalendar.project.service.interfaces.AdminService;
import com.expocalendar.project.service.interfaces.AuthorizationService;
import com.expocalendar.project.service.interfaces.OrderService;
import com.expocalendar.project.service.interfaces.SelectionService;

/**
 * Singleton Factory allows to get services implementations

 */

public class ServiceFactory {

    private static ServiceFactory instance;

    private DAOFactory daoFactory;

    /**
     * Constructor sets DaoFactory field
     * which allows to pass DAO object to
     * services constructors.
     */

    private ServiceFactory() {
        daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    }


    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    /**
     * @return instance of AdminService implementation.
     */

    public AdminService getAdminService() {
        return new AdminServiceImpl(daoFactory.getExpositionDAO(), daoFactory.getExpoHallDAO());
    }

    /**
     * @return instance of AuthorizationService implementation.
     */

    public AuthorizationService getAuthorizationService() {
        return new AuthorizationServiceImpl(daoFactory.getAccountDAO());
    }

    /**
     * @return instance of OrderService implementation.
     */

    public OrderService getOrderService() {
        return new OrderServiceImpl(daoFactory.getExpositionDAO(),
                daoFactory.getExpoHallDAO(),
                daoFactory.getCreditCardDAO(),
                daoFactory.getOrderDAO());
    }

    /**
     * @return instance of concrete SelectionService implementation.
     */

    public SelectionService getSelectionService() {
        return new SelectionServiceImpl(daoFactory.getExpositionDAO(), daoFactory.getExpoHallDAO());
    }
}