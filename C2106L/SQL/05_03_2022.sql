SELECT ProductName, 
  SupplierID AS 'ID nhà cung cấp', 
  CategoryID AS 'ID loại sản phẩm', 
  Unit AS 'Đơn vị'
FROM Products 
WHERE Price BETWEEN 19.2 AND 20