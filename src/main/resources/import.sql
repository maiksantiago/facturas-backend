-- categorias
insert into categorias (nombre, descripcion) values ('Videojuegos', 'Consolas, juegos y accesorios');

-- productos
insert into productos (nombre, precio, stock, id_categoria) values ('Xbox Series X', 13500, 10, 1);
insert into productos (nombre, precio, stock, id_categoria) values ('Play Station 5', 15900, 10, 1);

-- clientes
insert into clientes (nombre, apellido, direccion, telefono, correo_electronico) values ('Miguel', 'Santiago', 'Cupertino, CA 95014', '1234567890', 'miguel@domain.com');
insert into clientes (nombre, apellido, direccion, telefono, correo_electronico) values ('Maik', 'Santiago', 'Palo Alto, CA 95020', '0123456789', 'maik@domain.com');

-- facturas
insert into facturas (fecha_emision, id_cliente) values ('2021-01-18', 1);
insert into facturas (fecha_emision, id_cliente) values ('2021-01-20', 1);

-- items
insert into items (cantidad, id_producto, id_factura) values (1, 1, 1);
insert into items (cantidad, id_producto, id_factura) values (1, 2, 2);