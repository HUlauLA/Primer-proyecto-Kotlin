import java.util.Scanner

//Clase Producto
data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidadDisponible: Int
)

// mostrar productos
fun mostrarInventario(productos: List<Producto>) {
    println("\n=== INVENTARIO DISPONIBLE ===")
    for (producto in productos) {
        println("Nombre: ${producto.nombre}")
        println("Precio: $${producto.precio}")
        println("Stock disponible: ${producto.cantidadDisponible}")
        println("-----------------------------")
    }
}

// fun main() {
  //  val scanner = Scanner(System.`in`)
   // val inventario = mutableListOf<Producto>()

 //   print("¿Cuántos productos desea ingresar?: ")
   // val cantidadProductos = scanner.nextInt()
  //  scanner.nextLine() // limpiar buffer

 //   for (i in 1..cantidadProductos) {
     //   println("\nProducto #$i")

     //   print("Nombre: ")
     //   val nombre = scanner.nextLine()

      //  print("Precio: ")
      //  val precio = scanner.nextDouble()

       // print("Cantidad disponible: ")
     //   val cantidadDisponible = scanner.nextInt()
     //   scanner.nextLine() // limpiar buffer

   //     val producto = Producto(nombre, precio, cantidadDisponible)
     //   inventario.add(producto)
//    }

    // invoca la funcion mostrarInventario
//    mostrarInventario(inventario)
//}
