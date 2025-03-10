class Consulta(
    val mascota: Mascotas,
    val diagnostico: String,
    val costoBase: Double,
    val incluyeMedicacion: Boolean): Mascotas(mascota.nombre,mascota.edad)
{
    fun calcularCosto(): Double{
        return if (incluyeMedicacion) costoBase*1.15
        else
            costoBase
    }
    override fun toString(): String {
        return "Consulta para ${mascota.nombre}: Diagnóstico: $diagnostico, Costo: ${calcularCosto()}"
    }
}