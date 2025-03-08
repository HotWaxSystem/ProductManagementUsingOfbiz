<#if parameters.productlist?? && parameters.productlist?size gt 0>
    <table border="1" cellspacing="0" cellpadding="8">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Description</th>
        </tr>
        <#list parameters.productlist as product>
            <tr>
                <td>${product.productId!''}</td>
                <td>${product.productName!''}</td>
                <td>${product.productDescription!''}</td>
            </tr>
        </#list>
    </table>
<#else>
    <p>No products found.</p>
</#if>