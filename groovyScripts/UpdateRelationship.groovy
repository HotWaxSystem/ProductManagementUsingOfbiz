import org.apache.ofbiz.entity.Delegator
import org.apache.ofbiz.entity.GenericValue
import org.apache.ofbiz.entity.GenericEntityException
import java.math.BigDecimal
import java.sql.Timestamp
import org.apache.ofbiz.entity.DelegatorFactory
import org.apache.ofbiz.base.util.Debug
 
def Updaterelationship()
{
  
    Delegator delegator = (Delegator) context.delegator
    GenericValue productData = delegator.findByAnd("ProductAssoc", ["productId": context.productId],["fromDate DESC"],false)?.get(0)         
    productData.set("thruDate",new Timestamp(System.currentTimeMillis()))
    delegator.store(productData)
    GenericValue productAssoc = delegator.makeValue("ProductAssoc")
    productAssoc.set("productId",context.productId)
    productAssoc.set("productIdTo",context.productIdTo)
    productAssoc.set("productAssocTypeId",context.productAssocTypeId)
    productAssoc.set("fromDate",new Timestamp(System.currentTimeMillis()))
    delegator.create(productAssoc)
        
}