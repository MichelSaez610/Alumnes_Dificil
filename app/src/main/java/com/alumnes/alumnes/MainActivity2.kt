package com.alumnes.alumnes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.alumnes.alumnes.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // this creates a vertical layout Manager
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        val dataSource = DataSource.instance

        // Get the selected option from the intent
        val selectedOption = intent.getStringExtra("selected_option")
        val selectedName = intent.getStringExtra("selected_name")

        for (alumne in dataSource.alumneList) {
            if (alumne.course == selectedOption && alumne.name == selectedName) {
                data.add(ItemsViewModel(R.drawable.pikachu, "${alumne.name}  ${alumne.age}  ${alumne.course}"))
            }
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        binding.recyclerview.adapter = adapter

        binding.returnButton.setOnClickListener{
            finish()
        }
    }
}