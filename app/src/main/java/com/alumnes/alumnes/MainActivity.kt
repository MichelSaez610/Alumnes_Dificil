package com.alumnes.alumnes

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
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
            val selectedName = binding.nomAlumne.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("selected_option", selectedOption)
            intent.putExtra("selected_name", selectedName)
            startActivity(intent)
        }

        toggleButtonAdd(binding)

        // Add text change listeners to name and age fields
        binding.nomAlumne.addTextChangedListener {
            toggleButtonAdd(binding)
        }

        binding.edatAlumne.addTextChangedListener {
            toggleButtonAdd(binding)
        }

        binding.buttonAdd.setOnClickListener {
            val course = binding.dropdownMenu.selectedItem.toString()
            val age = Integer.parseInt(binding.edatAlumne.text.toString())
            val name = binding.nomAlumne.text.toString()
            addToArray(name, age, course)
        }
    }

    fun addToArray(name: String, age:Int, course: String) {
        val newAlumne = Alumne(name, age, course)
        DataSource.instance.alumneList.add(newAlumne)
    }

    fun toggleButtonAdd(binding: ActivityMainBinding) {
        val name = binding.nomAlumne.text.toString()
        val age = binding.edatAlumne.text.toString()

        if (name.isEmpty() || age.isEmpty()) {
            markButtonDisable(binding.buttonAdd)
        } else {
            binding.buttonAdd.isEnabled = true
            binding.buttonAdd.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.buttonAdd.setBackgroundColor(ContextCompat.getColor(this, R.color.purple))
        }
    }

    fun markButtonDisable(button: Button) {
        button?.isEnabled = false
        button?.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black))
        button?.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey))
    }
}