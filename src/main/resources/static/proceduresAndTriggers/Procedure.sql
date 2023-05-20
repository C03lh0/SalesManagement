CREATE PROCEDURE GetSalesANDInventoryFROMProductName
    @PRODUCT_NAME VARCHAR(50)
AS
    BEGIN
        DECLARE @PRODUCT_ID INT,
                @SALE_QUANTITY INT,
                @STOCK_QUANTITY INT
           
        SELECT @PRODUCT_ID = ProductID FROM PRODUCTS WHERE ProductName = @PRODUCT_NAME;

    SELECT @PRODUCT_ID = FINALRESULT.ID, @SALE_QUANTITY = FINALRESULT.SALES, @STOCK_QUANTITY = FINALRESULT.STOCK FROM PRODUCTS
        INNER JOIN (
            SELECT MIN(Products.ProductID) AS 'ID',SUM(Order_Details.Quantity) AS 'SALES', MIN(Products.UnitsInStock) AS 'STOCK' FROM PRODUCTS 
                    INNER JOIN Order_Details ON Order_Details.ProductID = @PRODUCT_ID
                    INNER JOIN Orders ON Orders.OrderID = Order_Details.OrderID
            WHERE Products.ProductID = @PRODUCT_ID GROUP BY Products.ProductID) 
            AS FINALRESULT 
        ON Products.ProductID = FINALRESULT.ID
    IF @SALE_QUANTITY = 0 OR @STOCK_QUANTITY = 0 OR @STOCK_QUANTITY IS NULL OR @SALE_QUANTITY IS NULL
        BEGIN
            SELECT 'THERE ARE NO SALES OR STOCK FOR THIS PRODUCT'
        END
    ELSE
        BEGIN
            SELECT @PRODUCT_NAME AS 'NAME' , @SALE_QUANTITY 'SALES NUMBER', @STOCK_QUANTITY 'STOCK QUANTITY'
        END 
    END

CREATE PROCEDURE SelectThe5ProductsWithLessQuantity
AS
    BEGIN
        DECLARE @PRODUCT_ID INT,
                @STOCK_QUANTITY INT
           
        SELECT TOP 5 ProductID, UnitsInStock FROM Products ORDER BY UnitsInStock DESC
    END