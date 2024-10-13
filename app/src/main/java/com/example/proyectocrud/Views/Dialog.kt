package com.example.proyectocrud.Views

import com.example.proyectocrud.Data.RepositoryCliente
import com.example.proyectocrud.Logic.Interfaces.OperacionesInterfaces

class Dialog(private val getId:()->Int) {
    private var listener: OperacionesInterfaces? = null

    private var action : Int = 0


    fun setListener ( _listener : OperacionesInterfaces){
        listener = _listener

    }


    fun show(typeAction : Int){
        listener?.let{
            val posibleName = "Se ha cambiado"
            val posibleId = getId()
            when (typeAction){
                0 -> onAccept()

                1 ->
                    if (posibleId != -1)
                        onEdit(posibleId, posibleName,"",0)

                2 ->
                    if (posibleId != -1)
                        onDelete(posibleId)

            }

        }
    }

    private fun onDelete(id : Int) {
        listener!!.ClienteDel(id)
    }

    private fun onEdit(id: Int, name : String, apellido:String, telefono:Int) {
        listener!!.ClienteUpdate(id, name, apellido,telefono)
    }


    private fun onAccept() {
        listener!!.ClienteAdd(RepositoryCliente.incrementPrimary(), "Nuevo cliente","",0)
    }
}