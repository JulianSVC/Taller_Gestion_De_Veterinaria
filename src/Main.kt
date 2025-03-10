
fun main() {
    val lstMascota= mutableListOf<Mascotas>()
    val Mascota_1 = Mascotas("Thor","Perro",12,10.1)
    lstMascota.add(Mascota_1)
    val lsthistorial_de_consultas = mutableListOf<Consulta>()
    val consulta_1 = Consulta(Mascota_1, "Tos",  20000.67, false)
    lsthistorial_de_consultas.add(consulta_1)

    while (true){
        println("""
            Menú de Gestión de Mascotas:
            1. Agregar nueva mascota.
            2. Registrar consulta médica.
            3. Mostrar historial de consultas.
            4. Modificar datos de una mascota.
            5. Calcular costo total de consultas.
            6. Salir del sistenma.           
            Selecciona alguna de las opciones: 
        """.trimIndent())
        when(readln().toIntOrNull()){
            1 -> {
                print("Nombre: ")
                val nombre = readLine() ?: ""
                print("Especie: ")
                val especie = readLine() ?: ""
                print("Edad: ")
                val edad = readLine()?.toIntOrNull() ?: 0
                print("Peso: ")
                val peso = readLine()?.toDoubleOrNull() ?: 0.0
                lstMascota.add(Mascotas(nombre, especie, edad, peso))
                println("Mascota agregada exitosamente.")
            }
            2 -> {
                if (lstMascota.isEmpty()) {
                    println("No hay mascotas registradas.")
                    continue
                }

                println("Seleccione una mascota:")
                lstMascota.forEachIndexed { index, mascota ->
                    println("${index + 1}. ${mascota.describirMascota()}")
                }

                val mascotaIndex = readLine()?.toIntOrNull()?.minus(1) ?: continue
                if (mascotaIndex !in lstMascota.indices) {
                    println("Selección inválida.")
                    continue
                }

                val mascotaSeleccionada = lstMascota[mascotaIndex]

                print("Diagnóstico: ")
                val diagnostico = readLine() ?: ""
                print("Costo base: ")
                val costoBase = readLine()?.toDoubleOrNull() ?: 0.0
                print("Incluye medicación? (true/false): ")
                val incluyeMedicacion = readLine()?.toBoolean() ?: false

                val consulta = Consulta(mascotaSeleccionada, diagnostico, costoBase, incluyeMedicacion)
                lsthistorial_de_consultas.add(consulta)
                println("Consulta registrada exitosamente.")
            }
            3 -> {
                if (lsthistorial_de_consultas.isEmpty()) {
                    println("No hay consultas registradas.")
                    continue
                }

                println("Historial de consultas:")
                lsthistorial_de_consultas.forEach { consulta ->
                    println(consulta)
                }
            }
            4 -> {
                if (lstMascota.isEmpty()) {
                    println("No hay mascotas registradas.")
                    continue
                }

                println("Seleccione una mascota para modificar:")
                lstMascota.forEachIndexed { index, mascota ->
                    println("${index + 1}. ${mascota.describirMascota()}")
                }

                val mascotaIndex = readLine()?.toIntOrNull()?.minus(1) ?: continue
                if (mascotaIndex !in lstMascota.indices) {
                    println("Selección inválida.")
                    continue
                }

                val mascotaSeleccionada = lstMascota[mascotaIndex]

                println("""
                    Seleccione qué desea modificar:
                    1. Peso
                    2. Edad
                """.trimIndent())

                when (readLine()?.toIntOrNull()) {
                    1 -> {
                        print("Nuevo peso: ")
                        val nuevo_peso= readLine()?.toDoubleOrNull() ?: continue
                        mascotaSeleccionada.actualizar_peso(nuevo_peso)
                        println("Peso actualizado exitosamente.")
                    }
                    2 -> {
                        mascotaSeleccionada.incrementarEdad()
                        println("Edad incrementada exitosamente.")
                    }
                    else -> println("Opción inválida.")
                }
            }
            5 -> {
                if (lstMascota.isEmpty()) {
                    println("No hay mascotas registradas.")
                    continue
                }

                println("Seleccione una mascota para calcular el costo total de sus consultas:")
                lstMascota.forEachIndexed { index, mascota ->
                    println("${index + 1}. ${mascota.describirMascota()}")
                }

                val mascotaIndex = readLine()?.toIntOrNull()?.minus(1) ?: continue
                if (mascotaIndex !in lstMascota.indices) {
                    println("Selección inválida.")
                    continue
                }

                val mascotaSeleccionada = lstMascota[mascotaIndex]
                val costoTotal = lsthistorial_de_consultas
                    .filter { it.mascota == mascotaSeleccionada }
                    .sumOf { it.calcularCosto() }

                println("El costo total de las consultas para ${mascotaSeleccionada.nombre} es: $costoTotal")
            }
            6 -> {
                println("Saliendo del sistema ...")
                return
                break
            }
            else -> println("Opción inválida intentalo de nuevo.")
        }
    }
}