class CarritoCompra {
    private val items = mutableListOf<ItemCarrito>()

    fun agregarProducto(producto: Producto, cantidad: Int) {
        if (cantidad <= 0) {
            println("La cantidad debe ser mayor que 0.")
            return
        }

        if (cantidad > producto.cantidadDisponible) {
            println("No hay suficiente inventario de ${producto.nombre}.")
            return
        }

        val itemExistente = items.find { it.producto.nombre.equals(producto.nombre, ignoreCase = true) }

        if (itemExistente != null) {
            if (itemExistente.cantidad + cantidad <= producto.cantidadDisponible) {
                itemExistente.cantidad += cantidad
                println("Se actualizó la cantidad de ${producto.nombre} en el carrito.")
            } else {
                println("No se puede agregar esa cantidad. Supera el inventario disponible.")
            }
        } else {
            items.add(ItemCarrito(producto, cantidad))
            println("${producto.nombre} agregado al carrito.")
        }
    }

    fun eliminarProducto(nombreProducto: String) {
        val item = items.find { it.producto.nombre.equals(nombreProducto, ignoreCase = true) }

        if (item != null) {
            items.remove(item)
            println("${item.producto.nombre} eliminado del carrito.")
        } else {
            println("El producto no se encuentra en el carrito.")
        }
    }

    fun obtenerItems(): List<ItemCarrito> {
        return items
    }

    fun mostrarCarrito() {
        if (items.isEmpty()) {
            println("\nEl carrito está vacío.")
            return
        }

        println("\n================= CARRITO DE COMPRAS =================")
        println(String.format("%-20s %-10s %-15s %-15s", "Producto", "Cantidad", "Precio Unit.", "Total"))

        for (item in items) {
            println(
                String.format(
                    "%-20s %-10d $%-14.2f $%-14.2f",
                    item.producto.nombre,
                    item.cantidad,
                    item.producto.precio,
                    item.totalPorProducto()
                )
            )
        }

        val total = items.sumOf { it.totalPorProducto() }
        println(String.format("\nTotal del carrito: $%.2f", total))
    }
}