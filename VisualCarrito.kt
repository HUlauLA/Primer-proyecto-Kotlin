fun mostrarCarrito(carrito: List<ItemCarrito>) {

    if (carrito.isEmpty()) {
        println("⚠ El carrito está vacío.")
        return
    }

    println("\n========= CARRITO =========")
    println("No.\tProducto\tCantidad\tPrecio\tSubtotal")

    var total = 0.0

    carrito.forEachIndexed { index, item ->

        val subtotal = item.cantidad * item.producto.precio
        total += subtotal

        println("${index + 1}\t${item.producto.nombre}\t\t${item.cantidad}\t\t$${item.producto.precio}\t$${subtotal}")
    }

    println("---------------------------")
    println("TOTAL: $" + total)
}