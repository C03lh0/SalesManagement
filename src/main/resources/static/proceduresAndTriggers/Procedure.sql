CREATE PROCEDURE SelectThe5ProductsWithLessQuantity
AS
    BEGIN
        DECLARE @PRODUCT_ID INT,
                @STOCK_QUANTITY INT
           
        SELECT TOP 5 * FROM Products ORDER BY UnitsInStock DESC
    END