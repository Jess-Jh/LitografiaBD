
-- REPORTE 4
select e.cedulaEmpleado, e.apellido, e.nombre, e.tipo, e.sueldo, count(idPedido) as cantidadPedidos
from empleado e, pedido p, pedidomateriaprima pm, materiaprima m, proveedormateriaprima pmp, proveedor v
where e.cedulaEmpleado = p.Empleado_cedulaEmpleado
and p.idPedido = pm.Pedido_idPedido
and pm.MateriaPrima_idMateriaPrima = m.idMateriaPrima
and m.idMateriaPrima = pmp.MateriaPrima_idMateriaPrima
and pmp.Proveedor_idProveedor = v.idProveedor
and v.idProveedor = '59449877'
group by e.cedulaEmpleado
order by cantidadPedidos desc;

-- REPORTE 5
select p.idProducto, p.tipo, p.precio, f.idFactura, f.fecha, c.cedulaCliente, c.nombre, c.apellido
from producto p, facturaproducto fp, factura f, cliente c
where p.idProducto = fp.Producto_idProducto
and fp.Factura_idFactura = f.idFactura
and f.Cliente_cedulaCliente = c.cedulaCliente
order by f.fecha desc;

-- REPORTE 6
select p.idProveedor, p.nombre, p.rut, sum(m.cantidad) as cantidadMateriaPrima
from proveedor p, proveedormateriaprima pmp, materiaprima m
where p.idProveedor = pmp.Proveedor_idProveedor
and pmp.MateriaPrima_idMateriaPrima = m.idMateriaPrima
group by p.idProveedor
having sum(m.cantidad) > 20
order by cantidadMateriaPrima desc;

-- REPORTE 7
select c.cedulaCliente, c.nombre, c.apellido, count(d.idDiseno) as cantidadDisenos
from cliente c, especificaciondiseno ed, diseno d
where c.cedulaCliente = ed.Cliente_cedulaCliente
and ed.Diseno_idDiseno = d.idDiseno
and d.tipo in ('Tarjeta', 'Volante', 'Logo')
group by c.cedulaCliente;

-- REPORTE 8
select c.cedulaCliente, c.apellido, c.nombre, c.correoElectronico, sum(p.cantidad) as cantidadCompra
from cliente c, especificacionlitografica el, empleado e, factura f, facturaproducto fp, producto p
where c.cedulaCliente = f.Cliente_cedulaCliente
and f.idFactura = fp.Factura_idFactura
and fp.Producto_idProducto = p.idProducto
and e.sueldo = (select sueldo
				from empleado
				order by sueldo asc
                limit 1)
group by c.cedulaCliente
order by cantidadCompra desc;

-- REPORTE 9
select d.idDevolucion, d.tipo, sum(dp.cantidad) as cantidadDevoluciones
from devolucion d, devolucionproducto dp
where d.idDevolucion = dp.Devolucion_idDevolucion
group by d.idDevolucion
having sum(dp.cantidad) > (select sum(m.cantidad) 
							from materiaprima m, proveedormateriaprima pmp, proveedor p
                            where m.idMateriaPrima = pmp.MateriaPrima_idMateriaPrima
                            and pmp.Proveedor_idProveedor = p.idProveedor
                            and p.nombre = 'Gertruda')
order by cantidadDevoluciones desc;

-- REPORTE 10
select f.idFactura, f.precio, f.fecha, f.Cliente_cedulaCliente
from factura f, facturaempleado fe, empleado e
where f.idFactura = fe.Factura_idFactura
and fe.Empleado_cedulaEmpleado = e.cedulaEmpleado
and e.cedulaEmpleado in (select distinct e.cedulaEmpleado
						 from empleado e, pedido p
                         where e.cedulaEmpleado = p.Empleado_cedulaEmpleado
                         and p.precio > 20000)
and f.idFactura not in (select f.idFactura
						from factura f, cliente c
                        where f.Cliente_cedulaCliente = c.cedulaCliente
                        and c.nombre = 'Betteanne')
                        







