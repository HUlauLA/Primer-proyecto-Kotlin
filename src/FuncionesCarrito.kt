fun agregarProducto(carrito: MutableList<ItemCarrito>, inventario: MutableList<Producto>) {

    if (inventario.isEmpty()) {
        println("No hay productos disponibles.")
        return
    }

    mostrarInventario(inventario)

    print("Seleccione el número del producto: ")
    val index = readLine()!!.toInt() - 1

    if (index !in inventario.indices) {
        println("Producto inválido.")
        return
    }

    val producto = inventario[index]

    print("Cantidad: ")
    val cantidad = readLine()!!.toInt()

    if (cantidad > producto.cantidadDisponible) {
        println("Stock insuficiente.")
        return
    }

    // Verificar si ya está en el carrito
    val itemExistente = carrito.find { it.producto.nombre == producto.nombre }

    if (itemExistente != null) {
        itemExistente.cantidad += cantidad
    } else {
        carrito.add(ItemCarrito(producto, cantidad))
    }

    producto.cantidadDisponible -= cantidad

    println("Producto agregado al carrito.")
}

fun eliminarProducto(carrito: MutableList<ItemCarrito>) {

    if (carrito.isEmpty()) {
        println("El carrito está vacío.")
        return
    }

    mostrarCarrito(carrito)

    print("Seleccione el número del producto a eliminar: ")
    val index = readLine()!!.toInt() - 1

    if (index !in carrito.indices) {
        println("Opción inválida.")
        return
    }

    carrito.removeAt(index)

    println("Producto eliminado del carrito.")
}

fun comprar(carrito: MutableList<ItemCarrito>) {

    if (carrito.isEmpty()) {
        println("El carrito está vacío.")
        return
    }

    mostrarCarrito(carrito)

    println("Compra realizada con éxito ")
    carrito.clear()
}

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