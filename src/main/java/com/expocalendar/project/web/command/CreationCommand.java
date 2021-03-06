package com.expocalendar.project.web.command;

import com.expocalendar.project.service.ServiceFactory;
import com.expocalendar.project.service.interfaces.AdminService;
import com.expocalendar.project.service.interfaces.SelectionService;
import com.expocalendar.project.web.controller.ControllerHelper;
import com.expocalendar.project.web.managment.PagesManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.util.Map;

public class CreationCommand implements Command {

    private final static Logger LOGGER = Logger.getLogger(CreationCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        AdminService adminService = serviceFactory.getAdminService();
        SelectionService selectionService = serviceFactory.getSelectionService();

        ControllerHelper controllerHelper = ControllerHelper.getInstance();

        Map<String, String> requestParameters;

        String obj = request.getParameter("object");

        switch (obj) {
            case "exposition":
                try {
                    requestParameters = controllerHelper.extractParameters(request);
                    adminService.createExposition(requestParameters);
                    request.getSession().setAttribute("themes", selectionService.findThemes());
                    request.getSession().setAttribute("allExpositions", selectionService.getAllExpositions());

                } catch (MalformedURLException e) {
                    LOGGER.error("MalformedURLException occurred in " + this.getClass().getSimpleName(), e);
                }
                break;

            case "hall":
                requestParameters = controllerHelper.extractParameters(request);
                adminService.createExpoHall(requestParameters);
                request.getSession().setAttribute("halls", selectionService.getExpoHalls());
        }

        LOGGER.info(this.getClass().getSimpleName() + " executed");

        return PagesManager.getProperty("path.page.admin");
    }
}
