import org.apache.ofbiz.entity.Delegator
import org.apache.ofbiz.entity.GenericValue
import org.apache.ofbiz.entity.GenericEntityException
import java.math.BigDecimal
import java.sql.Timestamp
import org.apache.ofbiz.entity.DelegatorFactory
import org.apache.ofbiz.base.util.Debug
 
def RelationShipDetail()
{
    Delegator delegator = (Delegator) context.delegator 
    GenericValue productAssoc = delegator.makeValue("ProductAssoc")
    productAssoc.set("productId",context.productId)
    productAssoc.set("productIdTo",context.productIdTo)
    productAssoc.set("productAssocTypeId",context.productAssocTypeId)
    productAssoc.set("fromDate",new Timestamp(System.currentTimeMillis()))
    delegator.create(productAssoc)   
}