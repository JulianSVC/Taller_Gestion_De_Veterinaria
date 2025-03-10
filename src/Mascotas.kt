open class Mascotas {
    var nombre : String = ""
    var especie : String = ""
    var edad : Int = 0
    var peso : Double = 0.0

   constructor()
   constructor(nombre: String, especie: String, edad: Int, peso: Double) {
       this.nombre = nombre
       this.especie = especie
       this.edad = edad
       this.peso = peso
   }
    constructor(nombre: String, edad: Int)

    override fun toString(): String{
        return "Mascota: $nombre, Especie: $especie, Edad: $edad, Peso: $peso kg"
    }
    fun actualizar_peso(nuevo_peso: Double)
    {
        this.peso = nuevo_peso
    }
    fun incrementarEdad(){
        this.edad++
    }
    fun describirMascota(): String {
        return toString()
    }
}