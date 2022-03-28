package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnso0.setOnClickListener{
            cal("0")
        }
        btnso1.setOnClickListener{
            cal("1")
        }
        btnso2.setOnClickListener{
            cal("2")
        }
        btnso3.setOnClickListener{
            cal("3")
        }
        btnso4.setOnClickListener{
            cal("4")
        }
        btnso5.setOnClickListener{
            cal("5")
        }
        btnso6.setOnClickListener{
            cal("6")
        }
        btnso7.setOnClickListener{
            cal("7")
        }
        btnso8.setOnClickListener{
            cal("8")
        }
        btnso9.setOnClickListener{
            cal("9")
        }
        btnxoa.setOnClickListener{
            cal("xoa")
        }
        btnamduong.setOnClickListener{
            cal("amduong")
        }
        btnbang.setOnClickListener{
            cal("=")
        }
        btncong.setOnClickListener{
            cal("+")
        }
        btntru.setOnClickListener{
            cal("-")
        }
        btnnhan.setOnClickListener{
            cal("*")
        }
        btnchia.setOnClickListener {
            cal("/")
        }
        btnCE.setOnClickListener {
             cal("CE")
        }
    }
    fun cal(function:String){
        if (pre_number.text == "0"){
            pre_number.setText("")
        }
        val pre = pre_number.text.toString()
        val post = post_number.text.toString()
        when(function) {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> pre_number.setText(pre.plus(function))
            "xoa" -> pre_number.setText(pre.dropLast(1))
            "amduong" -> pre_number.setText((pre.toDouble() * -1).toString())
            "+" -> {
                post_number.setText(pre.plus(" " + function))
                pre_number.setText("")
            }
            "-" -> {
                post_number.setText(pre.plus(" " + function))
                pre_number.setText("")
            }
            "*" -> {
                post_number.setText(pre.plus(" " + function))
                pre_number.setText("")
            }
            "/" -> {
                post_number.setText(pre.plus(" " + function))
                pre_number.setText("")
            }
            "=" -> {
                if ((post_number.text.last()).toString() == "+") {
                    val double1: Double? = (post_number.text.dropLast(2)
                        .toString()).toDouble() + (pre_number.text.toString()).toDouble()
                    pre_number.setText(double1.toString())
                }
                if ((post_number.text.last()).toString() == "-") {
                    val double1: Double? = (post_number.text.dropLast(2)
                        .toString()).toDouble() - (pre_number.text.toString()).toDouble()
                    pre_number.setText(Math.getExponent(Double.MIN_VALUE).toString())
                }
                if ((post_number.text.last()).toString() == "*") {
                    val double1: Double? = (post_number.text.dropLast(2)
                        .toString()).toDouble() * (pre_number.text.toString()).toDouble()
                    pre_number.setText(double1.toString())
                }
                if ((post_number.text.last()).toString() == "/") {
                    val double1: Double? = (post_number.text.dropLast(2)
                        .toString()).toDouble() / (pre_number.text.toString()).toDouble()
                    pre_number.setText(String.format("%.1f", double1).toDouble().toString())
                }
            }
            "CE" -> {
                pre_number.setText("")
                post_number.setText("")
            }
        }

        if (pre_number.text == ""){
            pre_number.setText("0")
        }
    }
}