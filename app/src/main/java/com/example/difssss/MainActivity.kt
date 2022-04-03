package com.example.difssss

import AdapterRec
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.difssss.Interfacesss.MyItemInterface
import com.example.difssss.Models.UserModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var listofUser :ArrayList<UserModel>
    lateinit var adapter:AdapterRec
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        initView()

    }

    private fun loadData() {
        listofUser = ArrayList()
        for(i in 0..50){
            listofUser.add(UserModel("User $i"))
        }
    }

    private fun initView() {

        Rec1.layoutManager =  LinearLayoutManager(this)
        adapter = AdapterRec(listofUser)
        adapter.submitList(listofUser)
        Rec1.adapter  =adapter

        val  touchHelper  =object :ItemTouchHelper.Callback(){
            override fun getMovementFlags(
                recyclerView : RecyclerView,
                viewHolder : RecyclerView.ViewHolder
            ) : Int {
                val swipeF  = ItemTouchHelper.RIGHT
                return makeMovementFlags(0,swipeF)
            }

            override fun onMove(
                recyclerView : RecyclerView,
                viewHolder : RecyclerView.ViewHolder,
                target : RecyclerView.ViewHolder
            ) : Boolean {
                return false
            }

            override fun onSwiped(viewHolder : RecyclerView.ViewHolder, direction : Int) {
                adapter.onRemove(viewHolder.adapterPosition)

            }
        }
        val itemtouch  = ItemTouchHelper(touchHelper)
        itemtouch.attachToRecyclerView(Rec1)



    }
}