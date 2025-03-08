package com.ofbiz.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;

public class OfbizDemoEvents {

    public static final String MODULE = OfbizDemoEvents.class.getName();

    public static String createProductEvent(HttpServletRequest request, HttpServletResponse response) {
        Delegator delegator = (Delegator) request.getAttribute("delegator");
        LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");

        // Get parameters from request
        String productName = request.getParameter("productName");
        String productCategoryId = request.getParameter("productCategoryId");
        String productPrice = request.getParameter("price");

        // Validate required fields
        if (UtilValidate.isEmpty(productName) || UtilValidate.isEmpty(productCategoryId) || UtilValidate.isEmpty(productPrice)) {
            String errMsg = "Product Name, Product Category ID, and Product Price are required fields.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }

        try {
            Debug.logInfo("======= Creating Product using createProduct service =======", MODULE);
            
            dispatcher.runSync("createProduct", 
                UtilMisc.toMap("productName", productName, 
                               "productCategoryId", productCategoryId, 
                               "price", productPrice, 
                               "userLogin", userLogin));

        } catch (GenericServiceException e) {
            String errMsg = "Error creating product: " + e.toString();
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }

        request.setAttribute("_EVENT_MESSAGE_", "Product created successfully.");
        return "success";
    }
}
