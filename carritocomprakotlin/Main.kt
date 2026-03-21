fun main() {
    val productos = mutableListOf(
        Producto("Laptop", 850.00, 5),
        Producto("Mouse", 25.00, 10),
        Producto("Teclado", 45.00, 8),
        Producto("Monitor", 180.00, 4)
    )

    val carrito = CarritoCompra()
    var opcion: Int

    do {
        println("=============== TIENDA EN CONSOLA ===============")
        println("1. Ver productos")
        println("2. Agregar producto al carrito")
        println("3. Eliminar producto del carrito")
        println("4. Ver carrito")
        println("5. Generar factura")
        println("6. Salir")
        print("Seleccione una opción: ")

        opcion = readlnOrNull()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                println("\n================= PRODUCTOS DISPONIBLES =================")
                for ((index, producto) in productos.withIndex()) {
                    println(
                        "${index + 1}. ${producto.nombre} - " +
                        "Precio: $${"%.2f".format(producto.precio)} - " +
                        "Stock: ${producto.cantidadDisponible}"
                    )
                }
                println()
            }

            2 -> {
                println("\nIngrese el número del producto que desea agregar:")
                for ((index, producto) in productos.withIndex()) {
                    println(
                        "${index + 1}. ${producto.nombre} - " +
                        "Precio: $${"%.2f".format(producto.precio)} - " +
                        "Stock: ${producto.cantidadDisponible}"
                    )
                }

                print("Producto: ")
                val indice = readlnOrNull()?.toIntOrNull()

                if (indice == null || indice !in 1..productos.size) {
                    println("Opción de producto no válida.\n")
                    continue
                }

                val productoSeleccionado = productos[indice - 1]

                print("Cantidad a agregar: ")
                val cantidad = readlnOrNull()?.toIntOrNull()

                if (cantidad == null || cantidad <= 0) {
                    println("Cantidad no válida.\n")
                    continue
                }

                if (cantidad > productoSeleccionado.cantidadDisponible) {
                    println("No hay suficiente inventario.\n")
                    continue
                }

                carrito.agregarProducto(productoSeleccionado, cantidad)
                productoSeleccionado.cantidadDisponible -= cantidad
                println()
            }

            3 -> {
                print("\nIngrese el nombre del producto a eliminar del carrito: ")
                val nombre = readlnOrNull().orEmpty()

                val item = carrito.obtenerItems()
                    .find { it.producto.nombre.equals(nombre, ignoreCase = true) }

                if (item != null) {
                    item.producto.cantidadDisponible += item.cantidad
                }

                carrito.eliminarProducto(nombre)
                println()
            }

            4 -> {
                carrito.mostrarCarrito()
                println()
            }

            5 -> {
                val factura = Factura(carrito.obtenerItems())
                factura.mostrarFactura()
            }

            6 -> {
                println("Saliendo del sistema...")
            }

            else -> {
                println("Opción inválida.\n")
            }
        }
    } while (opcion != 6)
}