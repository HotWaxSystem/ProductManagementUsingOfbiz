 import org.apache.ofbiz.entity.Delegator
import org.apache.ofbiz.entity.GenericValue
import org.apache.ofbiz.entity.GenericEntityException
import java.math.BigDecimal
import java.sql.Timestamp
import org.apache.ofbiz.entity.DelegatorFactory
import org.apache.ofbiz.base.util.Debug
 
def UpdateFeatureDetail()
{
    Delegator delegator = (Delegator) context.delegator

    GenericValue productFeatureAppl = delegator.makeValue("ProductFeatureAppl")
    GenericValue productFeatureApplfind = delegator.findByAnd("ProductFeatureAppl", ["productId": context.productId,"productFeatureId":context.productFeatureoldId], null,false)?.get(0)
    if(productFeatureApplfind)
    {
        productFeatureApplfind.set("thruDate",new Timestamp(System.currentTimeMillis()))
        delegator.store(productFeatureApplfind)
    }
    productFeatureAppl.set("productFeatureId",context.productFeatureNewId)
    productFeatureAppl.set("productId",context.productId)
    productFeatureAppl.set("fromDate",new Timestamp(System.currentTimeMillis()))
    productFeatureAppl.set("productFeatureApplTypeId",context.productFeatureApplTypeId)
    delegator.create(productFeatureAppl)    
}