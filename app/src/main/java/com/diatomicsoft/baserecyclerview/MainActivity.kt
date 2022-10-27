package com.diatomicsoft.baserecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.diatomicsoft.baserecyclerview.base_recycler_view.BaseAdapter
import com.diatomicsoft.baserecyclerview.base_recycler_view.init
import com.diatomicsoft.baserecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Data
        val userList = mutableListOf(
            UserModel(1, "Tarek", "01239909090"),
            UserModel(2, "Reza", "012399132244"),
            UserModel(3, "Shakib", "01456732399")
        )

        val adapter = BaseAdapter<UserModel>(R.layout.rv_item_user)
        binding.rvUser.init( adapter, userList)
        adapter.setOnListItemViewClickListener(object : BaseAdapter.OnListItemViewClickListener {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(view.context, userList[position].name, Toast.LENGTH_SHORT).show()
            }
        })

    }
}