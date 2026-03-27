import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Factura(
    private val items: List<ItemCarrito>,
    private val porcentajeImpuesto: Double = 0.13
) {

    private val numeroFactura: Int = (1000..9999).random()
    private val fecha: String = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))

    fun mostrarProductosComprados() {
        println("\n=========== PRODUCTOS COMPRADOS ===========")
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
    }

    fun calcularSubtotal(): Double {
        return items.sumOf { it.totalPorProducto() }
    }

    fun calcularImpuesto(subtotal: Double): Double {
        return subtotal * porcentajeImpuesto
    }

    fun calcularTotalFinal(): Double {
        val subtotal = calcularSubtotal()
        val impuesto = calcularImpuesto(subtotal)
        return subtotal + impuesto
    }

    fun mostrarFactura() {
        if (items.isEmpty()) {
            println("\nNo hay productos en el carrito para generar factura.")
            return
        }

        println("\n=========== FACTURA ===========")
        println("No. Factura: $numeroFactura")
        println("Fecha: $fecha")

        mostrarProductosComprados()

        val subtotal = calcularSubtotal()
        val impuesto = calcularImpuesto(subtotal)
        val total = calcularTotalFinal()

        println("\nSubtotal: $" + "%.2f".format(subtotal))
        println("Impuesto (13%): $" + "%.2f".format(impuesto))
        println("Total: $" + "%.2f".format(total))
        println("================================")
    }
}