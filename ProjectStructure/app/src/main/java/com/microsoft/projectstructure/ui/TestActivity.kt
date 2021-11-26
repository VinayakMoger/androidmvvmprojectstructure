package com.microsoft.projectstructure.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.microsoft.projectstructure.databinding.ActivityTestBinding
import com.microsoft.projectstructure.utility.Status
import com.microsoft.projectstructure.viewmodel.TestViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestActivity : BaseActivity() {
    private val viewModel: TestViewModel by viewModels()
    lateinit var binding :ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            callRestAPIButton.setOnClickListener {
                callRestAPI()
            }
        }
    }

    private fun callRestAPI() {
        viewModel.getTestData().observe(this,{
            when(it.status) {
                Status.LOADING -> showProgressDialog(this@TestActivity)
                Status.SUCCESS ->{
                    dialogCancel()
                    binding.apiData.text = "Email : "+it.data!!.data.email
                }
                Status.ERROR ->{
                    dialogCancel()
                    Toast.makeText(this@TestActivity, it.message!!,Toast.LENGTH_LONG).show()
                }

            }
        })
    }
}
