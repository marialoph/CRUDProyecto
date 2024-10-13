package com.example.proyectocrud.Logic


import com.example.proyectocrud.Data.RepositoryCliente
import kotlin.random.Random

class Controller () {
    private var myListClient: MutableList<Cliente>

    init{
        myListClient = RepositoryCliente.arrayClient.toMutableList()
    }

    fun ClientAddController(cli : Cliente){
        myListClient.add(cli)
    }

    fun ClientDelController (id : Int) : Boolean  = myListClient.removeAll { it.id == id }


    fun ClientUpdateController (id : Int, name : String, apellido:String, telefono:Int): Boolean {
        val findClient : Cliente? = myListClient.find { it.id == id }
        return findClient?.let{
            it.name = name
            it.apellido = apellido
            it.telefono = telefono
            true
        }?:false
    }

    fun showData() = myListClient.toString()

    fun devClient (pos : Int) = myListClient.find {  it.id == pos }


    fun devIdRandom() : Int{
        return if (myListClient.size == 0 ) {
            -1
        }else {
            val p = Random.nextInt(0, myListClient.size)
            myListClient[p].id
        }
    }

}