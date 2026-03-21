fun main() {

    val inventario = mutableListOf(
        Producto("Laptop", 800.0, 5),
        Producto("Mouse", 20.0, 10),
        Producto("Teclado", 50.0, 7),
        Producto("Monitor", 200.0, 3)
    )

    val carrito = mutableListOf<ItemCarrito>()

    var opcion: Int

    do {
        println("\n====== MENÚ PRINCIPAL ======")
        println("1. Ver productos")
        println("2. Agregar producto")
        println("3. Ver carrito")
        println("4. Eliminar producto")
        println("5. Comprar")
        println("6. Salir")
        print("Seleccione una opción: ")

        opcion = readLine()!!.toInt()

        when (opcion) {

    1 -> mostrarInventario(inventario)
    2 -> agregarProducto(carrito, inventario)
    3 -> mostrarCarrito(carrito)
    4 -> eliminarProducto(carrito)
    5 -> comprar(carrito)
    6 -> println("Saliendo del sistema...")

            else -> println("Opción inválida")
        }

    } while (opcion != 6)
}
