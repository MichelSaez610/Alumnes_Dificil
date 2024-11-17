package com.alumnes.alumnes

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.alumnes.alumnes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.dropdown_items, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.dropdownMenu.setAdapter(adapter)

        binding.buttonNext.setOnClickListener{
            val selectedOption = binding.dropdownMenu.selectedItem.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("selected_option", selectedOption)
            startActivity(intent)
        }

        binding.buttonAdd.setOnClickListener{

        }
        //Falta hacer que añada el alumno cuando pone el nombre edad y elije el curso.
        //El ejercicio dificil es que con el nombre edad y curso, al darle a button_next, se tiene que filtrar el recyleView.
    }
}