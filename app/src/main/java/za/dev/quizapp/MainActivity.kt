package za.dev.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_Start:Button = findViewById(R.id.btnStart)
        val et_Name:EditText = findViewById(R.id.etName)
        btn_Start.setOnClickListener {

            if (et_Name.text.isEmpty())
            {
                Toast.makeText(this,"Please Enter Your Name", Toast.LENGTH_LONG).show()
            }
            else
            {
                val intent = Intent(this, Questions::class.java) //intent moves to the next screen
                intent.putExtra(Constants.USER_NAME, et_Name.text.toString())
                startActivity(intent)
                finish()  //finishes the activity

            }
        }
    }
}