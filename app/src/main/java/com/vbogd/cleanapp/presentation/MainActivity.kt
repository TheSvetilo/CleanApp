package com.vbogd.cleanapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vbogd.cleanapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel = ViewModelProvider(this, MainViewModelFactory(this))
//            .get(MainViewModel::class.java)

        viewModel.result.observe(this) { result ->
            binding.displayUsernameTextView.text = result
        }

        binding.getDataButton.setOnClickListener {
            viewModel.getData()
        }

        binding.saveDataButton.setOnClickListener {
            val text = binding.editUserNameTextEdit.text.toString()
            viewModel.saveData(text)
        }
    }
}