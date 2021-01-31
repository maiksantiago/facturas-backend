-- categorias
insert into categorias (nombre, descripcion) values ('Videojuegos', 'Consolas, juegos y accesorios');

-- productos
insert into productos (nombre, precio, stock, id_categoria) values ('Xbox Series S 512 GB', 8499, 8, 1);
insert into productos (nombre, precio, stock, id_categoria) values ('Xbox Series X 1 TB', 13999, 8, 1);

-- clientes
insert into clientes (nombre, apellido, direccion, telefono, correo_electronico) values ('John', 'Doe', 'Cupertino, CA 95014', '1234567890', 'johndoe@gmail.com');
insert into clientes (nombre, apellido, direccion, telefono, correo_electronico) values ('Jane', 'Doe', 'Seattle, WA 98109', '0123456789', 'janedoe@gmail.com');

-- facturas
insert into facturas (fecha_emision, id_cliente) values ('2021-01-20', 1);

-- items
insert into items (cantidad, id_producto, id_factura) values (2, 1, 1);
insert into items (cantidad, id_producto, id_factura) values (2, 2, 1);