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
import org.apache.ofbiz.service.ServiceUtil;
import java.util.Map;

public class ProductEvents{

    public static final String MODULE = ProductEvents.class.getName();

    public static String productUpdateEvent(HttpServletRequest request, HttpServletResponse response) {
        Delegator delegator = (Delegator) request.getAttribute("delegator");
        LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");

        String productId = request.getParameter("productId"); 
        String productName = request.getParameter("productName");
        String productCategoryId = request.getParameter("productCategoryId");
        String productPrice = request.getParameter("price");

        if (UtilValidate.isEmpty(productId)) {
            String errMsg = "Product Id is a required field.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error"; 
        }

        try {
            Debug.logInfo("=======Updating product using UpdateProduct service=========", MODULE);

            Map<String, Object> context = UtilMisc.toMap(
                    "productId" , productId,
                    "productName", productName,
                    "productCategoryId", productCategoryId,
                    "price", productPrice,
                    "userLogin", userLogin
            );

            Map<String, Object> result = dispatcher.runSync("UpdateProduct", context);

            if (ServiceUtil.isError(result)) {
                String errorMessage = ServiceUtil.getErrorMessage(result);
                request.setAttribute("_ERROR_MESSAGE_", errorMessage);
                return "error";
            } else {
                String successMessage = (String) result.get("successMessage");
                request.setAttribute("_EVENT_MESSAGE_", successMessage);
                return "success";
            }
        } catch (GenericServiceException e) {
            String errMsg = "Error updating product: " + e.getMessage();
            Debug.logError(errMsg, MODULE);
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
    }
}