package com.example.proyectocrud.Data

import com.example.proyectocrud.Logic.Cliente

class RepositoryCliente {

    companion object {
        var primary = 100

        val arrayClient : List<Cliente> = listOf (
            Cliente (incrementPrimary(), "Clara", "Galián", 694567890),
            Cliente (incrementPrimary(), "Maria", "López", 694676328),
            Cliente (incrementPrimary(), "Angel", "Pérez", 695879024),
            Cliente (incrementPrimary(), "Carlos", "Hernández",698721677)
        )

        fun incrementPrimary() = primary ++
    }

}