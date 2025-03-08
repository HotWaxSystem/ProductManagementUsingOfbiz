<form method="post" action="<@ofbizUrl>assocProductToVirtual</@ofbizUrl>" name="CreateRelationshipForm" class="form-horizontal">

    <div class="control-group">
        <label class="control-label" for="productId">Product ID</label>
        <div class="controls">
            <input type="text" id="productId" name="productId" required>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productIdTo">Associated Product ID</label>
        <div class="controls">
            <input type="text" id="productIdTo" name="productIdTo" required>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productAssocTypeId">Association Type</label>
        <div class="controls">
            <input type="text" id="productAssocTypeId" name="productAssocTypeId" required>
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn">Create Relationship</button>
        </div>
    </div>

</form>