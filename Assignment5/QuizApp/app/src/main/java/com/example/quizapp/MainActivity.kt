package com.example.quizapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private var result: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onQ1RadioButtonClicked(view: View) {
        // correct answer: true
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_q1_a ->
                    if (checked) {
                        result +=50
                    }
            }
        }
    }

    fun onQ2CheckBoxClicked(view: View) {
        // correct answer: open
        if (view is CheckBox) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.chk_q2_b ->
                    if (checked) {
                        result +=50
                    }
            }
        }
    }

    fun reset(view: View) {
        clearChoices();
    }

    private fun clearChoices(){
        //clearing part 1
        question_one_radio.clearCheck();

        //clearing part  2
        chk_q2_a.isChecked=false;
        chk_q2_b.isChecked=false;
        chk_q2_c.isChecked=false;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun submit(view: View) {
        val current = LocalDateTime.now()

        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        val date = current.format(dateFormatter)
        val time = current.format(timeFormatter)
        val message = if(result > 0)
            "Congratulations! You submitted on current $date and $time, Your achieved $result%"
        else "Please, try again."
        val title = "QuizApp Result"
        showResultDialog(title, message)
    }

    private fun showResultDialog(title: String, message: String){
        val alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("OK")
                { dialog, _ ->
                    clearChoices()
                    result = 0
                    dialog.dismiss()
                }
            }
            builder.setMessage(message).setTitle(title)
            builder.create()
        }
        alertDialog.show()
    }
}