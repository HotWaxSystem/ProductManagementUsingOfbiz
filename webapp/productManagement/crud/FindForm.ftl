
<form method="post" action="<@ofbizUrl>FindProduct</@ofbizUrl>" name="AddOfbizDemo" class="form-horizontal">

    <div class="control-group">
        <label class="control-label" for="productName">Product Name</label>
        <div class="controls">
            <input type="text" id="productName" name="productName">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productCategory">Product Category</label>
        <div class="controls">
            <input type="text" id="productCategory" name="productCategory">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productPrice">Product Price</label>
        <div class="controls">
            <input type="text" id="productPrice" name="productPrice">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productFeature">Product Feature</label>
        <div class="controls">
            <input type="text" id="productFeature" name="productFeature">
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn">${uiLabelMap.CommonAdd}</button>
        </div>
    </div>

</form>
