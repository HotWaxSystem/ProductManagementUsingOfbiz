import org.apache.ofbiz.entity.Delegator
import org.apache.ofbiz.entity.GenericValue
import org.apache.ofbiz.entity.GenericEntityException
import java.math.BigDecimal
import java.sql.Timestamp
import org.apache.ofbiz.entity.DelegatorFactory
import org.apache.ofbiz.base.util.Debug


def UpdateProductDetail() {
    Delegator delegator = (Delegator) context.delegator

    GenericValue productData = delegator.findOne("Product", ["productId": context.productId], false)
    GenericValue productprice = delegator.findByAnd("ProductPrice", ["productId": context.productId], null,false)?.get(0)

    if (productData && productprice) {
        if(context.productName)
        {
            productData.set("productName", context.productName)
        }
        
        delegator.store(productData)

        productprice.set("thruDate",new Timestamp(System.currentTimeMillis()))
        delegator.store(productprice)

        if(context.productPrice)
        {
            GenericValue productPricecreate = delegator.makeValue("ProductPrice")
            productPricecreate.set("productId", context.productId)
            productPricecreate.set("productPriceTypeId", "DEFAULT_PRICE")
            productPricecreate.set("productPricePurposeId", "PURCHASE")
            productPricecreate.set("currencyUomId", "USD")
            productPricecreate.set("productStoreGroupId", "_NA_")
            productPricecreate.set("price", new BigDecimal(context.productPrice ?: 0))
            productPricecreate.set("fromDate", new Timestamp(System.currentTimeMillis()))
            delegator.create(productPricecreate)
        }
        return success("Product updated successfully")
    }
    else {
        Debug.logError("Product not found for ID: " + context.productId, "UpdateProductDetail")
        return error("Product not found")
    }
}