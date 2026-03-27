data class ItemCarrito(
    val producto: Producto,
    var cantidad: Int
){
    fun totalPorProducto(): Double {
        return producto.precio * cantidad
    }
}