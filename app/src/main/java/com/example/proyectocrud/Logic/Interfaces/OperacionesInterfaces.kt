package com.example.proyectocrud.Logic.Interfaces

interface OperacionesInterfaces {
    fun ClienteAdd ( id: Int, name: String, apellido:String, telefono:Int )
    fun ClienteDel ( id: Int)
    fun ClienteUpdate ( id: Int, name: String, apellido:String, telefono:Int)
}