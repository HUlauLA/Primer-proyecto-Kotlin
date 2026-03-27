class Carrito {

    private val items = mutableListOf<ItemCarrito>()

    // AGREGAR PRODUCTO
    fun agregarProducto(producto: Producto, cantidad: Int) {

        if (producto.cantidadDisponible == 0) {
            println("El producto '${producto.nombre}' está agotado.")
            return
        }

        if (cantidad <= 0) {
            println("La cantidad debe ser mayor que 0.")
            return
        }

        if (cantidad > producto.cantidadDisponible) {
            println("La cantidad solicitada supera el stock disponible (${producto.cantidadDisponible}).")
            return
        }

        val itemExistente = items.find { it.producto.nombre == producto.nombre }

        if (itemExistente != null) {

            if (itemExistente.cantidad + cantidad > producto.cantidadDisponible) {
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
    fun eliminarProducto(nombreProducto: String, cantidad: Int) {

        val itemExistente = items.find { it.producto.nombre == nombreProducto }

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