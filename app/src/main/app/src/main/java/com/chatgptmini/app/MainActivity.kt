package com.chatgptmini.app

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var chatBox: LinearLayout
    private lateinit var input: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chatBox = findViewById(R.id.chatBox)
        input = findViewById(R.id.input)

        val sendButton = findViewById<Button>(R.id.sendButton)

        sendButton.setOnClickListener {
            val message = input.text.toString().trim()

            if (message.isNotEmpty()) {
                addMessage("You", message)

                input.text.clear()

                // Gemini connection will be added next.
                addMessage(
                    "Mini",
                    "I'm ready! Gemini AI connection will be added next."
                )
            }
        }
    }

    private fun addMessage(sender: String, message: String) {
        val textView = TextView(this)

        textView.text = "$sender:\n$message"
        textView.textSize = 16f
        textView.setPadding(20, 15, 20, 15)

        chatBox.addView(textView)
    }
}
