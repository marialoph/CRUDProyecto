package com.example.proyectocrud

import android.os.Bundle
import android.util.Log

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectocrud.Logic.Cliente
import com.example.proyectocrud.Logic.Controller
import com.example.proyectocrud.Logic.Interfaces.OperacionesInterfaces
import com.example.proyectocrud.Views.Dialog


class MainActivity : AppCompatActivity(), OperacionesInterfaces {
    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDel: ImageView
    private lateinit var myDialog : Dialog
    private val controller= Controller()

    companion object {
        const val TAG = "----------"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log. d(TAG, "Mensaje con log")
        start()
    }



    private fun start() {
        myButtonAdd = findViewById(R.id.myButtonAdd)
        myButtonUpdate = findViewById(R.id.myButtomEdit)
        myButtonDel = findViewById(R.id.myButtomDel)
        myDialog = Dialog { controller.devIdRandom() }

        myDialog.setListener(this)

        myButtonAdd.setOnClickListener{

            myDialog.show(0)
        }

        myButtonUpdate.setOnClickListener{
            myDialog.show(1)

        }

        myButtonDel.setOnClickListener( {
            myDialog.show(2)

        })


    }


    override fun ClienteAdd(id: Int, name: String, apellido:String,telefono:Int){
        val newClient = Cliente (id, name, apellido, telefono)
        controller.ClientAddController(newClient)
        var msg =  "El cliente con id = $id, ha sido añadido correctamente"

        Log.d(TAG, msg)
        showConsoleData(msg)
    }

    override fun ClienteDel(id: Int) {
        var msg = ""
        val delete = controller.ClientDelController(id)

        if (delete)
            msg =  "El cliente con id = $id, se ha eliminado correctamente"
        else
            msg = "El cliente con id = $id, no se ha encontrado para eliminar"

        Log. d(TAG, msg)
        showConsoleData(msg)

    }



    override fun ClienteUpdate(id: Int, name: String, apellido:String,telefono:Int) {
        var msg = ""
        val update = controller.ClientUpdateController(id, name, apellido, telefono)

        if (update)
            msg =  "El cliente con id = $id, ha sido actualizado correctamente"
        else
            msg = "El cliente con id = $id, no se ha podido actualizar"

        Log. d(TAG, msg)
        showConsoleData(msg)

    }

    fun showConsoleData(msg:String){
        val msg = controller.showData()
        Thread.sleep(2000)
        Log. d(TAG, msg)
    }
}