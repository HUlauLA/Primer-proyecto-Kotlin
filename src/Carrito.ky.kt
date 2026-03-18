class Carrito {

    private val items = mutableListOf<ItemCarrito>()

    // AGREGAR PRODUCTO
    fun agregarProducto(producto: Producto, cantidad: Int) {

        if (producto.stock == 0) {
            println("El producto '${producto.nombre}' está agotado.")
            return
        }

        if (cantidad <= 0) {
            println("La cantidad debe ser mayor que 0.")
            return
        }

        if (cantidad > producto.stock) {
            println("La cantidad solicitada supera el stock disponible (${producto.stock}).")
            return
        }

        val itemExistente = items.find { it.producto.id == producto.id }

        if (itemExistente != null) {

            if (itemExistente.cantidad + cantidad > producto.stock) {
                println("No puedes agregar más. Supera el stock disponible.")
                return
            }

            itemExistente.cantidad += cantidad

        } else {
            items.add(ItemCarrito(producto, cantidad))
        }

        println("Producto agregado correctamente al carrito.")
    }

    // ELIMINAR PRODUCTO
    fun eliminarProducto(idProducto: Int, cantidad: Int) {

        val itemExistente = items.find { it.producto.id == idProducto }

        if (itemExistente == null) {
            println("Ese producto no está en el carrito.")
            return
        }

        if (cantidad <= 0) {
            println("La cantidad debe ser mayor que 0.")
            return
        }

        if (cantidad >= itemExistente.cantidad) {
            items.remove(itemExistente)
            println("🗑Producto eliminado completamente del carrito.")
        } else {
            itemExistente.cantidad -= cantidad
            println("Se eliminaron $cantidad unidades del producto.")
        }
    }

    fun obtenerItems(): List<ItemCarrito> {
        return items
    }
}