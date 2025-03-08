<form method="post" action="<@ofbizUrl>UpdateProduct</@ofbizUrl>" name="UpdateProductForm" class="form-horizontal">

    <input type="hidden" id="productId" name="productId" value="">

    <div class="control-group">
        <label class="control-label" for="productName">Product Name</label>
        <div class="controls">
            <input type="text" id="productName" name="productName">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productPrice">Product Price</label>
        <div class="controls">
            <input type="text" id="productPrice" name="productPrice">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productFeatureoldId">Old Product Feature ID</label>
        <div class="controls">
            <input type="text" id="productFeatureoldId" name="productFeatureoldId">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="ProductFeatureNewId">New Product Feature ID</label>
        <div class="controls">
            <input type="text" id="ProductFeatureNewId" name="ProductFeatureNewId">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productFeatureApplTypeId">Product Feature Application Type</label>
        <div class="controls">
            <input type="text" id="productFeatureApplTypeId" name="productFeatureApplTypeId">
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn">Update Product</button>
        </div>
    </div>

</form>