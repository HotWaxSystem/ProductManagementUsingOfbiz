import org.apache.ofbiz.entity.Delegator
import org.apache.ofbiz.entity.DelegatorFactory
import org.apache.ofbiz.entity.GenericValue
import org.apache.ofbiz.entity.GenericEntityException
import java.sql.Timestamp
import java.math.BigDecimal

def CreateProductDetail() {
    try {
        Delegator delegator = (Delegator) context.delegator
        String productId = delegator.getNextSeqId("Product")

        GenericValue product = delegator.makeValue("Product")
        product.set("productId", productId)
        product.set("productName", context.productName)
        product.set("internalName", context.internalName ?: productId)
        delegator.create(product)

        String productPriceId = delegator.getNextSeqId("ProductPrice")
        GenericValue productPrice = delegator.makeValue("ProductPrice")
        productPrice.set("productId", productId)
        productPrice.set("productPriceTypeId", "DEFAULT_PRICE")
        productPrice.set("productPricePurposeId", "PURCHASE")
        productPrice.set("currencyUomId", "USD")
        productPrice.set("productStoreGroupId", "_NA_")
        productPrice.set("price", new BigDecimal(context.price ?: 0))
        productPrice.set("fromDate", new Timestamp(System.currentTimeMillis()))
        delegator.create(productPrice)

        GenericValue productCategoryMember = delegator.makeValue("ProductCategoryMember")
        productCategoryMember.set("productCategoryId", context.productCategoryId)
        productCategoryMember.set("productId", productId)
        productCategoryMember.set("fromDate", new Timestamp(System.currentTimeMillis()))
        delegator.create(productCategoryMember)

        return ["productId": productId, "responseMessage": "success"]
    } catch (GenericEntityException e) {
        return ["responseMessage": "error", "errorMessage": "Error creating product: " + e.getMessage()]
    }
}
