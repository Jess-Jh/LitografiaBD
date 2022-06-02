select e.cedulaEmpleado, e.apellido, e.nombre, e.tipo, e.sueldo, e.direccion, count(idPedido) as cantidadPedidos
from empleado e, pedido p, pedidomateriaprima pm, materiaprima m, proveedormateriaprima pmp, proveedor v
where e.cedulaEmpleado = p.Empleado_cedulaEmpleado
and p.idPedido = pm.Pedido_idPedido
and pm.MateriaPrima_idMateriaPrima = m.idMateriaPrima
and m.idMateriaPrima = pmp.MateriaPrima_idMateriaPrima
and pmp.Proveedor_idProveedor = v.idProveedor
and v.idProveedor = 394394024
group by e.cedulaEmpleado
order by cantidadPedidos desc
