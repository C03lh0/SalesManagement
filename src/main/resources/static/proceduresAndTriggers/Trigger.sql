CREATE TRIGGER trgCustomerInsert
ON Customers
AFTER INSERT
AS
BEGIN
    DECLARE @City NVARCHAR(100);
    DECLARE @Count INT;

    SELECT @City = City FROM inserted;

    SELECT @Count = COUNT(*) FROM Customers WHERE City = @City;

    IF @Count >= 10
    BEGIN
        RAISERROR('Não é possível inserir o cliente. Limite máximo de clientes da mesma cidade atingido.', 16, 1);
        ROLLBACK;
    END
END;


